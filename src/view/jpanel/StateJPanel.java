package view.jpanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.View;

public class StateJPanel extends JPanel implements ActionListener{
	
	//******JPanel, JProgressBar, Image 등 객체 생성 및 변수 선언_180707_1*******
	private JButton extendJButton = new JButton(new ImageIcon("image/state/state_company.png"));
	private JButton educateJButton = new JButton(new ImageIcon("image/state/state_edu.png"));
	private JButton employJButton = new JButton(new ImageIcon("image/state/state_employ.png"));
	private JButton computerJButton = new JButton(new ImageIcon("image/state/state_computer.png"));
	private JButton keyboardJButton = new JButton(new ImageIcon("image/state/state_keyboard.png"));

	private JProgressBar extendBar = new JProgressBar();
	private JProgressBar educateBar = new JProgressBar();
	private JProgressBar employBar = new JProgressBar();
	private JProgressBar computerBar = new JProgressBar();
	private JProgressBar keyboardBar = new JProgressBar();

	private BufferedImage statePanelImage;
	//-------------------------------------------------------------------

	public StateJPanel(){
		
		//***************StateJPanel_180707_1​****************
		setLayout(null);
		setBounds(2, 205, 340, 385);
		//----------------------------------------------------

		//**********************이미지 객체화_180707_1*************************
		try {
			statePanelImage = ImageIO.read(new File("image/state/state_panel.png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
		//------------------------------------------------------------------

		//****************각각의 JButton Setting_180707_1****************
		extendJButton.setBounds(190, 55, 140, 70);      
		educateJButton.setBounds(190, 115, 140, 70);
		employJButton.setBounds(190, 175, 140, 70);
		computerJButton.setBounds(190, 235, 140, 70);
		keyboardJButton.setBounds(190, 295, 140, 70);

		extendJButton.addActionListener(this);
		educateJButton.addActionListener(this);
		employJButton.addActionListener(this);
		computerJButton.addActionListener(this);
		keyboardJButton.addActionListener(this);

		extendJButton.setOpaque(false);
		educateJButton.setOpaque(false);
		employJButton.setOpaque(false);
		computerJButton.setOpaque(false);
		keyboardJButton.setOpaque(false);

		extendJButton.setBorderPainted(false);
		educateJButton.setBorderPainted(false);
		employJButton.setBorderPainted(false);
		computerJButton.setBorderPainted(false);
		keyboardJButton.setBorderPainted(false);

		extendJButton.setContentAreaFilled(false);
		educateJButton.setContentAreaFilled(false);
		employJButton.setContentAreaFilled(false);
		computerJButton.setContentAreaFilled(false);
		keyboardJButton.setContentAreaFilled(false);

		extendJButton.setFocusPainted(false);
		educateJButton.setFocusPainted(false);
		employJButton.setFocusPainted(false);
		computerJButton.setFocusPainted(false);
		keyboardJButton.setFocusPainted(false);

		extendJButton.setFocusable(false);
		educateJButton.setFocusable(false);
		employJButton.setFocusable(false);
		computerJButton.setFocusable(false);
		keyboardJButton.setFocusable(false);
		//------------------------------------------------------------
		
		//*****************각각의 JBar Setting_180707_1*****************
		extendBar.setLocation(10, 70);
		educateBar.setLocation(10 ,130);
		employBar.setLocation(10, 190);
		computerBar.setLocation(10, 250);
		keyboardBar.setLocation(10, 310);

		extendBar.setSize(160, 40);
		educateBar.setSize(160, 40);
		employBar.setSize(160, 40);
		computerBar.setSize(160, 40);
		keyboardBar.setSize(160, 40);

		extendBar.setStringPainted(true);
		educateBar.setStringPainted(true);
		employBar.setStringPainted(true);
		computerBar.setStringPainted(true);
		keyboardBar.setStringPainted(true);

		extendBar.setFont((new Font("맑은 고딕", Font.BOLD, 20)));
		educateBar.setFont((new Font("맑은 고딕", Font.BOLD, 20)));
		employBar.setFont((new Font("맑은 고딕", Font.BOLD, 20)));
		computerBar.setFont((new Font("맑은 고딕", Font.BOLD, 20)));
		keyboardBar.setFont((new Font("맑은 고딕", Font.BOLD, 20)));

		extendBar.setMaximum(10);
		educateBar.setMaximum(10);
		employBar.setMaximum(10);
		computerBar.setMaximum(10);
		keyboardBar.setMaximum(10);

		extendBar.setValue(1);
		educateBar.setValue(1);
		employBar.setValue(1);
		computerBar.setValue(1);
		keyboardBar.setValue(1);

		extendBar.setString(1 + "/" + extendBar.getMaximum());
		educateBar.setString(1 + "/" + educateBar.getMaximum());
		employBar.setString(1 + "/" + employBar.getMaximum());
		computerBar.setString(1 + "/" + computerBar.getMaximum());
		keyboardBar.setString(1 + "/" + keyboardBar.getMaximum());
		//------------------------------------------------------------
		
		//***********add this​_180707_1************
		this.add(extendJButton);
		this.add(educateJButton);
		this.add(employJButton);
		this.add(computerJButton);
		this.add(keyboardJButton);
		
		this.add(extendBar);
		this.add(educateBar);
		this.add(employBar);
		this.add(computerBar);
		this.add(keyboardBar);
		//-----------------------------------------
	}
	
	//*********JButton 등의 이벤트 발생 시작 메소드_180707_1************
	@Override
	public void actionPerformed(ActionEvent e) {
		View.cm().stateChoice(e, extendBar, educateBar, employBar, computerBar, keyboardBar, educateJButton);

	}
	//---------------------------------------------------------
	
	//*********StateJPanel BackGround Image add_180707_1************
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(statePanelImage, -1, 1, null);

	}
	//---------------------------------------------------------
}