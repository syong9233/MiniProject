package model.dao;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.vo.*;

import view.View;
import view.jbutton.LottoRegameJButton;
import view.jbutton.YesJButton;
import view.jlabel.TotalMoneyJLabel;
import view.jpanel.*;

public class DataAccessStore {
	private Store store;
	private BufferedImage lottoSuccessImage;
	private BufferedImage lottoFailImage;

	public DataAccessStore(){
		store = new Store();
	}

	public Store getStore(){
		return store;
	}

	//*******************�ζ� �������� ����� ��� ȣ��Ǵ� �޼ҵ�_180707_1**********************
	public void lottoStart(ActionEvent e, Main main, LottoJPanel lottoJPanel, 
			JPanel yesOrNoJPanel, JButton lottoRegame){
		try {
			lottoSuccessImage = ImageIO.read(new File("image/lotto/lotto_success.png"));
			lottoFailImage = ImageIO.read(new File("image/lotto/lotto_fail.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		JPanel success = new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(lottoSuccessImage, 0, 5, null); 
			}
		};

		success.setLayout(null);
		success.setBounds(0, -35, 350, 550);
		success.setVisible(false);

		JPanel fail = new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(lottoFailImage, 0, 5, null); 
			}
		};

		fail.setLayout(null);
		fail.setBounds(0, -35, 350, 550);
		fail.setBackground(new Color(80, 50, 30));
		fail.setVisible(false);


