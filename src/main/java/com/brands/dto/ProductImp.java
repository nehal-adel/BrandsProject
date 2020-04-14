package com.brands.dto;

import com.brands.dao.Products;
import com.brands.dao.Users;

import java.util.List;

public class ProductImp implements ProductDto {
    @Override
    public List<Products> searchProductByName(String name) {
        return null;
    }

    @Override
    public List<Products> searchProductByPrice(Double price) {
        return null;
    }

    @Override
    public List<Products> getAllProducts() {
        return null;
    }

    @Override
    public List<Products> getAllProductsByCategoryId(int category_id) {
        return null;
    }

    @Override
    public boolean addProduct(Products product) {
        return false;
    }

    @Override
    public Users getUserById(int user_id) {
        return null;
    }
}
