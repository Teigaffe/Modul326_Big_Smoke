package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import controller.Kinobuchsystem;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ChooseMovie extends JFrame {

	public ChooseMovie(Kinobuchsystem controller) {
		
		Kinobuchsystem kinobuchsystem = controller;
		ArrayList<String> Movies = new ArrayList<>();
		Movies.add("WW2");
		Movies.add("Spiderman");
		
		setBounds(100, 100, 450, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(6, 3, 10, 10));
		
		JComboBox movieList = new JComboBox();
		
		JLabel lblPlaceAReservation = new JLabel("Choose the movie for which you want to see the reservations:");
		lblPlaceAReservation.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblPlaceAReservation);
		
		JLabel lblMovie = new JLabel("Movie:");
		lblMovie.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblMovie);
		
		
		movieList.setModel(new DefaultComboBoxModel(Movies.toArray()));
		getContentPane().add(movieList);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReservationsOverview r = new ReservationsOverview(kinobuchsystem, movieList.getSelectedItem().toString());
			}
		});
		getContentPane().add(btnSelect);	
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		getContentPane().add(btnBack);
		
		setSize(550, 500);
        setBackground(Color.BLACK);
        setTitle("Movie Managment");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	}

}
