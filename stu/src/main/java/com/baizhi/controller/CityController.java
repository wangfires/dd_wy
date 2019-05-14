package com.baizhi.controller;

import com.baizhi.entity.City;
import com.baizhi.service.CityService;
import com.baizhi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("city")
public class CityController {
    @Autowired
    private CityService cityService;
    @Autowired
    private StudentService studentService;
    @RequestMapping("edit")
    @ResponseBody
    public void edit(City city,String oper){
        if("add".equals(oper)){
            cityService.add(city);
        }if("edit".equals(oper)){
            cityService.update(city);
        }else if("del".equals(oper)){
            cityService.delete(city.getId());
        }
    }
    @ResponseBody
    @RequestMapping("findByPage")
    public Map<String,Object> findAll(Integer page,Integer rows){
        HashMap<String,Object> result = new HashMap<>();
        Long totals=cityService.findTotals();
        result.put("page",page);
        Long totalPage=totals%rows==0?totals/rows:totals/rows+1;
        result.put("total",totalPage);
        result.put("records",totals);
        Integer start= (page-1)*rows;
        List<City> citys = cityService.findByPage(start, rows);

        for (City city : citys) {
            city.setNumber(studentService.findByCityid(city.getId()));
        }

        result.put("rows",citys);
        return result;
    }
    @RequestMapping("findAll")
    @ResponseBody

    public void find(String type, HttpServletResponse response) throws IOException {
        StringBuilder sb =  new StringBuilder();
        sb.append("<select>");
        List<City> depts = cityService.findAll();
        //遍历所有部门信息
        for (City dept : depts) {
            sb.append("<option value=\"").append(dept.getId()).append("\">")
                    .append(dept.getName()).append("</option>");
        }
        sb.append("</select>");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(sb.toString());
    }
}
