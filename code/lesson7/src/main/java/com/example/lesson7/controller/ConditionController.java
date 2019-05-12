package com.example.lesson7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;


@Controller
public class ConditionController {
    @RequestMapping("condition")
    public ModelAndView ifCondition(String flag){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("condition");
        mv.addObject("flag",flag);
        return mv;
    }

    @RequestMapping("for")
    public ModelAndView forExample(ModelAndView mv){
        mv.setViewName("for");
        List<Map<String,Object>> users = new ArrayList<> ();

        Map<String,Object> user = new HashMap<>();

        user.put("id",1);
        user.put("username","lol");
        user.put("salary",10000);
        users.add(user);

        user = new HashMap<>();
        user.put("id",2);
        user.put("username","Dota");
        user.put("salary",20000);
        users.add(user);

        user = new HashMap<>();
        user.put("id",3);
        user.put("username","overWatch");
        user.put("salary",300000);
        users.add(user);

        mv.addObject("users",users);

        return mv;
    }

    @RequestMapping("inline")
    public ModelAndView inline(ModelAndView mv){
        mv.setViewName("inline");
        mv.addObject("username","LOL");
        return mv;
    }

    @RequestMapping("object")
    public ModelAndView object(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        request.setAttribute("username","LOL");
        session.setAttribute("loginName","英雄联盟");
        mv.setViewName("object");
        return mv;
    }

    @RequestMapping("string")
    public ModelAndView string(ModelAndView mv){
        mv.setViewName("string");
        mv.addObject("username","LOL: 英雄联盟");
        return mv;
    }

    @RequestMapping("utility")
    public ModelAndView utility(ModelAndView mv){
        mv.setViewName("utility");
        mv.addObject("words","this is test string length");
        mv.addObject("date",new Date());
        return mv;
    }
}
