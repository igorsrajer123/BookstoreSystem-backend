package com.example.bookstoreSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstoreSystem.model.OtherProductsBookstores;

@Repository
public interface OtherProductsBookstoresRepository extends JpaRepository<OtherProductsBookstores, Long>{

	List<OtherProductsBookstores> findAll();
	
	OtherProductsBookstores findOneById(Long id);
	
	List<OtherProductsBookstores> findAllByBookstoreId(Long id);
	
	List<OtherProductsBookstores> findAllByOtherProductId(Long id);
}
