package com.dialog.exam.shopping_cart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dialog.exam.shopping_cart.model.ProductCart;
import com.dialog.exam.shopping_cart.model.ShoppingCart;

public interface CartService {

	ProductCart addItemToCart(Integer userId, Integer productId);
	
	ProductCart updateCart(Integer cartId, Integer productId, Integer quentity);
	
	List<ProductCart> removeItemFromCart(Integer cartId, Integer productId);
}
