

import java.util.ArrayList;
public class Store {
	
	/** The items in store. */
	ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<DigitalVideoDisc>();
	

	/**
	 * Removes the DVD.
	 *
	 * @param disc the disc
	 */
	public void removeDVD(DigitalVideoDisc disc) {
		itemsInStore.remove(disc);
		System.out.println("The disc " + disc.getTitle() + " has been removed");
	}

	/**
	 * Adds the digital video disc.
	 *
	 * @param disc the disc
	 */
	public void addDVD(DigitalVideoDisc disc) {
		// Nếu số lượng chưa max thì có thể thêm
			itemsInStore.add(disc);
			System.out.println("The disc " + disc.getTitle() + " has been added");
	}
	
}
