package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import DAL.SerializerHelper;
import controller.Kinobuchsystem;
import model.Film;
import model.Kinosaal;
import model.Platz;
import model.Reihe;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.BorderLayout;

public class ReservationsOverview extends JFrame {
	private final JLabel lblLegend = new JLabel("X = Occupied | O = Empty");

	public ReservationsOverview(Kinobuchsystem controller, String movieName) {
		
		Kinobuchsystem kinobuchsystem = controller;
		
		setBounds(100, 100, 450, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTextArea lblReservations = new JTextArea("");
		lblReservations.setEditable(false);
		lblReservations.setFont(new Font("Monospaced", Font.PLAIN, 30));
		lblReservations.setText(createReservationsOverview(movieName));
		getContentPane().add(lblReservations);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		getContentPane().add(btnBack, BorderLayout.SOUTH);
		lblLegend.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblLegend, BorderLayout.NORTH);
		
		setSize(550, 500);
        setBackground(Color.BLACK);
        setTitle("Movie Managment");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	}
	
	private String createReservationsOverview(String movieName){
		String returnVal = "";
		
		SerializerHelper s = new SerializerHelper();
		ArrayList<Film> movies = s.Deserialize();
		Film currentMovie;
		for(Film f : movies){
			if(f.getName().equalsIgnoreCase(movieName)){
				currentMovie = f;
				ArrayList<Kinosaal> rooms = f.getRooms();
				for(Kinosaal k: rooms){
					ArrayList<Reihe> rows = k.getReihen();
					for(Reihe r: rows){
						ArrayList<Platz> seats = r.getPlaetze();
						for(Platz p : seats){
							if(p.isReserved()){
								returnVal += " X ";
							} else {
								returnVal += " 0 ";
							}
						}
						returnVal += "\n";
					}
				}
			}
		}
		
		return returnVal;
		
	}

}
