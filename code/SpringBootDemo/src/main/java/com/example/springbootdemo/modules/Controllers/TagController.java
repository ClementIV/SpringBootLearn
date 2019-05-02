package com.example.springbootdemo.modules.Controllers;

import com.example.springbootdemo.modules.Dto.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/tag")
public class TagController {

    @GetMapping("/jspScript")
    public String jspScript(){
        return "tag/jspScript";
    }

    @RequestMapping("/tagIf")
    public ModelAndView tagIf(String userName){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("tag/tagIf");
        mv.addObject("userName",userName);

        return mv;
    }

    @RequestMapping("/tagChoose")
    public ModelAndView tagChoose(int age){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("tag/tagChoose");
        mv.addObject("age",age);

        return mv;
    }

    @RequestMapping("/tagForEach")
    public ModelAndView tagForEach(Map<String,Object> map){
       List<Student> studentList= new ArrayList<>();

       Student student = new Student();
       student.setName("java 乐园");
       student.setAge(1);
       student.setAddr("北京");

       studentList.add(student);

       student = new Student();
       student.setName("架构师知音");
       student.setAge(11);
       student.setAddr("上海");

       studentList.add(student);

       ModelAndView mv = new ModelAndView();
       mv.setViewName("tag/tagForEach");
       mv.addObject("studentList",studentList);

       return mv;

    }
}
