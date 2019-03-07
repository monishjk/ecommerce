package com.store.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.store.dao.CartItemDao;
import com.store.model.CartItem;
import com.store.model.User;

@Repository("cartItemDaoImpl")
@Transactional
public class CartItemDaoImpl implements CartItemDao {
	@Autowired
	private SessionFactory sessionFactory;

	public User getUser(String email) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, email);
		return user;
	}

	public void saveOrUpdateCartItem(CartItem cartItem) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(cartItem);
	}

	public List<CartItem> getCartItem(String email) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from CartItem where user.email=?");
		query.setString(0, email);
		List<CartItem> cartItems=query.list();
		return cartItems;
	}

	public void removeCartItem(int itemId) {
		Session session=sessionFactory.getCurrentSession();
		CartItem cartItem=(CartItem)session.get(CartItem.class, itemId);
		session.delete(cartItem);
	}

	public CartItem getCartItemId(int itemId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("From CartItem where id="+itemId);
		CartItem cartItem=(CartItem) session.get(CartItem.class, itemId);
		return cartItem;
	}

}
