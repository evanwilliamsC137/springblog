package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DiceRollController {

    private int roll = 0;

    @GetMapping("/roll-dice")
    public String Guess() {
        roll = dice();
        return "diceRoll";
    }

//    Use model to pass data to the view
    @GetMapping("/roll-dice/{n}")
    public String GuessResponse(@PathVariable int n, Model model) {

        boolean guessCorrect = false;
        if (n == roll) {
            guessCorrect = true;
        }

//        add attribute with model to pass data to view
        model.addAttribute("roll", roll);
        model.addAttribute("n", n);
        model.addAttribute("guessCorrect", guessCorrect);

        return "diceResult";
    }

    public int dice() {
        int roll = (int) (Math.random() * 6) + 1;
        return roll;
    }
}
