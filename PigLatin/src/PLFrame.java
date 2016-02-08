import javax.swing.*;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;


public class PLFrame extends JFrame implements ActionListener
{
	private Font font = new Font("Arial", Font.BOLD, 24);
	
	private JTextField inputField;
	private JTextField outputField;
	
	private JButton isVowelButton;
	private JButton vowelButton;
	private JButton consonantButton;
	private JButton quButton;
	private JButton translationButton;
	
	private ImageIcon pigIcon, pigIcon2, pigIcon3;
	
	public static void main(String[] args) 
	{
		PLFrame frame = new PLFrame();
		frame.setResizable(false);
		frame.setTitle("Pig Latin Converter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.init();
		frame.setVisible(true);
		frame.pack();
	}
	
	public void init() 
	{
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		JPanel north = new JPanel(new GridLayout(2, 1));
		inputField = new JTextField("fahrenbacher");
		inputField.setFont(font);
		outputField = new JTextField();
		outputField.setEditable(false);
		outputField.setFont(font);
		north.add(inputField);
		north.add(outputField);
		
		c.add(north, BorderLayout.NORTH);
		
		try {
			pigIcon = new ImageIcon(new URL("http://www.freeiconsweb.com/Icons-show/angrybirds_pig_adium/ALERT_00.png"));
			pigIcon2 = new ImageIcon(new URL("http://www.freeiconsweb.com/Icons-show/angrybirds_pig_adium/INVISIBLE.png"));
			pigIcon3 = new ImageIcon(new URL("http://www.freeiconsweb.com/Icons-show/angrybirds_pig_adium/CONNECTING_06.png"));

		}
		catch(Exception e) {
			e.printStackTrace();
		}

		
		JPanel south = new JPanel();
		south.setPreferredSize(new Dimension(900, 300));
		isVowelButton = new JButton("Vowel?", pigIcon);
		isVowelButton.setFont(font);
		south.add(isVowelButton);
		isVowelButton.addActionListener(this);
		vowelButton = new JButton("Vowel Rule", pigIcon2);
		vowelButton.setFont(font);
		south.add(vowelButton);
		vowelButton.addActionListener(this);
		quButton = new JButton("QU Rule", pigIcon3);
		quButton.setFont(font);
		south.add(quButton);
		quButton.addActionListener(this);
		consonantButton = new JButton("Consonant Rule", pigIcon);
		consonantButton.setFont(font);
		south.add(consonantButton);
		consonantButton.addActionListener(this);
		translationButton = new JButton("Translate", pigIcon2);
		translationButton.setFont(font);
		south.add(translationButton);
		translationButton.addActionListener(this);
		
		c.add(south, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent event) {

		Object source = event.getSource();
		String input = inputField.getText();
		
		//Easter "Eggs" - LOL
		if(input.equals("bird")) {
			try
			{
				Applet.newAudioClip(new URL("https://sites.google.com/a/d219.org/fahrenbacher-com/ap-computer-science-12-13/objected-oriented-programming---part-i/bird.wav?attredirects=0&d=1")).play();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(input.equals("pig")) {
			try
			{
				Applet.newAudioClip(new URL("https://sites.google.com/a/d219.org/fahrenbacher-com/ap-computer-science-12-13/objected-oriented-programming---part-i/pig.wav?attredirects=0&d=1")).play();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(source == isVowelButton) {
			outputField.setText(PLProcessor.isVowel(input) + "");
		}
		else if(source == vowelButton) {
			outputField.setText(PLProcessor.vowelRule(input));
		}
		else if(source == consonantButton) {
			outputField.setText(PLProcessor.consonantRule(input));
		}
		else if(source == quButton) {
			outputField.setText(PLProcessor.quRule(input));
		}
		else if(source == translationButton) {
			outputField.setText(PLProcessor.fullTranslation(input));
		}
		
	}

}
