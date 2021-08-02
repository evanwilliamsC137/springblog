package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.exceptions.TemplateInputException;

import javax.persistence.EntityNotFoundException;

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

    @PostMapping("/posts/{id}/edit")
    public String postToEdit(@PathVariable long id, @ModelAttribute Post post) {
//        checks to see if the user is logged in and has authentication
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post postFromDB = postDao.getById(id);
        if(user.getId() == postFromDB.getUser().getId()){
            post.setUser(user);
            postDao.save(post);
        }
        return "redirect:/posts/" + id;
    }

    @GetMapping("/posts/{id}/edit")
    public String editForm(@PathVariable long id, Model model){
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post postToEdit = postDao.findById(id);
        if (currentUser.getId() == postToEdit.getUser().getId()) {
            model.addAttribute("post", postToEdit);
            return "posts/edit";
        }else {
            return "redirect:/posts/" + id;
        }
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
        try {
            Post post = postDao.findById(id);
            model.addAttribute("post",post);
            if (post.getId() == 0) {
                return "redirect:/posts";
            }
            boolean isPostOwner = false;
            if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {
                User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                isPostOwner = currentUser.getId() == post.getUser().getId();
            }
            model.addAttribute("isPostOwner",isPostOwner);

            return "posts/show";
        }catch (Exception e) {
            e.printStackTrace();
            return "redirect:/posts";
        }

    }

    @GetMapping("/posts/create")
    public String createForm(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post){
        post.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        postDao.save(post);
        emailSvc.prepareAndSend(post,"New Post","New post has been created!");
        return "redirect:/posts";
    }

}
