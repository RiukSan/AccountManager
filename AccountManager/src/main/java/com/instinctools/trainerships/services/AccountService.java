package com.instinctools.trainerships.services;

import org.springframework.stereotype.Service;

import com.instinctools.trainerships.model.Account;

@Service
public interface AccountService {
	public Account update(Integer id, String name);

	public Account create(Integer userId, String name);

	public void delete(Integer id);
}
