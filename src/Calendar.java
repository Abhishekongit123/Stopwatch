import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

@SuppressWarnings("serial")
public class Calendar extends JFrame implements MouseListener {

	JPanel headerPanel;
	JTextField headtext = new JTextField("Calander");
	Font f1, f2;
	Font f3 = new Font(Font.MONOSPACED, Font.BOLD, 28);
	Font f4 = new Font("Garamond", Font.BOLD, 20);
	
	Date m,t;
	JLabel date, month, year, day, dt, mt, yt,hours,minute,second,ht,mmt,st;
	
	Color color1 = new Color(52, 73, 94);
	Color color2 = new Color(19, 15, 64);
	Color color3 = new Color(255, 107, 107);
	Color color4 = new Color(112, 161, 255);
	Color color5 = new Color(220, 221, 225);

	ImageIcon clock = new ImageIcon("P:\\Java Projects\\Stopwatch\\img\\alarm.png");
	JButton btn = new JButton("Clock", clock);

	JDialog time;
	
	Image icon = Toolkit.getDefaultToolkit().getImage("P:\\Java Projects\\Stopwatch\\img\\alarm.png");   
	Image icon1 = Toolkit.getDefaultToolkit().getImage("P:\\Java Projects\\Stopwatch\\img\\watch.png");

	public Calendar() {
		setTitle("Calendar & Clock");
		setBounds(200, 150, 550, 415);
		setResizable(false);
		setIconImage(icon);
		getContentPane().setBackground(color5);
		getContentPane().setLayout(null);

		f1 = new Font("Garamond", Font.BOLD, 50);
		headtext.setBounds(145, 10, 250, 50);
		headtext.setBackground(color2);
		headtext.setForeground(Color.WHITE);
		headtext.setHorizontalAlignment(JTextField.CENTER);
		headtext.setEditable(false);
		headtext.setBorder(null);
		headtext.setFont(f1);
		headerPanel = new JPanel();
		headerPanel.setBounds(0, 0, 550, 80);
		headerPanel.setBackground(color2);
		headerPanel.setLayout(null);
		headerPanel.add(headtext);
		add(headerPanel);

	    m = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("MMM");
		SimpleDateFormat sdf3 = new SimpleDateFormat("YYYY");
		

		date = new JLabel(sdf1.format(m));
		dt = new JLabel("DATE");
		f2 = new Font("Garamond", Font.BOLD, 25);
		date.setBounds(220, 82, 100, 100);
		date.setHorizontalAlignment(JLabel.CENTER);
		date.setForeground(Color.RED);
		date.setFont(f3);
		dt.setBounds(220, 82, 100, 30);
		dt.setFont(f2);
		dt.setHorizontalAlignment(JLabel.CENTER);

		month = new JLabel(sdf2.format(m));
		mt = new JLabel("MONTH");
		month.setBounds(205, 160, 130, 100);
		month.setHorizontalAlignment(JLabel.CENTER);
		month.setForeground(Color.RED);
		month.setFont(f3);
		mt.setBounds(213, 160, 120, 30);
		mt.setFont(f2);
		mt.setHorizontalAlignment(JLabel.CENTER);

		year = new JLabel(sdf3.format(m));
		yt = new JLabel("YEAR");
		year.setBounds(217, 235, 100, 100);
		year.setHorizontalAlignment(JLabel.CENTER);
		year.setForeground(Color.RED);
		year.setFont(f3);
		yt.setBounds(207, 235, 120, 30);
		yt.setFont(f2);
		yt.setHorizontalAlignment(JLabel.CENTER);

		add(date);
		add(dt);
		add(month);
		add(mt);
		add(year);
		add(yt);

		btn.setBounds(5, 310, 525, 60);
		btn.setBackground(color3);
		btn.setVerticalTextPosition(SwingConstants.BOTTOM);
		btn.setHorizontalTextPosition(SwingConstants.CENTER);
		btn.setFocusable(false);
		btn.setBorderPainted(false);
		btn.addMouseListener(this);
		add(btn);

		t = new Date();
		SimpleDateFormat sdf4 = new SimpleDateFormat("hh"); 
		SimpleDateFormat sdf5 = new SimpleDateFormat("mm"); 
		SimpleDateFormat sdf6 = new SimpleDateFormat("ss");
		SimpleDateFormat sdf7 = new SimpleDateFormat("aa");
		 
		
		hours = new JLabel("HOURE'S");
		hours.setBounds(40, 20, 92, 30);
		hours.setFont(f4);
		minute = new JLabel("MINUTE'S");
		minute.setBounds(145, 20, 102, 30);
		minute.setFont(f4);
		second = new JLabel("SECOND'S");
		second.setBounds(260, 20, 104, 30);
		second.setFont(f4);
		
		 ht = new JLabel(sdf4.format(t)); 
		 ht.setBounds(65,60,50,30); 
		 ht.setFont(f3);
		 ht.setForeground(Color.RED);
		 mmt = new JLabel(sdf5.format(t));
		 mmt.setBounds(180,60,50,30); 
		 mmt.setFont(f3); mmt.setForeground(Color.RED);
		 st = new JLabel(sdf6.format(t)+" "+sdf7.format(t));
		 st.setBounds(272,60,85,30); st.setFont(f3); 
		 st.setForeground(Color.RED);
		 
		time = new JDialog(this, "Clock", true);
		time.setLayout(null);
		time.setResizable(false);
		time.setIconImage(icon1);
		time.getContentPane().setBackground(color5);
		time.setBounds(400,250,420, 160);
		time.add(hours);
		time.add(minute);
		time.add(second);
		time.add(ht);
		time.add(mmt);
		time.add(st);
	}
	
	public void mouseClicked(MouseEvent e) {
		btn.setBackground(color4);
		time.setVisible(true);

	}
	
	public void mousePressed(MouseEvent e) {


	}
	
	public void mouseReleased(MouseEvent e) {

	}
	
	public void mouseEntered(MouseEvent e) {
		
	}
	
	public void mouseExited(MouseEvent e) {
		
	}
}
