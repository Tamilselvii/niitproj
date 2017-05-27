package com.niit.modeldaoimpl;

import com.niit.modeldao.Cartdao;
import com.niit.modeldto.Cart;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 

 
@Repository("cartdao")

public class Cartdaoimpl implements Cartdao{
	 @Autowired
	    SessionFactory sessionFactory;
	     
	    public void Cartdao(SessionFactory sessionFactory)
	    {
	        this.sessionFactory=sessionFactory;
	    }
	     
	    @Transactional
	    public void addtoCart(Cart cart)
	    {
	        sessionFactory.getCurrentSession().saveOrUpdate(cart);
	    }
	     
	    @Transactional
	    public void deleteCartItem(int cid)
	    {
	        Cart myCartItem=(Cart)sessionFactory.getCurrentSession().get(Cart.class,cid);
	        sessionFactory.getCurrentSession().delete(myCartItem);
	    }
	    @Transactional
	    public Cart getCartItem(int cid)
	    {
	        Session session=sessionFactory.getCurrentSession();
	        Cart mycartitem=(Cart)session.get(Cart.class,cid);
	        //session.close();
	        return mycartitem;
	         
	    }
	     
	    @Transactional
	    public void updateCart(Cart cart)
	    {
	        sessionFactory.getCurrentSession().saveOrUpdate(cart);
	    }
	    @Transactional
	    public List<Cart> getCartItems(String username)
	    {
	        Query q=sessionFactory.openSession().createQuery("from Cart where status='NP' and username=:uname");
	        q.setParameter("uname",username);
	        @SuppressWarnings("unchecked")
	        List<Cart> list=q.list();
	        return list;
	    }

		public void retrievecart() {
			// TODO Auto-generated method stub
			
		}

		public List<Cart> getCartByCartName(String cartname) {
			// TODO Auto-generated method stub
			return null;
		}

		public Cart getCartByCartid(int cartid) {
			// TODO Auto-generated method stub
			return null;
		}

		public List<Cart> displayAll() {
			// TODO Auto-generated method stub
			return null;
		}

		public void getCartItems() {
			// TODO Auto-generated method stub
			
		}

		public void retriveCart() {
			// TODO Auto-generated method stub
			
		}

		public void retrivecart() {
			// TODO Auto-generated method stub
			
		}

		public Cart getCartItem(String cartname) {
			// TODO Auto-generated method stub
			return null;
		}
}
