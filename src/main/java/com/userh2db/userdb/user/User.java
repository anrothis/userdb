package com.userh2db.userdb.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "User") 
@Table
public class User implements Serializable
{
	/**
	 *
	 */
	private static final long serialVersionUID = -2391038738182066591L;

	@Id
	@SequenceGenerator(
		name = "user_sequence",
		sequenceName = "user_sequence",
		allocationSize = 1
	)
	@GeneratedValue(
		strategy = GenerationType.AUTO,
		generator = "user_sequence"
	)
	@Column(name = "ID",nullable = false, unique = true)
    private Long id;
    @Column(name = "Vorname", nullable = false, columnDefinition = "Text")
	private String forename;
    @Column(name = "Nachname", nullable = false, columnDefinition = "Text")
	private String surename;
	@Column(name = "Email", nullable = false, columnDefinition = "VARCHAR", unique = true)
    private String email;
	
	public User() {}
	public User(String forename, String surename, String email) {
		this.forename = forename;
		this.surename = surename;
		this.email = email;
	}
	public User(Long id, String forename, String surename, String email) {
		this.id = id;
		this.forename = forename;
		this.surename = surename;
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getForename() {
		return forename;
	}
	public void setForename(String forename) {
		this.forename = forename;
	}
	public String getSurename() {
		return surename;
	}
	public void setSurename(String surename) {
		this.surename = surename;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", forename=" + forename + ", id=" + id + ", surename=" + surename + "]";
	}
}

