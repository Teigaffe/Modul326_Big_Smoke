package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Besucher implements Serializable{

	private String telefonnummer;
	private ArrayList<Reservation> reservation;
	public String getTelefonnummer() {
		return telefonnummer;
	}
	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}
	public ArrayList<Reservation> getReservation() {
		return reservation;
	}
	public void setReservation(ArrayList<Reservation> reservation) {
		this.reservation = reservation;
	}
	
	
}
