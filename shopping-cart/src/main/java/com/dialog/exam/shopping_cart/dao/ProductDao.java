package com.dialog.exam.shopping_cart.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dialog.exam.shopping_cart.model.Product;

@Repository
public interface ProductDao extends CrudRepository<Product, Integer> {

}
