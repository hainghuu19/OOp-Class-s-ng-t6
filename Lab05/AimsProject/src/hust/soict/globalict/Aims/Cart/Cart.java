package hust.soict.globalict.Aims.Cart;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import hust.soict.globalict.Aims.Exception.LimitExceededException;
import hust.soict.globalict.Aims.Media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public void setItemsOrdered(ArrayList<Media> itemsOrdered) {
		this.itemsOrdered = (ObservableList<Media>) itemsOrdered;
	}

	public float totalCost() {
		float sum = 0f;
		if (this.itemsOrdered.size() == 0) {
			return 0f;
		}
		for (Media m : this.itemsOrdered) {
			sum += m.getCost();
		}
		return sum;
	}

	public void print() {
		if (this.itemsOrdered.size() == 0) {
			System.out.println("No item has been ordered");
			return;
		}
		System.out.println("***********************CART***********************\n" + "Ordered Items:");
		for (Media item : this.itemsOrdered) {
			if (item == null)
				break;
			System.out.println(item.toString());
		}
		System.out.println("Total cost:" + this.totalCost() + "\n***************************************************");
	}

	public void addMedia(Media m) throws LimitExceededException {
		if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
			this.itemsOrdered.add(m);
			System.out.println("Added successfully");
		} else {
			throw new LimitExceededException("ERROR: The number of media exceeds limit");
		}
	}

	public void removeMedia(Media rmMedia) throws LimitExceededException{
		if (this.itemsOrdered.size() == 0) {
			throw new LimitExceededException("ERROR: The number of media is negative");
		}
		for (Media t : this.itemsOrdered) {
			Boolean correct = t.getCategory().equals(rmMedia.getCategory()) && t.getCost() == rmMedia.getCost()
					&& t.getId() == rmMedia.getId() && t.getTitle().equals(rmMedia.getTitle());
			if (correct) {
				this.itemsOrdered.remove(rmMedia);
				System.out.println("Removed successfully");
				return;
			}
		}
		System.out.println("No item match with your item");
	}

	public void searchByTitle(String title) {
		int count = 0;
		System.out.println("***********************CART***********************\n" + "Items with Title:");
		for (Media item : this.itemsOrdered) {
			if (item.isMatchTitle(title)) {
				count++;
				System.out.println(item.toString());
			}
		}
		if (count == 0)
			System.out.println("No item has that title");
		System.out.println("***************************************************");
	}

	public void searchById(int id) {
		int count = 0;
		System.out.println("***********************CART***********************\n" + "Items with ID:");
		for (Media item : this.itemsOrdered) {
			if (item.isMatchId(id)) {
				count++;
				System.out.println(item.toString());
				break;
			}
		}
		if (count == 0)
			System.out.println("No item has that id");
		System.out.println("***************************************************");
	}

	public void sortByCostTitle() {
		java.util.Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
		this.print();
	}

	public void sortByTitleCost() {
		java.util.Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
		this.print();
	}
	public void empty() {
		this.itemsOrdered.clear();
	}
	public Media getALuckyItem() {
		int indexOfFreeItem = 0;
		if (this.itemsOrdered.size() >= 5) {
			indexOfFreeItem = ThreadLocalRandom.current().nextInt(this.itemsOrdered.size());
			return this.itemsOrdered.get(indexOfFreeItem);
		} else {
			return null;
		}
	}
}