		if(e.getSource() instanceof YesJButton){
			if(main.getM_qtyOfLotto() != 0){
				main.setM_qtyOfLotto(main.getM_qtyOfLotto()-1);
				int r = (int)(Math.random()*2)+1;
				if( r == 1 ){
					main.setM_TotalOfMoney(main.getM_TotalOfMoney()+(main.getM_AmountOfTapMoney()*250));
					lottoJPanel.add(success);
					lottoRegame.setVisible(true);
					yesOrNoJPanel.setVisible(false);
					success.setVisible(true);
				}else{
					lottoJPanel.add(fail);
					yesOrNoJPanel.setVisible(false);
					lottoRegame.setVisible(true);
					fail.setVisible(true);
				}
			}else{
				JOptionPane.showMessageDialog(null, "���� ������ �����մϴ�.",   "Warning", JOptionPane.WARNING_MESSAGE);
			}
		}else if(e.getSource() instanceof LottoRegameJButton){
			yesOrNoJPanel.setVisible(true);
			lottoJPanel.setVisible(true);
			fail.setVisible(false);
			success.setVisible(false);
		}
	}
	//-------------------------------------------------------------------------

	//********************��� �Ϸ� ��ư�� ���� ������ üũ_180707_1************************
	public void StoreMenu(StoreJPanel storeJPanel, ActionEvent e, Main main, Player player) {
		if (e.getActionCommand().equals("P")) {
			buyPotion(player, main);
		} else if (e.getActionCommand().equals("L")) {
			buyLotto(player, main);
		} else if (e.getActionCommand().equals("A")) {
			buyAutoTap(player, main);
		} else if (e.getActionCommand().equals("C")) {
			buyCash(player);
		}
	}
	//--------------------------------------------------------------------------

	//**********���� ������ ���_180707_1**********
	public void potionTime(int time) {
		View.cm().potionTime(time);
	}
	//---------------------------------------

	//**********���� ������ ���_180707_1**********
	public void autoTime(int time) {
		View.cm().autoTime(time);
	}
	//---------------------------------------

	//******************���� ���������� ���� ���������� �� Ȯ��_180707_1*******************
	public void useItem(TotalMoneyJLabel totalMoneyJLabel, MainJPanel mainJPanel, ActionEvent e, DataAccessMain main) {
		if (e.getActionCommand().equals("���ǻ��")) {
			if (main.getMain().getM_qtyOfPotion() <= 0) {
				JOptionPane.showMessageDialog(null,"���� �������� �����ϴ�.");
			} else {
				main.getMain().setM_qtyOfPotion(main.getMain().getM_qtyOfPotion() - 1);
				JOptionPane.showMessageDialog(null,"������ ���Ǿ����ϴ�. \n"+
						main.getMain().getM_qtyOfPotion() + "�� ���ҽ��ϴ�.");
				View.cm().savePlayer();
				main.getMain().setM_PotionTime(main.getMain().getM_PotionTime() + 30);
				potionTime(main.getMain().getM_PotionTime());
			}
		}

		if (e.getActionCommand().equals("���ۻ��")) {
			if (main.getMain().getM_qtyOfAutoTap() <= 0) {
				JOptionPane.showMessageDialog(null,"���� �������� �����ϴ�.");
			} else {
				main.getMain().setM_qtyOfAutoTap(main.getMain().getM_qtyOfAutoTap() - 1);
				JOptionPane.showMessageDialog(null,"���۰� ���Ǿ����ϴ�.\n" +
						main.getMain().getM_qtyOfAutoTap() + "�� ���ҽ��ϴ�.");
				View.cm().savePlayer();
				main.getMain().setM_AutoTime(main.getMain().getM_AutoTime() + 30);
				autoTime(main.getMain().getM_AutoTime());
			}
		}
	}
	//-----------------------------------------------------------------------

	//***************ĳ�� ����_180707_1*****************
	public void buyCash(Player player) {
		player.setP_Cash(player.getP_Cash() + 1000);
		JOptionPane.showMessageDialog(null,"���� Cash : " + player.getP_Cash());
	}
	//-----------------------------------------------

	//***************���� ������ ����_180707_1*****************
	public void buyPotion(Player player, Main main) {
		if (player.getP_Cash() < store.getS_priceOfPotion()) {
			JOptionPane.showMessageDialog(null,"�ݾ��� �����մϴ�.");

			return;
		}
		player.setP_Cash(player.getP_Cash() - store.getS_priceOfPotion());
		main.setM_qtyOfPotion(main.getM_qtyOfPotion() + 1);
		JOptionPane.showMessageDialog(null,"���� ���� �Ϸ� (1000 Cash)\n" + "�ܿ� Cash : " + player.getP_Cash());

		return;
	}
	//-----------------------------------------------

	//***************�ζ� ������ ����_180707_1*****************
	public void buyLotto(Player player, Main main) {
		if (player.getP_Cash() < store.getS_priceOfLotto()) {
			JOptionPane.showMessageDialog(null,"�ݾ��� �����մϴ�.");

			return;
		}
		player.setP_Cash(player.getP_Cash() - store.getS_priceOfLotto());
		main.setM_qtyOfLotto(main.getM_qtyOfLotto() + 1);
		JOptionPane.showMessageDialog(null,"���� ���� �Ϸ� (2000 Cash)\n" + "�ܿ� Cash : " + player.getP_Cash());

		return;
	}
	//-----------------------------------------------

	//***************���� ������ ����_180707_1*****************
	public void buyAutoTap(Player player, Main main) {
		if (player.getP_Cash() < store.getS_priceOfAutoTap()) {
			JOptionPane.showMessageDialog(null,"�ݾ��� �����մϴ�.");
			return;
		}
		player.setP_Cash(player.getP_Cash() - store.getS_priceOfAutoTap());
		main.setM_qtyOfAutoTap(main.getM_qtyOfAutoTap() + 1);
		JOptionPane.showMessageDialog(null,"���� ���� �Ϸ� (500 Cash)\n" + "�ܿ� Cash : " + player.getP_Cash());
		return;
	}
	//-----------------------------------------------

	//***************ĳ��, ������ �� ���� Ȯ��_180707_1*****************
	//??????????????????????????????????????????????????????????
	public void check(Player player, Main main) {
		System.out.println("���� Cash : " + player.getP_Cash());
		System.out.println("���� ���� ���� : " + main.getM_qtyOfPotion());
		System.out.println("���� ���� ���� : " + main.getM_qtyOfLotto());
		System.out.println("���� ���� ���� : " + main.getM_qtyOfAutoTap());
	}
	//-----------------------------------------------
}
