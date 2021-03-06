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

	//*************자동으로 금액이 오르는 부분, 아이템 사용시 자동으로 체크 후 사용_180707_1*************
	public void potionRun(int time) {
		main.setM_potiontime(time);
		return;
	}

	public void autoRun(int time) {
		main.setM_autotime(time);
		return;
	}

	public void autoRun(TotalMoneyJLabel totalMoneyJLabel, Main main, int time, TapMoneyJLabel tapMoneyJLabel) {
		while (true) {

			if (main.getM_potiontime() > 0) {

				main.setM_AmountOfTapMoney(main.getM_AmountOfTapMoney() * 10);
				int tim = 0;

				for (int i = main.getM_potiontime(); i > 0; i--) {
					try {

						Thread.sleep(100);
						main.setM_potiontime(main.getM_potiontime() - 1);
						View.sub_potionTimeJLabel.setText(String.format("%,d", main.getM_potiontime()));

						if (tim == 10) {
							main.setM_TotalOfMoney(main.getM_TotalOfMoney() + main.getM_AmountOfAutoMoney());
							totalMoneyJLabel.setText(String.format("%,d", main.getM_TotalOfMoney()));
							tapMoneyJLabel.setText(String.format("%,d", main.getM_AmountOfTapMoney()));
							tim = 0;
						}

						tim++;

						if (main.getM_autotime() > 0) {

							main.setM_TotalOfMoney(main.getM_TotalOfMoney() + main.getM_AmountOfTapMoney());
							totalMoneyJLabel.setText(String.format("%,d", main.getM_TotalOfMoney()));
							
							main.setM_autotime(main.getM_autotime() - 1);
							View.sub_autoTimeJLabel.setText(String.format("%,d",main.getM_autotime()));

							System.out.println("auto in potion" + main.getM_autotime());

						}

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				main.setM_AmountOfTapMoney(main.getM_AmountOfTapMoney() / 10);
				tapMoneyJLabel.setText(String.format("%,d", main.getM_AmountOfTapMoney()));

			}

			if (main.getM_autotime() > 0) {

				for (int i = main.getM_autotime(); i > 0; i--) {

					try {
						Thread.sleep(100);

						System.out.println("tap");
						
						main.setM_autotime(main.getM_autotime() - 1);
						View.sub_autoTimeJLabel.setText(String.format("%,d",main.getM_autotime()));
						totalMoneyJLabel.setText(String.format("%,d", main.getM_TotalOfMoney()));
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
				totalMoneyJLabel.setText(String.format("%,d", main.getM_TotalOfMoney()));
				main.setM_TotalOfMoney(main.getM_TotalOfMoney() + main.getM_AmountOfAutoMoney());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	//-------------------------------------------------------------------------

	//*************************스페이스바를 눌렀을 경우_180707_1*************************
	public void keyReleased(TotalMoneyJLabel totalMoneyJLabel, DataAccessQuest quest, DataAccessState state,
			JLabel goalTap, JLabel ingTap, JLabel goalMoney,
			JLabel ingMoney , JButton button1, JButton button2, JButton extendJButton, JButton educateJButton,
																JButton employJButton, JButton computerJButton, JButton keyboardJButton) {	
		main.setM_TotalOfMoney(main.getM_TotalOfMoney() + main.getM_AmountOfTapMoney());
		totalMoneyJLabel.setText(String.format("%,d", main.getM_TotalOfMoney()));
		quest.viewQuest(main, goalTap, ingTap, goalMoney, ingMoney);
		state.keyboardSpace(main, extendJButton, educateJButton,employJButton, computerJButton, keyboardJButton);
	}// 180710_JButton 추가
	//-----------------------------------------------------------------------

	//*************************게임 상단 금액 셋팅_180707_1*************************
	public void setMain(Player player, NicknameJLabel nicknameJLabel, 
			TotalMoneyJLabel totalMoneyJLabel, AutoMoneyJLabel autoMoneyJLabel, 
			TapMoneyJLabel tapMoneyJLabel, JProgressBar extendBar, JProgressBar educateBar,
			JProgressBar employBar, JProgressBar computerBar, JProgressBar keyboardBar, State state,
			JLabel ingTap, JLabel goalTap, JLabel ingMoney, JLabel goalMoney, Quest quest) {
		nicknameJLabel.setText("player : " + player.getP_Nickname());
		totalMoneyJLabel.setText(String.format("%,d", (main.getM_TotalOfMoney())));
		autoMoneyJLabel.setText(String.format("%,d", (main.getM_AmountOfAutoMoney())));
		tapMoneyJLabel.setText(String.format("%,d", (main.getM_AmountOfTapMoney())));
		
		//서브에 템 표시
		View.potionJLabel.setText(String.format("%,d", main.getM_qtyOfPotion()));
		View.autoJLabel.setText(String.format("%,d", main.getM_qtyOfAutoTap()));
		View.cashJLabel.setText(String.format("%,d",player.getP_Cash()));
		View.lottoJLabel.setText(String.format("%,d",main.getM_qtyOfLotto()));
		View.sub_potionTimeJLabel.setText(String.format("%,d", main.getM_potiontime()));
		View.sub_autoTimeJLabel.setText(String.format("%,d",main.getM_autotime()));
		
		//로또에 템 표시
		LottoJPanel.lotto_LottoJLabel.setText(String.format("%,d",main.getM_qtyOfLotto()));
		
		//스토어에 템 표시
		View.store_AutoJLabel.setText(String.format("%,d", main.getM_qtyOfAutoTap()));
		View.Store_LottoJLabel.setText(String.format("%,d",main.getM_qtyOfLotto()));
		View.store_PotionJLabel.setText(String.format("%,d", main.getM_qtyOfPotion()));
		View.store_CashJLabel.setText(String.format("%,d", player.getP_Cash()));
		
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
		
		quest.setTap2(player.getTap2());
		quest.setTemp2(player.getTemp2());
		
		goalTap.setText(player.getTap2() + "");
		ingTap.setText((player.getP_qtyOfTap() + 1) + "");
		goalMoney.setText(String.format("%,d", quest.getTemp2()));
		ingMoney.setText(String.format("%,d", main.getM_TotalOfMoney()));
	}
	//-----------------------------------------------------------------------
	public void reSetMoneyJLabel(AutoMoneyJLabel autoMoneyJLabel, TapMoneyJLabel tapMoneyJLabel) {
		autoMoneyJLabel.setText(String.format("%,d", (main.getM_AmountOfAutoMoney())));
		tapMoneyJLabel.setText(String.format("%,d", (main.getM_AmountOfTapMoney())));
	}
	//**************새로 시작하는 이용자인지 기존에 플레이를 했던 이용자인지 체크_180707_1****************
	public void checkFisrtGame(View view, DataAccessPlayer player,
			State state, Quest quest,  NicknameJLabel nicknameJLabel, 
			TotalMoneyJLabel totalMoneyJLabel, AutoMoneyJLabel autoMoneyJLabel,
			TapMoneyJLabel tapMoneyJLabel, MainJPanel mainJPanel, SubJPanel subJPanel,
			JProgressBar extendBar, JProgressBar educateBar, JProgressBar employBar,
			JProgressBar computerBar, JProgressBar keyboardBar, JLabel ingTap, JLabel goalTap, JLabel ingMoney, JLabel goalMoney){
		if(player.getPlayer().getP_Nickname().equals("")){
			int temp = 1;
			String nickname = "";
			while(temp == 1){
				nickname = JOptionPane.showInputDialog(null, "닉네임 입력", "닉네임 설정", JOptionPane.OK_CANCEL_OPTION);
				if(nickname.length() != 0){
					for(int i = 0; i < nickname.length(); i++){
						if(nickname.charAt(i) == 32){
							JOptionPane.showMessageDialog(null,"닉네임에 띄어쓰기를 넣을 수 없습니다");
							i = nickname.length();
						}else if(i == (nickname.length()-1)){
							temp = 2;
						}
					}
				}else{
					if(nickname.length() == 0){
						JOptionPane.showMessageDialog(null,"닉네임은 공백일 수 없습니다");
					}
				}
			}

			if(!nickname.equals("")){
				player.setP_Nickname(nickname);
				setPlayer(player.getPlayer(), state, quest);
				setMain(player.getPlayer(), nicknameJLabel, totalMoneyJLabel, autoMoneyJLabel, tapMoneyJLabel,
						extendBar, educateBar, employBar, computerBar, keyboardBar, state, ingTap, goalTap, ingMoney, goalMoney, quest);
				autoRun(totalMoneyJLabel, this.getMain(), 0, tapMoneyJLabel);
			}else{
				view.setVisible(false); 
			}
		}else{
			setPlayer(player.getPlayer(), state, quest);
			setMain(player.getPlayer(), nicknameJLabel, totalMoneyJLabel, autoMoneyJLabel, tapMoneyJLabel,
					extendBar, educateBar, employBar, computerBar, keyboardBar, state, ingTap, goalTap, ingMoney, goalMoney, quest);
			whileNotPlay(view, mainJPanel, subJPanel, player.getPlayer());
			autoRun(totalMoneyJLabel, this.getMain(), 0, tapMoneyJLabel);
	
		}


	}
	//-----------------------------------------------------------------------

	//*******************플레이하지 않은 동안 획득한 금액 추가_180707_1*******************
	public void whileNotPlay(View view, MainJPanel mainJPanel, SubJPanel subJPanel, Player player){
		int temp = (int)((new Date().getTime() - player.getP_lastTime().getTime()) / 1000);

	      main.setM_TotalOfMoney(main.getM_TotalOfMoney() + (main.getM_AmountOfTapMoney() * temp));
	      
	        JOptionPane.showMessageDialog(null, "휴가 기간 동안 획득한 금액! ! !\n" + String.format("%,d", (main.getM_AmountOfTapMoney() * temp)) + "원", "Get Money! ! !", JOptionPane.PLAIN_MESSAGE);
	}
	//-----------------------------------------------------------------------

	//*****************첫 게임, 이어하는 게임의 플레이어 정보 설정_180707_1*******************
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
	
	//*********************게임 내 버튼을 누를 경우 페이지 이동_180707_1*******************
	public void pageMove(View view, ActionEvent e, MainJPanel mainJPanel,
			StateJPanel stateJPanel, QuestJPanel questJPanel, StoreJPanel storeJPanel,
			LottoJPanel lottoJPanel, SubJPanel subJPanel, JButton extendJButton,
			JButton educateJButton, JButton employJButton, JButton computerJButton, JButton keyboardJButton,
			JProgressBar extendBar, JProgressBar educateBar, JProgressBar employBar,
			JProgressBar computerBar, JProgressBar keyboardBar, NicknameJLabel nicknameJLabel,
			TotalMoneyJLabel totalMoneyJLabel, AutoMoneyJLabel autoMoneyJLabel, TapMoneyJLabel tapMoneyJLabel
			,DataAccessStore store, StoreBackJButton storeBackJButton, DataAccessPlayer player) {
		
		
		
	
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
			View.potionJLabel.setText(String.format("%,d", main.getM_qtyOfPotion()));
			View.autoJLabel.setText(String.format("%,d", main.getM_qtyOfAutoTap()));
			View.cashJLabel.setText(String.format("%,d",player.getPlayer().getP_Cash()));
			View.lottoJLabel.setText(String.format("%,d",main.getM_qtyOfLotto()));
		}else if(e.getSource() instanceof BackJButton){
			lottoJPanel.setVisible(false);
			subJPanel.setVisible(true);
			view.add(subJPanel);
			view.add(mainJPanel);
			view.repaint();
			View.lottoJLabel.setText(String.format("%,d",main.getM_qtyOfLotto()));
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
		}else if(e.getActionCommand().equals("회사 확장")){
			View.cm().stateChoice("회사 확장", main, extendBar, mainJPanel, stateJPanel, view, nicknameJLabel, totalMoneyJLabel, autoMoneyJLabel, tapMoneyJLabel);
		}else if(e.getActionCommand().equals("교육 이수")){
			View.cm().stateChoice("교육 이수", main, educateBar, mainJPanel, stateJPanel, view, nicknameJLabel, totalMoneyJLabel, autoMoneyJLabel, tapMoneyJLabel);
		}else if(e.getActionCommand().equals("직원 고용")){
			View.cm().stateChoice("직원 고용", main, employBar, mainJPanel, stateJPanel, view, nicknameJLabel, totalMoneyJLabel, autoMoneyJLabel, tapMoneyJLabel);
		}else if(e.getActionCommand().equals("컴퓨터 사양")){
			View.cm().stateChoice("컴퓨터 사양", main, computerBar, mainJPanel, stateJPanel, view, nicknameJLabel, totalMoneyJLabel, autoMoneyJLabel, tapMoneyJLabel);
		}else if(e.getActionCommand().equals("타자수")){
			View.cm().stateChoice("타자수", main, keyboardBar, mainJPanel, stateJPanel, view, nicknameJLabel, totalMoneyJLabel, autoMoneyJLabel, tapMoneyJLabel);
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