package hust.soict.globalict.Aims.Media;

import hust.soict.globalict.Aims.Exception.IllegalItemException;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();

	public Book(int id, String title, String category, float cost, List<String> authors) {
		super(id, title, category, cost);
		this.authors = authors;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public void addAuthor(String authorName) throws IllegalItemException {
		if (this.authors.contains(authorName)) {
			throw new IllegalItemException("ERROR: Author is already in list");
		}
		this.authors.add(authorName);
		System.out.println(authorName + "is added");
	}

	public void removeAuthor(String authorName) throws IllegalItemException {
		if (!this.authors.contains(authorName)) {
			throw new IllegalItemException("ERROR: Author is not in list");
		}
		this.authors.remove(authorName);
		System.out.println(authorName + "is removed");
	}

	@Override
	public String toString() {
		return this.getTitle() + " - " + this.getCategory() + " - " + ": " + this.getCost() + "$\n";
	}
}
