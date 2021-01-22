package com.example.springbootMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Liang
 * @date 2020/11/29 - 21:00
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String index(){

        return "index";
    }

    @RequestMapping("/index")
    public String index1(){

        return "index";
    }
    @RequestMapping("/errorPage")
    public String errorPage(Model model){

        return "/errorPage";
    }

    @RequestMapping("/frameLesson")
    public String frameLesson(){
        return "/frameLesson";
    }
    @RequestMapping("/edit")
    public String edit(){
        return "edit/frameLesson";
    }
}
