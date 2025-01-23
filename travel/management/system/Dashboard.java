package travel.management.system;

import java.awt.Color;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class Dashboard extends JFrame implements ActionListener{
	
	String username;
	JButton addPersonalDetails,updatePersonalDetails,viewPersonalDetails,deletePersonalDetails,checkPackages,bookPackage,viewBookedPackages,viewHotels,bookHotel,viewBookedHotels,destinations,payments,calculator,notepad,about;
	
	Dashboard(String username){
		//setBounds(0,0,1600,1000);
		this.username = username;
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(0,0,102));
		p1.setBounds(0,0,1600,50);
		add(p1);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
		Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(5,0,55,55);
		p1.add(image);
		
		JLabel heading = new JLabel("Dashboard");
		heading.setBounds(80,10,200,30);
		heading.setForeground(Color.WHITE);
		heading.setFont(new Font("Tahoma",Font.BOLD,25));
		p1.add(heading);
		
		JPanel p2 = new JPanel();
		p2.setLayout(null);
		p2.setBackground(new Color(0,0,102));
		p2.setBounds(0,50,300,900);
		add(p2);
		
		addPersonalDetails = new JButton("Add Personal Details");
		addPersonalDetails.setBounds(0,0,300,50);
		addPersonalDetails.setBackground(new Color(0,0,102));
		addPersonalDetails.setForeground(Color.WHITE);
		addPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
		addPersonalDetails.setMargin(new Insets(0,0,0,60));
		addPersonalDetails.addActionListener(this);
		p2.add(addPersonalDetails);
		
		updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0,40,300,50);
        updatePersonalDetails.setBackground(new Color(0,0,102));
        updatePersonalDetails.setForeground(Color.WHITE);
        updatePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        updatePersonalDetails.setMargin(new Insets(0,0,0,30));
		updatePersonalDetails.addActionListener(this);
		p2.add(updatePersonalDetails);
		
		viewPersonalDetails = new JButton("View Details");
		viewPersonalDetails.setBounds(0,80,300,50);
		viewPersonalDetails.setBackground(new Color(0,0,102));
		viewPersonalDetails.setForeground(Color.WHITE);
		viewPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
		viewPersonalDetails.setMargin(new Insets(0,0,0,130));
		viewPersonalDetails.addActionListener(this);
		p2.add(viewPersonalDetails);
		
		deletePersonalDetails = new JButton("Delete Personal Details");
		deletePersonalDetails.setBounds(0,120,300,50);
		deletePersonalDetails.setBackground(new Color(0,0,102));
		deletePersonalDetails.setForeground(Color.WHITE);
		deletePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
		deletePersonalDetails.setMargin(new Insets(0,0,0,30));
		deletePersonalDetails.addActionListener(this);
		p2.add(deletePersonalDetails);
		
		checkPackages = new JButton("Check Package");
		checkPackages.setBounds(0,160,300,50);
		checkPackages.setBackground(new Color(0,0,102));
		checkPackages.setForeground(Color.WHITE);
		checkPackages.setFont(new Font("Tahoma",Font.PLAIN,20));
		checkPackages.setMargin(new Insets(0,0,0,100));
		checkPackages.addActionListener(this);
		p2.add(checkPackages);
		
		bookPackage = new JButton("Book Package");
		bookPackage.setBounds(0,200,300,50);
		bookPackage.setBackground(new Color(0,0,102));
		bookPackage.setForeground(Color.WHITE);
		bookPackage.setFont(new Font("Tahoma",Font.PLAIN,20));
		bookPackage.setMargin(new Insets(0,0,0,110));
		bookPackage.addActionListener(this);
		p2.add(bookPackage);
		
		viewBookedPackages = new JButton("View Booked Packages");
		viewBookedPackages.setBounds(0,240,300,50);
		viewBookedPackages.setBackground(new Color(0,0,102));
		viewBookedPackages.setForeground(Color.WHITE);
		viewBookedPackages.setFont(new Font("Tahoma",Font.PLAIN,20));
		viewBookedPackages.setMargin(new Insets(0,0,0,30));
		viewBookedPackages.addActionListener(this);
		p2.add(viewBookedPackages);
		
		viewHotels = new JButton("View Hotels");
		viewHotels.setBounds(0,280,300,50);
		viewHotels.setBackground(new Color(0,0,102));
		viewHotels.setForeground(Color.WHITE);
		viewHotels.setFont(new Font("Tahoma",Font.PLAIN,20));
		viewHotels.setMargin(new Insets(0,0,0,130));
		viewHotels.addActionListener(this);
		p2.add(viewHotels);
		
		bookHotel = new JButton("Book Hotel");
		bookHotel.setBounds(0,320,300,50);
		bookHotel.setBackground(new Color(0,0,102));
		bookHotel.setForeground(Color.WHITE);
		bookHotel.setFont(new Font("Tahoma",Font.PLAIN,20));
		bookHotel.setMargin(new Insets(0,0,0,140));
		bookHotel.addActionListener(this);
		p2.add(bookHotel);
		
		viewBookedHotels = new JButton("View Booked Hotels");
		viewBookedHotels.setBounds(0,360,300,50);
		viewBookedHotels.setBackground(new Color(0,0,102));
		viewBookedHotels.setForeground(Color.WHITE);
		viewBookedHotels.setFont(new Font("Tahoma",Font.PLAIN,20));
		viewBookedHotels.setMargin(new Insets(0,0,0,60));
		viewBookedHotels.addActionListener(this);
		p2.add(viewBookedHotels);
		
		destinations = new JButton("Destinations");
		destinations.setBounds(0,400,300,50);
		destinations.setBackground(new Color(0,0,102));
		destinations.setForeground(Color.WHITE);
		destinations.setFont(new Font("Tahoma",Font.PLAIN,20));
		destinations.setMargin(new Insets(0,0,0,120));
		destinations.addActionListener(this);
		p2.add(destinations);
		
		payments = new JButton("Payments");
		payments.setBounds(0,440,300,50);
		payments.setBackground(new Color(0,0,102));
		payments.setForeground(Color.WHITE);
		payments.setFont(new Font("Tahoma",Font.PLAIN,20));
		payments.setMargin(new Insets(0,0,0,140));
		payments.addActionListener(this);
		p2.add(payments);
		
		calculator = new JButton("Calculator");
		calculator.setBounds(0,480,300,50);
		calculator.setBackground(new Color(0,0,102));
		calculator.setForeground(Color.WHITE);
		calculator.setFont(new Font("Tahoma",Font.PLAIN,20));
		calculator.setMargin(new Insets(0,0,0,140));
		calculator.addActionListener(this);
		p2.add(calculator);
		
		notepad = new JButton("Notepad");
		notepad.setBounds(0,520,300,50);
		notepad.setBackground(new Color(0,0,102));
		notepad.setForeground(Color.WHITE);
		notepad.setFont(new Font("Tahoma",Font.PLAIN,20));
		notepad.setMargin(new Insets(0,0,0,150));
		notepad.addActionListener(this);
		p2.add(notepad);
		
		about = new JButton("About");
		about.setBounds(0,560,300,50);
		about.setBackground(new Color(0,0,102));
		about.setForeground(Color.WHITE);
		about.setFont(new Font("Tahoma",Font.PLAIN,20));
		about.setMargin(new Insets(0,0,0,170));
		about.addActionListener(this);
		p2.add(about);
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
		Image i5 = i4.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel image1 = new JLabel(i6);
		image1.setBounds(0,0,1500,800);
		add(image1);
		
		JLabel text = new JLabel("Travel and Tourism Management System");
		text.setBounds(400,60,1200,70);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Raleway",Font.PLAIN,45));
		image1.add(text);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == addPersonalDetails) {
			new AddCustomer(username);
		}else if(ae.getSource() == updatePersonalDetails) {
			new UpdateCustomer(username);
		}else if(ae.getSource() == viewPersonalDetails) {
			new viewCustomer(username);
		}else if(ae.getSource() == deletePersonalDetails) {
			new DeleteCustomer(username);
		}else if(ae.getSource() == checkPackages) {
			new CheckPackage();
		}else if(ae.getSource() == bookPackage) {
			new BookPackage(username);
		}else if(ae.getSource() == viewBookedPackages) {
			new ViewBookedPackage(username);
		}else if(ae.getSource() == viewHotels) {
			new CheckHotels();
		}else if(ae.getSource() == bookHotel) {
			new BookHotel(username);
		}else if(ae.getSource() == viewBookedHotels) {
			new ViewBookedHotels(username);
		}else if(ae.getSource() == destinations) {
			new Destinations();
		}else if(ae.getSource() == payments) {
			new Payment();
		}else if(ae.getSource() == calculator) {
			try {
				Runtime.getRuntime().exec("calc.exe");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource() == notepad) {
			try {
				Runtime.getRuntime().exec("notepad.exe");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource() == about) {
			 new About();
		}
	}
	public static void main(String[] args) {
		new Dashboard("");
	}
}
