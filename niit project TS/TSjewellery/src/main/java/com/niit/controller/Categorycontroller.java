package com.niit.controller;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;



import com.niit.modeldao.Categorydao;

import com.niit.modeldto.Category;

import com.niit.modeldto.Product;







@Controller
public class Categorycontroller {
	
	@Autowired
	Categorydao categorydao;

	

	@RequestMapping(value="CategoryAddition",method=RequestMethod.GET)

	public String addcategory(@RequestParam("name") String catname,@RequestParam("desc") String catdesc,Model m)

	{	

		Category category=new Category();

		/*category.setId(catid);*/

		category.setName(catname);

		category.setDesc(catdesc);

		

		categorydao.addcategory(category);;

		

		List<Category> list=categorydao.displayAll();

		m.addAttribute("catlist",list);

		

		return "Category";

	}

	

	@RequestMapping("Category")

	public String showCategoryPage(Model m)

	{

		List<Category> list=categorydao. displayAll();

		m.addAttribute("catlist",list);		

		return "Category";

	}

	

	@RequestMapping(value="/deleteCategory/{catid}",method=RequestMethod.GET)

	public String deletecategory(@PathVariable("catid") int catid,Model m)

	{

		categorydao.deletecategory(catid);

		List<Category> list=categorydao.displayAll();

		m.addAttribute("catlist",list);

		return "redirect:/Category";

	}

	@RequestMapping(value="updateCategory/{catid}",method=RequestMethod.GET)

	public String readyUpdate(@PathVariable("catid")int catid,Model m)

	{

		Category category=categorydao.getCategoryByCategoryid(catid);

		m.addAttribute("category",category);

		

		List<Category> list=categorydao.displayAll();

		m.addAttribute("catlist",list);

		

		return "UpdateCategory";

	}

	

	@RequestMapping(value="UpdateCategory",method=RequestMethod.GET)

	public String updateCategory(@ModelAttribute("category") Category category,Model m)

	{

		categorydao.updatecategory(category);

		

		Category category1 = new Category();

		m.addAttribute(category1);

		

		List<Category> list=categorydao.displayAll();

		m.addAttribute("catlist",list);

		

		return "redirect:/Category";

	}

	


}
