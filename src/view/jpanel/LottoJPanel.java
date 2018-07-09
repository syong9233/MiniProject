package view.jpanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import view.jbutton.BackJButton;
import view.jbutton.LottoRegameJButton;
import view.jbutton.YesJButton;

import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import javax.imageio.ImageIO;

import view.View;

public class LottoJPanel extends JPanel implements ActionListener{
	
	//***********JPanel, JButton, Image 등 객체 생성 및 변수 선언_180707_1************
	public YesJButton yesButton = new YesJButton(new ImageIcon("image/lotto/ans_YES.png"));; 
	public BackJButton backButton = new BackJButton(new ImageIcon("image/lotto/ans_BACK.png"));
	private LottoRegameJButton lottoRegame = new LottoRegameJButton(new ImageIcon("image/lotto/regame.png"));
	private JPanel yesOrNoJPanel;
	private BufferedImage lottoBackGroundImage;
	private BufferedImage lottoYesOrNoImage;
	//------------------------------------------------------------------------
	
	public LottoJPanel(){
		//***************LottoJPanel_180707_1​****************
		setLayout(null);
		setBounds(0, 50, 350, 600);
		setBackground(new Color(255, 255, 255));
		//------------------------------------------------------

		//**********************이미지 객체화_180707_1*************************
		try {
			lottoBackGroundImage = ImageIO.read(new File("image/lotto/lottoJPanel_2.png"));
			lottoYesOrNoImage = ImageIO.read(new File("image/lotto/lotto_confirm_2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//------------------------------------------------------------------

		//*************LoTTo ReGame JButton_180707_1*************
		lottoRegame.setVisible(false);
		//-------------------------------------------------------

		//************yesOrNoPanel_180707_1****************
		yesOrNoJPanel = new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(lottoYesOrNoImage, 0, 5, null); 
			}
		};

		yesOrNoJPanel.setLayout(null);
		yesOrNoJPanel.setBounds(35, 320, 290, 180);
		yesOrNoJPanel.setOpaque(false);
		//--------------------------------------------------------

		//***********add this, add action​_180707_1************
		lottoRegame.addActionListener(this);
		yesButton.addActionListener(this);
		
		yesOrNoJPanel.add(yesButton);
		yesOrNoJPanel.add(backButton);
		yesOrNoJPanel.add(backButton);

		this.add(lottoRegame);
		this.add(yesOrNoJPanel);
		//--------------------------------------------------------
	}

	//*********JButton 등의 이벤트 발생 시작 메소드_180707_1************
	@Override
	public void actionPerformed(ActionEvent e) {
		View.cm().lottoStart(e, this, yesOrNoJPanel, lottoRegame);
	}
	//---------------------------------------------------------

	//*********LottoJPanel BackGround Image add_180707_1************
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(lottoBackGroundImage, 0, -93, null);
	}
	//---------------------------------------------------------
}