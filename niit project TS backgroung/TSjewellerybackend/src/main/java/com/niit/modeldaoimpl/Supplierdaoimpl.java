package com.niit.modeldaoimpl;

import java.util.List;



import org.hibernate.Query;

import org.hibernate.Session;

import org.hibernate.SessionFactory;

import org.hibernate.Transaction;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;



import com.niit.modeldao.Supplierdao;

import com.niit.modeldto.Category;

import com.niit.modeldto.Product;

import com.niit.modeldto.Supplier;

import com.niit.modeldto.User;

@Transactional

@Repository("supplierdao")

public class Supplierdaoimpl implements Supplierdao

{

	@Autowired

	SessionFactory sessionFactory;
	
	public  Supplierdaoimpl(SessionFactory sessionFactory)
    {
        System.out.println("Supplierdao Object Created");
        this.sessionFactory=sessionFactory;
    }

	public void addSupplier(Supplier supplier) {

		Session session = sessionFactory.openSession();

		Transaction transaction = (Transaction) session.beginTransaction();

		session.persist(supplier);

		transaction.commit();

		session.close();

		

	}



	public void updateSupplier(Supplier supplier) {

		Session session = sessionFactory.openSession();

		Transaction transaction = (Transaction) session.beginTransaction();

		session.update(supplier);

		transaction.commit();

		session.close();

		

	}



	public void deleteSupplier(int sid) {

		Session session=sessionFactory.getCurrentSession();
        Supplier supplier=(Supplier)session.get(Supplier.class,sid);
        session.delete(supplier);

	}



	public Supplier getSupplierBySupplierName(String sname) {

		Session session=sessionFactory.openSession();

		Supplier supplier=(Supplier)session.get(Supplier.class,sname);

		session.close();

		return supplier;

	}



	public List<Supplier> displayAll() 

	{

		Session session=sessionFactory.openSession();

		@SuppressWarnings("unchecked")

		List<Supplier> list=session.createQuery("from Supplier").list();

		session.close();

		return list;

	}

}