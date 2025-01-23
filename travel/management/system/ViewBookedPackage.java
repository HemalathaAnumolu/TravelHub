package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class ViewBookedPackage extends JFrame implements ActionListener{
	
    JButton back;
	
	ViewBookedPackage(String username){
		setBounds(450,150,750,500);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text = new JLabel("VIEW BOOKED PACKAGES");
		text.setFont(new Font("Tahoma",Font.BOLD,20));
		text.setBounds(50,0,300,30);
		add(text);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setFont(new Font("Tahoma",Font.BOLD,14));
		lblusername.setBounds(50,50,100,25);
		add(lblusername);
		
		JLabel labelusername = new JLabel();
		labelusername.setFont(new Font("Tahoma",Font.BOLD,14));
		labelusername.setBounds(180,50,200,25);
		add(labelusername);
		
		JLabel lblpackage = new JLabel("Package");
		lblpackage.setFont(new Font("Tahoma",Font.BOLD,14));
		lblpackage.setBounds(50,100,100,25);
		add(lblpackage);
		
		JLabel labelpackage = new JLabel();
		labelpackage.setFont(new Font("Tahoma",Font.BOLD,14));
		labelpackage.setBounds(180,100,200,25);
		add(labelpackage);
		
		JLabel lblpersons = new JLabel("Total Persons");
		lblpersons.setFont(new Font("Tahoma",Font.BOLD,14));
		lblpersons.setBounds(50,150,100,25);
		add(lblpersons);
		
		JLabel labelpersons = new JLabel();
		labelpersons.setFont(new Font("Tahoma",Font.BOLD,14));
		labelpersons.setBounds(180,150,200,25);
		add(labelpersons);
		
		JLabel lblid = new JLabel("Id");
		lblid.setFont(new Font("Tahoma",Font.BOLD,14));
		lblid.setBounds(50,200,100,25);
		add(lblid);
		
		JLabel labelid = new JLabel();
		labelid.setFont(new Font("Tahoma",Font.BOLD,14));
		labelid.setBounds(180,200,200,25);
		add(labelid);
		
		JLabel lblnumber = new JLabel("Number");
		lblnumber.setFont(new Font("Tahoma",Font.BOLD,14));
		lblnumber.setBounds(50,250,100,25);
		add(lblnumber);
		
		JLabel labelnumber = new JLabel();
		labelnumber.setFont(new Font("Tahoma",Font.BOLD,14));
		labelnumber.setBounds(180,250,200,25);
		add(labelnumber);
		
		JLabel lblphone = new JLabel("Phone");
		lblphone.setFont(new Font("Tahoma",Font.BOLD,14));
		lblphone.setBounds(50,300,100,25);
		add(lblphone);
		
		JLabel labelphone = new JLabel();
		labelphone.setFont(new Font("Tahoma",Font.BOLD,14));
		labelphone.setBounds(180,300,200,25);
		add(labelphone);
		
		JLabel  lblprice = new JLabel("Price");
		lblprice.setFont(new Font("Tahoma",Font.BOLD,14));
		lblprice.setBounds(50,350,100,25);
		add(lblprice);
		
		JLabel labelprice = new JLabel();
		labelprice.setFont(new Font("Tahoma",Font.BOLD,14));
		labelprice.setBounds(180,350,200,25);
		add(labelprice);
		
		back = new JButton("Back");
		back.setBounds(350,400,100,25);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
		Image i2 = i1.getImage().getScaledInstance(350, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(360,70,350,300);
		add(image);
		
		try {
			Conn conn = new Conn();
			String query = "select * from bookpackage where username = '"+username+"'";
			ResultSet rs = conn.s.executeQuery(query);
			while(rs.next()) {
				labelusername.setText(rs.getString("username"));
				labelid.setText(rs.getString("id"));
				labelnumber.setText(rs.getString("number"));
				labelpackage.setText(rs.getString("package"));
				labelphone.setText(rs.getString("phone"));
				labelpersons.setText(rs.getString("persons"));
				labelprice.setText(rs.getString("price"));
			}
		}catch(Exception e) {
			
		}
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
	}

	public static void main(String[] args) {
		new ViewBookedPackage("HemalathaAnumolu");
	}

}
