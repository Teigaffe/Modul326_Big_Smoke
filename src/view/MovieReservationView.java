package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controller.Kinobuchsystem;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MovieReservationView extends JFrame {
	private JTextField CustomerName;
	private JTextField PhoneNumber;

	public MovieReservationView(Kinobuchsystem controller, String movieName){
		Kinobuchsystem kinobuchsystem = controller;
		
		List<String> rowsAndSeats = new ArrayList<>();
		for(int i = 0; i < 10; i++){
			rowsAndSeats.add(""+i);
		}
		
		JComboBox seatList = new JComboBox();
		JComboBox rowList = new JComboBox();
		JComboBox roomList = new JComboBox();
		JComboBox timeList = new JComboBox();
		
		setBounds(100, 100, 450, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(13, 3, 10, 10));
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblTime);
		
		timeList.setModel(new DefaultComboBoxModel(kinobuchsystem.returnMovieTimes(movieName).toArray()));
		getContentPane().add(timeList);
		
		JLabel lblRoom = new JLabel("Room:");
		lblRoom.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblRoom);
		
		roomList.setModel(new DefaultComboBoxModel(kinobuchsystem.returnMovieRooms(movieName).toArray()));
		getContentPane().add(roomList);
		
		JLabel lblRow = new JLabel("Row:");
		lblRow.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblRow);
		
		rowList.setModel(new DefaultComboBoxModel(rowsAndSeats.toArray()));
		getContentPane().add(rowList);
		
		JLabel lblSeat = new JLabel("Seat:");
		lblSeat.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblSeat);
		
		seatList.setModel(new DefaultComboBoxModel(rowsAndSeats.toArray()));
		getContentPane().add(seatList);
		
		JLabel lblCustomerName = new JLabel("Customer Name:");
		lblCustomerName.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblCustomerName);
		
		CustomerName = new JTextField();
		getContentPane().add(CustomerName);
		CustomerName.setColumns(10);
		
		JLabel lblCustomerPhone = new JLabel("Customer Phone:");
		lblCustomerPhone.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblCustomerPhone);
		
		PhoneNumber = new JTextField();
		getContentPane().add(PhoneNumber);
		PhoneNumber.setColumns(10);
		
		JButton btnReserve = new JButton("Reserve");
		btnReserve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.createReservation(CustomerName.getText(), PhoneNumber.getText(), seatList.getSelectedItem().toString(), rowList.getSelectedItem().toString(), roomList.getSelectedItem().toString(), movieName, timeList.getSelectedItem().toString());
				dispose();
			}
		});
		getContentPane().add(btnReserve);
		
		setSize(550, 500);
        setBackground(Color.BLACK);
        setTitle("Movie Managment");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	}
	
}
