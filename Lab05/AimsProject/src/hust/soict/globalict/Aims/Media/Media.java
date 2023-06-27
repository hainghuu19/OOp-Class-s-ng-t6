package hust.soict.globalict.Aims.Media;

import java.util.Comparator;

public abstract class Media {
	private int id;
	private String title;
	private String category;
	private float cost;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

	public Media(int id, String title, String category, float cost) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	public static Comparator<Media> getCompareByTitleCost() {
		return COMPARE_BY_TITLE_COST;
	}

	public static Comparator<Media> getCompareByCostTitle() {
		return COMPARE_BY_COST_TITLE;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	@Override
	public boolean equals(Object o) {
		try {
			return (this.title.toLowerCase().equals(((Media)o).getTitle().toLowerCase()) && this.cost == ((Media)o).getCost());
		} catch (NullPointerException | ClassCastException ex) {
			System.err.println(ex.getMessage());
			return false;
		}
	}

//	@Override
//	public String toString() {
//		System.out.println("tostring Media");
//		return "";
//
//	}

	public void printItem() {
		System.out.println("Title: " + this.getTitle());
		System.out.println("Category: " + this.getCategory());
		System.out.println("Id: " + this.getId());
		System.out.println("Cost: " + this.getCost());
	}

	public boolean isMatchId(int id) {
		if (this.getId() == id) {
			return true;
		}
		return false;
	}

	public boolean isMatchTitle(String title) {
		if (this.getTitle().equals(title)) {
			return true;
		}
		return false;
	}

}
