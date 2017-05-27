package com.niit.controller;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.modeldao.Categorydao;
import com.niit.modeldao.Productdao;
import com.niit.modeldao.Supplierdao;
import com.niit.modeldto.Category;
import com.niit.modeldto.Product;
import com.niit.modeldto.Supplier;



@Controller
public class Productcontroller 
{
	@Autowired
	Productdao productdao;
	@Autowired
	Supplierdao supplierdao;
	@Autowired
	Categorydao categorydao;
	
	@RequestMapping(value="Product")
	public String showProduct(Model m)
	{
		Product product = new Product();
		m.addAttribute(product);
		
		List<Product> list=productdao.displayAll();
		m.addAttribute("proddet",list);
		m.addAttribute("suplist",this.getSuppliers());
		m.addAttribute("catlist",this.getCategories());
		return "Product";
		
	}
	
	
	@RequestMapping(value="addProduct",method=RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product product,@RequestParam("image") MultipartFile filedet,Model m)
{
		
		productdao.addProduct(product);
		
		// Image Uploading Code
	String path = "E:\\niit project TS\\TSjewellery\\src\\main\\webapp\\resources\\images\\";
		
		path = path + String.valueOf(product.getProductid()) + ".jpg";
		
		File f=new File(path);
		
		if (!filedet.isEmpty()) 
		{
			try
			{
				byte[] bytes = filedet.getBytes();
				FileOutputStream fos=new FileOutputStream(f);
				BufferedOutputStream bs = new BufferedOutputStream(fos);
				bs.write(bytes);
				bs.close();
				
			}
			catch(Exception e)
			{
				System.out.println("Exception Arised:"+e);
			}
			
		}
		else
		{
			System.out.println("File Uploading Problem");
		}
		
		
		//Complete Image Uploading
		
		Product product1 = new Product();
		m.addAttribute(product1);
		
		List<Product> list=productdao.displayAll();
		m.addAttribute("proddet",list);
		
		return "Product";
	}
	
	@RequestMapping(value="deleteProduct/{productid}",method=RequestMethod.GET)
	public String deleteProduct(@PathVariable("productid")int productid,Model m)
	{
		
		productdao.deleteProduct(productid);
		
		Product product1 = new Product();
		m.addAttribute(product1);
		
		List<Product> list=productdao.displayAll();
		m.addAttribute("proddet",list);
		
		return "redirect:/Product";
	}
	
	@RequestMapping(value="updateProduct/{productid}",method=RequestMethod.GET)
	public String readyUpdate(@PathVariable("productid")int productid,Model m)
	{
		Product product=productdao.getProductByProductid(productid);
		m.addAttribute("abc",product);
		
		List<Product> list=productdao.displayAll();
		m.addAttribute("proddet",list);
		
		return "UpdateProduct";
	}
	
	@RequestMapping(value="UpdateProduct",method=RequestMethod.GET)
	public String updateProduct(@ModelAttribute("product") Product product,Model m)
	{
		productdao.updateProduct(product);		
		Product product1 = new Product();
		m.addAttribute(product1);
		
		List<Product> list=productdao.displayAll();
		m.addAttribute("proddet",list);
		
		return "redirect:/Product";
	}
	
	public LinkedHashMap<Integer,String> getCategories()
	{
		List<Category> list=categorydao.displayAll();
		
		LinkedHashMap<Integer,String> catlist=new LinkedHashMap<Integer,String>();
		
		for(Category cat:list)
		{
			catlist.put(cat.getId(),cat.getName());
		}
		
		return catlist;
	}
	public LinkedHashMap<Integer,String> getSuppliers()
	{
		List<Supplier> list=supplierdao.displayAll();
		
		LinkedHashMap<Integer,String> suplist=new LinkedHashMap<Integer,String>();
		
		for(Supplier sup:list)
		{
			suplist.put(sup.getSid(),sup.getSname());
		}
		
		return suplist;
	}
}
