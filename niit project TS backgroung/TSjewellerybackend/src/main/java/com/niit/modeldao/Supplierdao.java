package com.niit.modeldao;

import java.util.List;



import com.niit.modeldto.Product;

import com.niit.modeldto.Supplier;

import com.niit.modeldto.User;



public interface Supplierdao 

{

	public void addSupplier(Supplier supplier);

	public void updateSupplier(Supplier supplier);

	public void deleteSupplier(int sid);

	public Supplier getSupplierBySupplierName(String sname);

	public List<Supplier> displayAll();

}
