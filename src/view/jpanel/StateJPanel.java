package view.jpanel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;

import model.vo.State;
import view.View;

public class StateJPanel extends JPanel implements ActionListener{
	private State state;
	
//	private JButton extendJButton = new JButton(new ImageIcon("abc.PNG"));
	//****************JButton****************
	private JButton extendJButton = new JButton("회사 확장");
	private JButton educateJButton = new JButton("교육 이수");
	private JButton employJButton = new JButton("직원 고용");
	private JButton computerJbutton = new JButton("컴퓨터 사양");
	private JButton keyboardJButton = new JButton("타자수");
	
	//****************JBar****************
	private JProgressBar extendBar = new JProgressBar();
	private JProgressBar educateBar = new JProgressBar();
	private JProgressBar employBar = new JProgressBar();
	private JProgressBar computerBar = new JProgressBar();
	private JProgressBar keyboardBar = new JProgressBar();
	
	public StateJPanel(){
		setLayout(null);
		setBounds(3, 300, 338, 268);
		setBackground(new Color(100, 100, 100));
		
		//****************JButton****************
		extendJButton.setBounds(220, 10, 110, 30);		
		educateJButton.setBounds(220, 55, 110, 30);
		employJButton.setBounds(220, 100, 110, 30);
		computerJbutton.setBounds(220, 145, 110, 30);
		keyboardJButton.setBounds(220, 190, 110, 30);
		
		extendJButton.addActionListener(this);
		educateJButton.addActionListener(this);
		employJButton.addActionListener(this);
		computerJbutton.addActionListener(this);
		keyboardJButton.addActionListener(this);
		
		this.add(extendJButton);
		this.add(educateJButton);
		this.add(employJButton);
		this.add(computerJbutton);
		this.add(keyboardJButton);
		
		extendJButton.setFocusable(false);
		educateJButton.setFocusable(false);
		employJButton.setFocusable(false);
		computerJbutton.setFocusable(false);
		keyboardJButton.setFocusable(false);
		
		//****************bar****************
		extendBar.setLocation(10, 10);
		educateBar.setLocation(10 ,55);
		employBar.setLocation(10, 100);
		computerBar.setLocation(10, 145);
		keyboardBar.setLocation(10, 190);
		
		extendBar.setSize(200, 30);
		educateBar.setSize(200, 30);
		employBar.setSize(200, 30);
		computerBar.setSize(200, 30);
		keyboardBar.setSize(200, 30);
		
		extendBar.setStringPainted(true);
		educateBar.setStringPainted(true);
		employBar.setStringPainted(true);
		computerBar.setStringPainted(true);
		keyboardBar.setStringPainted(true);
		
//		extendBar.setString(Byte.toString(state.getP_lvOfExtend()) + "/" + 10);
//		educateBar.setString(Byte.toString(state.getP_lvOfEducate()) + "/" + Integer.toString(10));
//		employBar.setString(Byte.toString(state.getP_lvOfEmploy()) + "/" + Integer.toString(10));
//		computerBar.setString(Byte.toString(state.getP_lvOfComputer()) + "/" + Integer.toString(10));
//		keyboardBar.setString(Byte.toString(state.getP_lvOfKeyboard()) + "/" + Integer.toString(10));
		
		this.add(extendBar);
		this.add(educateBar);
		this.add(employBar);
		this.add(computerBar);
		this.add(keyboardBar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		View.cm().stateChoice(e);
		
	}
}