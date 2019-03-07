package com.store.daoImpl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.store.dao.UserProcessDao;
import com.store.model.UserProcess;

@Repository("userProcessDaoImpl")
@Transactional
public class UserProcessDaoImpl implements UserProcessDao{
	@Autowired
	private SessionFactory sessionFactory;
	public boolean saveUserProcess(UserProcess userProcess) {
		// TODO Auto-generated method stub
		System.out.println("ID: "+userProcess.getId());
		Session session=sessionFactory.getCurrentSession();
		session.save(userProcess);
		System.out.println("ID: "+userProcess.getId());		
		return true;
 	}
	
	public boolean deleteUserProcess(UserProcess userProcess) {
		// TODO Auto-generated method stub
		System.out.println("ID: "+userProcess.getId());
		Session session=sessionFactory.getCurrentSession();
		session.delete(userProcess);
		System.out.println("ID: "+userProcess.getId());
		return true;
	}
	
	public boolean updateUserProcess(UserProcess userProcess) {
		// TODO Auto-generated method stub
		System.out.println("ID: "+userProcess.getId());
		Session session=sessionFactory.getCurrentSession();
		session.update(userProcess);
		System.out.println("ID: "+userProcess.getId());		
		return true;
	}

	public List<UserProcess> getId(int id) {
		// TODO Auto-generated method stub
		String query="FROM UserProcess WHERE ID="+id;
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query qry=session.createQuery(query);
		List<UserProcess> up=qry.list();		
		return up;
		
	}

	public boolean loginUserProcess(UserProcess user) {
		// TODO Auto-generated method stub
		String q="FROM UserProcess WHERE UserName="+user.getName();
		if(q==null)
			return false;
		else
			return true;
	}
}
