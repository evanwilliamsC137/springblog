package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import jdk.jfr.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String welcome() {
        return "home";
    }

    @GetMapping("/search")
    public String getSearchForm() {
        return "search/index";
    }

//    @PostMapping("/search")
//    public String makeSearch(Model model, @RequestParam(name = "search-params") String params, @RequestParam(name = "query") String query) {
//        List<Post> searchResults;
//        searchResults = postD.findAllEventsByTitleOrLocationContaining(query);
//        model.addAttribute("searchResults", searchResults);
//        return "search/results";
//    }

    @GetMapping("/search/results")
    public String showResults(@ModelAttribute(name = "searchResults") ArrayList<Event> searchResults, @ModelAttribute(name = "searchResults2") ArrayList<Organization> searchResults2) {
        return "search/results";
    }
}
