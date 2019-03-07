package com.store.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.store.dao.PaymentModeDao;
import com.store.model.PaymentMode;

@Repository("paymentModeDaoImpl")
@Transactional
public class PaymentModeDaoImpl implements PaymentModeDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	public PaymentMode getPayment(String digi16) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		PaymentMode paymentMode=(PaymentMode) session.get(PaymentMode.class, digi16);
		return paymentMode;
	}

	public boolean updatePayment(PaymentMode paymentMode) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.update(paymentMode);
		return true;
	}
	
}
