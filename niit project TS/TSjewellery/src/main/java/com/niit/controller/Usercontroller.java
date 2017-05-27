/*package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.niit.modeldao.Userdao;
import com.niit.modeldto.User;

@Controller
public class Usercontroller {
	@Autowired
	Userdao userdao;

	@RequestMapping("/registration")
	public String getregistrationpage(Model model) {
		model.addAttribute("user", new User());
		System.out.println("enter register");
		return "registration";
	}

	@RequestMapping(value = "/registration/user", method = RequestMethod.POST)
	public String registationUser(@ModelAttribute("user") User user) {
		System.out.println("welcome" + user.getName());
		userdao.addUser(user);
		return "registration";

	}
}
*/