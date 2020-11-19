package com.reading.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long coustomerId;

	private String firstName;
	private String lastName;
	private String email;
	private int phoneNumber;
	private String address;

	@OneToMany(fetch = FetchType.EAGER)
	private Set<Book> orderedBook = new HashSet<>();

	public Customer() {
	}

	public Customer(String firstName, String lastName, String email, int phoneNumber, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public void orderBook(Book book) {
		this.orderedBook.add(book);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getCoustomerId() {
		return coustomerId;
	}

	public Set<Book> getOrderedBook() {
		return orderedBook;
	}

	@Override
	public String toString() {
		return String.format(
				"Customer [coustomerId=%s, firstName=%s, lastName=%s, email=%s, phoneNumber=%s, address=%s]",
				coustomerId, firstName, lastName, email, phoneNumber, address);
	}

	public static Customer getCustomer() {
		Customer customer = new Customer("Kunal", "Kumar", "kunal@h=gmail.com", 1234567890, "India");
		return customer;
	}

}
