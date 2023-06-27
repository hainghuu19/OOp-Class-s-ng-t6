package hust.soict.globalict.Aims.Media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {

	public MediaComparatorByTitleCost() {
		// TODO Auto-generated constructor stub
	}

	Comparator<Media> compare = Comparator.comparing(Media::getTitle).thenComparingDouble(Media::getCost);

	@Override
	public int compare(Media o1, Media o2) {
		Comparator<Media> comp = Comparator.comparing(Media::getTitle).thenComparingDouble(Media::getCost);
		return comp.compare(o1, o2);
	}
}
