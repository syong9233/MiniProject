package model.dao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
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
import view.jbutton.storeMenuJButton.BuyCashJButton;
import view.jbutton.storeMenuJButton.UseAutoTapJButton;
import view.jbutton.storeMenuJButton.UsePotionJButton;
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
	public void potionRun(int time) {
		main.setM_potiontime(time);
		return;
	}

	public void autoRun(int time) {
		main.setM_autotime(time);
		return;
	}

	public void autoRun(TotalMoneyJLabel totalMoneyJLabel, Main main, int time) {
		while (true) {

			if (main.getM_potiontime() > 0) {

				main.setM_AmountOfTapMoney(main.getM_AmountOfTapMoney() * 10);
				int tim = 0;

				for (int i = main.getM_potiontime(); i > 0; i--) {
					try {

						Thread.sleep(100);
						main.setM_potiontime(main.getM_potiontime() - 1);

						if (tim == 10) {
							main.setM_TotalOfMoney(main.getM_TotalOfMoney() + main.getM_AmountOfAutoMoney());
							totalMoneyJLabel.setText(String.format("%,d", main.getM_TotalOfMoney()) + " : ����");
							tim = 0;
						}

						tim++;

						if (main.getM_autotime() > 0) {

							main.setM_TotalOfMoney(main.getM_TotalOfMoney() + main.getM_AmountOfTapMoney());
							totalMoneyJLabel.setText(String.format("%,d", main.getM_TotalOfMoney()) + " : ����");

							main.setM_autotime(main.getM_autotime() - 1);
							System.out.println("auto in potion" + main.getM_autotime());

						}

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				main.setM_AmountOfTapMoney(main.getM_AmountOfTapMoney() / 10);

			}

			if (main.getM_autotime() > 0) {

				for (int i = main.getM_autotime(); i > 0; i--) {

					try {
						Thread.sleep(100);

						System.out.println("tap");

						main.setM_autotime(main.getM_autotime() - 1);
						totalMoneyJLabel.setText(String.format("%,d", main.getM_TotalOfMoney()) + " : ����");
						main.setM_TotalOfMoney(main.getM_TotalOfMoney() + main.getM_AmountOfTapMoney());

						if (main.getM_potiontime() > 0)
							break;

					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}

			} else if (main.getM_autotime() > 0 && main.getM_potiontime() > 0)
				continue;

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

	//*************************�����̽��ٸ� ������ ���_180707_1*************************
	public void keyReleased(TotalMoneyJLabel totalMoneyJLabel, DataAccessQuest quest,
			JLabel goalTap, JLabel ingTap, JLabel goalMoney,
			JLabel ingMoney , JButton button1, JButton button2) {	
		main.setM_TotalOfMoney(main.getM_TotalOfMoney() + main.getM_AmountOfTapMoney());
		totalMoneyJLabel.setText(String.format("%,d", main.getM_TotalOfMoney()));
		quest.viewQuest(main, totalMoneyJLabel, goalTap, ingTap, goalMoney, ingMoney);
	}
	//-----------------------------------------------------------------------

	//*************************���� ��� �ݾ� ����_180707_1*************************
	public void setMain(Player player, NicknameJLabel nicknameJLabel, 
			TotalMoneyJLabel totalMoneyJLabel, AutoMoneyJLabel autoMoneyJLabel, 
			TapMoneyJLabel tapMoneyJLabel, JProgressBar extendBar, JProgressBar educateBar,
			JProgressBar employBar, JProgressBar computerBar, JProgressBar keyboardBar, State state) {
		nicknameJLabel.setText("player : " + player.getP_Nickname());
		totalMoneyJLabel.setText(String.format("%,d", (main.getM_TotalOfMoney())));
		autoMoneyJLabel.setText(String.format("%,d", (main.getM_AmountOfAutoMoney())));
		tapMoneyJLabel.setText(String.format("%,d", (main.getM_AmountOfTapMoney())));
		
		extendBar.setValue(state.getP_lvOfExtend());
		educateBar.setValue(state.getP_lvOfEducate());
		employBar.setValue(state.getP_lvOfEmploy());
		computerBar.setValue(state.getP_lvOfComputer());
		keyboardBar.setValue(state.getP_lvOfKeyboard());
		extendBar.setString(state.getP_lvOfExtend() + "/" + extendBar.getMaximum());
		educateBar.setString(state.getP_lvOfEducate() + "/" + educateBar.getMaximum());
		employBar.setString(state.getP_lvOfEmploy() + "/" + employBar.getMaximum());
		computerBar.setString(state.getP_lvOfComputer() + "/" + computerBar.getMaximum());
		keyboardBar.setString(state.getP_lvOfKeyboard() + "/" + keyboardBar.getMaximum());
	}
	//-----------------------------------------------------------------------
	public void reSetMoneyJLabel(AutoMoneyJLabel autoMoneyJLabel, TapMoneyJLabel tapMoneyJLabel) {
		autoMoneyJLabel.setText(String.format("%,d", (main.getM_AmountOfAutoMoney())));
		tapMoneyJLabel.setText(String.format("%,d", (main.getM_AmountOfTapMoney())));
	}
	//**************���� �����ϴ� �̿������� ������ �÷��̸� �ߴ� �̿������� üũ_180707_1****************
	public void checkFisrtGame(View view, DataAccessPlayer player,
			State state, Quest quest,  NicknameJLabel nicknameJLabel, 
			TotalMoneyJLabel totalMoneyJLabel, AutoMoneyJLabel autoMoneyJLabel,
			TapMoneyJLabel tapMoneyJLabel, MainJPanel mainJPanel, SubJPanel subJPanel,
			JProgressBar extendBar, JProgressBar educateBar, JProgressBar employBar,
			JProgressBar computerBar, JProgressBar keyboardBar){
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
				setMain(player.getPlayer(), nicknameJLabel, totalMoneyJLabel, autoMoneyJLabel, tapMoneyJLabel,
						extendBar, educateBar, employBar, computerBar, keyboardBar, state);
				autoRun(totalMoneyJLabel, this.getMain(), 0);
			}else{
				view.setVisible(false); 
			}
		}else{
			setPlayer(player.getPlayer(), state, quest);
			setMain(player.getPlayer(), nicknameJLabel, totalMoneyJLabel, autoMoneyJLabel, tapMoneyJLabel,
					extendBar, educateBar, employBar, computerBar, keyboardBar, state);
			whileNotPlay(view, mainJPanel, subJPanel, player.getPlayer());
			autoRun(totalMoneyJLabel, this.getMain(), 0);
	
		}
	}
	//-----------------------------------------------------------------------

	//*******************�÷������� ���� ���� ȹ���� �ݾ� �߰�_180707_1*******************
	public void whileNotPlay(View view, MainJPanel mainJPanel, SubJPanel subJPanel, Player player){
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
	
	public void loadQuest(Quest quest, JLabel goalTap, JLabel ingTap, JLabel goalMoney, JLabel ingMoney){
		goalTap.setText(quest.getTap2() + "");
		ingTap.setText((quest.getQ_qtyOfTap() + 1) + "");
		quest.setQ_qtyOfTap(quest.getQ_qtyOfTap() + 1);
		goalMoney.setText(String.format("%,d", quest.getTemp2()));
		ingMoney.setText(String.format("%,d", main.getM_TotalOfMoney()));
		quest.setQ_qtyOfTotalMoney(main.getM_TotalOfMoney());
	}
	
	//*********************���� �� ��ư�� ���� ��� ������ �̵�_180707_1*******************
	public void pageMove(View view, ActionEvent e, MainJPanel mainJPanel,
			StateJPanel stateJPanel, QuestJPanel questJPanel, StoreJPanel storeJPanel,
			LottoJPanel lottoJPanel, SubJPanel subJPanel, JButton extendJButton,
			JButton educateJButton, JButton employJButton, JButton computerJButton, JButton keyboardJButton,
			JProgressBar extendBar, JProgressBar educateBar, JProgressBar employBar,
			JProgressBar computerBar, JProgressBar keyboardBar, NicknameJLabel nicknameJLabel,
			TotalMoneyJLabel totalMoneyJLabel, AutoMoneyJLabel autoMoneyJLabel, TapMoneyJLabel tapMoneyJLabel
			,DataAccessStore store, StoreBackJButton storeBackJButton) {
		
		
		
	
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
			view.add(subJPanel);
			view.add(mainJPanel);
			view.repaint();
			View.cm().savePlayer();
		}else if(e.getSource() instanceof BackJButton){
			lottoJPanel.setVisible(false);
			subJPanel.setVisible(true);
			view.add(subJPanel);
			view.add(mainJPanel);
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
		}else if(e.getActionCommand().equals("ȸ�� Ȯ��")){
			View.cm().stateChoice("ȸ�� Ȯ��", main, extendBar, mainJPanel, stateJPanel, view, nicknameJLabel, totalMoneyJLabel, autoMoneyJLabel, tapMoneyJLabel);
		}else if(e.getActionCommand().equals("���� �̼�")){
			View.cm().stateChoice("���� �̼�", main, educateBar, mainJPanel, stateJPanel, view, nicknameJLabel, totalMoneyJLabel, autoMoneyJLabel, tapMoneyJLabel);
		}else if(e.getActionCommand().equals("���� ���")){
			View.cm().stateChoice("���� ���", main, employBar, mainJPanel, stateJPanel, view, nicknameJLabel, totalMoneyJLabel, autoMoneyJLabel, tapMoneyJLabel);
		}else if(e.getActionCommand().equals("��ǻ�� ���")){
			View.cm().stateChoice("��ǻ�� ���", main, computerBar, mainJPanel, stateJPanel, view, nicknameJLabel, totalMoneyJLabel, autoMoneyJLabel, tapMoneyJLabel);
		}else if(e.getActionCommand().equals("Ÿ�ڼ�")){
			View.cm().stateChoice("Ÿ�ڼ�", main, keyboardBar, mainJPanel, stateJPanel, view, nicknameJLabel, totalMoneyJLabel, autoMoneyJLabel, tapMoneyJLabel);
		} else if (e.getSource() instanceof UsePotionJButton) {
			System.out.println("potion");
			store.useItem(totalMoneyJLabel, mainJPanel, e, this);
			
		} else if (e.getSource() instanceof UseAutoTapJButton) {
			System.out.println("tap");
			store.useItem(totalMoneyJLabel, mainJPanel, e, this);
		} else if (e.getSource() instanceof BuyCashJButton){
			storeBackJButton.setVisible(false);
		}

	}
	//---------------------------------------------------------------
}