package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.PostRepository;
import com.codeup.springblog.models.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository usersDao;

    public PostController(PostRepository postDao, UserRepository usersDao){
        this.postDao = postDao;
        this.usersDao = usersDao;
    }

    @PostMapping ("/posts/edit")
    public String editPost(@RequestParam("postId") long postId, @RequestParam("title") String title, @RequestParam("body") String body){
        Post post = new Post(postId,title,body);
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/edit")
    public String editForm(@RequestParam("editPost") long id, Model model){
        model.addAttribute("post", postDao.findById(id));
        return "posts/edit";
    }

    @PostMapping("/posts/delete")
    public String deletePost(@RequestParam(name = "deletePost") long id){
        postDao.deleteById(id);
        return "redirect:/posts";
    }

//    show an index of all the posts
    @GetMapping("/posts")
    public String posts(Model model) {

        model.addAttribute("posts",postDao.findAll());

        return "posts/index";
    }

//  Show one single post
    @GetMapping("/posts/{id}")
    public String singlePost(@PathVariable long id, Model model){
        model.addAttribute("post",postDao.findById(id));

        return "posts/show";
    }

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

//    Walkthrough
//@PostMapping ("/posts/edit/{id}")
//public String editPost(@RequestParam("postId") long postId, @RequestParam("title") String title, @RequestParam("body") String body){
//    Post post = postDao.getById(postId);
//    post.setId(postId);
//    post.setTitle(title);
//    post.setBody(body);
//    postDao.save(post);
//    return "redirect:/posts";
//}

//    Walkthrough
//    @GetMapping("/posts/edit")
//    public String editForm2(@PathVariable long id, Model model){
//        model.addAttribute("post", postDao.findById(id));
//        return "posts/edit";
//    }

}
