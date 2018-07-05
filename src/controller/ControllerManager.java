package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.dao.DataAccessMain;
import model.dao.DataAccessPlayer;
import model.dao.DataAccessQuest;
import model.dao.DataAccessState;
import model.dao.DataAccessStore;
import view.View;
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
	private static ControllerManager cm = new ControllerManager();
	
	private DataAccessPlayer player = new DataAccessPlayer();
	private DataAccessMain main = new DataAccessMain();
	private DataAccessQuest quest = new DataAccessQuest();
	private DataAccessState state = new DataAccessState();
	private DataAccessStore store = new DataAccessStore();
		
	public void savePlayer(){
		player.save(main.getMain(), quest.getQuest(), state.getState(), store.getStore());
	}
	
	public void loadPlayer(){
		player.load();
	}
	
	public void newPlayer(String Nickname){
		player.setP_Nickname(Nickname);
	}
	
	public void autoRun(TotalMoneyJLabel totalMoneyJLabel, MainJPanel mainJPanel){
		main.autoRun(totalMoneyJLabel, mainJPanel, player.getPlayer());
	}
	
	public void keyReleased(TotalMoneyJLabel totalMoneyJLabel) {	
		main.keyReleased(totalMoneyJLabel);	//quest占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙占�.
	}
	
	public Boolean checkFisrtGame(){
		return main.checkFisrtGame(player);
	}

	public void setMain(NicknameJLabel nicknameJLabel, TotalMoneyJLabel totalMoneyJLabel, AutoMoneyJLabel autoMoneyJLabel, TapMoneyJLabel tapMoneyJLabel) {
		main.setPlayer(player.getPlayer(), state.getState(), quest.getQuest());
		main.setMain(player.getPlayer(), nicknameJLabel, totalMoneyJLabel, autoMoneyJLabel, tapMoneyJLabel);
		
	}
	
	public void setP_Nickname(String nickname){
		player.setP_Nickname(nickname);
	}


	public void pageMove(View view, ActionEvent e, MainJPanel mainJPanel, StateJPanel stateJPanel, QuestJPanel questJPanel, StoreJPanel storeJPanel, LottoJPanel lottoJPanel, SubJPanel subJPanel) {
		main.pageMove(view, e, mainJPanel, stateJPanel, questJPanel, storeJPanel, lottoJPanel, subJPanel);
	}

	public void questChoice(ActionEvent e){
		quest.choice(e, main.getMain());
	}


	public void lottoStart(ActionEvent e, LottoJPanel lottoJPanel, JPanel yesOrNoJPanel, JButton lottoRegame){
		store.lottoStart(e, main.getMain(), lottoJPanel, yesOrNoJPanel, lottoRegame);
		
	}

	//************스탯 버튼 초이스******************
	public void stateChoice(ActionEvent e){
		state.choice(e, main.getMain());
	}

}
































