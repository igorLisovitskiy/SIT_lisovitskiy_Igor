package com.lisovitskiy.hw5;

public class Book {
	private int id;
	private static int numberOfBooks = 0;
	private String name;
	String[] autors;
	private String publishingHouse;
	private int publishingYear;
	private int numberOfPages;
	private double price;
	private Binding binding;

	enum Binding {
		WIRE("Plastic coils"), SEWN("Running stitch"), COPTIC("Through the fold"), JAPANESE("On the inside");
		private String bindingName;
		private Binding(String bindingName) {
			this.bindingName = bindingName;
		}
		public String getBinding() {
			return bindingName;
		}
	}

	public Book(String name, String[] autors, String publishingHouse, int publishingYear, int numberOfPages,
			double price, Binding binding) {
		this.id = ++numberOfBooks;
		this.name = name;
		this.autors = autors;
		this.publishingHouse = publishingHouse;
		this.publishingYear = publishingYear;
		this.numberOfPages = numberOfPages;
		this.price = price;
		this.binding = binding;
	}

	public Binding getBinding() {
		return this.binding;
	}

	public void setBinding(Binding binding) {
		this.binding = binding;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAutors() {
		String[] authors = this.autors;
		String authorsList = String.join(", ", authors);
		return authorsList;
	}

	public void setAutors(String[] autors) {
		this.autors = autors;
	}

	public String getPublishingHouse() {
		return publishingHouse;
	}

	public void setPublishingHouse(String publishingHouse) {
		this.publishingHouse = publishingHouse;
	}

	public int getPublishingYear() {
		return publishingYear;
	}

	public void setPublishingYear(int publishingYear) {
		this.publishingYear = publishingYear;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String toString() {
		String formatting = "\n\u0009\u00B7";
		return "Book: " + this.id + ";" + formatting + "Name: " + this.name + ":" + formatting + "Author: "
				+ this.getAutors() + ";" + formatting + "Published by: " + this.publishingHouse + " in "
				+ this.publishingYear + ";" + formatting + this.numberOfPages + " pages" + ", binding: "
				+ this.binding.getBinding() + ";" + formatting + "Price: " + this.price + "";
	}

	public static void main(String[] args) {
		Book b1 = new Book("Divine Songs", new String[] { "Isaac Watts" }, "Watts. Inc", 1715, 120, 123, Binding.WIRE);
		Book b2 = new Book("A Description of Three Hundred Animals", new String[] { "Sarah Fielding" },
				"Fielding Corp.", 1712, 52, 13, Binding.COPTIC);
		Book b3 = new Book("Evenings at Home", new String[] { "Sarah Trimmer" }, "Trimmer Int.", 1800, 129, 50,
				Binding.JAPANESE);
		Book b4 = new Book("The Perambulation of a Mouse", new String[] { "Sarah Fielding", "Dorothy Kilner" },
				"Kilner Com.", 1788, 120, 75, Binding.SEWN);
		Book b5 = new Book("The Life", new String[] { "Sarah Fielding" }, "Kilner Com.", 1794, 330, 32, Binding.COPTIC);
		Book b6 = new Book("The History of Little Jack", new String[] { "Dorothy Kilner" }, "Watts. Inc", 1715, 189,
				1205, Binding.WIRE);
		Library l = new Library();
		l.addBook(b1);
		l.addBook(b2);
		l.addBook(b3);
		l.addBook(b4);
		l.addBook(b5);
		l.addBook(b6);
		// l.showAllBooks(););
		//l.getBooksByPublishingHouse("Fielding Corp.");
		//l.getBooksOlderThan(1720);
		l.getBooksByAuthor("Dorothy Kilner");

	}

}
