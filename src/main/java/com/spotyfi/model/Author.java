package com.spotyfi.model;

public class Author implements Comparable<Author> {
	
	private final String name;
	
	public Author(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Author author) {
		return this.name.compareTo(author.name);
	}

	@Override
	public String toString() {
		return "Author [name=" + name + "]";
	}
	
}
