package com.niit.modeldaoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.modeldao.Supplierdao;
import com.niit.modeldto.Category;
import com.niit.modeldao.Categorydao; 

 
@Repository("categorydao")
public class Categorydaoimpl implements Categorydao
{
    @Autowired
    SessionFactory sessionFactory;
     
    public Categorydaoimpl(SessionFactory sessionFactory)
    {
        this.sessionFactory=sessionFactory;
    }
     
    @Transactional
    public void addcategory(Category category)
    {
        Session session=sessionFactory.getCurrentSession();
        session.save(category);
    }
     
    @Transactional
    public void deletecategory(int catid)
    {
        Session session=sessionFactory.getCurrentSession();
        Category category=(Category)session.get(Category.class,catid);
        session.delete(category);
    }
     
    public List<Category> retrieve()
    {
        Session session=sessionFactory.openSession();
        @SuppressWarnings("unchecked")
        List<Category> list=session.createQuery("from Category").list();
        session.close();
        return list;
    }

	public void updatecategory(Category category) {
		// TODO Auto-generated method stub
		
	}

	public void retrievecategory() {
		// TODO Auto-generated method stub
		
	}

	public Category getCategoryByCategoryName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public Category getCategoryByCategoryid(int categoryid) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Category> displayAll() {
		// TODO Auto-generated method stub
		  Session session=sessionFactory.openSession();
	        @SuppressWarnings("unchecked")
	        List<Category> list=session.createQuery("from Category").list();
	        session.close();
	        return list;
		
	}

}