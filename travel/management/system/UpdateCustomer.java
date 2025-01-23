package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class UpdateCustomer extends JFrame implements ActionListener{
	
	JLabel labelusername,labelname;
	JComboBox comboid;
	JTextField tfnumber,tfcountry,tfaddress,tfemail,tfphone,tfid,tfgender;
	JRadioButton rmale,rfemale;
	JButton add,back;
	
	UpdateCustomer(String username){
		setBounds(450,150,750,500);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
		text.setBounds(50,5,300,25);
		text.setFont(new Font("Tahoma",Font.PLAIN,20));
		add(text);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setBounds(30,40,150,25);
		add(lblusername);
		
		labelusername = new JLabel();
		labelusername.setBounds(220,40,150,25);
		add(labelusername);
		
		JLabel lblid = new JLabel("Id");
		lblid.setBounds(30,80,150,25);
		add(lblid);
		
		tfid = new JTextField();
		tfid.setBounds(220,80,150,25);
		add(tfid);
		
		JLabel lblnumber = new JLabel("Number");
		lblnumber.setBounds(30,120,150,25);
		add(lblnumber);
		
		tfnumber = new JTextField();
		tfnumber.setBounds(220,120,150,25);
		add(tfnumber);
		
		JLabel lblname = new JLabel("Name");
		lblname.setBounds(30,160,150,25);
		add(lblname);
		
		labelname = new JLabel();
		labelname.setBounds(220,160,150,25);
		add(labelname);
		
		JLabel lblgender = new JLabel("Gender");
		lblgender.setBounds(30,200,150,25);
		add(lblgender);
		
		tfgender = new JTextField();
		tfgender.setBounds(220,200,150,25);
		add(tfgender);
		
		JLabel lblcountry = new JLabel("Country");
		lblcountry.setBounds(30,240,150,25);
		add(lblcountry);
		
		tfcountry = new JTextField();
		tfcountry.setBounds(220,240,150,25);
		add(tfcountry);
		
		JLabel lbladdress = new JLabel("Address");
		lbladdress.setBounds(30,280,150,25);
		add(lbladdress);
		
		tfaddress = new JTextField();
		tfaddress.setBounds(220,280,150,25);
		add(tfaddress);
		
		JLabel lblemail = new JLabel("Email");
		lblemail.setBounds(30,320,150,25);
		add(lblemail);
		
		tfemail = new JTextField();
		tfemail.setBounds(220,320,150,25);
		add(tfemail);
		
		JLabel lblphone = new JLabel("Phone Number");
		lblphone.setBounds(30,360,150,25);
		add(lblphone);
		
		tfphone = new JTextField();
		tfphone.setBounds(220,360,150,25);
		add(tfphone);
		
		add = new JButton("Update");
		add.setBounds(70,410,100,25);
		add.setBackground(Color.BLACK);
		add.setForeground(Color.WHITE);
		add.addActionListener(this);
		add(add);
		
		back = new JButton("Back");
		back.setBounds(220,410,100,25);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
		Image i2 = i1.getImage().getScaledInstance(200, 400, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350,0,400,500);
		add(image);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
			while(rs.next()) {
				labelusername.setText(rs.getString("username"));
				labelname.setText(rs.getString("name"));
				tfid.setText(rs.getString("id"));
				tfnumber.setText(rs.getString("number"));
				tfgender.setText(rs.getString("Gender"));
				tfcountry.setText(rs.getString("country"));
				tfaddress.setText(rs.getString("address"));
				tfemail.setText(rs.getString("email"));
				tfphone.setText(rs.getString("phone"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		             
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == add) {
			String username = labelusername.getText();
			String id = tfid.getText();
			String number = tfnumber.getText();
			String name = labelname.getText();
			String Gender = tfgender.getText();
			String country = tfcountry.getText();
			String address = tfaddress.getText();
			String email = tfemail.getText();
			String phone = tfphone.getText();
			try {
				Conn c = new Conn();
				String query = "update customer set username ='"+username+"', id ='"+id+"', number = '"+number+"', name = '"+name+"', gender = '"+Gender+"', country = '"+country+"', address = '"+address+"', email = '"+email+"', phone = '"+phone+"' WHERE username = '"+username+"'";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
				setVisible(false);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new UpdateCustomer("HemalathaAnumolu");
	}
}