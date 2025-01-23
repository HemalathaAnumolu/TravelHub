package travel.management.system;

import java.awt.*;
import javax.swing.*;

public class Destinations extends JFrame implements Runnable  {
	Thread t1;
    JLabel[] label = new JLabel[10];
    JLabel caption;
    
    public void run() {
    	
        try {
            for (int i = 0; i < 9; i++) {
                label[i].setVisible(true); 
                Thread.sleep(2500);
                if (i < 9) {
                    label[i].setVisible(false);
                }
            }
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Destinations() {

        setBounds(450, 150, 750, 500);

        ImageIcon[] iimage = new ImageIcon[10];
        Image[] jimage = new Image[10];
        ImageIcon[] kimage = new ImageIcon[10];

        for (int i = 0; i < 9; i++) {
            iimage[i] = new ImageIcon(ClassLoader.getSystemResource("icons/dest" + (i + 1) + ".jpg"));
            jimage[i] = iimage[i].getImage().getScaledInstance(750, 500, Image.SCALE_DEFAULT);
            kimage[i] = new ImageIcon(jimage[i]);
            label[i] = new JLabel(kimage[i]);
            label[i].setBounds(0, 0, 750, 500);
            label[i].setVisible(false);
            add(label[i]);
        }

        label[0].setVisible(true);

        t1 = new Thread(this);
        t1.start();

        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Destinations();
    }
}
