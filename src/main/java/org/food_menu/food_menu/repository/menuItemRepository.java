package org.food_menu.food_menu.repository;

import java.util.List;
import java.util.Optional;

import org.food_menu.food_menu.dto.menuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface menuItemRepository extends JpaRepository<menuItem, Integer>{

	boolean existsByName(String name);

    Optional<menuItem> findByName(String name);

    List<menuItem> findByCategory(String category);

    List<menuItem> findByPriceBetween(double price, double price2);

}
