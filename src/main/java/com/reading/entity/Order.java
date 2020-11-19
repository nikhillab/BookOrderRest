package com.reading.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "order_id")
	private int orderId;
	
	@Column(name = "customer_id")
	private long customerId;
	
	@Column(name = "book_id")
	private long bookId;

	public Order() {
	}

	public Order(long customerId, long bookId) {
		this.customerId = customerId;
		this.bookId = bookId;
	}

	@Override
	public String toString() {
		return String.format("Order [orderId=%s, customerId=%s, bookId=%s]", orderId, customerId, bookId);
	}

}
