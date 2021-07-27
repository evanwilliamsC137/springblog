package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.PostRepository;
import com.codeup.springblog.models.User;
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

    @PostMapping ("/posts/{id}/edit")
    public String save(@PathVariable long id, @ModelAttribute Post post){
        post.setUser(usersDao.getById(1L));
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String editForm(@PathVariable long id, Model model){
        Post postToEdit = postDao.findById(id);
        model.addAttribute("post", postToEdit);
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

    @GetMapping("/posts/{id}")
    public String singlePost(@PathVariable long id, Model model){
        model.addAttribute("post",postDao.findById(id));

        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String createForm(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post){
        post.setUser(usersDao.getById(1L));
        postDao.save(post);
        return "redirect:/posts";
    }

}
