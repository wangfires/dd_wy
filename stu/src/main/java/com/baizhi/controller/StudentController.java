package com.baizhi.controller;

import com.baizhi.entity.Student;
import com.baizhi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("stu")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @RequestMapping("edit")
    @ResponseBody
    public void deit(List<String> tagids, Student student, String oper){
        if("add".equals(oper)){
            System.out.println(student);
            studentService.add(student);

        }if("edit".equals(oper)){
            studentService.update(student);
        }else if("del".equals(oper)){
            studentService.delete(student.getId());
        }
    }
    @ResponseBody
    @RequestMapping("findByPage")
    public Map<String,Object> findAll(boolean _search,String searchField, String searchString,Integer page, Integer rows){


            HashMap<String, Object> result = new HashMap<>();
            Long totals = studentService.findTotals();
            result.put("page", page);
            Long totalPage = totals % rows == 0 ? totals / rows : totals / rows + 1;
            result.put("total", totalPage);
            result.put("records", totals);
            Integer start = (page - 1) * rows;
        if (_search==false) {
            searchField=null;
            searchString=null;
            
        }
        result.put("rows", studentService.findByPage(searchField, searchString, start, rows));




        return result;
        }

    @ResponseBody
    @RequestMapping("findByCityId")
    public Long find(String cityid){
        return studentService.findByCityid(cityid);
    }
    @ResponseBody
    @RequestMapping("findByClazzId")
    public Long find1(String clazzid){
        return studentService.findByCityid(clazzid);
    }
    @ResponseBody
    @RequestMapping("findByGroupId")
    public Long find2(String groupid){
        return studentService.findByCityid(groupid);
    }
}
