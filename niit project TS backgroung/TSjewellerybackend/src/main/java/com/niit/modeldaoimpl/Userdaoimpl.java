package com.niit.modeldaoimpl;
import java.util.List;

import javax.management.Query;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.modeldto.Product;
import com.niit.modeldto.User;
import com.niit.modeldao.Userdao;

@Transactional
@Repository("userdao")
public class Userdaoimpl implements Userdao {
	@Autowired
	SessionFactory sessionFactory;
	
	public void addUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction transaction = (Transaction) session.beginTransaction();
		session.persist(user);
		transaction.commit();
		session.close();
	}


public void updateUser(User user) {
	Session session = sessionFactory.openSession();
	Transaction transaction = (Transaction) session.beginTransaction();
	session.persist( user);
	transaction.commit();
	session.close();
	
}

public void deleteUser(int userid) {
	Session session = sessionFactory.openSession();
	Transaction transaction = (Transaction) session.beginTransaction();
	session.persist(userid);
	transaction.commit();
	session.close();
	
}

public User getUserByName(String username) {
	Query query=(Query) sessionFactory.getCurrentSession().createQuery("from user where userid=? ");
	((org.hibernate.query.Query) query).setString(0, username);
	
	return (User) ((org.hibernate.Query) query).uniqueResult();
}
public List<Product> displayAll()
{
	return sessionFactory.getCurrentSession().createQuery("from user").list();
}

}