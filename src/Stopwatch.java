import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class Stopwatch extends JFrame implements ActionListener {

	JButton startbtn, stopbtn, resetbtn, calendar, calculator;
	JLabel Hr, Min, Sec, Ms, moreapp;

	static int milliseconds = 0;
	static int seconds = 0;
	static int minutes = 0;
	static int hours = 0;

	static boolean state = true;
	
	Color color = new Color(206, 214, 224);
	Font font = new Font(Font.SANS_SERIF, Font.BOLD,15);
	
	Image icon = Toolkit.getDefaultToolkit().getImage("P:\\Java Projects\\Stopwatch\\img\\time.png");   
	
	public Stopwatch() {

		// Frame

		setTitle("Stopwatch Application");
		setBounds(100, 100, 470, 345);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setIconImage(icon);
		getContentPane().setLayout(null);

		// Buttons

		startbtn = new JButton("Start");
		startbtn.setBounds(52, 70, 80, 35);
		startbtn.setBackground(color);
		startbtn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
		startbtn.setFont(font);
		startbtn.setFocusable(false);
		startbtn.addActionListener(this);
		getContentPane().add(startbtn);

		stopbtn = new JButton("Stop");
		stopbtn.setBounds(142, 70, 80, 35);
		stopbtn.setBackground(color);
		stopbtn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
		stopbtn.setFont(font);
		stopbtn.setFocusable(false);
		stopbtn.addActionListener(this);
		getContentPane().add(stopbtn);

		resetbtn = new JButton("Restart");
		resetbtn.setBounds(232, 70, 171, 35);
		resetbtn.setBackground(color);
		resetbtn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
		resetbtn.setFont(font);
		resetbtn.setFocusable(false);
		resetbtn.addActionListener(this);
		getContentPane().add(resetbtn);

		ImageIcon cal = new ImageIcon("P:\\Java Projects\\Stopwatch\\img\\calendar.png");
		calendar = new JButton("Calendar", cal);
		calendar.setVerticalTextPosition(SwingConstants.BOTTOM);
		calendar.setHorizontalTextPosition(SwingConstants.CENTER);
		calendar.setForeground(Color.RED);
		calendar.setBackground(color);
		calendar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
		calendar.setFocusable(false);
		calendar.setBounds(110, 160, 110, 130);
		calendar.addActionListener(this);
		getContentPane().add(calendar);

		ImageIcon cul = new ImageIcon("P:\\Java Projects\\Stopwatch\\img\\calculator.png");
		calculator = new JButton("Calculator", cul);
		calculator.setVerticalTextPosition(SwingConstants.BOTTOM);
		calculator.setHorizontalTextPosition(SwingConstants.CENTER);
		calculator.setForeground(Color.BLACK);
		calculator.setBackground(color);
		calculator.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
		calculator.setFocusable(false);
		calculator.setBounds(240, 160, 110, 130);
		calculator.addActionListener(this);
		getContentPane().add(calculator);

		// Lables

		Hr = new JLabel("");
		Hr.setHorizontalAlignment(JLabel.CENTER);
		Hr.setBounds(50, 10, 84, 50);
		Hr.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK), "Hours"));
		Hr.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
		getContentPane().add(Hr);

		Min = new JLabel("");
		Min.setHorizontalAlignment(JLabel.CENTER);
		Min.setBounds(140, 10, 84, 50);
		Min.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK), "Min's"));
		Min.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
		getContentPane().add(Min);

		Sec = new JLabel("");
		Sec.setHorizontalAlignment(JLabel.CENTER);
		Sec.setBounds(230, 10, 100, 50);
		Sec.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK), "Sec's"));
		Sec.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
		getContentPane().add(Sec);

		Ms = new JLabel("00");
		Ms.setHorizontalAlignment(JLabel.CENTER);
		Ms.setBounds(330, 20, 75, 40);
		Ms.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK), "msec"));
		Ms.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(Ms);

		moreapp = new JLabel("<HTML><U>MORE APPLICATIONS</U></HTML>");
		moreapp.setBounds(140, 120, 190, 30);
		moreapp.setForeground(Color.RED);
		moreapp.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		moreapp.setHorizontalAlignment(JLabel.CENTER);
		getContentPane().add(moreapp);

	}

	// Main method

	public static void main(String[] args) {
		new Stopwatch().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		state = true;

		if (e.getSource() == startbtn) {
			Thread t = new Thread() {
				public void run() {
					for (;;) {
						if (state == true) {
							try {
								sleep(1);
								if (milliseconds > 1000) {
									milliseconds = 0;
									seconds++;
								}
								if (seconds > 60) {
									milliseconds = 0;
									seconds = 0;
									minutes++;
								}
								if (minutes > 60) {
									milliseconds = 0;
									seconds = 0;
									minutes = 0;
									hours++;
								}

								Ms.setText(milliseconds + " msec");

								milliseconds++;

								Sec.setText("" + seconds);
								Min.setText("" + minutes);
								Hr.setText("" + hours);

							} catch (Exception e) {

							}
						} else {
							break;
						}
					}
				}
			};
			t.start();
		}

		if (e.getSource() == stopbtn) {
			state = false;
		}

		if (e.getSource() == resetbtn) {
			state = false;

			hours = 0;
			minutes = 0;
			seconds = 0;
			milliseconds = 0;

			Hr.setText("0");
			Min.setText("0");
			Sec.setText("0");
			Ms.setText("0");
		}
		
		if (e.getSource()==calendar) {
			new Calendar().setVisible(true);
		}
		
		if (e.getSource()== calculator) {
			new Calculator().setVisible(true);
		}
		
	}

}
