package com.example.bookstoreSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstoreSystem.model.OtherProduct;
import com.example.bookstoreSystem.model.ProductType;

@Repository
public interface OtherProductRepository extends JpaRepository<OtherProduct, Long>{

	List<OtherProduct> findAll();
	
	OtherProduct findOneById(Long id);
	
	OtherProduct findOneByName(String name);
	
	OtherProduct findOneByCode(String code);
	
	List<OtherProduct> findAllByPublisherId(Long id);
	
	List<OtherProduct> findAllByType(ProductType type);
	
	OtherProduct findOneByOtherProductsInBookstores_Id(Long id);
	
	OtherProduct findOneByOtherProductReceiptItems_Id(Long id);
	
	OtherProduct findOneByShoppingCartItems_Id(Long id);
	
	OtherProduct findOneByDeliveryItems_Id(Long id);
	
	List<OtherProduct> findAllByNameContainingIgnoreCase(String name);
}
