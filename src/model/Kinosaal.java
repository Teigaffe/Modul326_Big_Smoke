package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Kinosaal implements Serializable{

	private int kinosaal;
	private ArrayList<Reihe> reihen;
	public int getKinosaal() {
		return kinosaal;
	}
	public void setKinosaal(int kinosaal) {
		this.kinosaal = kinosaal;
	}
	public ArrayList<Reihe> getReihen() {
		return reihen;
	}
	public void setReihen(ArrayList<Reihe> reihen) {
		this.reihen = reihen;
	}
	
	
}
