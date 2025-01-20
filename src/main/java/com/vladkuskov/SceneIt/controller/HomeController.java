package com.vladkuskov.SceneIt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
//handles the root, serving as the home page/landing page
    @GetMapping("/")
    public String showLandingPage(Model model) {
        // Define genres for the buttons
        String[] genres = {"Action", "Comedy", "Drama", "Fantasy", "Horror", "Romance", "Thriller"};
        model.addAttribute("genres", genres);
        return "landing";
    }
}
