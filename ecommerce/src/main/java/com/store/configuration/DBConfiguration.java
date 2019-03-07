package com.store.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.store.dao.CartItemDao;
import com.store.dao.CategoryDao;
import com.store.dao.CustomerDao;
import com.store.dao.PaymentModeDao;
import com.store.dao.PlaceOrderHistoryDao;
import com.store.dao.ProductDao;
import com.store.dao.SupplierDao;
import com.store.dao.UserProcessDao;
import com.store.daoImpl.CartItemDaoImpl;
import com.store.daoImpl.CategoryDaoImpl;
import com.store.daoImpl.CustomerDaoImpl;
import com.store.daoImpl.PaymentModeDaoImpl;
import com.store.daoImpl.PlaceOrderHistoryDaoImpl;
import com.store.daoImpl.ProductDaoImpl;
import com.store.daoImpl.SupplierDaoImpl;
import com.store.daoImpl.UserProcessDaoImpl;
import com.store.model.Authorities;
import com.store.model.BillingAddress;
import com.store.model.CartItem;
import com.store.model.Category;
import com.store.model.Customer;
import com.store.model.PaymentMode;
import com.store.model.PlaceOrderHistory;
import com.store.model.Product;
import com.store.model.ShippingAddress;
import com.store.model.Supplier;
import com.store.model.User;
import com.store.model.UserProcess;

@Configuration
@ComponentScan("com.store")
@EnableTransactionManagement   //commit / rollback
public class DBConfiguration {
//to create beans
	
	@Bean(name="dataSource")
	public DataSource getDataSource() {
		System.out.println("Entering DataSource Bean creation method ");
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("org.h2.Driver");
	    dataSource.setUrl("jdbc:h2:tcp://localhost/~/store");
	    dataSource.setUsername("sa");
	    dataSource.setPassword("sa");
	    System.out.println("DataSource bean " +dataSource);
	    return dataSource;
	}
	/*
	 * <bean id="sessionFactory" class="org.springframework.orm.hibernate4.LocalSessionFactoryBuilder">
	 * <property name="dataSource" ref="dataSource">
	 */
	@Bean(name="sessionFactory") //SessionFactory - factory of session objects
	public SessionFactory sessionFactory() {

		Properties hibernateProp=new Properties();
		
		hibernateProp.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProp.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		
		LocalSessionFactoryBuilder factoryBuilder=new LocalSessionFactoryBuilder(getDataSource());
		factoryBuilder.addAnnotatedClass(Category.class);
		factoryBuilder.addAnnotatedClass(Supplier.class);
	    factoryBuilder.addAnnotatedClass(Product.class);
	    factoryBuilder.addAnnotatedClass(User.class);
	    factoryBuilder.addAnnotatedClass(CartItem.class);
	    factoryBuilder.addAnnotatedClass(BillingAddress.class);
	    factoryBuilder.addAnnotatedClass(Authorities.class);
	    factoryBuilder.addAnnotatedClass(Customer.class);
	    factoryBuilder.addAnnotatedClass(PaymentMode.class);
	    factoryBuilder.addAnnotatedClass(PlaceOrderHistory.class);
	    factoryBuilder.addAnnotatedClass(ShippingAddress.class);
	    factoryBuilder.addAnnotatedClass(UserProcess.class);
		factoryBuilder.addProperties(hibernateProp);
		
		
		System.out.println("Creating SessionFactory Bean");
	    return factoryBuilder.buildSessionFactory();
	}
	
	@Bean(name="userProcessDaoImpl")
	public UserProcessDao getUserProcess() {
		System.out.println("User Process Dao Created");
		return new UserProcessDaoImpl();
	}
	
	@Bean(name="productDaoImpl")
	public ProductDao getProduct() {
		System.out.println("Product Dao Created");
		return new ProductDaoImpl();
	}
	
	@Bean(name="supplierDaoImpl")
	public SupplierDao getSupplier() {
		System.out.println("Supplier Dao Created");
		return new SupplierDaoImpl();
	}
	
	@Bean(name="categoryDaoImpl")
	public CategoryDao getCategroy() {
		System.out.println("Category Dao Created");
		return new CategoryDaoImpl();
	}
	
	@Bean(name="customerDaoImpl")
	public CustomerDao getCustomer() {
		System.out.println("Customer Dao Created");
		return new CustomerDaoImpl();
	}
	
	@Bean(name="cartItemDaoImpl")
	public CartItemDao getCartItem() {
		System.out.println("Cart Item Dao Created");
		return new CartItemDaoImpl();
	}
	
	@Bean(name="placeOrderHistoryDaoImpl")
	public PlaceOrderHistoryDao getPlaceOrderHistory() {
		System.out.println("Place Order History Dao Created");
		return new PlaceOrderHistoryDaoImpl();
	}
	
	@Bean(name="paymentModeDaoImpl")
	public PaymentModeDao getPaymentMode() {
		System.out.println("Place Order History Dao Created");
		return new PaymentModeDaoImpl();
	}
	
	@Bean
	public HibernateTransactionManager hibTransManagement(){
		return new HibernateTransactionManager(sessionFactory());
	}
}
