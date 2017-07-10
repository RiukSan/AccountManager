package com.instinctools.trainerships.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Client implements Serializable {

	private static final long serialVersionUID = 5681817303654694077L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;

	@Column
	private String name;

	public Client() {
		accounts = new ArrayList<Account>();
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CLIENT_ACCOUNT", joinColumns = { @JoinColumn(name = "CLIENT_ID") }, inverseJoinColumns = { @JoinColumn(name = "ACCOUNT_ID") })
	private List<Account> accounts;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String string) {
		this.name = string;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public void addAccount(Account account) {
		this.accounts.add(account);
	}
}
