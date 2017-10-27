package com.dimas.maryanto.blogs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tag")
public class TagController {

    @GetMapping("/")
    public String showTagByPage() {
        return "";
    }
}
