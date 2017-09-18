package com.instinctools.trainerships;

import java.util.List;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.instinctools.trainerships.model.Client;
import com.instinctools.trainerships.services.impl.JPAClientService;

@Controller
public class ClientController {

	ApplicationContext context = new AnnotationConfigApplicationContext(JPAClientService.class);
	JPAClientService clientService = context.getBean(JPAClientService.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String list(Locale locale, Model model) {
		List<Client> list = clientService.getAllUsers();
		model.addAttribute("clients", list);
		return "clientList";
	}

	@RequestMapping(value = "/deleteClient", method = RequestMethod.GET)
	public String delete(Locale locale, Model model, @RequestParam(value = "id") int id) {
		clientService.delete(id);
		return "redirect:/";
	}

	@RequestMapping(value = "/createClient", method = RequestMethod.GET)
	public String create(Locale locale, Model model, @RequestParam(value = "cli_name") String name) {
		clientService.create(name);
		return "redirect:/";
	}

	@RequestMapping(value = "/editClient", method = RequestMethod.GET)
	public String edit(Locale locale, Model model, @RequestParam(value = "id") int id) {
		Client client = clientService.edit(id);
		model.addAttribute("client", client);
		return "editClient";
	}

}
