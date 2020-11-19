package com.reading.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reading.entity.Book;
import com.reading.entity.Customer;
import com.reading.service.CustomerService;

@RestController
public class Controller {
	@Autowired
	private CustomerService service;

	@RequestMapping("/")
	public String home() {
		return "Hello World";
	}

	/**
	 * GET mapping for getting user by user id
	 */
	@GetMapping("/user/{id}")
	public ResponseEntity<Customer> getUser(@PathVariable long id) {
		Optional<Customer> userDetail = service.getUserDetail(id);
		if (userDetail.isEmpty())
			return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Customer>(userDetail.get(), HttpStatus.FOUND);

	}

	/**
	 * POST mapping for Creating new user and return user
	 */

	@PostMapping("/user")
	public Customer createCustomer(@RequestBody Customer customer) {
		return service.saveUser(customer);
	}

	/**
	 * POST mapping for getting ordering book using userID and bookID return the
	 * user detail and is order.
	 */

	@PostMapping("/order/{userId}/{bookId}")
	public ResponseEntity<Customer> orderBook(@PathVariable long userId, @PathVariable long bookId) {
		Optional<Customer> order = service.order(userId, bookId);
		if (order.isPresent())
			return new ResponseEntity<Customer>(order.get(), HttpStatus.CREATED);

		return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
	}

	/**
	 * GET mapping for getting user list of orders
	 */

	@GetMapping("/user/{id}/list")
	public ResponseEntity<Set<Book>> getUserOrder(@PathVariable long id) {
		Optional<Set<Book>> orderList = service.orderList(id);
		if (orderList.isPresent())
			return new ResponseEntity<Set<Book>>(orderList.get(), HttpStatus.ACCEPTED);

		return new ResponseEntity<Set<Book>>(HttpStatus.BAD_REQUEST);
	}

}
