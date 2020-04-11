package com.brands.dao;
// Generated Apr 10, 2020, 7:31:12 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Cart generated by hbm2java
 */
@Entity
@Table(name="cart"
    ,catalog="brands"
)
public class Cart  implements java.io.Serializable {


     private int cartId;
     private Date buyingDate;
     private Users user ;

    public Cart() {
    }

	
    public Cart(int cartId) {
        this.cartId = cartId;
    }
    public Cart(int cartId, Date buyingDate, Users user) {
       this.cartId = cartId;
       this.buyingDate = buyingDate;
       this.user = user;
    }
   
     @Id 

    
    @Column(name="cart_id", unique=true, nullable=false)
    public int getCartId() {
        return this.cartId;
    }
    
    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="buying_date", length=19)
    public Date getBuyingDate() {
        return this.buyingDate;
    }
    
    public void setBuyingDate(Date buyingDate) {
        this.buyingDate = buyingDate;
    }

@OneToOne(fetch=FetchType.LAZY, mappedBy="cart")
    public Users getUserses() {
        return this.user;
    }
    
    public void setUserses(Users user) {
        this.user = user;
    }




}

