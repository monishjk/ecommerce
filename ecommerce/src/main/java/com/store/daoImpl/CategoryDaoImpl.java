package com.store.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.store.dao.CategoryDao;
import com.store.model.Category;

@Repository("categoryDaoImpl")
@Transactional
public class CategoryDaoImpl implements CategoryDao{

	@Autowired
	private SessionFactory sessionFactory;
	public boolean saveCategory(Category category) {
		// TODO Auto-generated method stub
		System.out.println("ID: "+category.getCid());
		Session session=sessionFactory.getCurrentSession();
		session.save(category);
		System.out.println("ID: "+category.getCid());
		return true;
	}

	public boolean deleteCategory(int cid) {
		// TODO Auto-generated method stub
		System.out.println("ID: "+cid);
		Session session=sessionFactory.getCurrentSession();
		Category category=(Category) session.load(Category.class,cid);
		session.delete(category);
		System.out.println("ID: "+category.getCid());
		return true;
	}

	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		System.out.println("ID: "+category.getCid());
		Session session=sessionFactory.getCurrentSession();
		session.update(category);
		System.out.println("ID: "+category.getCid());
		return true;
	}

	public List<Category> getAllProducts() {
		// TODO Auto-generated method stub
		String query="FROM Category";
		Session session=sessionFactory.openSession();
		Query q=session.createQuery(query);
		List<Category> list=q.list();
		return list;
	}

	public Category getIdProducts(int id) {
		// TODO Auto-generated method stub
		String query="FROM Category WHERE id="+id;
		Session session=sessionFactory.openSession();
		/*Query q=session.createQuery(query);
		List<Category> list=q.list();*/
		Transaction trans=session.beginTransaction();
		Category cat=(Category) session.get(Category.class, id);
		trans.commit();
		session.flush();
		session.close();
		return cat;
	}
}