package com.niit.modeldao;
import java.util.List;

import com.niit.modeldto.Product;
public interface Productdao {
	public Product addProduct();
	public  void addProduct(Product product);
	public void updateProduct(Product product);
	public void deleteProduct(int productid);
	public void retrievecatagory();
	

public Product getProductByProductName(String username);
public Product getProductByProductid(int productid);
public List<Product>displayAll();

}
