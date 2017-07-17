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
import java.awt.event.ActionEvent;

public class ReservationView extends JFrame {

	public ReservationView(Kinobuchsystem controller) {
		
		Kinobuchsystem kinobuchsystem = controller;
		
		setBounds(100, 100, 450, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(12, 3, 10, 10));
		
		JComboBox movieList = new JComboBox();
		
		JLabel lblPlaceAReservation = new JLabel("Place a Reservation:");
		lblPlaceAReservation.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblPlaceAReservation);
		
		JLabel lblMovie = new JLabel("Movie:");
		lblMovie.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblMovie);
		
		
		movieList.setModel(new DefaultComboBoxModel(kinobuchsystem.returnMovieTitles().toArray()));
		getContentPane().add(movieList);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MovieReservationView movieReservationView = new MovieReservationView(kinobuchsystem, movieList.getSelectedItem().toString());
				dispose();
			}
		});
		getContentPane().add(btnSelect);	
		
		setSize(550, 500);
        setBackground(Color.BLACK);
        setTitle("Movie Managment");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	}

}
