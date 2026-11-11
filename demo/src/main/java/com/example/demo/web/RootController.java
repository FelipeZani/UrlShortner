package com.example.demo.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Service.UrlShortenerService;
import com.example.demo.domain.Url;

import org.springframework.ui.Model;
@Controller 
public class RootController {

    UrlShortenerService urlShortenerService; 

    RootController(UrlShortenerService urlShortenerService ){ this.urlShortenerService = urlShortenerService;}
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to my URL shortener!");
        return "index.html";
    }

    @PostMapping("/createShortenUrl")
    public String createShortenUrl(@RequestParam("url") String url,Model model) {

        Url shortenedUrl = urlShortenerService.create(url);

        model.addAttribute("shortenedUrl", "http://localhost:8080/accessUrl/"+shortenedUrl.getNewUrl());
            model.addAttribute("targetUrl",shortenedUrl.getOriginalUrl());


        return "fragments/shortenedUrl :: result";
    }
    @GetMapping("/accessUrl/{url}")
public ModelAndView accessUrl(@PathVariable("url") String url) {

    String originalUrl = urlShortenerService.access(url);

    System.out.println("Original website: " + originalUrl);

    return new ModelAndView("redirect:" + originalUrl);
}
}