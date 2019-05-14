package com.baizhi.controller;

import com.baizhi.entity.Tag;
import com.baizhi.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("tag")
public class TagCOntroller {
    @Autowired
    private TagService tagService;
    @RequestMapping("add")
    @ResponseBody
    public void addorUpdate(Tag tag){
        System.out.println(tag);
        tagService.add(tag);

    }
    @RequestMapping("remove")
    @ResponseBody
    public void aa(String id){
        tagService.delete(id);
    }
    @RequestMapping("findAll")
    @ResponseBody
    public List<Tag> findAll(){
        List<Tag> all = tagService.findAll();
        return all;
    }
    @ResponseBody
    @RequestMapping("findByType")
    public void find(String type, HttpServletResponse response) throws IOException {
        StringBuilder sb =  new StringBuilder();
//        sb.append("<select>");
//        List<Tag> depts = tagService.findByType(type);
//        //遍历所有部门信息
//        for (Tag dept : depts) {
//            sb.append("<option value=\"").append(dept.getId()).append("\">")
//                    .append(dept.getName()).append("</option>");
//        }
//        sb.append("</select>");
//        response.setContentType("text/html;charset=UTF-8");
//        response.getWriter().print(sb.toString());
//        <input type="checkbox" checked/>

        List<Tag> depts = tagService.findByType(type);
        for (Tag dept : depts) {
           sb.append("<input type=\"checkbox\" name=\"tagid\" value=\"").append(dept.getId())
                   .append("\"").append("/>").append(dept.getName());
       }
        response.setContentType("text/html;charset=UTF-8");
       response.getWriter().print(sb.toString());

    }
}
