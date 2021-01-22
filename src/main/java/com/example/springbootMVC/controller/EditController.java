package com.example.springbootMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Liang
 * @date 2020/11/29 - 21:00
 */
@Controller
@RequestMapping("/edit")
public class EditController {

    @RequestMapping("/editFrameLesson")
    public String editFrameLesson(){
        return "edit/editFrameLesson";
    }

}
