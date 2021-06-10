package com.maike.meal.controller;

import java.util.LinkedHashMap;
import java.util.List;

import com.maike.meal.domain.Meal;
import com.maike.meal.domain.SearchText;
import com.maike.meal.service.ParsingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

    private static final String MAIN_PAGE = "main";
    private static final String JSON_MEAL_URL = "https://www.themealdb.com/api/json/v1/1/search.php?s=";

    @Autowired
    private ParsingService parsingService;

    @GetMapping
    public String main(@RequestParam(value="page", required = false) String page, Model model){
        int pagination = page != null ? Integer.parseInt(page) : 1;
        Object obj = parsingService.parse(JSON_MEAL_URL);
        LinkedHashMap lm = (LinkedHashMap) obj;
        List<Meal> meals = (List<Meal>) lm.get("meals");
        int countPagination = Math.round((meals.size() / 5));
        model.addAttribute("meals", meals);
        model.addAttribute("countPagination", countPagination);
        model.addAttribute("pagination", pagination);
        model.addAttribute("searchText", (new SearchText()));
        return MAIN_PAGE;
    }

    @PostMapping
    public String search(@RequestParam(value="page", required = false) String page, 
        @ModelAttribute("searchText") SearchText searchText, Model model){
        Object obj = parsingService.parse(JSON_MEAL_URL + searchText.getText());
        LinkedHashMap lm = (LinkedHashMap) obj;
        List<Meal> meals = (List<Meal>) lm.get("meals");
        if(meals != null){
            int countPagination = Math.round((meals.size() / 5));
            model.addAttribute("countPagination", countPagination);
        }
        model.addAttribute("meals", meals);
        model.addAttribute("pagination", searchText.getText().isEmpty() ? (page != null ? Integer.parseInt(page) : 1) : null);
        model.addAttribute("searchText", searchText);
        return MAIN_PAGE;
    }
    
}
