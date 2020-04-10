/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brands.dto;

import com.brands.dao.*;
import java.util.List;

/**
 *
 * @author Shimaa Mohammed
 */
public interface ProductDto {
    /*nehal*/
    public List<Products> searchProductByName(String name);
    public List<Products> searchProductByPrice(Double price);
    public List<Products> getAllProducts();
    public List<Products> getAllProductsByCategoryId(int category_id);
    public boolean addProduct(Products product);
    public Users getUserById(int user_id);
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
