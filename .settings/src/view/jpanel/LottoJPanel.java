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
import view.jbutton.storeMenuJButton.Lotto_CountLottoJButton;
import view.jlabel.Lotto_LottoJLabel;

public class LottoJPanel extends JPanel implements ActionListener{
	public YesJButton yesButton = new YesJButton(new ImageIcon("image/lotto/ans_YES.png"));
	public BackJButton backButton = new BackJButton(new ImageIcon("image/lotto/ans_BACK.png"));
	private LottoRegameJButton lottoRegame = new LottoRegameJButton(new ImageIcon("image/lotto/regame.png"));
	private JPanel yesOrNoJPanel;
	private BufferedImage lottoBackGroundImage;
	private BufferedImage lottoYesOrNoImage;
	private BufferedImage lottoSuccessImage;
	private BufferedImage lottoFailImage;
	private JPanel success;
	private JPanel fail;

	//로또패널에 아이템 개수 표시
	public static Lotto_LottoJLabel lotto_LottoJLabel = new Lotto_LottoJLabel();
		
			//로또 - 이미지용 버튼
	private Lotto_CountLottoJButton lotto_CountLottoJButton = new Lotto_CountLottoJButton(new ImageIcon("image/lotto/lotto_lottoCount.png"));
		
	public LottoJPanel(){

		this.setLayout(null);
		this.setBounds(0, 56, 350, 600);
		this.setBackground(new Color(255, 255, 255));

		//패널에 이미지 넣는 방법(try/catch/@override)
		try {
			lottoBackGroundImage = ImageIO.read(new File("image/lotto/lottoJPanel_2.png"));
			lottoYesOrNoImage = ImageIO.read(new File("image/lotto/lotto_confirm_2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			lottoSuccessImage = ImageIO.read(new File("image/lotto/lotto_success.png"));
			lottoFailImage = ImageIO.read(new File("image/lotto/lotto_fail.png"));
		} catch (IOException e1) {

			e1.printStackTrace();
		}
		
		success = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(lottoSuccessImage, 0, 5, null);
			}
		};

		fail = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(lottoFailImage, 0, 5, null);
			}
		};
		
		fail.setVisible(false);
		success.setVisible(false);
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
		//로또 템 이미지
				this.add(lotto_CountLottoJButton);
				
					//로또 아이템 개수 라벨
				this.add(lotto_LottoJLabel);
			
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
		View.cm().lottoStart(e, this, yesOrNoJPanel, lottoRegame, success, fail, lotto_CountLottoJButton);
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