package model.dao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import model.vo.Main;
import model.vo.Player;
import model.vo.Quest;
import model.vo.State;
import view.View;
import view.jbutton.BackJButton;
import view.jbutton.LottoBackJButton;
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
import javax.swing.JButton; 	

public class DataAccessMain {
	private Main main;
	
	public DataAccessMain(){
		main = new Main();
	}
	
	public Main getMain(){
		return main;
	}
	
	public void autoRun(TotalMoneyJLabel totalMoneyJLabel, MainJPanel mainJPanel, Player player){
		
				while(true){
					try {
						Thread.sleep(1000);
						totalMoneyJLabel.setText(String.format("%,d", main.getM_TotalOfMoney()) + " : º¸À¯");
						main.setM_TotalOfMoney(main.getM_TotalOfMoney() + main.getM_AmountOfAutoMoney());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
		
	}
	
	public void keyReleased(TotalMoneyJLabel totalMoneyJLabel, DataAccessQuest quest, JButton button3) {	
		main.setM_TotalOfMoney(main.getM_TotalOfMoney() + main.getM_AmountOfTapMoney());
		totalMoneyJLabel.setText(String.format("%,d", main.getM_TotalOfMoney()) + " : º¸À¯");
		//quest.ÇÔ¼ö 
		quest.questAdd(main, totalMoneyJLabel, button3); 
	}
	
	public void setMain(Player player, NicknameJLabel nicknameJLabel, TotalMoneyJLabel totalMoneyJLabel, AutoMoneyJLabel autoMoneyJLabel, TapMoneyJLabel tapMoneyJLabel) {
		nicknameJLabel.setText("player : " + player.getP_Nickname());
		totalMoneyJLabel.setText(String.format("%,d", (main.getM_TotalOfMoney())) + " : º¸À¯");
		autoMoneyJLabel.setText(String.format("%,d", (main.getM_AmountOfAutoMoney())) + " : ÀÚµ¿");
		tapMoneyJLabel.setText(String.format("%,d", (main.getM_AmountOfTapMoney())) + " : ÅÇ");
	}
	
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
	
	public Boolean checkFisrtGame(DataAccessPlayer player){
		boolean temp = true;
		
		try{
			if(!(player.getPlayer().getP_Nickname().equals(""))){
				temp = false;
			}
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		
		return temp;
	}
	
	public void whileNotPlay(MainJPanel mainJPanel, Player player){
		JLabel noticeJLabel = new JLabel("ÇÃ·¹ÀÌ ÇÏÁö ¾ÊÀº µ¿¾È È¹µæÇÑ ±Ý¾× ");
		JLabel noticeMoneyJLabel = new JLabel();
		int temp = (int)((new Date().getTime() - player.getP_lastTime().getTime()) / 1000);

		main.setM_TotalOfMoney(main.getM_TotalOfMoney() + (main.getM_AmountOfTapMoney() * temp));

		noticeJLabel.setBounds(82, 80, 300, 50);
		noticeJLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 11));
		noticeJLabel.setForeground(new Color(255, 255, 255));
		noticeMoneyJLabel.setBounds(22, 100, 300, 50);
		noticeMoneyJLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 11));
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

	public void pageMove(View view, ActionEvent e, MainJPanel mainJPanel, StateJPanel stateJPanel, QuestJPanel questJPanel, StoreJPanel storeJPanel,
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
	
}
