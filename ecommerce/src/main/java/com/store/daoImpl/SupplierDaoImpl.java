package com.store.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.store.dao.SupplierDao;
import com.store.model.Supplier;

@Repository("supplierDaoImpl")
@Transactional
public class SupplierDaoImpl implements SupplierDao {

	@Autowired
	SessionFactory sessionFactory;
	public boolean addSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		System.out.println("ID: "+supplier.getSupplierId());
		Session session=sessionFactory.getCurrentSession();
		session.save(supplier);
		System.out.println("ID: "+supplier.getSupplierId());
		return true;
	}

	public boolean deleteSupplier(int id) {
		// TODO Auto-generated method stub
		System.out.println("ID: "+id);
		Session session=sessionFactory.getCurrentSession();
		Supplier supplier=(Supplier)session.load(Supplier.class, id);
		session.delete(supplier);
		System.out.println("ID: "+id);
		return true;
	}

	public boolean updateSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		System.out.println("ID: "+supplier.getSupplierId());
		Session session=sessionFactory.getCurrentSession();
		session.update(supplier);
		System.out.println("ID: "+supplier.getSupplierId());
		return true;
	}

	public List<Supplier> listSupplier() {
		// TODO Auto-generated method stub
		String query="FROM Supplier";
		Session session=sessionFactory.openSession();
		Query q=session.createQuery(query);
		List<Supplier> list=q.list();
		return list;
	}

	public Supplier getSupplier(int id) {
		// TODO Auto-generated method stub
		String query="FROM Supplier WHERE supplierId="+3;
		Session session=sessionFactory.openSession();
		/*Query q=session.createQuery(query);
		List<Supplier> list=q.list();*/
		Transaction trans=session.beginTransaction();
		Supplier supplier=(Supplier) session.get(Supplier.class, id);
		trans.commit();
		session.flush();
		session.close();
		return supplier;
	}

}
