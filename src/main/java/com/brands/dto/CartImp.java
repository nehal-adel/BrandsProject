package com.brands.dto;

import com.brands.dao.Products;

import java.util.List;

public class CartImp implements CartDto {
    @Override
    public Products getProductByProductId(int product_id) {
        return null;
    }

    @Override
    public boolean addProductByProductIdToCart(int product_id) {
        return false;
    }

    @Override
    public boolean removeProductByProductIdFromCart(int product_id) {
        return false;
    }

    @Override
    public boolean updateQuantityByProductId(int product_id) {
        return false;
    }

    @Override
    public List<Products> getAllProductByUserId(int user_id) {
        return null;
    }

    @Override
    public boolean userBuyProductForUser(int user_id) {
        return false;
    }

    @Override
    public void updateNoOfProductsInCart(int product_id, int user_id) {

    }

    @Override
    public Double calculateSumOfProducts(int user_id) {
        return null;
    }
}
