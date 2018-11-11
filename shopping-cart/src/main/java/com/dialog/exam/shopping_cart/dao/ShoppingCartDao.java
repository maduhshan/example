package com.dialog.exam.shopping_cart.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dialog.exam.shopping_cart.model.Customer;
import com.dialog.exam.shopping_cart.model.ShoppingCart;

@Repository
public interface ShoppingCartDao extends CrudRepository<ShoppingCart, Integer> {

	@Query(value = "SELECT * FROM shopping_cart WHERE shopping_cart.customer_id = ?1", nativeQuery = true)
	ShoppingCart getShoppingCartByCustomerId(Integer customer_id);
}
