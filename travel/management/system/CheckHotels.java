package travel.management.system;

import java.awt.*;
import javax.swing.*;

public class CheckHotels extends JFrame implements Runnable {

    Thread t1;
    JLabel[] label = new JLabel[10];
    JLabel caption;
    
    public void run() {
    	
    	String[] text = new String[] {"JW Marriott Hotel","Mandarin Oriental Hotel","Four Seasons Hotel","Radisson Hotel","Classio Hotel","The Bay Club Hotel","Breeze Blows Hotel","Quick Stop Hotel","Happy Mornings Motel","Moss View Hotel"};
    	
        try {
            for (int i = 0; i < 10; i++) {
                label[i].setVisible(true); // Show the current label
                caption.setText(text[i]);
                Thread.sleep(2500); // Pause for 2.5 seconds
                if (i < 9) {
                    label[i].setVisible(false); // Hide the current label, except the last one
                }
            }
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    CheckHotels() {

        setBounds(450, 150, 750, 500);
        
        caption = new JLabel();
        caption.setBounds(50,400,600,50);
        caption.setFont(new Font("Tahoma",Font.PLAIN,40));
        caption.setForeground(Color.WHITE);
        add(caption);

        ImageIcon[] iimage = new ImageIcon[10];
        Image[] jimage = new Image[10];
        ImageIcon[] kimage = new ImageIcon[10];

        for (int i = 0; i < 10; i++) {
            iimage[i] = new ImageIcon(ClassLoader.getSystemResource("icons/hotel" + (i + 1) + ".jpg"));
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
        new CheckHotels();
    }
}
