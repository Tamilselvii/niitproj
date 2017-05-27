package com.niit.controller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homecontroller {

	 @RequestMapping("Home")
	    public String Home()
	    {
	        return "Home";
	    }
	 /*@RequestMapping("Register")
	    public String showRegisterPage()
	    {
	        return "registration";
	    } */
	   
	     
	    @RequestMapping("/")
	    public String showDefaultPage()
	    {
	        return "index";
	    }
	     
	    @RequestMapping("Login")
	    public String showloginPage()
	    {
	        return "login";
	    }
	    @RequestMapping("AboutUs")
	    public String aboutUS()
	    {
	        return "aboutus";
	    }
	 
}
