package com.niit.controller;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;



import com.niit.modeldao.Categorydao;

import com.niit.modeldao.Supplierdao;

import com.niit.modeldto.Category;

import com.niit.modeldto.Supplier;







@Controller
public class Suppliercontroller {
	@Autowired

	Supplierdao supplierdao;

	

	@RequestMapping(value="SupplierAddition",method=RequestMethod.GET)

	public String addSupplier(@RequestParam("sname") String sname,@RequestParam("sadd") String sadd,Model m)

	{	

	Supplier supplier=new Supplier();

		/*supplier.setSid(sid);*/

		supplier.setSname(sname);

		supplier.setSadd(sadd);

		

		supplierdao.addSupplier(supplier);

		

		List<Supplier> list=supplierdao.displayAll();

		m.addAttribute("suplist",list);

		

		return "Supplier";

	}

	

	@RequestMapping("Supplier")

	public String showSupplierPage(Model m)

	{

		List<Supplier> list=supplierdao.displayAll();

		m.addAttribute("suplist",list);		

		return "Supplier";

	}

	

	@RequestMapping(value="/deleteSupplier/{sid}",method=RequestMethod.GET)

	public String deleteSupplier(@PathVariable("sid") int sid,Model m)

	{

		supplierdao.deleteSupplier(sid);

		List<Supplier> list=supplierdao.displayAll();

		m.addAttribute("suplist",list);

		return "redirect:/Supplier";

	}
}
