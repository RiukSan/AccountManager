package com.instinctools.trainerships.services.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.instinctools.trainerships.HibernateUtil;
import com.instinctools.trainerships.model.Account;
import com.instinctools.trainerships.model.Client;
import com.instinctools.trainerships.services.AccountService;

@Service
public class JPAAccountService implements AccountService {
	private Session session;

	public JPAAccountService() {
	}

	public Account update(Integer id, String name) {
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Account acc = session.load(Account.class, id);
		acc.setName(name);
		session.saveOrUpdate(acc);
		transaction.commit();
		return acc;
	}

	public Account create(Integer userId, String name) {
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Client client = session.load(Client.class,userId);
		Account acc = new Account();
		acc.setName(name);
		client.addAccount(acc);
		session.save(client);
		transaction.commit();
		return acc;
	}

	public void delete(Integer id) {
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Account acc = session.load(Account.class, id);
		session.delete(acc);
		transaction.commit();
	}

}
