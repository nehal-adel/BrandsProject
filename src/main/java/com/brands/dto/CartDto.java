/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brands.dto;

import com.brands.dao.Products;
import java.util.List;

/**
 *
 * @author Shimaa Mohammed
 */
public interface CartDto {
    /*nehal*/
    public Products getProductByProductId(int product_id);
    public boolean addProductByProductIdToCart(int product_id);
    public boolean removeProductByProductIdFromCart(int product_id);
    public boolean updateQuantityByProductId(int product_id);
    public List<Products> getAllProductByUserId(int user_id); // should update buying date
    public boolean userBuyProductForUser(int user_id);
    public void updateNoOfProductsInCart(int product_id, int user_id); // will be rethought when we change DB
    public Double calculateSumOfProducts(int user_id);
    /*nehal end*/

     /*badri*/
    
     /*badri end*/
    
    
     /*noura*/
    
     /*noura end*/
    
    
     /*hesham*/
    
     /*end hesham*/
    
    
     /*shimaa*/
    
     /*shimaa end*/
}
