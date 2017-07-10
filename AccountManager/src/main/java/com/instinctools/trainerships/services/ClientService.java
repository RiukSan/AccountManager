package com.instinctools.trainerships.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import com.instinctools.trainerships.HibernateUtil;
import com.instinctools.trainerships.model.Client;

@Service
public class ClientService {
	private Session session;

	public ClientService() {
	}

	public Client create(String name) {
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Client client = new Client();
		client.setName(name);
		session.save(client);
		transaction.commit();
		return client;
	}

	public void delete(int id) {
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Client client = session.load(Client.class, id);
		session.delete(client);
		transaction.commit();
	}

	public Client edit(int id) {
		session = HibernateUtil.getSessionFactory().openSession();
		Client client = (Client) session.load(Client.class, id);
		return client;
	}

	public List<Client> getAllUsers() {
		session = HibernateUtil.getSessionFactory().openSession();
		Query<Client> query = session.createQuery("from Client");
		List<Client> list = query.getResultList();
		return list;
	}

}
