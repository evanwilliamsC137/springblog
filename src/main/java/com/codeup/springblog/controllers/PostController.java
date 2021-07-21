package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class PostController {
//    show an index of all the posts
    @GetMapping("/posts")
    public String posts(Model model) {
        List<Post> posts = new ArrayList<>();
        Post post1 = new Post("post1","test post");
        Post post2 = new Post("post2","test post2");

        posts.add(post1);
        posts.add(post2);

        model.addAttribute("/posts",posts);

        return "posts/index";
    }
//  Show one single post
    @GetMapping("/posts/{id}")
    public String singlePost(@PathVariable long id, Model model){
        Post post = new Post("Title","body for the post");
        model.addAttribute("post",post);


        return "posts/show";
    }

//    Request mapping for explicit path and method
//    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
//    @ResponseBody
//    public String createForm(){
//        return "Form for create a blog post";
//    }
//
//    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
//    @ResponseBody
//    public String createPost(){
//        return "Form for create a blog post";
//    }



//    Get and Post mapping direct annotation
    @GetMapping("/posts/create")
    @ResponseBody
    public String createForm(){
        return "Form to create a blog post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost(){
        return "Create post here";
    }

}
