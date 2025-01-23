package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener {
    Choice chotel, cac, cfood;
    JTextField tfPersons, tfdays;
    String username;
    JLabel labelusername, labelid, labelnumber, labelphone, labelprice;
    JButton checkPrice, bookhotel, back;

    BookHotel(String username) {
        this.username = username;
        setBounds(400, 150, 830, 500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("BOOK HOTEL");
        text.setBounds(100, 5, 200, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblusername.setBounds(40, 45, 100, 20);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelusername.setBounds(230, 45, 150, 20);
        add(labelusername);

        JLabel lblhotel = new JLabel("Select Hotel");
        lblhotel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblhotel.setBounds(40, 80, 150, 25);
        add(lblhotel);

        chotel = new Choice();
        chotel.setBounds(230, 80, 180, 20);
        add(chotel);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while (rs.next()) {
                chotel.add(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblpersons.setBounds(40, 115, 100, 20);
        add(lblpersons);

        tfPersons = new JTextField("1");
        tfPersons.setBounds(230, 115, 180, 25);
        add(tfPersons);

        JLabel lbldays = new JLabel("No. of Days");
        lbldays.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbldays.setBounds(40, 150, 150, 20);
        add(lbldays);

        tfdays = new JTextField("1");
        tfdays.setBounds(230, 150, 180, 25);
        add(tfdays);

        JLabel lblac = new JLabel("AC/ Non-AC");
        lblac.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblac.setBounds(40, 185, 150, 20);
        add(lblac);

        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(230, 185, 180, 20);
        add(cac);

        JLabel lblfood = new JLabel("Food Included");
        lblfood.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblfood.setBounds(40, 220, 150, 20);
        add(lblfood);

        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(230, 220, 180, 20);
        add(cfood);

        JLabel lblid = new JLabel("Id");
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblid.setBounds(40, 255, 150, 25);
        add(lblid);

        labelid = new JLabel();
        labelid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelid.setBounds(230, 255, 150, 25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblnumber.setBounds(40, 290, 150, 25);
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelnumber.setBounds(230, 290, 150, 25);
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblphone.setBounds(40, 325, 150, 25);
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelphone.setBounds(230, 325, 150, 25);
        add(labelphone);

        JLabel lblprice = new JLabel("Total price");
        lblprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblprice.setBounds(40, 360, 150, 25);
        add(lblprice);

        labelprice = new JLabel();
        labelprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelprice.setBounds(230, 360, 150, 25);
        add(labelprice);

        // Fetch user data
        try {
            Conn conn = new Conn();
            String query = "select * from customer where username = '" + username + "'";
            ResultSet rs = conn.s.executeQuery(query);
            if (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
            } else {
                System.out.println("No data found for username: " + username);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        checkPrice = new JButton("Check Price");
        checkPrice.setBackground(Color.BLACK);
        checkPrice.setForeground(Color.WHITE);
        checkPrice.setBounds(60, 400, 120, 25);
        checkPrice.addActionListener(this);
        add(checkPrice);

        bookhotel = new JButton("Book Hotel");
        bookhotel.setBackground(Color.BLACK);
        bookhotel.setForeground(Color.WHITE);
        bookhotel.setBounds(200, 400, 120, 25);
        bookhotel.addActionListener(this);
        add(bookhotel);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340, 400, 120, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(350, 220, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(380, 50, 500, 300);
        add(l12);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkPrice) {
        	try {
	        	Conn c = new Conn();
	        	ResultSet rs = c.s.executeQuery("select * from hotel where name = '"+chotel.getSelectedItem()+"'");
	        	while(rs.next()) {
	        		int cost = Integer.parseInt(rs.getString("costperperson"));
	        		int acroom = Integer.parseInt(rs.getString("acroom"));
	        		int food = Integer.parseInt(rs.getString("foodincluded"));
	        		
	        		int persons = Integer.parseInt(tfPersons.getText());
	        		int days = Integer.parseInt(tfdays.getText());
	        		
	        		String acselected = cac.getSelectedItem();
	        		String foodselected = cfood.getSelectedItem();
	        		
	        		if(persons*days>0) {
	        			int total = 0;
	        			total += acselected.equals("AC") ? acroom : 0;
	        			total += foodselected.equals("Yes") ? food : 0;
	        			total += cost;
	        			total = total * persons * days;
	        			labelprice.setText("Rs "+total);
	        		}else {
	        			JOptionPane.showMessageDialog(null, "Please enter a valid number");
	        		}
	        	}
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
        } else if (ae.getSource() == bookhotel) {
            try {
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookhotel values('" + labelusername.getText() + "', '" + chotel.getSelectedItem() + "', '" + tfPersons.getText() + "', '" + tfdays.getText() + "','" + cac.getSelectedItem()+ "','" + cfood.getSelectedItem() + "','" + labelid.getText() + "', '" + labelnumber.getText() + "', '" + labelphone.getText() + "', '" + labelprice.getText() + "')");
                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookHotel("HemalathaAnumolu");
    }
}