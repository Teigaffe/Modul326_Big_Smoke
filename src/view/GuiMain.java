package view;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Kinobuchsystem;
import model.Film;
import model.Kinosaal;
import model.Platz;
import model.Reihe;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class GuiMain extends JFrame {
	GuiMain guiMain = this;
	
	String movieName;
	int movieLength;
	Kinobuchsystem kinobuchsystem = new Kinobuchsystem();
    JButton btnSeeReservations = new JButton("See Reservations");
    JButton btnPlaceReservation = new JButton("Place Reservation");
    private final JButton btnBlockbuster = new JButton("Blockbuster");
    private final JLabel label = new JLabel("");
    private final JLabel label_1 = new JLabel("");

    public GuiMain() {
        getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
        getContentPane().add(btnPlaceReservation);
        btnPlaceReservation.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		kinobuchsystem.setMovies(readMovies());
        		ReservationView reservationView = new ReservationView(kinobuchsystem);
        	}
        });
        btnPlaceReservation.setBounds(60, 400, 220, 30);
        
        getContentPane().add(label);
        getContentPane().add(btnBlockbuster);
        btnBlockbuster.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new MovieView(movieName, movieLength);
        	}
        });
        
        getContentPane().add(label_1);
        getContentPane().add(btnSeeReservations);
        btnSeeReservations.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ChooseMovie c = new ChooseMovie(kinobuchsystem);
        	}
        });
        btnSeeReservations.setBounds(60, 400, 220, 30);
        
        // JFrame properties
        setSize(550, 500);
        setBackground(Color.BLACK);
        setTitle("Air Traffic Control");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GuiMain();
    }
    
    public void fillMovieValues(String name, int length){
		movieName = name;
		movieLength = length;
    }
    private ArrayList<Film> readMovies(){
    	ArrayList<Film> movieList = new ArrayList<>();
    	List<String> lines = null;
    	Path filePath = Paths.get("Input/MovieList.txt");
    	String[] movies = null;
    	boolean isSameMovie = false;
    	try {
			lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	for(String s : lines){
    		Film movie = new Film();
    		String[] seperatedLine = s.split(";");
    		movie.setFilmId(Integer.parseInt(seperatedLine[0]));
    		movie.setName(seperatedLine[1]);
    		movie.setLaufzeit(Integer.parseInt(seperatedLine[2]));
    		
    		
    		ArrayList<String> showTime = new ArrayList<>();
    		String[]times = seperatedLine[4].split(",");
    		for(String time : times){
    			showTime.add(time);
    		}
    		movie.setShowTime(showTime);
    		
    		
    		ArrayList<Kinosaal> rooms = new ArrayList<>();
    		String[] roomNumbers = seperatedLine[5].split(",");
    		for(String room : roomNumbers){
    			Kinosaal newRoom = createCinemaRoom(Integer.parseInt(room), 10);
    			rooms.add(newRoom);
    		}
    		movie.setRooms(rooms);
    		movieList.add(movie);
    		
    	}
    	
    	
		return movieList;
    	
    }
    
    private Kinosaal createCinemaRoom(int id, int row){
    	Kinosaal cinemaRoom = new Kinosaal();
    	ArrayList<Reihe> rows = new ArrayList<>();
    	
    	cinemaRoom.setKinosaal(id);
    	for(int i = 0; i<row; i++){
    		Reihe newRow = new Reihe();
    		newRow.setReihennummer(i);
    		ArrayList<Platz> seats = new ArrayList<>();
    		for(int j = 0; j<row; j++){
        		Platz seat = new Platz();
        		seat.setPlatznummer(j);
        		seats.add(seat);
        		
        	}
    		newRow.setPlaetze(seats);
    		rows.add(newRow);
    	}
    	cinemaRoom.setReihen(rows);
    	
		return cinemaRoom;
    	
    }
}