package com.dialog.exam.shopping_cart.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dialog.exam.shopping_cart.model.ProductCart;

@Repository
public interface ProductCartDao extends CrudRepository<ProductCart, Integer> {
	
	@Query(value = "SELECT * FROM product_cart WHERE product_cart.product_id = ?1", 
			nativeQuery=true)
	ProductCart getProductCartByProductId(Integer product_id);
	
	@Query(value = "SELECT * FROM product_cart WHERE product_cart.product_id = ?1 AND product_cart.cart_id = ?2", 
			nativeQuery=true)
	ProductCart getProductCartByProductIdAndCartId(Integer product_id, Integer cartId);
	
	@Query(value = "SELECT * FROM product_cart WHERE product_cart.cart_id = ?1", 
			nativeQuery=true)
	List<ProductCart> getProductCartByCartId(Integer cartId);
	
	@Query(value = "DELETE FROM product_cart WHERE product_cart.product_id = ?1 AND product_cart.cart_id = ?2", 
			nativeQuery=true)
	@Modifying
	Integer removeItemFromCart(Integer product_id, Integer cartId);
}
