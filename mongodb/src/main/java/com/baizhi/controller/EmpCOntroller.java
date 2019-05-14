package com.baizhi.controller;

import com.baizhi.entity.Emp;
import com.baizhi.service.EmpService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("emp")
public class EmpCOntroller {
    @Autowired
    private EmpService empService;
    @RequestMapping("edit")
    @ResponseBody
    public void edit(Emp emp){
        System.out.println(emp.getId());
        if (emp.getId()==null||"".equals(emp.getId())){
            emp.setId(null);
            empService.add(emp);

        }else {
            empService.update(emp);
        }
    }
    @RequestMapping("delete")
    @ResponseBody
    public void del(String id){
        empService.delete(id);
    }
    @RequestMapping("findBypage")
    @ResponseBody
    public Map<String,Object> findByPage(Integer page,Integer rows){
        HashMap<String, Object> result = new HashMap<>();
        PageInfo<Emp> byPage = empService.findByPage(page, rows);
        result.put("page",page);
        result.put("rows",byPage.getList());
        result.put("total",byPage.getPages());
        result.put("records",byPage.getTotal());
        return result;
    }
}
