package com.codeup.springblog.controllers;
import com.codeup.springblog.models.Ad;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.codeup.springblog.repositories.AdRepository;

@Controller
class AdController {
// Ad repository injection
//    Set as final, cant be changed
    private final AdRepository adDao;
    private final UserRepository usersDao;

//    Constructor takes in Dao as parameter
    public AdController(AdRepository adDao, UserRepository usersDao) {
        this.adDao = adDao;
        this.usersDao = usersDao;
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

    @GetMapping("ads/create")
    public String createAdForm(Model model) {
        model.addAttribute("ad",new Ad());
        return "ads/create";
    }

    @PostMapping("ads/create")
    public String createAd(@ModelAttribute Ad ad) {
        ad.setUser(usersDao.getById(1L));
        adDao.save(ad);
        return "redirect:/ads";
    }

}
