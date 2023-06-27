package hust.soict.globalict.Aims.Media;

import hust.soict.globalict.Aims.Exception.IllegalItemException;
import hust.soict.globalict.Aims.Exception.PlayerException;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<>();

	public String getArtist() {
		return artist;
	}

	public CompactDisc(int id, String title, String category, float cost, String director, String artist,
			ArrayList<Track> tracks) {
		super(id, title, category, cost, director, 10);
		this.artist = artist;
		this.tracks = tracks;
	}


	public void addTrack(Track name) throws IllegalItemException {
		if (this.tracks.contains(name)) {
			throw new IllegalItemException("ERROR:track is already in this list");
		}
		this.tracks.add(name);
		System.out.println(name + "is added");
	}

	public void removeAuthor(Track name) throws IllegalItemException {
		if (!this.tracks.contains(name)) {
			throw new IllegalItemException("ERROR:author is already in this list");
		}
		this.tracks.remove(name);
		System.out.println(name + "is removed");
	}

	@Override
	public int getLength() {
		int len = 0;
		for (Track t : tracks) {
			len += t.getLength();
		}
		return len;
	}

	@Override
	public void play() throws PlayerException {
		if(this.getLength() > 0) {
		// TODO Play all tracks in the CD as you have implemented
			java.util.Iterator iter = tracks.iterator();
			Track nextTrack;
			while(iter.hasNext()) {
				nextTrack = (Track) iter.next();
				try {
					nextTrack.play();
				}catch(PlayerException e) {
					throw e;
				}
			}
		}else {
			throw new PlayerException("ERROR: CD length is non-positive!");
		}
	}


	@Override
	public String toString() {
		return this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength()
				+ ": " + this.getCost() + "$\n";
	}
}
