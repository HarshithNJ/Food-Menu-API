package org.food_menu.food_menu.service;

import java.util.HashMap;
import java.util.Map;

import org.food_menu.food_menu.dto.menuItem;
import org.food_menu.food_menu.repository.menuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class menuItemService {
    
    @Autowired
    menuItemRepository repository;

    public ResponseEntity<Object> addMenuItem(menuItem item) {
        if(item.getPrice() <= 0){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Item Value must be greater than 0");

            return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
        }else if(repository.existsByName(item.getName())){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Item already exists by name : "+item.getName());
            
            return new ResponseEntity<Object>(map, HttpStatus.CONFLICT);
        }else{
            repository.save(item);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Item added to Menu Successfully");
            map.put("Menu Items", item);

            return new ResponseEntity<Object>(map, HttpStatus.CREATED);
        }
    }

}
