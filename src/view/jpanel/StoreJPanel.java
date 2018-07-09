package view.jpanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.ImageIcon;

import view.View;

public class StoreJPanel extends JPanel implements ActionListener {
	
	//***********JButton, Image 등 객체 생성 및 변수 선언_180707_1************
	private JButton buyPotion = new JButton(new ImageIcon("image/store/store_portion.png"));
	private JButton buyLotto = new JButton("L");
	private JButton buyAutoTap = new JButton("A");
	private JButton buyCash = new JButton("C");

	private BufferedImage storeBackgroundImage;
	//----------------------------------------------------------------

	public StoreJPanel() {

		//***************StoreJPanel_180707_1​****************
		this.setLayout(null);
		this.setBounds(3, 52, 338, 516);
		this.setBackground(new Color(100, 100, 100));
		//----------------------------------------------------
		
		//**********************이미지 객체화_180707_1*************************
		try {
			storeBackgroundImage = ImageIO.read(new File("image/store/store_background.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//------------------------------------------------------------------
		
		//****************각각의 JButton Setting_180707_1****************
		buyPotion.setLocation(60, 120);
		buyPotion.setSize(105, 162);
		buyPotion.addActionListener(this);
		buyPotion.setFont(new Font("맑은 고딕", Font.BOLD, 12));

		buyLotto.setLocation(265, 85);
		buyLotto.setSize(68, 50);
		buyLotto.addActionListener(this);
		buyLotto.setFont(new Font("맑은 고딕", Font.BOLD, 12));

		buyAutoTap.setLocation(265, 140);
		buyAutoTap.setSize(68, 50);
		buyAutoTap.addActionListener(this);
		buyAutoTap.setFont(new Font("맑은 고딕", Font.BOLD, 12));

		buyCash.setLocation(265, 195);
		buyCash.setSize(68, 50);
		buyCash.addActionListener(this);
		buyCash.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		//------------------------------------------------------------
		
		//***********add this​_180707_1************
		this.add(buyPotion);
		this.add(buyLotto);
		this.add(buyAutoTap);
		this.add(buyCash);
		//-----------------------------------------
	}

	//*********JButton 등의 이벤트 발생 시작 메소드_180707_1************
	@Override
	public void actionPerformed(ActionEvent e) {
		View.cm().storeMenu(this, e);
	}
	//---------------------------------------------------------

	//*******StoreJPanel BackGround Image add_180707_1**********
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(storeBackgroundImage, -1, 1, null);
	}
	//---------------------------------------------------------

}