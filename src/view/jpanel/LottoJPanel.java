package view.jpanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import view.View;
import view.jbutton.BackJButton;
import view.jbutton.LottoRegameJButton;
import view.jbutton.YesJButton;

public class LottoJPanel extends JPanel implements ActionListener{
	public YesJButton yesButton = new YesJButton(new ImageIcon("image/lotto/ans_YES.png"));; 
	public BackJButton backButton = new BackJButton(new ImageIcon("image/lotto/ans_BACK.png"));
	private LottoRegameJButton lottoRegame = new LottoRegameJButton(new ImageIcon("image/lotto/regame.png"));
	private JPanel yesOrNoJPanel;
	private BufferedImage lottoBackGroundImage;
	private BufferedImage lottoYesOrNoImage;

	public LottoJPanel(){

		this.setLayout(null);
		this.setBounds(0, 50, 350, 600);
		this.setBackground(new Color(255, 255, 255));

		//패널에 이미지 넣는 방법(try/catch/@override)
		try {
			lottoBackGroundImage = ImageIO.read(new File("image/lotto/lottoJPanel_2.png"));
			lottoYesOrNoImage = ImageIO.read(new File("image/lotto/lotto_confirm_2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//*************************************

		//******로또 regame버튼*************
		this.add(lottoRegame);
		//*************************************

		//*********yesOrNoPanel추가************
		yesOrNoJPanel = new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(lottoYesOrNoImage, 0, 5, null); 
			}
		};

		yesOrNoJPanel.setLayout(null);
		yesOrNoJPanel.setBounds(35, 320, 290, 180);
		//판넬 배경 투명으로 설정
		yesOrNoJPanel.setOpaque(false);
		this.add(yesOrNoJPanel);
		//*************************************

		//*******yes no 버튼 추가 **********

		yesOrNoJPanel.add(yesButton);
		yesOrNoJPanel.add(backButton);

		backButton.setLocation(143, 100);
		backButton.setSize(110,30);
		yesOrNoJPanel.add(backButton);

		//this가 현재 클래스
		//button에 버튼 액션을 추가함
		lottoRegame.addActionListener(this);
		yesButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		View.cm().lottoStart(e, this, yesOrNoJPanel, lottoRegame);
	}

	//패널에 이미지 넣는방법
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(lottoBackGroundImage, 0, -93, null);

	}

	public JButton getYesButton() {
		return yesButton;
	}

}