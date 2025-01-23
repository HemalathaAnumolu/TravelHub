package travel.management.system;

import java.awt.*;
import javax.swing.*;

public class CheckPackage extends JFrame{
	
	CheckPackage(){
		setBounds(450,150,750,500);
		
		String[] package1 = {"GOLD PACKAGE","6 Days and 7 Nights","Airport Assisstance","Half Day City Tour","Soft Drinks Free","Daily Buffet","Full Day 3 Island Cruise","English Speaking Guide","BOOK PACKAGE","SUMMER SPECIAL","Rs 12000/-","package1.jpg"};
		String[] package2 = {"SILVER PACKAGE","4 Days and 5 Nights","Toll Free"," Entrance Free Tickets","Meet and Greet at Airport","Welcome Drinks on Arrival","Night Safari","Cruise with Dinner","BOOK NOW","WINTER SPECIAL","Rs 24000/-","package2.jpg"};
		String[] package3 = {"BRONZE PACKAGE","2 Days and 3 Nights","Return Airfare","Free Clubbing","Horse Riding & Other Games","Hard Drinks Free","Daily Buffet","BBQ Dinner","BOOK NOW","MONSOON SPECIAL","Rs 32000/-","package3.jpg"};
		
		JTabbedPane tab = new JTabbedPane();
		
		JPanel p1 = createPackage(package1);
		tab.addTab("Package 1",null,p1);
		
		JPanel p2 = createPackage(package2);
		tab.addTab("Package 2",null,p2);
		
		JPanel p3 = createPackage(package3);
		tab.addTab("Package 3",null,p3);
		
		add(tab);
		
		
		setVisible(true);
		
	}
	
	public JPanel createPackage(String[] pack) {
		JPanel p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(Color.WHITE);
		
		JLabel l1 = new JLabel(pack[0]);
		l1.setBounds(50,10,300,30);
		l1.setForeground(Color.BLUE);
		l1.setFont(new Font("Tahoma",Font.BOLD,28));
		p1.add(l1);
		
		JLabel l2 = new JLabel(pack[1]);
		l2.setBounds(30,50,300,30);
		l2.setForeground(Color.RED);
		l2.setFont(new Font("Tahoma",Font.BOLD,20));
		p1.add(l2);
		
		JLabel l3 = new JLabel(pack[2]);
		l3.setBounds(30,90,300,30);
		l3.setForeground(Color.GREEN);
		l3.setFont(new Font("Tahoma",Font.BOLD,20));
		p1.add(l3);
		
		JLabel l4 = new JLabel(pack[3]);
		l4.setBounds(30,130,300,30);
		l4.setForeground(Color.RED);
		l4.setFont(new Font("Tahoma",Font.BOLD,20));
		p1.add(l4);
		
		JLabel l5 = new JLabel(pack[4]);
		l5.setBounds(30,170,300,30);
		l5.setForeground(Color.GREEN);
		l5.setFont(new Font("Tahoma",Font.BOLD,20));
		p1.add(l5);
		
		JLabel l6 = new JLabel(pack[5]);
		l6.setBounds(30,210,300,30);
		l6.setForeground(Color.RED);
		l6.setFont(new Font("Tahoma",Font.BOLD,20));
		p1.add(l6);
		
		JLabel l7 = new JLabel(pack[6]);
		l7.setBounds(30,250,300,30);
		l7.setForeground(Color.GREEN);
		l7.setFont(new Font("Tahoma",Font.BOLD,20));
		p1.add(l7);
		
		JLabel l8 = new JLabel(pack[7]);
		l8.setBounds(30,290,300,30);
		l8.setForeground(Color.RED);
		l8.setFont(new Font("Tahoma",Font.BOLD,20));
		p1.add(l8);
		
		JLabel l9 = new JLabel(pack[8]);
		l9.setBounds(60,340,300,30);
		l9.setForeground(Color.BLACK);
		l9.setFont(new Font("Tahoma",Font.BOLD,25));
		p1.add(l9);
		
		JLabel l10 = new JLabel(pack[9]);
		l10.setBounds(80,380,300,30);
		l10.setForeground(Color.MAGENTA);
		l10.setFont(new Font("Tahoma",Font.BOLD,25));
		p1.add(l10);
		
		JLabel l11 = new JLabel(pack[10]);
		l11.setBounds(500,380,300,30);
		l11.setForeground(Color.CYAN);
		l11.setFont(new Font("Tahoma",Font.BOLD,25));
		p1.add(l11);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/"+pack[11]));
		Image i2 = i1.getImage().getScaledInstance(350, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l12 = new JLabel(i3);
		l12.setBounds(280,10,500,300);
		p1.add(l12);
		
		return p1;
	}
	
	public static void main(String[] args) {
		new CheckPackage();
	}
}
