package com.reading;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.reading.entity.Book;
import com.reading.entity.Customer;
import com.reading.entity.Order;
import com.reading.repository.BookRep;
import com.reading.repository.CustomerRepo;
import com.reading.repository.OrderRepo;

@SpringBootApplication
public class ReadingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ReadingApplication.class, args);
	}

	@Autowired
	OrderRepo order;
	@Autowired
	CustomerRepo cust;
	@Autowired
	BookRep book;

	@Override
	public void run(String... args) throws Exception {

		List<Book> saveAll = book.saveAll(Book.getBook());
		Customer customer = Customer.getCustomer();
		customer.orderBook(saveAll.get(1));
		Customer saveedCust = cust.save(customer);
		System.out.println("Saved Book>>>>>>>>>>>>" + saveAll.size());
		System.out.println("Saved Customer>>>>>>>>" + saveedCust);
		Order saveedOrder = order.save(new Order(saveedCust.getCoustomerId(), saveAll.get(1).getBookId()));

		System.out.println("Order >>>>>>>>>>>>>>>" + saveedOrder);
	}

}
