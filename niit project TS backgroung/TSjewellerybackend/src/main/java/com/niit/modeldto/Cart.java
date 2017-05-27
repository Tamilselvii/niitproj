package com.niit.modeldto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="Cart")
public class Cart 
{

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
int id;
 
String cartid,status,username;
int prodid,quantity,subtotal;
 
public String getUsername() {
    return username;
}
public void setUsername(String username) {
    this.username = username;
}
 
 
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public String getCartid() {
    return cartid;
}
public void setCartid(String cartid) {
    this.cartid = cartid;
}
public String getStatus() {
    return status;
}
public void setStatus(String status) {
    this.status = status;
}
public int getProdid() {
    return prodid;
}
public void setProdid(int prodid) {
    this.prodid = prodid;
}
public int getQuantity() {
    return quantity;
}
public void setQuantity(int quantity) {
    this.quantity = quantity;
}
public int getSubtotal() {
    return subtotal;
}
public void setSubtotal(int subtotal) {
    this.subtotal = subtotal;
}
 
}