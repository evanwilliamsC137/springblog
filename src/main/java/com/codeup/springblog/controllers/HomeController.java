package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
import jdk.jfr.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private PostRepository postsDao;

    public HomeController(PostRepository postsDao) {
        this.postsDao = postsDao;
    }

    @GetMapping("/")
    public String welcome() {
        return "home";
    }

    @GetMapping("/search")
    public String getSearchForm() {
        return "search/index";
    }

    @PostMapping("/search")
    public String makeSearch(Model model, @RequestParam(name = "query") String query) {
        List<Post> searchResults;
        searchResults = postsDao.findAllPostsContaining(query);
        model.addAttribute("searchResults", searchResults);
        return "search/results";
    }

    @GetMapping("/search/results")
    public String showResults(@ModelAttribute(name = "searchResults") ArrayList<Post> searchResults) {
        return "search/results";
    }
}
