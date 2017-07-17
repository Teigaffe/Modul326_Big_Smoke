package controller;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import DAL.SerializerHelper;
import model.Film;
import model.Kinosaal;
import model.Platz;
import model.Reihe;
import model.Reservation;

public class Kinobuchsystem implements Observer{
	
	private ArrayList<Film> movies = new ArrayList<>();
	
	public ArrayList<Film> getMovies() {
		return movies;
	}

	public void setMovies(ArrayList<Film> movies) {
		this.movies = movies;
	}
	
	public ArrayList<String> returnMovieTitles(){
		ArrayList<String> returnVal = new ArrayList<>();
		for(Film f : movies){
			returnVal.add(f.getName());
		}
		return returnVal;
	}
	
	public ArrayList<String> returnMovieTimes(String movieName){
		ArrayList<String> returnVal = new ArrayList<>();
		for(Film f : movies){
			if(f.getName().equalsIgnoreCase(movieName)){
				for(String time : f.getShowTime()){
					returnVal.add(time);
				}
			}
		}
		return returnVal;
	}
	
	public ArrayList<String> returnMovieRooms(String movieName){
		ArrayList<String> returnVal = new ArrayList<>();
		for(Film f : movies){
			if(f.getName().equalsIgnoreCase(movieName)){
				for(Kinosaal k : f.getRooms()){
					returnVal.add(Integer.toString(k.getKinosaal()));
				}
			}
		}
		return returnVal;
	}
	
	public void createReservation(String customerName, String customerPhone, String seat, String row, String room, String movie, String time){
		SerializerHelper serializerHelper = new SerializerHelper();
		movies = serializerHelper.Deserialize();
		for(Film f : movies){
			if(f.getName().equalsIgnoreCase(movie)){
				ArrayList<Kinosaal> rooms = f.getRooms();
				for(Kinosaal k: rooms){
					ArrayList<Reihe> rows = k.getReihen();
					for(Reihe r: rows){
						ArrayList<Platz> seats = r.getPlaetze();
						for(Platz p : seats){
							if(p.getPlatznummer() == Integer.parseInt(seat) && r.getReihennummer() == Integer.parseInt(row)){
								p.setReserved(true);
							}
						}
					}
				}
			}
		}
		serializerHelper.Serialize(movies);
	}
	
	public Reservation erstelleReservation() {
		return null;
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}
