package com.niit.controller;


 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.niit.modeldao.Productdao;
import com.niit.modeldto.Product;

import java.util.Collection;
import java.util.List;
 
import javax.servlet.http.HttpSession;
 
@Controller
public class SecurityController 
{
    @Autowired
    Productdao productDAO;
     
    @RequestMapping("/UserHome")
    public String showUserHome(Model m)
    {
        List<Product> list=productDAO.displayAll();      
        m.addAttribute("prodlist",list);
        return "UserHome";
    }
     
    @RequestMapping("/login_success")
    public String showAuthenticatedPage(HttpSession session,Model m)
    {
        String page=null;
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
         
        System.out.println("User Name:"+username);
         
        session.setAttribute("username",username);
         
        boolean LoggedIn=false;
        for(GrantedAuthority role:authorities)
        {
            System.out.println("Role Name:"+role);
            session.setAttribute("role",role.getAuthority());
            if(role.getAuthority().equals("USER_ROLE".trim()))
            {
                LoggedIn=true;
                page="UserHome";
                List<Product> list=productDAO.displayAll();      
                m.addAttribute("prodlist",list);
            }
            else
            {
                LoggedIn=true;
                page="AdminHome";
            }
             
        }
        session.setAttribute("LoggedIn",LoggedIn);
         
         
        return page;
    }
     
    @RequestMapping(value="/ProductDesc/{productid}",method=RequestMethod.GET)
    public String showProductDesc(@PathVariable("productid")Product productid,Model m)
    {
        Product prod=productDAO.addProduct(product);
    	
    
        m.addAttribute("prodinfo",prod);
        return "ProductDesc";
    }
     
 
}
