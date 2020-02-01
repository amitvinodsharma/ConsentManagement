package com.api.consent.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.api.consent.model.PII;

@Repository
public class PIIDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<PII> getAllPIIs() {
		Session session = this.sessionFactory.getCurrentSession();
		List<PII> piiList = session.createQuery("from PII").list();
		return piiList;
	}

	public PII getPII(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		PII pII = (PII) session.get(PII.class, new Integer(id));
		return pII;
	}

	public Integer addPII(PII pII) {
		Session session = this.sessionFactory.getCurrentSession();
		Integer id = (Integer) session.save(pII);
		return id;
	}

	public PII updatePII(PII pII) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(pII);
		return pII;
	}

	public void deletePII(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		PII p = (PII) session.load(PII.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	}	
}
