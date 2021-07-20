package com.codeup.springblog.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

//    Request mapping for explicit path and method
    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
    @ResponseBody
    public String createGet(){
        return "Form for create a blog post";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String createPost(){
        return "Form for create a blog post";
    }



//    Get and Post mapping direct annotation
//    @GetMapping("/posts/create")
//    @ResponseBody
//    public String createGet(){
//        return "Form for create a blog post";
//    }
//
//    @PostMapping("/posts/create")
//    @ResponseBody
//    public String createPost(){
//        return "Create post here";
//    }

}
