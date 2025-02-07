package org.food_menu.food_menu.controller;

import java.util.List;

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

    @GetMapping("/menuItems/{name}")
    public ResponseEntity<Object> getMenuItemByName(@PathVariable String name){
        return service.getMenuItemByName(name);
    }

    @GetMapping("/menuItems/category/{category}")
    public ResponseEntity<Object> getMenuItemByCategory(@PathVariable String category){
        return service.getMenuItemByCategory(category);
    }

    @GetMapping("/menuitems/minprice/{price}/maxprice/{price1}")
    public ResponseEntity<Object> getMenuItemByPrice(@PathVariable double price, @PathVariable double price1){
        return service.getMenuItemByPrice(price, price1);
    }
}
