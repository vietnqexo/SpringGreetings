package com.quocviet.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="GREETING")
public class Greeting implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3033931264523085425L;
	
	@Id
	@Column(name="ID")
	@GeneratedValue
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="GREETING_DATE")
	private Date greetingDate;
	
	@Column(name="GREETING_TEXT")
	private String greetingText;

	@Column(name="USERNAME")
	private String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getGreetingDate() {
		return greetingDate;
	}

	public void setGreetingDate(Date greetingDate) {
		this.greetingDate = greetingDate;
	}

	public String getGreetingText() {
		return greetingText;
	}

	public void setGreetingText(String greetingText) {
		this.greetingText = greetingText;
	}
	
}
