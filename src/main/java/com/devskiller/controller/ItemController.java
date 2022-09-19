package com.devskiller.controller;

import com.devskiller.service.impl.IItemService;
import com.devskiller.service.impl.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private IItemService itemService;

    //To test the controller you can use http://localhost:8080/items/titles/50
    @GetMapping(value = "titles/{rating}", produces = "application/json;charset=UTF-8")
    public List<String> getTitles(@PathVariable("rating") Double rating) {
        return itemService.getTitlesWithAverageRatingLowerThan(rating);
    }
}
