package com.example.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Book {

	private final String title;
	private final Integer year;
	private final List<String> authors;

	private Book(Builder builder) {
		this.title = builder.title;
		this.year = builder.year;
		this.authors = new ArrayList<>(builder.authors);
	}

	private Book(String title, Integer year, List<String> authors) {
		this.title = title;
		this.year = year;
		this.authors = new ArrayList<>(authors);
	}

	public static void main(String[] args) {
		Book book = new Book("title", 1990, Arrays.asList("tom"));
		System.out.println(book);

		Book newBook = book.builder().withTitle("new Title").build();

		System.out.println(newBook);
	}

	public Builder builder() {
		return new Builder().withAuthors(this.authors).withTitle(this.title).withYear(this.year);
	}

	public String getTitle() {
		return title;
	}

	public Integer getYear() {
		return year;
	}

	public List<String> getAuthors() {
		return new ArrayList<>(authors);
	}

	@Override
	public String toString() {
		return "Book{" +
				"title='" + title + '\'' +
				", year=" + year +
				", authors=" + authors +
				'}';
	}

	public static final class Builder {
		private String title = null;
		private Integer year = null;
		private List<String> authors = null;

		public Book build() {
			return new Book(this);
		}

		public Builder from(Book other) {
			withTitle(other.title);
			withYear(other.year);
			withAuthors(other.authors);
			return this;
		}

		public Builder withTitle(String title) {
			this.title = title;
			return this;
		}

		public Builder withYear(Integer year) {
			this.year = year;
			return this;
		}

		public Builder withAuthors(List<String> authors) {
			this.authors = authors;
			return this;
		}
	}
}