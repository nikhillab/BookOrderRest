package com.reading.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookId;
	private String bookName;
	private String authorName;
	private long price;
	@Transient
	private long stock = 3;

	public Book() {
	}

	public Book(String bookName, String authorName, long price) {
		this.bookName = bookName;
		this.authorName = authorName;
		this.price = price;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public long getBookId() {
		return bookId;
	}

	public long getStock() {
		return stock;
	}

	public void setStock(long stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return String.format("Book [bookId=%s, bookName=%s, authorName=%s, price=%s, stock=%s]", bookId, bookName,
				authorName, price, stock);
	}

	public static List<Book> getBook() {
		List<Book> book = List.of(new Book("JavaSE11", "Nikhil", 500), new Book("JavaSE12", "Nikhil", 500),
				new Book("JavaSE13", "Nikhil", 500), new Book("JavaSE14", "Nikhil", 500),
				new Book("JavaSE15", "Nikhil", 500), new Book("JavaSE16", "Nikhil", 500));
		return book;

	}
}
