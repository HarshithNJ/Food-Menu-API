package org.food_menu.food_menu.controller;

import org.food_menu.food_menu.service.menuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class menuItemController {
    
    @Autowired
    menuItemService service;
}
