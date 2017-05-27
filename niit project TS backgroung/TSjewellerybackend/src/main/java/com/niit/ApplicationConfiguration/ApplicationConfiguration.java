package com.niit.ApplicationConfiguration;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.modeldao.Categorydao;
import com.niit.modeldao.Productdao;
import com.niit.modeldao.Supplierdao;
import com.niit.modeldaoimpl.Categorydaoimpl;
import com.niit.modeldaoimpl.Productdaoimpl;
import com.niit.modeldaoimpl.Supplierdaoimpl;
import com.niit.modeldto.Category;
import com.niit.modeldto.Product;
import com.niit.modeldto.Supplier;

import java.util.*;

 
@Configuration
@ComponentScan("com.niit.TSjewelleryBackend")
@EnableTransactionManagement
public class ApplicationConfiguration {
	 //Method will provide the Database Specific Info
    //DataSource object will contain that
    @Autowired
    @Bean(name="dataSource")
    public DataSource getH2DataSource()
    {
        System.out.println("Data Source Method");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        System.out.println("Data Source Created");
        return dataSource;
    }
     
    //Method will provide the Hibernate Related Properties
    //Properties object will contain the data.
    public Properties getHibernateProperties()
    {
        System.out.println("Hibernate Properties -Entered");
        Properties hibernate_prop=new Properties();
        hibernate_prop.setProperty("hibernate.hbm2ddl.auto", "update");
        hibernate_prop.put("hibernate.show_sql", "true"); //optional
        hibernate_prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        System.out.println("Hibernate Prperty Object Created");
        return hibernate_prop;
    }
     
    @Autowired
    @Bean(name="sessionFactory")
    public SessionFactory getSessionFactory()
    {
        System.out.println("SessionFactory Method-Entered");
        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(getH2DataSource());
        sessionBuilder.addProperties(getHibernateProperties());
        sessionBuilder.addAnnotatedClass(Product.class);
        sessionBuilder.addAnnotatedClass(Category.class);
        sessionBuilder.addAnnotatedClass(Supplier.class);
       /* sessionBuilder.addAnnotatedClass(Cart.class);*/
        SessionFactory sessionfactory=sessionBuilder.buildSessionFactory();
        System.out.println("SessionFactory Object Created");
        return sessionfactory;
    }
     
     
    @Bean(name="productdao")
    public Productdao getProductdao(SessionFactory sessionFactory)
    {
        return new Productdaoimpl(sessionFactory);
    }
     
    @Bean(name="categorydao")
    public Categorydao getCategorydao(SessionFactory sessionFactory)
    {
        return new Categorydaoimpl(sessionFactory);
    }
   @Bean(name="supplierdao")
    public Supplierdao getSupplierdao(SessionFactory sessionFactory)
    {
        return new Supplierdaoimpl(sessionFactory);
    }
     
    /*@Bean(name="cartdao")
    public Cartdao getCartdao(SessionFactory sessionFactory)
    {
        return new Cartdao(sessionFactory);
    }*/
     
    @Bean(name="transactionManager")
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
    {
        System.out.println("Transaction Manager");
        HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
        return transactionManager;
    }
     
     

}
