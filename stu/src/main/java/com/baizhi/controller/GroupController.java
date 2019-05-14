package com.baizhi.controller;

import com.baizhi.entity.Group;
import com.baizhi.service.GroupService;
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
@RequestMapping("group")
public class GroupController {
    @Autowired
    private GroupService groupService;
    @Autowired
    private StudentService studentService;
    @RequestMapping("edit")
    @ResponseBody
    public void edit(Group group, String oper){
        if("add".equals(oper)){
            groupService.add(group);
        }if("edit".equals(oper)){
            groupService.update(group);
        }else if("del".equals(oper)){
            groupService.delete(group.getId());
        }
    }
    @RequestMapping("findByPage")
    @ResponseBody
    public Map<String,Object> findAll(Integer page, Integer rows){
        HashMap<String,Object> result = new HashMap<>();
        Long totals=groupService.findTotals();
        result.put("page",page);
        Long totalPage=totals%rows==0?totals/rows:totals/rows+1;
        result.put("total",totalPage);
        result.put("records",totals);
        Integer start= (page-1)*rows;
        List<Group> groups = groupService.findByPage(start, rows);
        for (Group group : groups) {
            System.out.println(group);

            group.setNumber(studentService.findByGroupid(group.getId()));
        }
        result.put("rows",groups);


        return result;
    }
    @RequestMapping("findAll")
    public void find(String type, HttpServletResponse response) throws IOException {
        StringBuilder sb =  new StringBuilder();
        sb.append("<select>");
        List<Group> depts = groupService.findAll();
        //遍历所有部门信息
        for (Group dept : depts) {
            sb.append("<option value=\"").append(dept.getId()).append("\">")
                    .append(dept.getName()).append("</option>");
        }
        sb.append("</select>");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(sb.toString());
    }
    @RequestMapping("findByClazzid")
    public void aa(String clazzid,HttpServletResponse response) throws IOException {
        StringBuilder sb =  new StringBuilder();
        sb.append("<select>");
        List<Group> depts = groupService.findByClazz(clazzid);
        //遍历所有部门信息
        for (Group dept : depts) {
            sb.append("<option value=\"").append(dept.getId()).append("\">")
                    .append(dept.getName()).append("</option>");
        }
        sb.append("</select>");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(sb.toString());
    }
}
