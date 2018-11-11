package com.dialog.exam.shopping_cart.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dialog.exam.shopping_cart.dao.CustomerDao;
import com.dialog.exam.shopping_cart.dao.ProductCartDao;
import com.dialog.exam.shopping_cart.dao.ProductDao;
import com.dialog.exam.shopping_cart.dao.ShoppingCartDao;
import com.dialog.exam.shopping_cart.model.Customer;
import com.dialog.exam.shopping_cart.model.Product;
import com.dialog.exam.shopping_cart.model.ProductCart;
import com.dialog.exam.shopping_cart.model.ShoppingCart;

@Service
@Transactional
public class CartServiceImpl implements CartService {

	@Autowired
	private ShoppingCartDao shoppingCartDao;

	@Autowired
	private ProductCartDao productCartDao;

	@Autowired
	private ProductDao productDao;

	@Autowired
	private CustomerDao customerDao;

	@Override
	public ProductCart addItemToCart(Integer userId, Integer productId) {
		try {
			
			ShoppingCart cart = shoppingCartDao.getShoppingCartByCustomerId(userId);
			Optional<Product> product = productDao.findById(productId);

				if (cart != null) {
					
					ProductCart productCart = new ProductCart();
					productCart.setProduct(product.get());
					productCart.setQty(1);
					productCart.setShoppingCart(cart);
					
					return productCartDao.save(productCart);
					
//					Integer persistedQty = productCart.getQty();
//					
//					if (persistedQty >= quentity) {  // remove from cart
//						productCart.setQty(persistedQty - quentity);
//					} else if (persistedQty <= quentity) { // add to cart
//						productCart.setQty(persistedQty + quentity);
//					}
//					return productCartDao.save(productCart);
				} else {
					ShoppingCart shoppingCart = new ShoppingCart();
					shoppingCart.setCustomer(customerDao.findById(userId).get());
					shoppingCart.setDate(new Date());

					ShoppingCart persistedShoppingCart = shoppingCartDao.save(shoppingCart);
					ProductCart productCart = new ProductCart();
					productCart.setProduct(product.get());
					productCart.setQty(1);
					productCart.setShoppingCart(persistedShoppingCart);
					return productCartDao.save(productCart);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ProductCart> removeItemFromCart(Integer cartId, Integer productId) {
		Integer value = productCartDao.removeItemFromCart(productId, cartId);
		if (value != null) {
			return productCartDao.getProductCartByCartId(cartId);
		}
		return null;
	}

	@Override
	public ProductCart updateCart(Integer cartId, Integer productId, Integer quentity) {
		
		ProductCart productCart = productCartDao.getProductCartByProductIdAndCartId(productId, cartId);
		Integer persistedQty = productCart.getQty();
		
		if (persistedQty >= quentity) {  // remove from cart
			productCart.setQty(persistedQty - quentity);
		} else if (persistedQty <= quentity) { // add to cart
			productCart.setQty(persistedQty + quentity);
		}	
		return productCartDao.save(productCart);
	}

}
