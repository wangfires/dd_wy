package com.baizhi.controller;

import com.baizhi.entity.Manager;
import com.baizhi.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @RequestMapping("login")
    @ResponseBody
    public Map<String, Object> login(String username, String password, HttpSession session){
        Map<String, Object> login = managerService.login(username, password);
        Manager login1 = (Manager) login.get("login");
        System.out.println(login.get("perror"));
        System.out.println(login.get("nerror"));
        session.setAttribute("login",login1);
        login.remove("login");
        System.out.println(login);
        return login;
    }
}
