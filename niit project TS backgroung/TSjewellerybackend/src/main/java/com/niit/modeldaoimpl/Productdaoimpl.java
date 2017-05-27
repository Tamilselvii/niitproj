package com.niit.modeldaoimpl;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.modeldao.Productdao;
import com.niit.modeldao.Userdao;
import com.niit.modeldto.Product;
 

 
@Repository("productdao")
public class Productdaoimpl implements Productdao  
{
    @Autowired
    SessionFactory sessionFactory;
     
    public  Productdaoimpl(SessionFactory sessionFactory)
    {
        System.out.println("Productdao Object Created");
        this.sessionFactory=sessionFactory;
    }
     
    @Transactional
    public  void addProduct(Product product)
    {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
    }
     
    @Transactional
    public void deleteProduct(int productid)
    {
        Session session=sessionFactory.getCurrentSession();
        Product product=(Product)session.get(Product.class,productid);
        session.delete(product);
    }
     
    public List<Product> retrieveProduct()
    {
    	Session session=sessionFactory.openSession();
        Query query=session.createQuery("from Product");
        @SuppressWarnings("unchecked")
        List<Product> list=(List<Product>)query.list();
        session.close();
        return list;
    }
     
    public Product getProduct(int productid)
    {
        Session session=sessionFactory.openSession();
        Product product=(Product)session.get(Product.class,productid);
        session.close();
        return product;
    }
     
    @Transactional
    public void updateProduct1(Product product)
    {
        Session session=sessionFactory.getCurrentSession();
        session.update(product);
    }

	public Product addProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	public void retrievecatagory() {
		// TODO Auto-generated method stub
		
	}

	public Product getProductByProductName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public Product getProductByProductid(int productid) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> displayAll() {
		
		Session session=sessionFactory.openSession();
        Query query=session.createQuery("from Product");
        @SuppressWarnings("unchecked")
        List<Product> list=(List<Product>)query.list();
        session.close();
        return list;
		
	}
}