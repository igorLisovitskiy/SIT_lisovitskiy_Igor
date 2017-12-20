package com.lisovitskiy.hw5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
	private List<Book> books = new ArrayList<Book>();

	public void showAllBooks() {
		books.forEach(book -> System.out.println(book));
	}

	public void getBooksByAuthor(String author) {
		List<Book> filtered = books.stream().filter(b -> b.getAutors().contains(author)).collect(Collectors.toList());
		filtered.forEach(book -> System.out.println(book));
	}

	public void getBooksOlderThan(int year) {
		List<Book> filtered = books.stream().filter(b -> b.getPublishingYear() > year).collect(Collectors.toList());
		filtered.forEach(book -> System.out.println(book));
	}

	public void getBooksByPublishingHouse(String pubHouse) {
		List<Book> filtered = books.stream().filter(b -> b.getPublishingHouse().equals(pubHouse))
				.collect(Collectors.toList());
		filtered.forEach(book -> System.out.println(book));
	}

	public void addBook(Book b) {
		if ((b instanceof Book) == false) {
			System.out.println("Not a book!");
		} else {

			books.add(b);
		}
	}

}
