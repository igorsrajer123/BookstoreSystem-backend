package com.example.bookstoreSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstoreSystem.model.ShoppingCartItem;

@Repository
public interface ShoppingCartItemRepository extends JpaRepository<ShoppingCartItem, Long>{

	List<ShoppingCartItem> findAll();
	
	List<ShoppingCartItem> findAllByShoppingCartId(Long id);
	
	ShoppingCartItem findOneById(Long id);
	
	Long deleteOneById(Long id);
}
