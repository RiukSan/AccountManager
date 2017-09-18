package com.instinctools.trainerships;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.instinctools.trainerships.services.impl.JPAAccountService;

@Controller
public class AccountsController {

	ApplicationContext context = new AnnotationConfigApplicationContext(JPAAccountService.class);
	JPAAccountService accountService = context.getBean(JPAAccountService.class);
	
	@RequestMapping(value = "/updateAccount", method = RequestMethod.GET)
	public String update(Locale locale, Model model, @RequestParam(value = "id") Integer id,
			@RequestParam(value = "acc_name") String name) {	
		accountService.update(id, name);
		return "redirect:/";
	}

	@RequestMapping(value = "/createAccount", method = RequestMethod.GET)
	public String create(Locale locale, Model model, @RequestParam(value = "id") Integer id,
			@RequestParam(value = "acc_name") String name) {
		accountService.create(id, name);
		return "redirect:/";
	}

	@RequestMapping(value = "/deleteAccount", method = RequestMethod.GET)
	public String delete(Locale locale, Model model, @RequestParam(value = "id") Integer id) {
		accountService.delete(id);
		return "redirect:/";
	}

}
