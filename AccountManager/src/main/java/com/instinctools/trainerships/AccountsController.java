package com.instinctools.trainerships;

import java.util.Locale;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.instinctools.trainerships.model.Account;
import com.instinctools.trainerships.model.Client;

@Controller
public class AccountsController {

	@RequestMapping(value = "/updateAccount", method = RequestMethod.GET)
	public String update(Locale locale, Model model, @RequestParam(value = "id") Integer id,
			@RequestParam(value = "acc_name") String name) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Account acc = session.load(Account.class, id);
		acc.setName(name);
		session.saveOrUpdate(acc);
		transaction.commit();
		return "redirect:/";
	}

	@RequestMapping(value = "/createAccount", method = RequestMethod.GET)
	public String create(Locale locale, Model model, @RequestParam(value = "id") Integer id,
			@RequestParam(value = "acc_name") String name) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Client client = session.load(Client.class,id);
		Account acc = new Account();
		acc.setName(name);
		client.addAccount(acc);
		session.save(client);
		transaction.commit();
		return "redirect:/";
	}

	@RequestMapping(value = "/deleteAccount", method = RequestMethod.GET)
	public String delete(Locale locale, Model model, @RequestParam(value = "id") Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Account acc = session.load(Account.class, id);
		session.delete(acc);
		transaction.commit();
		return "redirect:/";
	}

}
