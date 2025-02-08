package org.food_menu.food_menu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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










    public ResponseEntity<Object> getMenu() {
        List<menuItem> menu = repository.findAll();

        if(menu.isEmpty()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Menu is empty");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success","Menu Items Obtained Successfully");
            map.put("Menu Items", menu);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }
    }

    public ResponseEntity<Object> getMenuItemByName(String name) {
        Optional<menuItem> menu = repository.findByName(name);

        if(menu.isPresent()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success","Menu Item Obtained Successfully");
            map.put("Menu Item", menu);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Item not found in Menu with the name : "+name);

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> getMenuItemByCategory(String category) {
        List<menuItem> menu = repository.findByCategory(category);

        if(menu.isEmpty()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Item not found in Menu with the category : "+category);

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success","Menu Item Obtained Successfully");
            map.put("Menu Items", menu);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }
    }

    public ResponseEntity<Object> getMenuItemByPrice(double price, double price1) {
        List<menuItem> menu = repository.findByPriceBetween(price, price1);

        if(menu.isEmpty()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Item not found in Menu with the price range : "+price+" to "+price1);

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success","Menu Item Obtained Successfully");
            map.put("Menu Items", menu);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }
    }










    public ResponseEntity<Object> deleteMenuItem(String name) {
        Optional<menuItem> menu = repository.findByName(name);

        if(menu.isPresent()){
            repository.deleteById(menu.get().getId());

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Item deleted from Menu Successfully");
            map.put("Menu Items", menu);

            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Item not found in Menu with the name : "+name);

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }
    }










    public ResponseEntity<Object> updateMenuItem(String name, menuItem item) {
        Optional<menuItem> menu = repository.findByName(name);

        if(menu.isPresent()){
            menuItem menuItem = menu.get();

            if(item.getName() != null)
                menuItem.setName(item.getName());

            if(item.getPrice() != 0)
                menuItem.setPrice(item.getPrice());

            if(item.getDescription() != null)
                menuItem.setDescription(item.getDescription());

            if(item.getCategory() != null)
                menuItem.setCategory(item.getCategory());

            repository.save(menuItem);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Item updated in Menu Successfully");
            map.put("Menu Items", menuItem);

            return new ResponseEntity<Object>(map, HttpStatus.ACCEPTED);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Item not found in Menu with the name : "+name);

            return new ResponseEntity<Object>(map, HttpStatus.NOT_MODIFIED);
        }
    }

}
