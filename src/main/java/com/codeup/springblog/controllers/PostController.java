package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.PostRepository;
import com.codeup.springblog.models.User;
import com.codeup.springblog.models.UserRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository usersDao;
    private final EmailService emailSvc;

    public PostController(PostRepository postDao, UserRepository usersDao, EmailService emailSvc) {
        this.postDao = postDao;
        this.usersDao = usersDao;
        this.emailSvc = emailSvc;
    }

    @PostMapping ("/posts/{id}/edit")
    public String save(@PathVariable long id, @ModelAttribute Post post){
        return createPost(post);
    }

    @GetMapping("/posts/{id}/edit")
    public String editForm(@PathVariable long id, Model model){
        Post postToEdit = postDao.findById(id);
        model.addAttribute("post", postToEdit);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id){
        postDao.delete(postDao.getById(id));
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
        emailSvc.prepareAndSend(post,"New Post","New post has been created!");
        return "redirect:/posts";
    }

}
