package com.techelevator.controller;

import com.techelevator.repository.MealPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("meal-plan")
@CrossOrigin(origins = "*")
public class MealPlanController {

    @Autowired
    MealPlanRepository mealPlanRepository;


}
