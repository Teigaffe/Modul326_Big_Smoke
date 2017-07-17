package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Reihe implements Serializable{

	private int reihennummer;
	private Kinosaal kinosaal;
	private ArrayList<Platz> plaetze;
	public int getReihennummer() {
		return reihennummer;
	}
	public void setReihennummer(int reihennummer) {
		this.reihennummer = reihennummer;
	}
	public Kinosaal getKinosaal() {
		return kinosaal;
	}
	public void setKinosaal(Kinosaal kinosaal) {
		this.kinosaal = kinosaal;
	}
	public ArrayList<Platz> getPlaetze() {
		return plaetze;
	}
	public void setPlaetze(ArrayList<Platz> plaetze) {
		this.plaetze = plaetze;
	}
	
	
}
