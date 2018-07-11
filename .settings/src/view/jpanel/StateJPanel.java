package view.jpanel;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class StateJPanel extends JPanel{

	//*****************************Image*****************************
	ImageIcon extendIcon = new ImageIcon("image/state/state_company.png");
	ImageIcon educateIcon = new ImageIcon("image/state/state_edu.png");
	ImageIcon employIcon = new ImageIcon("image/state/state_employ.png");
	ImageIcon computerIcon = new ImageIcon("image/state/state_computer.png");
	ImageIcon keyboardIcon = new ImageIcon("image/state/state_keyboard.png");

	//*****************************JButton*****************************
	public JButton extendJButton = new JButton("회사 확장", extendIcon);
	public JButton educateJButton = new JButton("교육 이수", educateIcon);
	public JButton employJButton = new JButton("직원 고용", employIcon);
	public JButton computerJButton = new JButton("컴퓨터 사양", computerIcon);
	public JButton keyboardJButton = new JButton("타자수", keyboardIcon);

	//*****************************JBar*****************************
	public JProgressBar extendBar = new JProgressBar();
	public JProgressBar educateBar = new JProgressBar();
	public JProgressBar employBar = new JProgressBar();
	public JProgressBar computerBar = new JProgressBar();
	public JProgressBar keyboardBar = new JProgressBar();

	private BufferedImage statePanelImage;
	private BufferedImage stateTitleImage; //180710 state_title 이미지 추가
	//-------------------------------------------------------------------

	public StateJPanel(){

		//***************StateJPanel_180707_1​****************
		setLayout(null);
		setBounds(3, 210, 338, 385);
		setOpaque(false);
		//***************************************************

		//**********************이미지 객체화_180707_1*************************
		try {
			statePanelImage = ImageIO.read(new File("image/state/state_panel.png"));
			stateTitleImage = ImageIO.read(new File("image/state/state_title.png")); //180710 state_title 이미지 추가
		} catch (IOException e) {

			e.printStackTrace();
		}
		//******************************************************************	


		//****************각각의 JButton Setting_180707_1****************
		extendJButton.setBounds(210, 40, 140, 70); //180710 버튼 이동
		educateJButton.setBounds(210, 90, 140, 70);
		employJButton.setBounds(210, 140, 140, 70);
		computerJButton.setBounds(210, 190, 140, 70);
		keyboardJButton.setBounds(210, 240, 140, 70);

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
		//************************************************************


		//*****************각각의 JBar Setting_180707_1*****************
		extendBar.setLocation(15, 60);   //180710 위치 이동
		educateBar.setLocation(15, 110);
		employBar.setLocation(15, 160);
		computerBar.setLocation(15, 210);
		keyboardBar.setLocation(15, 260);

		extendBar.setSize(180, 35);   //180710 사이즈 변경
		educateBar.setSize(180, 35);
		employBar.setSize(180, 35);
		computerBar.setSize(180, 35);
		keyboardBar.setSize(180, 35);

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

		extendBar.setBorderPainted(false);
		educateBar.setBorderPainted(false);
		employBar.setBorderPainted(false);
		computerBar.setBorderPainted(false);
		keyboardBar.setBorderPainted(false);
		//************************************************************

		//*********************add this​_180707_1**********************
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

	//*********StateJPanel BackGround Image add_180707_1************
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(statePanelImage, -1, -1, null);
		g.drawImage(stateTitleImage, 225, 5, null);	//180710 state_title 이미지 추가

	}
	//---------------------------------------------------------
}
