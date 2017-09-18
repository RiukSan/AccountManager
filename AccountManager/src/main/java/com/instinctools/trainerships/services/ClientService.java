package com.instinctools.trainerships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.instinctools.trainerships.model.Client;

@Service
public interface ClientService {

	public Client create(String name);

	public void delete(int id);

	public Client edit(int id);

	public List<Client> getAllUsers();
}
