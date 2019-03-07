package com.store.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.store.dao.ProductDao;
import com.store.model.Category;
import com.store.model.Product;

@Repository("productDaoImpl")
@Transactional
public class ProductDaoImpl implements ProductDao {
	public ProductDaoImpl() {
		System.out.println("ProductDaoImpl object is created");
	}

	@Autowired
	private SessionFactory sessionFactory;
	public boolean saveProduct(Product product) {

		Session session=sessionFactory.getCurrentSession();/*org.hibernate*/
		System.out.println("ID: "+product.getId());
		session.save(product);
		System.out.println("ID: "+product.getId());
		return true;
	}
	public boolean deleteProduct(int id) {

		Session session = sessionFactory.getCurrentSession(); /*org.hibernate*/
		System.out.println("ID: " + id);
		Product product=(Product) session.load(Product.class, id);
		session.delete(product);
		return true;
	}
	public boolean updateProduct(Product product) {

		Session session=sessionFactory.getCurrentSession();/*org.hibernate*/
		System.out.println("ID: "+product.getId());
		session.update(product);
		System.out.println("ID: "+product.getId());	
		return true;
	}
	public Product getId(int id) {
		
		Session session=sessionFactory.openSession();
		Transaction tans=session.beginTransaction();
		/*Query q=session.createQuery(query); here Query from hibernate query*/
		Product product= (Product) session.get(Product.class, id);
		tans.commit();
		session.flush();
		session.close();
		return product;
	}
	public List<Product> getAllProduct() {

		String query="FROM Product";
		Session session=sessionFactory.openSession();
		Query q=session.createQuery(query);
		List<Product> lp=q.list();
		return lp;
	}
	public List<Category> getAllCategories() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("FROM Category");
		List<Category> list=query.list();
		return list;
	}
}
