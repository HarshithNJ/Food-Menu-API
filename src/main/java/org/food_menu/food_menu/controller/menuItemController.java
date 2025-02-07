package org.food_menu.food_menu.controller;

import org.food_menu.food_menu.dto.menuItem;
import org.food_menu.food_menu.service.menuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class menuItemController {
    
    @Autowired
    menuItemService service;


    // To add a item to the menu
    @PostMapping("/menuItems")
    public ResponseEntity<Object> addMenuItem(@RequestBody menuItem item){
        return service.addMenuItem(item);
    }






    // To fetch items from the menu
    @GetMapping("/menuItems")
    public ResponseEntity<Object> getMenuItem(){
        return service.getMenu();
    }

    
}
