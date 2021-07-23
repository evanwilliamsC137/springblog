package com.codeup.springblog.controllers;
import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.codeup.springblog.models.AdRepository;

@Controller
class AdController {
// Ad repository injection
//    Set as final, cant be changed
    private final AdRepository adDao;

//    Constructor takes in Dao as parameter
    public AdController(AdRepository adDao) {
        this.adDao = adDao;
    }

    @GetMapping("/ads")
    public String index(Model model){
        model.addAttribute("ads",adDao.findAll());
        return "ads/index";
    }

    @GetMapping("/ads/{n}")
    public String viewOne(@PathVariable long n, Model model) {
        model.addAttribute("ad",adDao.findById(n));
        return "ads/show";
    }

    @GetMapping("/ads/first/{title}")
    public String viewOneByTitle(@PathVariable String title, Model model) {
        model.addAttribute("ad",adDao.findFirstByTitle(title));
        return "ads/show";
    }
}
