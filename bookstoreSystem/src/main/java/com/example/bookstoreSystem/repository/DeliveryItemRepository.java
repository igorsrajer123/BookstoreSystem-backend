package com.example.bookstoreSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstoreSystem.model.DeliveryItem;

@Repository
public interface DeliveryItemRepository extends JpaRepository<DeliveryItem, Long>{

	DeliveryItem findOneById(Long id);
	
	List<DeliveryItem> findAllByDeliveryId(Long id);
}
