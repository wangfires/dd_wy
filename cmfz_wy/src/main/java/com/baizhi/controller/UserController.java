package com.baizhi.controller;

import com.baizhi.entity.Fuser;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("find")
    public Map<String,Object> find(){
        Map<String, Object> result = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        list.add(userService.findOneWeek());
        list.add(userService.findTwoWeek());
        list.add(userService.findThreeWeek());
        list.add(userService.findFourWeek());
        list.add(userService.findFiveWeek());
        result.put("data",list);
        return result;
    }
    @RequestMapping("map")
    public Map<String,Object> map(){
        Map<String, Object> result = new HashMap<>();
        List<Fuser> man = userService.findBySex("男");
        List<Fuser> women = userService.findBySex("女");
        result.put("man",man);
        result.put("women",women);
        return result;
    }
    @RequestMapping("edit")
    public void edit(User user, MultipartFile aaa, HttpServletRequest request) throws IOException {
        System.out.println(user);
        System.out.println(aaa.getOriginalFilename());
        if (user.getId()==null||"".equals(user.getId())){
            String type = aaa.getOriginalFilename().substring(aaa.getOriginalFilename().indexOf("."));
            String realPath = request.getSession().getServletContext().getRealPath("/user/");
            String fileName = String.valueOf(System.currentTimeMillis()) + type;
            user.setHeadpic("/user/"+fileName);
            aaa.transferTo(new File(realPath+fileName));
            userService.add(user);
        }else {
            userService.update(user);
        }
    }
    @ResponseBody
    @RequestMapping("findByPage")
    public Map<String,Object> findAll( Integer page, Integer rows){
        HashMap<String, Object> result = new HashMap<>();
        PageInfo<User> byPage = userService.findByPage(page, rows);
        result.put("page",page);
        result.put("rows",byPage.getList());
        result.put("total",byPage.getPages());
        result.put("records",byPage.getTotal());
        return result;
    }
    @RequestMapping("/del")
    @ResponseBody
    public void remove(String id,String path,HttpServletRequest request){
        String realPath = request.getSession().getServletContext().getRealPath(path);
        System.out.println(realPath);
        File file = new File(realPath);
        if(file.isFile()) {
            file.delete();
        }
        userService.delete(id);
    }
}
