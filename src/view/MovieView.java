package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

public class MovieView extends JFrame{
	private String movieName;
	private int movieLength;

	public MovieView(String name, int length) {
		movieName = name;
		movieLength = length;
		
		setBounds(100, 100, 600, 525);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(4, 4, 10, 10));
		
		JLabel lblCurrentBlockbuster = new JLabel("Current Blockbuster:");
		lblCurrentBlockbuster.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrentBlockbuster.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblCurrentBlockbuster);
		
		JLabel lblMovieName = new JLabel("");
		lblMovieName.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovieName.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		getContentPane().add(lblMovieName);
		lblMovieName.setText(movieName);
		
		JLabel lblLength = new JLabel("Length:");
		lblLength.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLength.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblLength);
		
		JLabel lblLengthVal = new JLabel("");
		lblLengthVal.setHorizontalAlignment(SwingConstants.CENTER);
		lblLengthVal.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		getContentPane().add(lblLengthVal);
		lblLengthVal.setText(Integer.toString(movieLength));
		
		setSize(550, 500);
        setBackground(Color.BLACK);
        setTitle("Movie Managment");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	}

}
