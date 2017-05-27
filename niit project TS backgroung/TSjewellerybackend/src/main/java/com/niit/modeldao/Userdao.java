package com.niit.modeldao;

import java.util.List;

import com.niit.modeldto.Product;
import com.niit.modeldto.User;

public interface Userdao {
	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(int userid);
public User getUserByName(String username);
public List<Product> displayAll();



}
