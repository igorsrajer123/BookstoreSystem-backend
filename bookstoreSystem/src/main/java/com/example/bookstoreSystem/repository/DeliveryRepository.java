package com.example.bookstoreSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstoreSystem.model.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long>{

	List<Delivery> findAll();
	
	Delivery findOneById(Long id);
}
