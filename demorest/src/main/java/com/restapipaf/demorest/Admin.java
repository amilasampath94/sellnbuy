package com.restapipaf.demorest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Admin {

	private String name;
	private int Id;
	private String email;
	private String password;
	private int p_num;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Alien [name=" + name + ", Id=" + Id + ", email=" + email + ", password=" + password + ", p_num=" + p_num
				+ "]";
	}

}
