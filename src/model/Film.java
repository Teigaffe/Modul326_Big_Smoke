package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;

public class Film extends Observable implements Serializable {

	private int filmId;
	private int laufzeit;
	private String name;
	private ArrayList<String> showTime; 
	private ArrayList<Kinosaal> Rooms; 
	private boolean deleted;
	
	
	
	public ArrayList<String> getShowTime() {
		return showTime;
	}
	public void setShowTime(ArrayList<String> showTime) {
		this.showTime = showTime;
	}
	public ArrayList<Kinosaal> getRooms() {
		return Rooms;
	}
	public void setRooms(ArrayList<Kinosaal> rooms) {
		Rooms = rooms;
	}
	public int getFilmId() {
		return filmId;
	}
	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}
	public int getLaufzeit() {
		return laufzeit;
	}
	public void setLaufzeit(int laufzeit) {
		this.laufzeit = laufzeit;
		this.setChanged();
		this.notifyObservers();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		this.setChanged();
		this.notifyObservers();
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	public Film(){
		
	}
	
	
	
}
