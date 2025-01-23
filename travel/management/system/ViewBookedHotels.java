package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class ViewBookedHotels extends JFrame implements ActionListener{
	
	 JButton back;
		
	 ViewBookedHotels(String username){
			setBounds(450,150,750,500);
			getContentPane().setBackground(Color.WHITE);
			setLayout(null);
			
			JLabel text = new JLabel("VIEW BOOKED HOTELS");
			text.setFont(new Font("Tahoma",Font.BOLD,20));
			text.setBounds(50,0,300,30);
			add(text);
			
			JLabel lblusername = new JLabel("Username");
			lblusername.setFont(new Font("Tahoma",Font.PLAIN,14));
			lblusername.setBounds(50,40,100,25);
			add(lblusername);
			
			JLabel labelusername = new JLabel();
			labelusername.setFont(new Font("Tahoma",Font.PLAIN,14));
			labelusername.setBounds(180,40,200,25);
			add(labelusername);
			
			JLabel lblhotelname = new JLabel("Hotel Name");
			lblhotelname.setFont(new Font("Tahoma",Font.PLAIN,14));
			lblhotelname.setBounds(50,75,100,25);
			add(lblhotelname);
			
			JLabel labelhotelname = new JLabel();
			labelhotelname.setFont(new Font("Tahoma",Font.PLAIN,14));
			labelhotelname.setBounds(180,75,200,25);
			add(labelhotelname);
			
			JLabel lblpersons = new JLabel("Total Persons");
			lblpersons.setFont(new Font("Tahoma",Font.PLAIN,14));
			lblpersons.setBounds(50,110,100,25);
			add(lblpersons);
			
			JLabel labelpersons = new JLabel();
			labelpersons.setFont(new Font("Tahoma",Font.PLAIN,14));
			labelpersons.setBounds(180,110,200,25);
			add(labelpersons);
			
			JLabel lbldays = new JLabel("Total Days");
			lbldays.setFont(new Font("Tahoma",Font.PLAIN,14));
			lbldays.setBounds(50,145,100,25);
			add(lbldays);
			
			JLabel labeldays = new JLabel();
			labeldays.setFont(new Font("Tahoma",Font.PLAIN,14));
			labeldays.setBounds(180,145,200,25);
			add(labeldays);
			
			JLabel lblac = new JLabel("AC/Non-AC");
			lblac.setFont(new Font("Tahoma",Font.PLAIN,14));
			lblac.setBounds(50,180,100,25);
			add(lblac);
			
			JLabel labelac = new JLabel();
			labelac.setFont(new Font("Tahoma",Font.PLAIN,14));
			labelac.setBounds(180,180,200,25);
			add(labelac);
			
			JLabel lblfood = new JLabel("Food Included");
			lblfood.setFont(new Font("Tahoma",Font.PLAIN,14));
			lblfood.setBounds(50,215,100,25);
			add(lblfood);
			
			JLabel labelfood = new JLabel();
			labelfood.setFont(new Font("Tahoma",Font.PLAIN,14));
			labelfood.setBounds(180,215,200,25);
			add(labelfood);
			
			JLabel lblid = new JLabel("Id");
			lblid.setFont(new Font("Tahoma",Font.PLAIN,14));
			lblid.setBounds(50,250,100,25);
			add(lblid);
			
			JLabel labelid = new JLabel();
			labelid.setFont(new Font("Tahoma",Font.PLAIN,14));
			labelid.setBounds(180,250,200,25);
			add(labelid);
			
			JLabel lblnumber = new JLabel("Number");
			lblnumber.setFont(new Font("Tahoma",Font.PLAIN,14));
			lblnumber.setBounds(50,285,100,25);
			add(lblnumber);
			
			JLabel labelnumber = new JLabel();
			labelnumber.setFont(new Font("Tahoma",Font.PLAIN,14));
			labelnumber.setBounds(180,285,200,25);
			add(labelnumber);
			
			JLabel lblphone = new JLabel("Phone");
			lblphone.setFont(new Font("Tahoma",Font.PLAIN,14));
			lblphone.setBounds(50,320,450,25);
			add(lblphone);
			
			JLabel labelphone = new JLabel();
			labelphone.setFont(new Font("Tahoma",Font.PLAIN,14));
			labelphone.setBounds(180,320,200,25);
			add(labelphone);
			
			JLabel  lblprice = new JLabel("Price");
			lblprice.setFont(new Font("Tahoma",Font.PLAIN,14));
			lblprice.setBounds(50,355,100,25);
			add(lblprice);
			
			JLabel labelprice = new JLabel();
			labelprice.setFont(new Font("Tahoma",Font.PLAIN,14));
			labelprice.setBounds(180,355,200,25);
			add(labelprice);
			
			back = new JButton("Back");
			back.setBounds(300,400,100,25);
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
				String query = "select * from bookhotel where username = '"+username+"'";
				ResultSet rs = conn.s.executeQuery(query);
				while(rs.next()) {
					labelusername.setText(rs.getString("username"));
					labelhotelname.setText(rs.getString("name"));
					labeldays.setText(rs.getString("days"));
					labelac.setText(rs.getString("ac"));
					labelfood.setText(rs.getString("food"));
					labelid.setText(rs.getString("id"));
					labelnumber.setText(rs.getString("number"));
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
		new ViewBookedHotels("HemalathaAnumolu");
	}

}