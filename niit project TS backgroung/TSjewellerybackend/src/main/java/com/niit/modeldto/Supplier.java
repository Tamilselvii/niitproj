package com.niit.modeldto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity

public class Supplier 

{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int sid;

	String sname,sadd;

	public int getSid() {

		return sid;

	}

	public void setSid(int sid) {

		this.sid = sid;

	}

	public String getSname() {

		return sname;

	}

	public void setSname(String sname) {

		this.sname = sname;

	}

	public String getSadd() {

		return sadd;

	}

	public void setSadd(String sadd) {

		this.sadd = sadd;

	}

	

}