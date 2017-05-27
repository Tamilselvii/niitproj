package com.niit.controller;
import java.util.List;

import javax.servlet.http.HttpSession;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.modeldao.Cartdao;
import com.niit.modeldao.Productdao;
import com.niit.modeldto.Cart;
import com.niit.modeldto.Product;

 
@Controller
public class Cartcontroller 
{
    @Autowired
    Cartdao cartDAO;
     
    @Autowired
    Productdao productDAO;
     
    @RequestMapping(value="ShowCart")
    public String showCartPage(Model m,HttpSession session)
    {
        String cartname=(String)session.getAttribute("cartname");
        Cart cartitems=cartDAO.getCartItem(cartname);
        m.addAttribute("cartitems",cartitems);
        return "Cart";
    }
     
    @RequestMapping(value="/addToCart/{prodid}")
    public String addToCart(@PathVariable("prodid")int prodid,@RequestParam("quantity") int qty,HttpSession session,Model m)
    {
        String cartname=(String)session.getAttribute("cartname");
        Cart mycart=new Cart();
         
        Product product=productDAO.getProductByProductid(prodid);
        int productcost =product.getProductcost();
         
        mycart.setProdid(prodid);
        mycart.setQuantity(qty);
        mycart.setStatus("NP");
        mycart.setUsername(cartname);
        mycart.setCartid("C1001");
        mycart.setSubtotal(qty*productcost);
         
        cartDAO.addtoCart(mycart);
         
        List<Cart> cartitems=cartDAO.getCartByCartName(cartname);
        m.addAttribute("cartitems",cartitems);
         
        return "Cart";
    }
     
    @RequestMapping(value="deleteCartItem/{cid}")
    public String deleteCartItem(@PathVariable("cid") int cid,Model m,HttpSession session)
    {
        String cartname=(String)session.getAttribute("cartname");
         
        cartDAO.deleteCartItem(cid);
         
        List<Cart> cartitems=cartDAO.getCartByCartName(cartname);
        m.addAttribute("cartitems",cartitems);
        return "Cart";
    }
     
    @RequestMapping(value="updateCartItem/{cid}")
    public String updateCartItem(@PathVariable("cid")int cid,@RequestParam("qty")int qty,Model m,HttpSession session)
    {
        String cartname=(String)session.getAttribute("cartname");
         
        Cart cartitem=cartDAO.getCartItem(cartname);
         
        Product product=productDAO.getProductByProductid(cartitem.getProdid());
        int productcost=product.getProductcost();
         
        cartitem.setQuantity(qty);
        cartitem.setSubtotal(qty*productcost);
         
        cartDAO.updateCart(cartitem);
         
        List<Cart> cartitems=cartDAO.getCartByCartName(cartname);
        m.addAttribute("cartitems",cartitems);
         
        return "Cart";
         
    }
}
