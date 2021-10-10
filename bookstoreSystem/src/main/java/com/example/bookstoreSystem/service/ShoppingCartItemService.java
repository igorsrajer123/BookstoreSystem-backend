package com.example.bookstoreSystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstoreSystem.model.Book;
import com.example.bookstoreSystem.model.BooksBookstores;
import com.example.bookstoreSystem.model.OtherProduct;
import com.example.bookstoreSystem.model.OtherProductsBookstores;
import com.example.bookstoreSystem.model.ShoppingCart;
import com.example.bookstoreSystem.model.ShoppingCartItem;
import com.example.bookstoreSystem.repository.BookRepository;
import com.example.bookstoreSystem.repository.BooksBookstoresRepository;
import com.example.bookstoreSystem.repository.OtherProductRepository;
import com.example.bookstoreSystem.repository.OtherProductsBookstoresRepository;
import com.example.bookstoreSystem.repository.ShoppingCartItemRepository;
import com.example.bookstoreSystem.repository.ShoppingCartRepository;

@Service
public class ShoppingCartItemService {

	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	
	@Autowired
	private ShoppingCartItemRepository shoppingCartItemRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private OtherProductRepository otherProductRepository;
	
	@Autowired
	private BooksBookstoresRepository bbRepository;
	
	@Autowired
	private OtherProductsBookstoresRepository opbRepository;
	
	public List<ShoppingCartItem> findAllByShoppingCartId(Long id) {
		return shoppingCartItemRepository.findAllByShoppingCartId(id);
	}
	
	public ShoppingCartItem createNew(ShoppingCartItem shoppingCartItem) {
		ShoppingCart myShoppingCart = shoppingCartRepository.findOneById(shoppingCartItem.getShoppingCart().getId());
		
		List<ShoppingCartItem> existingItems = shoppingCartItemRepository.findAllByShoppingCartId(myShoppingCart.getId());
		boolean itemAlreadyInShoppingCart = false;
		for(ShoppingCartItem i : existingItems) {
			if(shoppingCartItem.getOtherProduct() == null) {
				if(i.getBook() != null) {
					if(i.getBook().getId() == shoppingCartItem.getBook().getId()) {
						i.setAmount(i.getAmount() + 1);
						shoppingCartItemRepository.save(i);
						itemAlreadyInShoppingCart = true;
						return i;
					}
				}
			}
					
			if(shoppingCartItem.getBook() == null) {
				if(i.getOtherProduct() != null) {
					if(i.getOtherProduct().getId() == shoppingCartItem.getOtherProduct().getId()) {
						i.setAmount(i.getAmount() + 1);
						shoppingCartItemRepository.save(i);
						itemAlreadyInShoppingCart = true;
						return i;
					}
				}
			}
		}
			
		if(!itemAlreadyInShoppingCart) return createNewItemInstance(shoppingCartItem, myShoppingCart);

		return null;
	}
	
	private ShoppingCartItem createNewItemInstance(ShoppingCartItem shoppingCartItem, ShoppingCart myShoppingCart) {
		ShoppingCartItem newItem = new ShoppingCartItem();
		newItem.setAmount(1);
		newItem.setShoppingCart(myShoppingCart);
			
		if(shoppingCartItem.getOtherProduct() == null) {
			Long id = shoppingCartItem.getBook().getId();
			newItem.setBook(bookRepository.findOneById(id));
		}
			
		if(shoppingCartItem.getBook() == null) 
			newItem.setOtherProduct(otherProductRepository.findOneById(shoppingCartItem.getOtherProduct().getId()));
			
		shoppingCartItemRepository.save(newItem);
			
		return newItem;
	}
	
	@Transactional
	public Long deleteItem(Long id) {
		return shoppingCartItemRepository.deleteOneById(id);		
	}
	
	public Boolean checkIfItemAvailable(Long id, int amount) {
		Book myBook = bookRepository.findOneById(id);
		
		if(myBook == null) {
			OtherProduct myOtherProduct = otherProductRepository.findOneById(id);
			List<OtherProductsBookstores> myOtherProductsBookstores = opbRepository.findAllByOtherProductId(myOtherProduct.getId());
			
			int otherProductSum = 0;
			for(OtherProductsBookstores o : myOtherProductsBookstores)
				otherProductSum += o.getAmount();
			
			if(amount > otherProductSum)
				return false;
			
			return true;
		}else {
			List<BooksBookstores> myBooksBookstores = bbRepository.findAllByBookId(myBook.getId());
			int bookSum = 0;
			for(BooksBookstores b : myBooksBookstores)
				bookSum += b.getAmount();
			
			if(amount > bookSum)
				return false;
		
			return true;
		}
	}
}
