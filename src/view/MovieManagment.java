package view;

import java.awt.Color;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Film;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import controller.Kinobuchsystem;

import javax.swing.JLabel;

public class MovieManagment extends JFrame {
	
	GuiMain guiMain;
	
	private String movieTitleReturnVal;
	private int movieLengthReturnVal;
	
    public String getMovieTitleReturnVal() {
		return movieTitleReturnVal;
	}
    
	public void setMovieTitleReturnVal(String movieTitleReturnVal) {
		this.movieTitleReturnVal = movieTitleReturnVal;
	}

	public int getMovieLengthReturnVal() {
		return movieLengthReturnVal;
	}

	public void setMovieLengthReturnVal(int movieLengthReturnVal) {
		this.movieLengthReturnVal = movieLengthReturnVal;
	}

	JPanel pnlButton = new JPanel();
    private JTextField movieTitle;
    private JTextField movieLength;

    public MovieManagment(GuiMain guiMain) {
    	
    	this.guiMain = guiMain;
        
        // JPanel bounds
        pnlButton.setBounds(800, 800, 200, 100);
        pnlButton.setLayout(new GridLayout(5, 3, 10, 20));
        getContentPane().add(pnlButton);
        
        JLabel lblMovieTitle = new JLabel("Movie Title:");
        pnlButton.add(lblMovieTitle);
        
        movieTitle = new JTextField();
        pnlButton.add(movieTitle);
        movieTitle.setColumns(10);
        
        JLabel lblMovieLength = new JLabel("Movie Length in Minutes");
        pnlButton.add(lblMovieLength);
        
        movieLength = new JTextField();
        pnlButton.add(movieLength);
        movieLength.setColumns(10);
        
        JButton btnCreateMovie = new JButton("Create Movie");
        btnCreateMovie.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		String movieName;
        		int movieLengthInMin;
        		movieName = movieTitle.getText();
        		movieLengthInMin = Integer.parseInt(movieLength.getText());
        		
        		guiMain.fillMovieValues(movieTitle.getText(), Integer.parseInt(movieLength.getText()));

        		dispose();
        	}
        });
        pnlButton.add(btnCreateMovie);

        // JFrame properties
        setSize(550, 500);
        setBackground(Color.BLACK);
        setTitle("Movie Managment");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
	

}