package com.dialog.exam.shopping_cart.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dialog.exam.shopping_cart.model.ProductCart;
import com.dialog.exam.shopping_cart.model.ShoppingCart;
import com.dialog.exam.shopping_cart.service.CartService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ApiOperation(value="Add to Cart", response=ProductCart.class)
	public ResponseEntity<ProductCart> addToCart(@RequestBody Map<String, Object> addToCartRequestBody) {
		
		ProductCart productCart = cartService.addItemToCart((Integer)addToCartRequestBody.get("user_id"),
				(Integer)addToCartRequestBody.get("product_id"));
		
		return new ResponseEntity<ProductCart>(productCart, HttpStatus.OK);	
	}
	
	@RequestMapping(value="/update/cart/{cartId}/product/{productId}", method=RequestMethod.PUT)
	@ApiOperation(value="Update Product Qty In Cart", response=ProductCart.class)
	public ResponseEntity<ProductCart> updateCart(@PathVariable Integer cartId, 
			@PathVariable Integer productId, 
			@RequestBody Map<String, Object> updateCartRequestBody) {
		
		ProductCart productCart = cartService.updateCart(cartId, productId, 
				(Integer)updateCartRequestBody.get("qty"));
		
		return new ResponseEntity<ProductCart>(productCart, HttpStatus.ACCEPTED);	
	}
	
	@RequestMapping(value="/remove/cart/{cartId}/product/{productId}", method=RequestMethod.DELETE)
	@ApiOperation(value="Remove Item From Cart", response=ProductCart.class)
	public ResponseEntity<List<ProductCart>> removeItemFromCart(@PathVariable Integer cartId, @PathVariable Integer productId) {
		return new ResponseEntity<List<ProductCart>> (cartService.removeItemFromCart(cartId, productId), HttpStatus.OK);	
	}
}
