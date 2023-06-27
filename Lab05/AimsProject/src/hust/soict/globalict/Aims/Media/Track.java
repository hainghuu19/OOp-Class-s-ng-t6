package hust.soict.globalict.Aims.Media;

import hust.soict.globalict.Aims.Exception.PlayerException;

public class Track implements Playable {
	private int length;
	private String title;

	public Track() {
		// TODO Auto-generated constructor stub
	}

	public int getLength() {
		return length;
	}

	public String getTitle() {
		return title;
	}

	public Track(int length, String title) {
		super();
		this.length = length;
		this.title = title;
	}

	@Override
	public void play() throws PlayerException {
		if(this.getLength() <= 0) {
			throw new PlayerException("ERROR: DVD length is non-psitive");
		}
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Track)) {
			return false;
		}
		Track track = (Track) o;
		if (track.getTitle().equals(this.getTitle()) && track.length == this.getLength()) {
			return true;
		}
		return false;
	}

}
