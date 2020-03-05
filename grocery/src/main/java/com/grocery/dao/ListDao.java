package com.grocery.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grocery.model.GroceryList;

@Repository
@Transactional
public class ListDao {

	private SessionFactory sesfact;

	@Autowired
	public ListDao(SessionFactory sesfact) {
		super();
		this.sesfact = sesfact;
	}

	public GroceryList save(GroceryList GroceryList) {
		try {
			sesfact.getCurrentSession().save(GroceryList);
			return GroceryList;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public GroceryList findById(int id) {
		try {
			return sesfact.getCurrentSession().get(GroceryList.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<GroceryList> findAll() {
		try {
			return sesfact.getCurrentSession().createQuery("from GroceryList", GroceryList.class).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public GroceryList update(GroceryList GroceryList) {
		try {
			sesfact.getCurrentSession().update(GroceryList);
			return GroceryList;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void delete(int id) {
		try {
			sesfact.getCurrentSession().delete(sesfact.getCurrentSession().get(GroceryList.class, id));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

}
