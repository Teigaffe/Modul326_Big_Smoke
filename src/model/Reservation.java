package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Reservation implements Serializable{

	private int reservationsId;
	private Besucher besucher;
	private ArrayList<Platz> plaetze;
	public int getReservationsId() {
		return reservationsId;
	}
	public void setReservationsId(int reservationsId) {
		this.reservationsId = reservationsId;
	}
	public Besucher getBesucher() {
		return besucher;
	}
	public void setBesucher(Besucher besucher) {
		this.besucher = besucher;
	}
	public ArrayList<Platz> getPlaetze() {
		return plaetze;
	}
	public void setPlaetze(ArrayList<Platz> plaetze) {
		this.plaetze = plaetze;
	}
	
	
}
