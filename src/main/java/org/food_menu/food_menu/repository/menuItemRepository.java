package org.food_menu.food_menu.repository;

import org.food_menu.food_menu.dto.menuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface menuItemRepository extends JpaRepository<menuItem, Integer>{

}
