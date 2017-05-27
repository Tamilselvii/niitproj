package com.niit.modeldao;

import java.util.List;

import com.niit.modeldto.Cart;
public interface Cartdao {

public void addtoCart(Cart cart);
public void updateCart(Cart cart);
public void deleteCartItem(int cid);
public Cart getCartItem(String cartname);
public void retrivecart();

public List <Cart> getCartByCartName(String cartname);
public Cart getCartByCartid(int cid);
public List<Cart> displayAll();



}
