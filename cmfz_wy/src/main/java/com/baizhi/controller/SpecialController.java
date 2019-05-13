package com.baizhi.controller;

import com.baizhi.entity.Special;
import com.baizhi.service.SpecialService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("special")
public class SpecialController {
    @Autowired
    private SpecialService specialService;
    @RequestMapping("edit")
    public void edit(Special special, MultipartFile aaa, HttpServletRequest request) throws IOException {
        System.out.println(special);
        System.out.println(aaa.getOriginalFilename());
        if (special.getId()==null||"".equals(special.getId())){
            String type = aaa.getOriginalFilename().substring(aaa.getOriginalFilename().indexOf("."));
            String realPath = request.getSession().getServletContext().getRealPath("/special/");
            String fileName = String.valueOf(System.currentTimeMillis()) + type;
            aaa.transferTo(new File(realPath+fileName));
            special.setPicture(fileName);
            specialService.add(special);
        }else {
            specialService.update(special);
        }
    }
    @RequestMapping("del")
    public void del(String id){
        specialService.delete(id);
    }
    @ResponseBody
    @RequestMapping("findByPage")
    public Map<String,Object> findAll(Integer page, Integer rows){
        HashMap<String, Object> result = new HashMap<>();
        PageInfo<Special> byPage =specialService.findByPage(page, rows);
        result.put("page",page);
        result.put("rows",byPage.getList());
        result.put("total",byPage.getPages());
        result.put("records",byPage.getTotal());
        return result;
    }
    @ResponseBody
    @RequestMapping("findAll")
    public List<Special> findAll(){
        List<Special> all = specialService.findAll();
        return all;
    }
}
