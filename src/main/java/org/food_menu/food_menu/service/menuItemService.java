package org.food_menu.food_menu.service;

import org.food_menu.food_menu.repository.menuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class menuItemService {
    
    @Autowired
    menuItemRepository repository;
}
