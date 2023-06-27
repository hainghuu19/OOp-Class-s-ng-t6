package hust.soict.globalict.Aims.Store;

import java.util.ArrayList;

import hust.soict.globalict.Aims.Exception.IllegalItemException;
import hust.soict.globalict.Aims.Exception.LimitExceededException;
import hust.soict.globalict.Aims.Media.Media;

public class Store {
	private ArrayList<Media> itemInStore = new ArrayList<>();

	public ArrayList<Media> getItemInStore() {
		return itemInStore;
	}

	public void addMedia(Media... medias) {
		for (Media media : medias) {
			itemInStore.add(media);
		}
		System.out.println("Added " + itemInStore.size() + " items");
	}

	public void removeMedia(Media... medias) throws LimitExceededException, IllegalItemException {
		if(itemInStore.size() == 0) {
			throw new LimitExceededException("ERROR: The number of items is 0");
		}
		for (Media rmMedia : medias) {
			Boolean correct = false;
			for (Media t : this.itemInStore) {
				correct = t.getCategory().equals(rmMedia.getCategory()) && t.getCost() == rmMedia.getCost()
						&& t.getId() == rmMedia.getId() && t.getTitle().equals(rmMedia.getTitle());
				if (correct) {
					this.itemInStore.remove(rmMedia);
					System.out.println("Removed successfully");
					break;
				}
			}
			if(correct) {
				throw  new IllegalItemException("ERROR: No item match");
			}
		}
	}
	public void print() {
		System.out.println("********STORE**********");
		for (int i = 0; i < itemInStore.size(); i++) {
			System.out.println(i + 1 + ".\t" + this.itemInStore.get(i).toString());
		}
		System.out.println("END");
		System.out.println("\n");
	}
}
