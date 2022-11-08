import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Calculator extends JFrame implements ActionListener {
	JTextField textField,heading,percentcal,rootcal,modcal,perdata1,perdata2,rootdata,moddata1,moddata2,percentsolution,modsolution,rootsolution,checkperfectroot,degreedata,angleOp;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[10];
	JButton addButton, subButton, mulButton, divButton, decButton, eqlButton, delButton, clrButton, morefunButton,clear,calculate,clear1,calculate1,clear2,calculate2,moreoption,sin,cos,tan,sinh,cosh,tanh;
	JRadioButton on;
	JPanel panel, percentagePanel, rootPanel, moduloPanel;

	Image icon = Toolkit.getDefaultToolkit().getImage("P:\\Java Projects\\Stopwatch\\img\\calculatorIcon.png");
	
	//labal
	JLabel per,per1,per2,per3,root,root1,mod,mod1,mod2,ans,ans1,ans2,outlabel;
	
	//font
	Font font = new Font(Font.SANS_SERIF, Font.BOLD, 30);
	Font font1 = new Font(Font.SANS_SERIF, Font.BOLD, 20);
	Font font2 = new Font(Font.SERIF , Font.BOLD, 15);
	Font font3 = new Font(Font.SANS_SERIF, Font.BOLD,15);
	
	//colors
	Color color = new Color(206, 214, 224);
	Color color1 = new Color(220, 221, 225);
	Color color2 = new Color(194, 54, 22); // red color
	Color color3 = new Color(225, 177, 44); // yellow color
	Color color4 = new Color(68, 189, 50); // green color
	Color color5 = new Color(0, 151, 230); // sky blue
	Color color6 = new Color(192, 57, 43);//pomegranate
	Color color7 = new Color(247, 241, 227);// swan white
	Color color8 = new Color(199, 236, 238);// btn color

	double num1 = 0, num2 = 0, result = 0;
	char operator;

	public Calculator() {

		setTitle("Calculator");
		setBounds(450, 100, 420, 500);
		setResizable(false);
		setIconImage(icon);
		setBackground(color1);
		getContentPane().setLayout(null);

		textField = new JTextField(operator);
		textField.setBounds(10, 15, 384, 70);
		textField.setBackground(color1);
		textField.setEditable(false);
		textField.setFont(font);
		textField.setBorder(BorderFactory.createLoweredBevelBorder());
		textField.setHorizontalAlignment(JTextField.RIGHT);
		add(textField);
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("x");
		divButton = new JButton("/");
		decButton = new JButton(".");
		eqlButton = new JButton("=");
		delButton = new JButton("<-");
		clrButton = new JButton("C");
		clrButton.setBackground(Color.blue);
		morefunButton = new JButton("Fun");

		on = new JRadioButton("ON/OFF");
		on.setFocusable(false);
		on.setHorizontalAlignment(JRadioButton.CENTER);
		on.addActionListener(this);

		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = eqlButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = morefunButton;

		Color color = new Color(206, 214, 224);

		for (int i = 0; i < 9; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(font);
			functionButtons[i].setBackground(color);
			functionButtons[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
			functionButtons[i].setFocusable(false);
			if (functionButtons[i].getText() == "C") {
				clrButton.setBackground(color2);
				clrButton.setForeground(Color.WHITE);
			}
			if (functionButtons[i].getText() == "=") {
				eqlButton.setBackground(color4);
				eqlButton.setForeground(Color.WHITE);
			}
			if (functionButtons[i].getText() == "<-") {
				delButton.setBackground(color5);
				delButton.setForeground(Color.WHITE);
			}
			if (functionButtons[i].getText() == "+" || functionButtons[i].getText() == "-"
					|| functionButtons[i].getText() == "x" || functionButtons[i].getText() == "/"
					|| functionButtons[i].getText() == "Fun") {
				addButton.setBackground(color3);
				addButton.setForeground(Color.WHITE);

				subButton.setBackground(color3);
				subButton.setForeground(Color.WHITE);

				mulButton.setBackground(color3);
				mulButton.setForeground(Color.WHITE);

				divButton.setBackground(color3);
				divButton.setForeground(Color.WHITE);

				morefunButton.setBackground(color3);
				morefunButton.setForeground(Color.WHITE);

			}
		}

		for (int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(font);
			numberButtons[i].setBackground(color);
			numberButtons[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
			numberButtons[i].setFocusable(false);
		}

		panel = new JPanel();
		panel.setBounds(10, 110, 384, 330);
		panel.setLayout(new GridLayout(5, 4, 15, 15));
		add(panel);

		panel.add(on);
		panel.add(delButton);
		panel.add(clrButton);
		panel.add(addButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(subButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(mulButton);
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(divButton);
		panel.add(numberButtons[0]);
		panel.add(decButton);
		panel.add(eqlButton);
		panel.add(morefunButton);

	}

	public void actionPerformed(ActionEvent e) {

		for (int i = 0; i < 10; i++) {
			if (e.getSource() == numberButtons[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}

		if (e.getSource() == decButton) {
			textField.setText(textField.getText().concat("."));
		}

		if (e.getSource() == addButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '+';
			textField.setText("");
		}
		if (e.getSource() == subButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '-';
			textField.setText("");
		}
		if (e.getSource() == mulButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = 'x';
			textField.setText("");
		}
		if (e.getSource() == divButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '/';
			textField.setText("");
		}

		if (e.getSource() == eqlButton) {
			num2 = Double.parseDouble(textField.getText());

			switch (operator) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case 'x':
				result = num1 * num2;
				break;
			case '/':
				result = num1 / num2;
				break;
			}
			textField.setText(String.valueOf(result));
			num1 = result;
		}
		if (e.getSource() == clrButton) {
			textField.setText("");
		}
		if (e.getSource() == delButton) {
			String string = textField.getText();
			textField.setText("");
			for (int i = 0; i < string.length() - 1; i++) {
				textField.setText(textField.getText() + string.charAt(i));
			}
		}
		if (e.getSource() == morefunButton) {
			JDialog d = new JDialog();
			d.setBounds(10, 100, 1350, 500);
			d.setTitle("More Functions");
			d.setResizable(false);
			d.setVisible(true);
			
			heading = new JTextField();
			heading.setText("More Functions");
			heading.setBounds(0, 0, 1334, 49);
			heading.setBackground(color5);
			heading.setForeground(Color.WHITE);
			heading.setBorder(null);
			heading.setEditable(false);
			heading.setHorizontalAlignment(JTextField.CENTER);
			heading.setFont(font);
			d.add(heading);
			
			ImageIcon more = new ImageIcon("P:\\Java Projects\\Stopwatch\\img\\settings.png");
			moreoption = new JButton();
			moreoption.setBounds(1294, 6, 35, 35);
			moreoption.setFocusable(false);
			moreoption.setBorder(null);
			moreoption.addActionListener(this);
			moreoption.setBackground(color5);
			moreoption.setIcon(more);
			heading.add(moreoption);

			percentagePanel = new JPanel();
			percentagePanel.setBounds(10, 55, 430, 398);
			percentagePanel.setBackground(color7);
			d.add(percentagePanel);
			
			percentcal = new JTextField();
			percentcal.setBounds(0, 0, 430, 35);
			percentcal.setBackground(color6);
			percentcal.setForeground(Color.WHITE);
			percentcal.setHorizontalAlignment(JTextField.CENTER);
			percentcal.setFont(font1);
			percentcal.setBorder(null);
        	percentcal.setText("Percentage Calcuator");
			percentagePanel.add(percentcal);
			
			perdata1 = new JTextField();
			perdata1.setBounds(100, 80, 110, 30);
			perdata1.setHorizontalAlignment(JTextField.CENTER);
			perdata1.setFont(font2);
			perdata1.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
			percentagePanel.add(perdata1);
			
			perdata2 = new JTextField();
			perdata2.setBounds(260, 80, 110, 30);
			perdata2.setHorizontalAlignment(JTextField.CENTER);
			perdata2.setFont(font2);
			perdata2.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
			percentagePanel.add(perdata2);
			
			percentsolution = new JTextField("   ANSWER :");
			percentsolution.setBounds(7, 185, 415,46);
			percentsolution.setEditable(false);
			percentsolution.setLayout(null);
			percentsolution.setFont(font2);
			percentsolution.setBackground(Color.WHITE);
			percentsolution.setForeground(color4);
			percentsolution.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
			percentagePanel.add(percentsolution);
			
			ans1 = new JLabel();
			ans1.setBounds(75, 190, 295, 200);
			ans1.setText("<html><p style='font-size:10px;'>Equation: <p style='color:red;'>Y = P% * X</p><br>Converting percent to decimal:<br><p style='color:red;'>p = P%/100 = val</p></p></html>");
			percentagePanel.add(ans1);
			
			per = new JLabel("Y is P% of X");
			per.setBounds(200, 40, 100, 30);
			percentagePanel.add(per);
			
			per1 = new JLabel("What is");
			per1.setBounds(50, 80, 80, 30);
			percentagePanel.add(per1);
			
			per2 = new JLabel("% of");
			per2.setBounds(220, 80, 50, 30);
			percentagePanel.add(per2);
			
			per3 = new JLabel("?");
			per3.setBounds(372, 80, 20, 30);
			percentagePanel.add(per3);
			
			clear1 = new JButton("Clear");
			clear1.setBounds(20, 130, 80, 35);
			clear1.setBorder(BorderFactory.createLineBorder(Color.BLACK,1,true));
			clear1.setBackground(color);
			clear1.setFont(font3);
			clear1.setFocusable(false);
			clear1.addActionListener(this);
			percentagePanel.add(clear1);
			
			calculate1 = new JButton("Calculate");
			calculate1.setBounds(310, 130, 100, 35);
			calculate1.setBorder(BorderFactory.createLineBorder(Color.BLACK,1,true));
			calculate1.setBackground(color);
			calculate1.setFont(font3);
			calculate1.setFocusable(false);
			calculate1.addActionListener(this);
			percentagePanel.add(calculate1);
			
			//....................................................................................................................................
			
			rootPanel = new JPanel();
			rootPanel.setBounds(450, 55, 430, 398);
			rootPanel.setBackground(color7);
			d.add(rootPanel);
			
			rootcal = new JTextField();
			rootcal.setBounds(0, 0, 430, 35);
			rootcal.setBackground(color6);
			rootcal.setForeground(Color.WHITE);
			rootcal.setBorder(null);
			rootcal.setHorizontalAlignment(JTextField.CENTER);
			rootcal.setFont(font1);
        	rootcal.setText("Cube Roots Calcuator");
			rootPanel.add(rootcal);
			
			rootblock();

			moduloPanel = new JPanel();
		    moduloPanel.setBounds(890, 55, 430, 398);
		    moduloPanel.setBackground(color7);
			d.add(moduloPanel);
			
			modcal = new JTextField();
			modcal.setBounds(0, 0, 430, 35);
			modcal.setBackground(color6);
			modcal.setForeground(Color.WHITE);
			modcal.setBorder(null);
			modcal.setHorizontalAlignment(JTextField.CENTER);
			modcal.setFont(font1);
        	modcal.setText("Modulo Calcuator");
			moduloPanel.add(modcal);
			
			modblock();
		}
		if (on.isSelected()) {
			addButton.setEnabled(false);
			subButton.setEnabled(false);
			mulButton.setEnabled(false);
			divButton.setEnabled(false);
			decButton.setEnabled(false);
			eqlButton.setEnabled(false);
			delButton.setEnabled(false);
			clrButton.setEnabled(false);
			morefunButton.setEnabled(false);

			numberButtons[0].setEnabled(false);
			numberButtons[1].setEnabled(false);
			numberButtons[2].setEnabled(false);
			numberButtons[3].setEnabled(false);
			numberButtons[4].setEnabled(false);
			numberButtons[5].setEnabled(false);
			numberButtons[6].setEnabled(false);
			numberButtons[7].setEnabled(false);
			numberButtons[8].setEnabled(false);
			numberButtons[9].setEnabled(false);
		} else {
			addButton.setEnabled(true);
			subButton.setEnabled(true);
			mulButton.setEnabled(true);
			divButton.setEnabled(true);
			decButton.setEnabled(true);
			eqlButton.setEnabled(true);
			delButton.setEnabled(true);
			clrButton.setEnabled(true);
			morefunButton.setEnabled(true);

			numberButtons[0].setEnabled(true);
			numberButtons[1].setEnabled(true);
			numberButtons[2].setEnabled(true);
			numberButtons[3].setEnabled(true);
			numberButtons[4].setEnabled(true);
			numberButtons[5].setEnabled(true);
			numberButtons[6].setEnabled(true);
			numberButtons[7].setEnabled(true);
			numberButtons[8].setEnabled(true);
			numberButtons[9].setEnabled(true);
		}
		
		if (e.getSource()== calculate) {
			String s1= moddata1.getText();
			String s2= moddata2.getText();
			int a = Integer.parseInt(s1);
			int b = Integer.parseInt(s2);
			int rem = a%b;
			String val = "RESULT : Divide " + a +" by "+ b +" to find the remainder = "+rem;
			
			modsolution.setText(val);
			modsolution.setBounds(7, 225, 415, 46);
			modsolution.setEditable(false);
			modsolution.setBackground(Color.WHITE);
			modsolution.setHorizontalAlignment(JTextField.CENTER);
			modsolution.setForeground(color4);
			modsolution.setFont(font2);
			modsolution.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
			moduloPanel.add(modsolution);
		}
		
		if (e.getSource()== clear) {
			modsolution.setBounds(7, 225, 415, 46);
			moddata1.setText("");
			moddata2.setText("");
			modsolution.setText("");
		}
		
		if (e.getSource() == calculate1) {
			String s3= perdata1.getText();
			String s4= perdata2.getText();
			int a = Integer.parseInt(s3);
			int b = Integer.parseInt(s4);
			Double val =(double)b/100*a;
			String op = "RESULT : "+val+" is "+a+"%  of "+b ;
			
			percentsolution.setText(op);
			percentsolution.setBounds(7, 185, 415,46);
			percentsolution.setEditable(false);
			percentsolution.setLayout(null);
			percentsolution.setBackground(Color.WHITE);
			percentsolution.setHorizontalAlignment(JTextField.CENTER);
			percentsolution.setForeground(color4);
			percentsolution.setFont(font2);
			percentsolution.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
			percentagePanel.add(percentsolution);
		}
		
		if (e.getSource()== clear1) {
			percentsolution.setBounds(15, 185, 415, 46);
			perdata1.setText("");
			perdata2.setText("");
			percentsolution.setText("");
		}
		
		if (e.getSource() == calculate2) {
			rootsolution.setBounds(15, 180, 415, 45);
			String s5= rootdata.getText();
			double j = Integer.parseInt(s5);
			double result = Math.cbrt(j);
			
			String op1 = "RESULT : "+result;
			rootsolution.setBounds(7, 185, 415, 46);
			rootsolution.setEditable(false);
			rootsolution.setBackground(Color.WHITE);
			rootsolution.setText(op1);
			rootsolution.setForeground(color4);
			rootsolution.setFont(font2);
			rootsolution.setHorizontalAlignment(JTextField.CENTER);
			rootsolution.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
			rootPanel.add(rootsolution);
			
			String cc = result*result*result == j ? j+" is a perfect cube":j+" is not a perfect cube";
			
			checkperfectroot.setBounds(150, 233, 200, 30);
			checkperfectroot.setText(cc);
			checkperfectroot.setEditable(false);
			checkperfectroot.setBorder(null);
			checkperfectroot.setBackground(color7);
			checkperfectroot.setForeground(Color.RED);
			checkperfectroot.setFont(font2);
			rootPanel.add(checkperfectroot);
			
		}
		
		if (e.getSource()== clear2) {
			rootdata.setText("");
			rootsolution.setBounds(15, 180, 415, 45);
			rootsolution.setText("");
			checkperfectroot.setText("");
		}
		
		if (e.getSource() == moreoption) {
			JDialog d1 = new JDialog();
			d1.setBounds(410, 200, 500, 275);
			d1.setTitle("Trigonometric Calculator");
			d1.setResizable(false);
			d1.setVisible(true);
			
			ans2 = new JLabel("Enter the value of angle (In Degree)");
			ans2.setBounds(55, 15, 390, 30);
			ans2.setFont(new Font(Font.SERIF, Font.BOLD, 25));
			ans2.setForeground(color2);
			d1.add(ans2);
			
			degreedata = new JTextField();
			degreedata.setBounds(100, 55, 300, 30);
			degreedata.setHorizontalAlignment(JTextField.CENTER);
			degreedata.setFont(font2);
			degreedata.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
			degreedata.setBackground(color7);
			d1.add(degreedata);
			
			outlabel = new JLabel("Output will be");
			outlabel.setBounds(175,90, 155, 30);
			outlabel.setFont(new Font(Font.SERIF, Font.BOLD, 25));
			outlabel.setForeground(color2);
			d1.add(outlabel);
			
			angleOp = new JTextField("   ANSWER:");
			angleOp.setBounds(100,132 ,300,30);
			angleOp.setFont(font2);
			angleOp.setEditable(false);
			angleOp.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
			angleOp.setBackground(color7);
			angleOp.setForeground(color4);
			d1.add(angleOp);
			
     		sin = new JButton("sin");
			sin.setBounds(55, 180, 55, 30);
			sin.setBackground(color8);
			sin.addActionListener(this);
			sin.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
			sin.setFocusable(false);
     		d1.add(sin);
			
			cos = new JButton("cos");
			cos.setBounds(115, 180, 55, 30);
			cos.setBackground(color8);
			cos.addActionListener(this);
			cos.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
			cos.setFocusable(false);
			d1.add(cos);
			
			tan = new JButton("tan");
			tan.setBounds(175, 180, 55, 30);
			tan.setBackground(color8);
			tan.addActionListener(this);
			tan.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
			tan.setFocusable(false);
			d1.add(tan);
		
			sinh = new JButton("sinh");
			sinh.setBounds(235, 180, 60, 30);
			sinh.setBackground(color8);
			sinh.addActionListener(this);
			sinh.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
			sinh.setFocusable(false);
			d1.add(sinh);
			
			cosh = new JButton("cosh");
			cosh.setBounds(300, 180, 62, 30);
			cosh.setBackground(color8);
			cosh.addActionListener(this);
			cosh.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
			cosh.setFocusable(false);
			d1.add(cosh);
			
			tanh = new JButton("tanh");
			tanh.setBounds(367, 180, 62, 30);
			tanh.setBackground(color8);
			tanh.addActionListener(this);
			tanh.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
			tanh.setFocusable(false);
			d1.add(tanh);
			
		}
		
		if (e.getSource() == sin) {
			String sangle = degreedata.getText();
			double angint = Integer.parseInt(sangle);
			double  angint1 = Math.toRadians(angint);
			double printString = Math.sin(angint1);
			String angle ="Result: "+printString;
			angleOp.setHorizontalAlignment(JTextField.CENTER);
			angleOp.setText(angle);
		}
		
		if (e.getSource() == cos) {
			String sangle = degreedata.getText();
			double angint = Integer.parseInt(sangle);
			double  angint1 = Math.toRadians(angint);
			double printString1 = Math.cos(angint1);
			String angle1 ="Result: "+printString1;
			angleOp.setHorizontalAlignment(JTextField.CENTER);
			angleOp.setText(angle1);
		}
		
		if (e.getSource() == tan) {
			String sangle = degreedata.getText();
			double angint = Integer.parseInt(sangle);
			double  angint1 = Math.toRadians(angint);
			double printString2 = Math.tan(angint1);
			String angle2 ="Result: "+printString2;
			angleOp.setHorizontalAlignment(JTextField.CENTER);
			angleOp.setText(angle2);
		}
		
		if (e.getSource() == sinh) {
			String sangle = degreedata.getText();
			double angint = Integer.parseInt(sangle);
			double  angint1 = Math.toRadians(angint);
			double printString3 = Math.sinh(angint1);
			String angle3 ="Result: "+printString3;
			angleOp.setHorizontalAlignment(JTextField.CENTER);
			angleOp.setText(angle3);
		}
		
		if (e.getSource() == cosh) {
			String sangle = degreedata.getText();
			double angint = Integer.parseInt(sangle);
			double  angint1 = Math.toRadians(angint);
			double printString4 = Math.cosh(angint1);
			String angle4 ="Result: "+printString4;
			angleOp.setHorizontalAlignment(JTextField.CENTER);
			angleOp.setText(angle4);
		}
		
		if (e.getSource() == tanh) {
			String sangle = degreedata.getText();
			double angint = Integer.parseInt(sangle);
			double  angint1 = Math.toRadians(angint);
			double printString5 = Math.tanh(angint1);
			String angle5 ="Result: "+printString5;
			angleOp.setHorizontalAlignment(JTextField.CENTER);
			angleOp.setText(angle5);
		}

	}

	private void rootblock() {
		
		rootdata = new JTextField();
		rootdata.setBounds(95, 80, 260, 25);
		rootdata.setHorizontalAlignment(JTextField.CENTER);
		rootdata.setFont(font2);
		rootdata.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		rootPanel.add(rootdata);
		
		rootsolution = new JTextField("   ANSWER :");
		rootsolution.setBounds(7, 185, 415, 46);
		rootsolution.setEditable(false);
		rootsolution.setBackground(Color.WHITE);
	    rootsolution.setForeground(color4);
	    rootsolution.setFont(font2);
		rootsolution.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		rootPanel.add(rootsolution);
		
		checkperfectroot = new JTextField();
		checkperfectroot.setBounds(150, 233, 200, 30);
		checkperfectroot.setEditable(false);
		checkperfectroot.setBorder(null);
		checkperfectroot.setBackground(color7);
		checkperfectroot.setForeground(Color.RED);
		checkperfectroot.setFont(font2);
		rootPanel.add(checkperfectroot);
		
		ans1 = new JLabel("<html><p style='font-size:10px;'>Perfect Cube Formula :<br><br>p = y<sup>3<sup><br><br><p style='color:red;'>Where,<br>p = perfect cube<br>y = cube root of X</p></html>");
		ans1.setBounds(75, 175, 295, 305);
		rootPanel.add(ans1); 
		
		root = new JLabel("3√X=?");
		root.setBounds(200, 40, 120, 30);
		rootPanel.add(root);
		
		root1 = new JLabel("X = ");
		root1.setBounds(70, 78, 25, 30);
		rootPanel.add(root1);
		
		clear2 = new JButton("Clear");
		clear2.setBounds(20, 130, 80, 35);
		clear2.setBorder(BorderFactory.createLineBorder(Color.BLACK,1,true));
		clear2.setBackground(color);
		clear2.setFont(font3);
		clear2.setFocusable(false);
		clear2.addActionListener(this);
		rootPanel.add(clear2);
		
		
		calculate2 = new JButton("Calculate");
		calculate2.setBounds(310, 130, 100, 35);
		calculate2.setBorder(BorderFactory.createLineBorder(Color.BLACK,1,true));
		calculate2.setBackground(color);
		calculate2.setFont(font3);
		calculate2.setFocusable(false);
		calculate2.addActionListener(this);
		rootPanel.add(calculate2);
		
	}

	private void modblock() {
		
		moddata1 = new JTextField();
		moddata1.setBounds(95, 80, 260, 25);
		moddata1.setHorizontalAlignment(JTextField.CENTER);
		moddata1.setFont(font2);
		moddata1.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		moduloPanel.add(moddata1);
		
		moddata2 = new JTextField();
		moddata2.setBounds(95, 120, 260, 25);
		moddata2.setHorizontalAlignment(JTextField.CENTER);
		moddata2.setFont(font2);
		moddata2.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		moduloPanel.add(moddata2);
		
		modsolution = new JTextField("   ANSWER :");
		modsolution.setBounds(7, 225, 415, 46);
		modsolution.setEditable(false);
		modsolution.setBackground(Color.WHITE);
		modsolution.setForeground(color4);
		modsolution.setFont(font2);
		modsolution.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		moduloPanel.add(modsolution);
		
		ans = new JLabel("<html><p style='font-size:10px;'> Divide a by  b  to find the remainder remainder.<br><br>---Confirm the answer satisfies the equation:---<br><br><p style='color:red;'>-------Quotient x Divisor + Remainder = Dividend-------</p></html>");
		ans.setBounds(75, 175, 295, 300);
		moduloPanel.add(ans);
		
		mod = new JLabel("a mod b = ?");
		mod.setBounds(190, 40, 100, 30);
		moduloPanel.add(mod);
		
		mod1 = new JLabel("a = ");
		mod1.setBounds(70, 78, 20, 30);
		moduloPanel.add(mod1);
		
		mod2 = new JLabel("b = ");
		mod2.setBounds(70, 118, 20, 30);
		moduloPanel.add(mod2);
		
		clear = new JButton("Clear");
		clear.setBounds(20, 170, 80, 35);
		clear.setBorder(BorderFactory.createLineBorder(Color.BLACK,1,true));
		clear.setBackground(color);
		clear.setFont(font3);
		clear.setFocusable(false);
		clear.addActionListener(this);
		moduloPanel.add(clear);
		
		
		calculate = new JButton("Calculate");
		calculate.setBounds(310, 170, 100, 35);
		calculate.setBorder(BorderFactory.createLineBorder(Color.BLACK,1,true));
		calculate.setBackground(color);
		calculate.setFont(font3);
		calculate.setFocusable(false);
		calculate.addActionListener(this);
		moduloPanel.add(calculate);
		
	}

}
