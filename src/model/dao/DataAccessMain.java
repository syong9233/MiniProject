package model.dao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import model.vo.Main;
import model.vo.Player;
import model.vo.Quest;
import model.vo.State;
import view.View;
import view.jbutton.BackJButton;
import view.jbutton.LottoJButton;
import view.jbutton.QuestBackJButton;
import view.jbutton.QuestJButton;
import view.jbutton.StateBackJButton;
import view.jbutton.StateJButton;
import view.jbutton.StoreBackJButton;
import view.jbutton.StoreJButton;
import view.jlabel.AutoMoneyJLabel;
import view.jlabel.NicknameJLabel;
import view.jlabel.TapMoneyJLabel;
import view.jlabel.TotalMoneyJLabel;
import view.jpanel.LottoJPanel;
import view.jpanel.MainJPanel;
import view.jpanel.QuestJPanel;
import view.jpanel.StateJPanel;
import view.jpanel.StoreJPanel;
import view.jpanel.SubJPanel;

public class DataAccessMain {
	private Main main;

	public DataAccessMain(){
		main = new Main();
	}

	public Main getMain(){
		return main;
	}

	//*************�ڵ����� �ݾ��� ������ �κ�, ������ ���� �ڵ����� üũ �� ���_180707_1*************
	public void autoRun(TotalMoneyJLabel totalMoneyJLabel, Main main, int time) {
		while (true) {
			if (main.getM_PotionTime() > 0) {
				if (main.getM_AutoTime() > 0) {
					for (int i = main.getM_AutoTime(); i > 0; i--) {
						try {
							main.setM_AutoTime(main.getM_AutoTime() - 1);
							System.out.println("auto" +main.getM_AutoTime());
							Thread.sleep(1000);
							totalMoneyJLabel.setText(String.format("%,d", main.getM_TotalOfMoney()) + " : ����");
							main.setM_TotalOfMoney(main.getM_TotalOfMoney() + main.getM_AmountOfAutoMoney() * 10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}

				for (int i = main.getM_PotionTime(); i > 0; i--) {
					try {
						main.setM_PotionTime(main.getM_PotionTime() - 1);
						System.out.println("potion"+main.getM_PotionTime());
						Thread.sleep(1000);
						totalMoneyJLabel.setText(String.format("%,d", main.getM_TotalOfMoney()) + " : ����");
						main.setM_TotalOfMoney(main.getM_TotalOfMoney() + main.getM_AmountOfAutoMoney() * 10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

			if (main.getM_AutoTime() > 0) {
				if (main.getM_PotionTime() > 0) {
					for (int i = main.getM_PotionTime(); i > 0; i--) {
						try {
							main.setM_PotionTime(main.getM_PotionTime() - 1);
							System.out.println("potion"+main.getM_PotionTime());
							Thread.sleep(1000);
							totalMoneyJLabel.setText(String.format("%,d", main.getM_TotalOfMoney()) + " : ����");
							main.setM_TotalOfMoney(main.getM_TotalOfMoney() + main.getM_AmountOfAutoMoney() * 10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					for (int i = main.getM_AutoTime(); i > 0; i--) {
						try {
							main.setM_AutoTime(main.getM_AutoTime() - 1);
							System.out.println("auto"+main.getM_AutoTime());
							Thread.sleep(1000);
							totalMoneyJLabel.setText(String.format("%,d", main.getM_TotalOfMoney()) + " : ����");
							main.setM_TotalOfMoney(main.getM_TotalOfMoney() + main.getM_AmountOfAutoMoney() * 10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}

			try {
				Thread.sleep(1000);
				totalMoneyJLabel.setText(String.format("%,d", main.getM_TotalOfMoney()) + " : ����");
				main.setM_TotalOfMoney(main.getM_TotalOfMoney() + main.getM_AmountOfAutoMoney());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	//-------------------------------------------------------------------------

	//*******������ ������� ��� �ð� �߰�(autuRun���� �ð� üũ �� ������ ����� �ð����� ����)_180707_1*******
	public void potionRun(int time) {
		main.setM_PotionTime(time);
		return;
	}
	//---------------------------------------------------------------------------------

	//*******������ ������� ��� �ð� �߰�(autuRun���� �ð� üũ �� ������ ����� �ð����� ����)_180707_1*******
	public void autoTime(int time) {
		main.setM_AutoTime(time);
		return;
	}
	//---------------------------------------------------------------------------------

	//*************************�����̽��ٸ� ������ ���_180707_1*************************
	public void keyReleased(TotalMoneyJLabel totalMoneyJLabel, DataAccessQuest quest,
			JLabel goalTap, JLabel ingTap, JLabel goalMoney,
			JLabel ingMoney , JButton button1, JButton button2) {	
		main.setM_TotalOfMoney(main.getM_TotalOfMoney() + main.getM_AmountOfTapMoney());
		totalMoneyJLabel.setText(String.format("%,d", main.getM_TotalOfMoney()) + " : ����");
		quest.viewQuest(main, totalMoneyJLabel, goalTap, ingTap, goalMoney, ingMoney);
	}
	//-----------------------------------------------------------------------

	//*************************���� ��� �ݾ� ����_180707_1*************************
	public void setMain(Player player, NicknameJLabel nicknameJLabel, 
			TotalMoneyJLabel totalMoneyJLabel, AutoMoneyJLabel autoMoneyJLabel, 
			TapMoneyJLabel tapMoneyJLabel) {
		nicknameJLabel.setText("player : " + player.getP_Nickname());
		totalMoneyJLabel.setText(String.format("%,d", (main.getM_TotalOfMoney())) + " : ����");
		autoMoneyJLabel.setText(String.format("%,d", (main.getM_AmountOfAutoMoney())) + " : �ڵ�");
		tapMoneyJLabel.setText(String.format("%,d", (main.getM_AmountOfTapMoney())) + " : ��");
	}
	//-----------------------------------------------------------------------

	//**************���� �����ϴ� �̿������� ������ �÷��̸� �ߴ� �̿������� üũ_180707_1****************
	public void checkFisrtGame(View view, DataAccessPlayer player,
			State state, Quest quest,  NicknameJLabel nicknameJLabel, 
			TotalMoneyJLabel totalMoneyJLabel, AutoMoneyJLabel autoMoneyJLabel,
			TapMoneyJLabel tapMoneyJLabel, MainJPanel mainJPanel){
		if(player.getPlayer().getP_Nickname().equals("")){
			int temp = 1;
			String nickname = "";
			while(temp == 1){
				nickname = JOptionPane.showInputDialog(null, "�г��� �Է�", "�г��� ����", JOptionPane.OK_CANCEL_OPTION);
				if(nickname.length() != 0){
					for(int i = 0; i < nickname.length(); i++){
						if(nickname.charAt(i) == 32){
							JOptionPane.showMessageDialog(null,"�г��ӿ� ���⸦ ���� �� �����ϴ�");
							i = nickname.length();
						}else if(i == (nickname.length()-1)){
							temp = 2;
						}
					}
				}else{
					if(nickname.length() == 0){
						JOptionPane.showMessageDialog(null,"�г����� ������ �� �����ϴ�");
					}
				}
			}

			if(!nickname.equals("")){
				player.setP_Nickname(nickname);
				setPlayer(player.getPlayer(), state, quest);
				setMain(player.getPlayer(), nicknameJLabel, totalMoneyJLabel, autoMoneyJLabel, tapMoneyJLabel);
				autoRun(totalMoneyJLabel, this.getMain(), 0);
			}else{
				view.setVisible(false); 
			}
		}else{
			setPlayer(player.getPlayer(), state, quest);
			setMain(player.getPlayer(), nicknameJLabel, totalMoneyJLabel, autoMoneyJLabel, tapMoneyJLabel);
			whileNotPlay(mainJPanel, player.getPlayer());
			autoRun(totalMoneyJLabel, this.getMain(), 0);
		}
	}
	//-----------------------------------------------------------------------

	//*******************�÷������� ���� ���� ȹ���� �ݾ� �߰�_180707_1*******************
	public void whileNotPlay(MainJPanel mainJPanel, Player player){
		JLabel noticeJLabel = new JLabel("�÷��� ���� ���� ���� ȹ���� �ݾ� ");
		JLabel noticeMoneyJLabel = new JLabel();
		int temp = (int)((new Date().getTime() - player.getP_lastTime().getTime()) / 1000);

		main.setM_TotalOfMoney(main.getM_TotalOfMoney() + (main.getM_AmountOfTapMoney() * temp));

		noticeJLabel.setBounds(82, 80, 300, 50);
		noticeJLabel.setFont(new Font("���� ���", Font.BOLD, 11));
		noticeJLabel.setForeground(new Color(255, 255, 255));
		noticeMoneyJLabel.setBounds(22, 100, 300, 50);
		noticeMoneyJLabel.setFont(new Font("���� ���", Font.BOLD, 11));
		noticeMoneyJLabel.setForeground(new Color(255, 255, 255));
		noticeMoneyJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		noticeMoneyJLabel.setText(String.format("%,d", (main.getM_AmountOfTapMoney() * temp)));
		mainJPanel.add(noticeJLabel);
		mainJPanel.add(noticeMoneyJLabel);
		mainJPanel.repaint();
		try {
			Thread.sleep(3000);
			noticeJLabel.setVisible(false);
			noticeMoneyJLabel.setVisible(false);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return;
	}
	//-----------------------------------------------------------------------

	//*****************ù ����, �̾��ϴ� ������ �÷��̾� ���� ����_180707_1*******************
	public void setPlayer(Player player, State state, Quest quest){
		main.setM_AmountOfAutoMoney(player.getP_AmountOfAutoMoney());
		main.setM_AmountOfTapMoney(player.getP_AmountOfTapMoney());
		main.setM_Cash(player.getP_Cash());
		main.setM_qtyOfAutoTap(player.getP_qtyOfAutoTap());
		main.setM_qtyOfLotto(player.getP_qtyOfLotto());
		main.setM_qtyOfPotion(player.getP_qtyOfPotion());
		main.setM_TotalOfMoney(player.getP_TotalOfMoney());
		state.setP_lvOfComputer(player.getP_lvOfComputer());
		state.setP_lvOfEducate(player.getP_lvOfEducate());
		state.setP_lvOfEmploy(player.getP_lvOfEmploy());
		state.setP_lvOfExtend(player.getP_lvOfExtend());
		state.setP_lvOfKeyboard(player.getP_lvOfKeyboard());
		quest.setQ_qtyOfTap(player.getP_qtyOfTap());
	}
	//-----------------------------------------------------------------------

	//*********************���� �� ��ư�� ���� ��� ������ �̵�_180707_1*******************
	public void pageMove(View view, ActionEvent e, MainJPanel mainJPanel,
			StateJPanel stateJPanel, QuestJPanel questJPanel, StoreJPanel storeJPanel,
			LottoJPanel lottoJPanel, SubJPanel subJPanel) {
		if(e.getSource() instanceof StateJButton){
			stateJPanel.setVisible(true);
			subJPanel.setVisible(false);
			view.add(stateJPanel);
			view.add(mainJPanel);
			view.repaint();
		}else if(e.getSource() instanceof QuestJButton){
			questJPanel.setVisible(true);
			subJPanel.setVisible(false);
			view.add(questJPanel);
			view.add(mainJPanel);
			view.repaint();
		}else if(e.getSource() instanceof StoreJButton){
			storeJPanel.setVisible(true);
			subJPanel.setVisible(false);
			view.add(storeJPanel);
			view.add(mainJPanel);
			view.repaint();
		}else if(e.getSource() instanceof LottoJButton){
			lottoJPanel.setVisible(true);
			subJPanel.setVisible(false);
			view.add(lottoJPanel);
			view.add(mainJPanel);
			view.repaint();
		}else if(e.getSource() instanceof StoreBackJButton){
			subJPanel.setVisible(true);
			storeJPanel.setVisible(false);
			view.add(mainJPanel);
			view.add(subJPanel);
			view.repaint();
			View.cm().savePlayer();
		}else if(e.getSource() instanceof BackJButton){
			lottoJPanel.setVisible(false);
			subJPanel.setVisible(true);
			view.add(mainJPanel);
			view.add(subJPanel);
			view.repaint();
		}else if(e.getSource() instanceof StateBackJButton){
			stateJPanel.setVisible(false);
			subJPanel.setVisible(true);
			view.add(subJPanel);
			view.add(mainJPanel);
			view.repaint();
		}else if(e.getSource() instanceof QuestBackJButton){
			questJPanel.setVisible(false);
			subJPanel.setVisible(true);
			view.add(subJPanel);
			view.add(mainJPanel);
			view.repaint();
		}
	}
	//---------------------------------------------------------------
}