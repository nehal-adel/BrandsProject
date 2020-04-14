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

/*
-user :
1-select product by name //search (like) *
2-select product by id // add to cart *
3-insert product id into cart // add to cart *
4-remove product by id from cart // remove from cart *
5-buy products // select sum(quantity * price) (from cart of user id == id) 
6-add credit // from ( profile page(add credit) + (welcome code)registeration)
//search by code-number in credit table and if found ->add value to user credit in user and remove row of credit code (ajax)->on blur4
//if code is wrong and credit is zero
7-add now date to cart with product and user id *
8-update no of products in cart (cart table) *
9- add status (online / offline) + make enum * 
10- make role enum * 
*/

public interface UserDto {
 /*nehal*/
 public boolean addCredit(String code);//make exceptions -> wrong code

 public boolean updateCreditWhenBuying(int user_id);

 public boolean addUser(Users user);

 public boolean updateUser(Users user);

 public Users getUserById(int id);

 public List<Users> getAllUsers();

 public boolean login(Users user);

 public boolean register(Users user);

 public boolean isExist(Users user);

 public boolean logOut(Users user);
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
