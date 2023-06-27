package hust.soict.globalict.Aims.Media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {

	public MediaComparatorByCostTitle() {
		// TODO Auto-generated constructor stub
	}

	Comparator<Media> compare = Comparator.comparingDouble(Media::getCost).thenComparing(Media::getTitle);

	@Override
	public int compare(Media o1, Media o2) {
		Comparator<Media> comp = Comparator.comparingDouble(Media::getCost).thenComparing(Media::getTitle);
		return comp.compare(o1, o2);
	}

}
