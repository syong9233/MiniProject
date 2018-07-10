package controller;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import model.dao.DataAccessMain;
import model.dao.DataAccessPlayer;
import model.dao.DataAccessQuest;
import model.dao.DataAccessState;
import model.dao.DataAccessStore;
import model.vo.Main;
import model.vo.Player;
import view.View;
import view.jbutton.questMenuJButton.questComplete_1;
import view.jbutton.questMenuJButton.questComplete_2;
import view.jbutton.storeMenuJButton.BuyAutoTapJButton;
import view.jbutton.storeMenuJButton.BuyCashJButton;
import view.jbutton.storeMenuJButton.BuyLottoJButton;
import view.jbutton.storeMenuJButton.BuyPotionJButton;
import view.jbutton.storeMenuJButton.CashCloseJButton;
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

public class ControllerManager {
	private DataAccessPlayer player = new DataAccessPlayer();
	private DataAccessMain main = new DataAccessMain();
	private DataAccessQuest quest = new DataAccessQuest();
	private DataAccessState state = new DataAccessState();
	private DataAccessStore store = new DataAccessStore();

	//***************************DataAccessPlayer DAO*************************************
	public void savePlayer(){
		player.save(main.getMain(), quest.getQuest(), state.getState(), store.getStore());
	}

	public void loadPlayer(){
		player.load();
		
	}

	public void newPlayer(String Nickname){
		player.setP_Nickname(Nickname);
	}

	public void setP_Nickname(String nickname){
		player.setP_Nickname(nickname);
	}
	//------------------------------------------------------------------------------------

	//***************************DataAccessMain DAO*************************************
	public void autoRun(TotalMoneyJLabel totalMoneyJLabel, MainJPanel mainJPanel){
		main.autoRun(totalMoneyJLabel, main.getMain(), 0);
	}

	public void keyReleased(TotalMoneyJLabel totalMoneyJLabel, JLabel ingTap,
			JLabel goalTap, JLabel ingMoney, JLabel goalMoney, 
			JButton button1, JButton button2, JButton extendJButton, JButton educateJButton, JButton employJButton, JButton computerJButton, JButton keyboardJButton) {	
		main.keyReleased(totalMoneyJLabel, quest, state, ingTap, goalTap, ingMoney,
				goalMoney, button1, button2, extendJButton, educateJButton, employJButton, computerJButton, keyboardJButton);
	}// 180710_JButton Ãß°¡


	public void checkFisrtGame(View view, NicknameJLabel nicknameJLabel, TotalMoneyJLabel totalMoneyJLabel,
			AutoMoneyJLabel autoMoneyJLabel, TapMoneyJLabel tapMoneyJLabel, MainJPanel mainJPanel, SubJPanel subJPanel, JProgressBar extendBar,
			JProgressBar educateBar, JProgressBar employBar, JProgressBar computerBar, JProgressBar keyboardBar){
		main.checkFisrtGame(view, player, state.getState(), quest.getQuest(), nicknameJLabel,
				totalMoneyJLabel, autoMoneyJLabel, tapMoneyJLabel, mainJPanel, subJPanel, extendBar, educateBar, employBar,
				computerBar, keyboardBar);
	}
	
	public void potionTime(int time){
		main.potionRun(time);
	}
	public void autoTime(int time){
		main.autoRun(time);
	}
	
	public void setMoneyJLabel(AutoMoneyJLabel autoMoneyJLabel, TapMoneyJLabel tapMoneyJLabel) {
		main.reSetMoneyJLabel(autoMoneyJLabel, tapMoneyJLabel);
	}
	
	public void pageMove(View view, ActionEvent e, MainJPanel mainJPanel,
			StateJPanel stateJPanel, QuestJPanel questJPanel, 
			StoreJPanel storeJPanel, LottoJPanel lottoJPanel, 
			SubJPanel subJPanel, JButton extendJButton, JButton educateJButton,
			JButton employJButton, JButton computerJButton, JButton keyboardJButton,
			JProgressBar extendBar, JProgressBar educateBar, JProgressBar employBar,
			JProgressBar computerBar, JProgressBar keyboardBar, NicknameJLabel nicknameJLabel,
			TotalMoneyJLabel totalMoneyJLabel, AutoMoneyJLabel autoMoneyJLabel, TapMoneyJLabel tapMoneyJLabel) {
		main.pageMove(view, e, mainJPanel, stateJPanel, questJPanel, storeJPanel,
				lottoJPanel, subJPanel, extendJButton, educateJButton,
				employJButton, computerJButton, keyboardJButton, extendBar, educateBar, employBar,
				computerBar, keyboardBar, nicknameJLabel, totalMoneyJLabel, autoMoneyJLabel, tapMoneyJLabel, store, null, player);
	}
	//------------------------------------------------------------------------------------

	//***************************DataAccessState DAO*************************************
	/*public void savePlayer(KeyEvent e) {
		state.stateLevelUp(e, main.getMain());
	}*/

	public void stateChoice(String choice, Main main, JProgressBar stateBar, MainJPanel mainJPanel,
			StateJPanel stateJPanel, View view, NicknameJLabel nicknameJLabel, TotalMoneyJLabel totalMoneyJLabel, AutoMoneyJLabel autoMoneyJLabel, TapMoneyJLabel tapMoneyJLabel){
		state.choice(choice, main, stateBar, mainJPanel, stateJPanel, view, nicknameJLabel, totalMoneyJLabel, autoMoneyJLabel, tapMoneyJLabel);
	}
	//------------------------------------------------------------------------------------

	//***************************DataAccessQuest DAO*************************************
	public void questChoice(ActionEvent e, questComplete_1 button1, questComplete_2 button2){
		quest.qChoice(e, main.getMain(), button1, button2);
	}
	//------------------------------------------------------------------------------------

	//***************************DataAccessStore DAO*************************************
	public void lottoStart(ActionEvent e, LottoJPanel lottoJPanel, JPanel yesOrNoJPanel, JButton lottoRegame, JPanel success, JPanel fail){
		store.lottoStart(e, main.getMain(), lottoJPanel, yesOrNoJPanel, lottoRegame, success, fail);
		
	}

	public void storeMenu(StoreJPanel storeJPanel,  ActionEvent e,JPanel emptyMoneyJPanel,BuyPotionJButton buyPotionJButton,BuyAutoTapJButton buyAutoTapJButton,
			BuyLottoJButton buyLottoJButton,BuyCashJButton buyCashJButton,JPanel buyCashJPanel, CashCloseJButton cashCloseJButton) {
		store.StoreMenu(storeJPanel, e , main.getMain(), player.getPlayer(), emptyMoneyJPanel, buyPotionJButton, buyAutoTapJButton, buyLottoJButton,
				buyCashJButton, buyCashJPanel, cashCloseJButton);
	}
	//------------------------------------------------------------------------------------
}