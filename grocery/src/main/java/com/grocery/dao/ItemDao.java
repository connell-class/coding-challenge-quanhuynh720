package com.grocery.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grocery.model.Item;
import com.grocery.model.Item;

@Repository
@Transactional
public class ItemDao {

	private SessionFactory sesfact;

	@Autowired
	public ItemDao(SessionFactory sesfact) {
		super();
		this.sesfact = sesfact;
	}

	public Item save(Item Item) {
		try {
			sesfact.getCurrentSession().save(Item);
			return Item;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Item> findAll() {
		try {
			return sesfact.getCurrentSession().createQuery("from Item", Item.class).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Item update(Item Item) {
		try {
			sesfact.getCurrentSession().update(Item);
			return Item;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void delete(int id) {
		try {
			sesfact.getCurrentSession().delete(sesfact.getCurrentSession().get(Item.class, id));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}


}
