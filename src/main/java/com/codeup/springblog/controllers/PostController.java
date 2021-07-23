package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }

    @PostMapping ("/posts/edit")
    public String save(@RequestParam("postId") long postId, @RequestParam("title") String title, @RequestParam("body") String body){
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



    public List<Post> posts = new ArrayList<>(){{
        add( new Post("Title 1", "Stuff for body 1"));
        add(new Post("2nd title", "Stuff for 2nd body."));
    }};



//    show an index of all the posts
    @GetMapping("/posts")
    public String posts(Model model) {

        model.addAttribute("posts",postDao.findAll());

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
