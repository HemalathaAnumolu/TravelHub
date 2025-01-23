package travel.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
	
	JButton login,signup,password;
	JTextField tfpassword,tfusername;
	
	Login(){
		setSize(700,350);
		setLocation(250,200);
		setLayout(null);
		
		getContentPane().setBackground(Color.white);
		
		JPanel pl = new JPanel();
		pl.setBackground(new Color(131,193,233));
		pl.setBounds(0,0,300,350);
		pl.setLayout(null);
		add(pl);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(50,70,200,200);
		pl.add(image);
		
		JPanel p2 = new JPanel();
		p2.setLayout(null);
		p2.setBounds(300,0,400,400);
		add(p2);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setBounds(60,20,100,25);
		lblusername.setFont(new Font("SAN SERIF",Font.PLAIN,15));
		p2.add(lblusername);
		
		tfusername = new JTextField();
		tfusername.setBounds(60,55,300,30);
		tfusername.setBorder(BorderFactory.createEmptyBorder());
		p2.add(tfusername);
		
		
		JLabel lblpassword = new JLabel("Password");
		lblpassword.setBounds(60,90,100,25);
		lblpassword.setFont(new Font("SAN SERIF",Font.PLAIN,15));
		p2.add(lblpassword);
		
		tfpassword = new JTextField();
		tfpassword.setBounds(60,125,300,30);
		tfpassword.setBorder(BorderFactory.createEmptyBorder());
		p2.add(tfpassword);
		
		password = new JButton("Forget Password");
		password.setBounds(140,170,130,30);
		password.setBackground(new Color(131,193,233));
		password.setForeground(Color.WHITE);
		password.setBorder(new LineBorder(new Color(133,193,233)));
		password.addActionListener(this);
		p2.add(password);
		
		login = new JButton("Login");
		login.setBounds(60,220,130,30);
		login.setBackground(new Color(131,193,233));
		login.setForeground(Color.WHITE);
		login.setBorder(new LineBorder(new Color(133,193,233)));
		login.addActionListener(this);
		p2.add(login);
		
		signup = new JButton("Signup");
		signup.setBounds(220,220,130,30);
		signup.setBackground(new Color(131,193,233));
		signup.setForeground(Color.WHITE);
		signup.setBorder(new LineBorder(new Color(133,193,233)));
		signup.addActionListener(this);
		p2.add(signup);
		

		JLabel text = new JLabel("Trouble in login...");
		text.setBounds(250,260,150,20);
		text.setForeground(Color.RED);
		p2.add(text);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == login) {
			try {
				String username = tfusername.getText();
				String pass = tfpassword.getText();
				
				String query = "select * from account where username = '"+username+"' AND password = '"+pass+"'";
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery(query);
				if(rs.next()) {
					setVisible(false);
					new Loading(username);
				}else {
					JOptionPane.showMessageDialog(null, "Incoorect username or password");
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource() == signup) {
			setVisible(false);
			new Signup();
		}else {
			setVisible(false);
			new ForgetPassword();
		}
	}
	
	public static void main(String[] args) {
		new Login();
	}
}
