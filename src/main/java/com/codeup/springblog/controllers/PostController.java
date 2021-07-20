package com.codeup.springblog.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String posts() {
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postId(){
        return "/posts/show";
    }


    @GetMapping("/posts/create")
    @ResponseBody
    public String createGet(){
        return "Form for create a blog post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String create(){
        return "Create post here";
    }

}
