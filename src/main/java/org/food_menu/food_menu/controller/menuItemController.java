package org.food_menu.food_menu.controller;

import org.food_menu.food_menu.dto.menuItem;
import org.food_menu.food_menu.service.menuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Menu Items API", description = "To Perform Operations on Menu Items")
public class menuItemController {
    
    @Autowired
    menuItemService service;


    // To add a item to the menu
    @Operation(summary = "To add a item to the menu", description = "Adds a new item to the menu")
    @ApiResponse(responseCode = "201", description = "Item added to the menu")
    @ApiResponse(responseCode = "409", description = "Item already exists in the menu")
    @ApiResponse(responseCode = "400", description = "Item Value must be greater than 0")
    @PostMapping("/menuItems")
    public ResponseEntity<Object> addMenuItem(@RequestBody menuItem item){
        return service.addMenuItem(item);
    }






    // To fetch items from the menu
    @GetMapping("/menuItems")
    @Operation(summary = "To fetch all items from the menu", description = "Fetches all items from the menu")
    @ApiResponse(responseCode = "302", description = "Items fetched from the menu Successfully")
    @ApiResponse(responseCode = "404", description = "Menu is empty")
    public ResponseEntity<Object> getMenuItem(){
        return service.getMenu();
    }

    @GetMapping("/menuItems/{name}")
    @Operation(summary = "To fetch a specific item by name from the menu", description = "Fetches a specific item by name from the menu")
    @ApiResponse(responseCode = "302", description = "Item fetched from the menu Successfully")
    @ApiResponse(responseCode = "404", description = "Menu is empty")
    public ResponseEntity<Object> getMenuItemByName(@PathVariable String name){
        return service.getMenuItemByName(name);
    }

    @GetMapping("/menuItems/category/{category}")
    @Operation(summary = "To Fetch Items By Category From The Menu", description = "Fetches Items By Category From The Menu")
    @ApiResponse(responseCode = "302", description = "Items fetched from the menu Successfully")
    @ApiResponse(responseCode = "404", description = "Menu is empty")
    public ResponseEntity<Object> getMenuItemByCategory(@PathVariable String category){
        return service.getMenuItemByCategory(category);
    }

    @GetMapping("/menuitems/minprice/{price}/maxprice/{price1}")
    @Operation(summary = "To Fetch Items By Price Range From The Menu", description = "Fetches Items By Price Range From The Menu")
    @ApiResponse(responseCode = "302", description = "Items fetched from the menu Successfully")
    @ApiResponse(responseCode = "404", description = "Menu is empty")
    public ResponseEntity<Object> getMenuItemByPrice(@PathVariable double price, @PathVariable double price1){
        return service.getMenuItemByPrice(price, price1);
    }









    // To Delete a item from the menu
    @DeleteMapping("/menuItems/{name}")
    @Operation(summary = "To Delete a item from the menu", description = "Deletes a item from the menu")
    @ApiResponse(responseCode = "200", description = "Item deleted from the menu Successfully")
    @ApiResponse(responseCode = "404", description = "Item not found in the menu")
    public ResponseEntity<Object> deleteMenuItem(@PathVariable String name){
        return service.deleteMenuItem(name);
    }






    //To Update a item in menu
    @PatchMapping("/menuItems/{name}")
    @Operation(summary = "To Update a item in menu", description = "Updates a item in menu")
    @ApiResponse(responseCode = "202", description = "Item updated in the menu Successfully")
    @ApiResponse(responseCode = "404", description = "Item not found in the menu")
    public ResponseEntity<Object> updateMenuItem(@PathVariable String name, @RequestBody menuItem item){
        return service.updateMenuItem(name, item);
    }
}
