package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class AddCustomer extends JFrame implements ActionListener{
	
	JLabel labelusername,labelname;
	JComboBox comboid;
	JTextField tfnumber,tfcountry,tfaddress,tfemail,tfphone;
	JRadioButton rmale,rfemale;
	JButton add,back;
	
	AddCustomer(String username){
		setBounds(450,150,750,500);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setBounds(30,40,150,25);
		add(lblusername);
		
		labelusername = new JLabel();
		labelusername.setBounds(220,40,150,25);
		add(labelusername);
		
		JLabel lblid = new JLabel("Id");
		lblid.setBounds(30,80,150,25);
		add(lblid);
		
		comboid = new JComboBox(new String[] {"Passport","Aadhar Card","Pan Card","Ration Card"});
		comboid.setBounds(220,80,150,25);
		comboid.setBackground(Color.WHITE);
		add(comboid);
		
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
		
		rmale = new JRadioButton("Male");
		rmale.setBounds(220,200,70,25);
		rmale.setBackground(Color.WHITE);
		add(rmale);
		
		rfemale = new JRadioButton("Female");
		rfemale.setBounds(300,200,70,25);
		rfemale.setBackground(Color.WHITE);
		add(rfemale);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rmale);
		bg.add(rfemale);
		
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
		
		add = new JButton("Add");
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
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
		Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350,5,400,500);
		add(image);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from account where username = 'HemalathaAnumolu'");
			while(rs.next()) {
				labelusername.setText(rs.getString("username"));
				labelname.setText(rs.getString("name"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		             
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == add) {
			String username = labelusername.getText();
			String id = (String)comboid.getSelectedItem();
			String number = tfnumber.getText();
			String name = labelname.getText();
			String Gender = null;
			if(rmale.isSelected()) {
				Gender = "Male";
			}else {
				Gender = "Female";
			}
			String country = tfcountry.getText();
			String address = tfaddress.getText();
			String email = tfemail.getText();
			String phone = tfphone.getText();
			try {
				Conn c = new Conn();
				String query = "insert into customer values('"+username+"','"+id+"','"+number+"','"+name+"','"+Gender+"','"+country+"','"+address+"','"+email+"','"+phone+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
				setVisible(false);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new AddCustomer("");
	}
}
