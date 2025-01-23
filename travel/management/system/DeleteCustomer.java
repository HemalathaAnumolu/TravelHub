package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class DeleteCustomer extends JFrame implements ActionListener{
	
	JButton back;
	String username;
	DeleteCustomer(String username){
		this.username = username;
		setBounds(400,150,830,500);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setFont(new Font("Tahoma",Font.BOLD,14));
		lblusername.setBounds(50,30,100,25);
		add(lblusername);
		
		JLabel labelusername = new JLabel();
		labelusername.setFont(new Font("Tahoma",Font.BOLD,14));
		labelusername.setBounds(180,30,200,25);
		add(labelusername);
		
		JLabel lblid = new JLabel("Id");
		lblid.setFont(new Font("Tahoma",Font.BOLD,14));
		lblid.setBounds(50,80,100,25);
		add(lblid);
		
		JLabel labelid = new JLabel();
		labelid.setFont(new Font("Tahoma",Font.BOLD,14));
		labelid.setBounds(180,80,200,25);
		add(labelid);
		
		JLabel lblnumber = new JLabel("Number");
		lblnumber.setFont(new Font("Tahoma",Font.BOLD,14));
		lblnumber.setBounds(50,130,100,25);
		add(lblnumber);
		
		JLabel labelnumber = new JLabel();
		labelnumber.setFont(new Font("Tahoma",Font.BOLD,14));
		labelnumber.setBounds(180,130,200,25);
		add(labelnumber);
		
		JLabel lblname = new JLabel("Name");
		lblname.setFont(new Font("Tahoma",Font.BOLD,14));
		lblname.setBounds(50,180,100,25);
		add(lblname);
		
		JLabel labelname = new JLabel();
		labelname.setFont(new Font("Tahoma",Font.BOLD,14));
		labelname.setBounds(180,180,200,25);
		add(labelname);
		
		JLabel lblgender = new JLabel("Gender");
		lblgender.setFont(new Font("Tahoma",Font.BOLD,14));
		lblgender.setBounds(50,230,100,25);
		add(lblgender);
		
		JLabel labelgender = new JLabel();
		labelgender.setFont(new Font("Tahoma",Font.BOLD,14));
		labelgender.setBounds(180,230,200,25);
		add(labelgender);
		
		JLabel lblcountry = new JLabel("Country");
		lblcountry.setFont(new Font("Tahoma",Font.BOLD,14));
		lblcountry.setBounds(450,30,100,25);
		add(lblcountry);
		
		JLabel labelcountry = new JLabel();
		labelcountry.setFont(new Font("Tahoma",Font.BOLD,14));
		labelcountry.setBounds(570,30,200,25);
		add(labelcountry);
		
		JLabel  lbladdress = new JLabel("Address");
		lbladdress.setFont(new Font("Tahoma",Font.BOLD,14));
		lbladdress.setBounds(450,80,100,25);
		add(lbladdress);
		
		JLabel labeladdress = new JLabel();
		labeladdress.setFont(new Font("Tahoma",Font.BOLD,14));
		labeladdress.setBounds(570,80,200,25);
		add(labeladdress);
		
		JLabel  lblemail = new JLabel("Email");
		lblemail.setFont(new Font("Tahoma",Font.BOLD,14));
		lblemail.setBounds(450,130,100,25);
		add(lblemail);
		
		JLabel labelemail = new JLabel();
		labelemail.setFont(new Font("Tahoma",Font.BOLD,14));
		labelemail.setBounds(570,130,250,25);
		add(labelemail);
		
		JLabel  lblphone = new JLabel("Phone");
		lblphone.setFont(new Font("Tahoma",Font.BOLD,14));
		lblphone.setBounds(450,180,100,25);
		add(lblphone);
		
		JLabel labelphone = new JLabel();
		labelphone.setFont(new Font("Tahoma",Font.BOLD,14));
		labelphone.setBounds(570,180,200,25);
		add(labelphone);
		
		back = new JButton("Delete");
		back.setBounds(350,280,100,25);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
		Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,300,600,200);
		add(image);
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
		Image i5 = i4.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel image2 = new JLabel(i6);
		image2.setBounds(580,300,600,200);
		add(image2);
		
		try {
			Conn conn = new Conn();
			String query = "select * from customer where username = '"+username+"'";
			ResultSet rs = conn.s.executeQuery(query);
			while(rs.next()) {
				labelusername.setText(rs.getString("username"));
				labelid.setText(rs.getString("id"));
				labelnumber.setText(rs.getString("number"));
				labelname.setText(rs.getString("name"));
				labelgender.setText(rs.getString("Gender"));
				labelcountry.setText(rs.getString("country"));
				labeladdress.setText(rs.getString("address"));
				labelemail.setText(rs.getString("email"));
				labelphone.setText(rs.getString("phone"));
			}
		}catch(Exception e) {
			
		}
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		try {
			Conn c = new Conn();
			c.s.executeUpdate("Delete from account where username = '"+username+"'");
			c.s.executeUpdate("Delete from customer where username = '"+username+"'");
			c.s.executeUpdate("Delete from bookpackage where username = '"+username+"'");
			c.s.executeUpdate("Delete from bookhotel where username = '"+username+"'");
			
			JOptionPane.showMessageDialog(null, "Data deleted successfully");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new DeleteCustomer("HemalathaAnumolu");
	}
}
