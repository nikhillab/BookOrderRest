package com.reading.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reading.entity.Book;
import com.reading.entity.Customer;
import com.reading.repository.BookRep;
import com.reading.repository.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	@Autowired
	private BookRep bookRep;

	public Optional<Customer> getUserDetail(long userId) {

		Optional<Customer> user = customerRepo.findById(userId);

		return user;

	}

	public Customer saveUser(Customer customer) {
		return customerRepo.save(customer);
	}

	public Optional<Customer> order(long userId, long bookId) {

		Optional<Book> findedBook = bookRep.findById(bookId);

		if (findedBook.isPresent()) {

			Book book = findedBook.get();

			if (book.getStock() > 0) {

				book.setStock(book.getStock() - 1);

				Optional<Customer> findedCustomer = customerRepo.findById(userId);

				if (findedCustomer.isPresent()) {
					Customer customer = findedCustomer.get();

					customer.orderBook(book);
					Customer updatedCustomer = customerRepo.save(customer);
					return Optional.of(updatedCustomer);
				}
			}
		}

		return Optional.empty();

	}

	public Optional<Set<Book>> orderList(long id) {
		Optional<Customer> findedUser = customerRepo.findById(id);
		if (findedUser.isPresent())
			return Optional.of(findedUser.get().getOrderedBook());
		return Optional.empty();

	}

}
