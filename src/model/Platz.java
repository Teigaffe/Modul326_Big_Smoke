package model;

import java.io.Serializable;

public class Platz implements Serializable{

	private int platznummer;
	private Reihe reihe;
	private boolean isReserved = false;
	public int getPlatznummer() {
		return platznummer;
	}
	public void setPlatznummer(int platznummer) {
		this.platznummer = platznummer;
	}
	public boolean isReserved() {
		return isReserved;
	}
	public void setReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}
	public Reihe getReihe() {
		return reihe;
	}
	public void setReihe(Reihe reihe) {
		this.reihe = reihe;
	}
	
	
}
