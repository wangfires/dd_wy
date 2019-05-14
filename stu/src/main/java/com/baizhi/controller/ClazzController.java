package com.baizhi.controller;

import com.baizhi.entity.Clazz;
import com.baizhi.service.ClazzService;
import com.baizhi.service.GroupService;
import com.baizhi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("clazz")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private StudentService studentService;
    @RequestMapping("edit")
    @ResponseBody
    public void edit(Clazz clazz,String oper){
        if("add".equals(oper)){
            clazzService.add(clazz);
        }if("edit".equals(oper)){
            clazzService.update(clazz);
        }else if("del".equals(oper)){
            clazzService.delete(clazz.getId());
        }
    }
    @RequestMapping("findByPage")
    @ResponseBody
    public Map<String,Object> findAll(Integer page, Integer rows){
        HashMap<String,Object> result = new HashMap<>();
        Long totals=clazzService.findTotals();
        result.put("page",page);
        Long totalPage=totals%rows==0?totals/rows:totals/rows+1;
        result.put("total",totalPage);
        result.put("records",totals);
        Integer start= (page-1)*rows;
        List<Clazz> clazzs = clazzService.findByPage(start, rows);
        List<Long> snumber=new ArrayList<Long>();
        List<Long> gnumber=new ArrayList<Long>();
        for (Clazz clazz : clazzs) {
            clazz.setSnumber(studentService.findByClazzid(clazz.getId()));
            clazz.setGnumber(groupService.findByClazzid(clazz.getId()));

        }

        result.put("rows",clazzs);
        return result;
    }
    @RequestMapping("findAll")
    public void find(String type, HttpServletResponse response) throws IOException {
        StringBuilder sb =  new StringBuilder();
        sb.append("<select id='st'>");
        List<Clazz> depts = clazzService.findAll();
        //遍历所有部门信息
        for (Clazz dept : depts) {
            sb.append("<option value=\"").append(dept.getId()).append("\">")
                    .append(dept.getName()).append("</option>");
        }
        sb.append("</select>");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(sb.toString());
    }
}
