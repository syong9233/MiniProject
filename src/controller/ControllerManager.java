package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import model.dao.DataAccessMain;
import model.dao.DataAccessPlayer;
import model.dao.DataAccessQuest;
import model.dao.DataAccessState;
import model.dao.DataAccessStore;
import model.vo.Main;
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
		main.keyReleased(totalMoneyJLabel);
	}
	
	public Boolean checkFisrtGame(){
		return main.checkFisrtGame(player);
	}

	public void setMain(NicknameJLabel nicknameJLabel, TotalMoneyJLabel totalMoneyJLabel, AutoMoneyJLabel autoMoneyJLabel, TapMoneyJLabel tapMoneyJLabel) {
		main.setPlayer(player.getPlayer(), state.getState());
		main.setMain(player.getPlayer(), nicknameJLabel, totalMoneyJLabel, autoMoneyJLabel, tapMoneyJLabel);
		
	}
	
	public void setP_Nickname(String nickname){
		player.setP_Nickname(nickname);
	}

	public void savePlayer(KeyEvent e) {
		state.stateLevelUp(e, main.getMain());
		

	}
	public void pageMove(View view, ActionEvent e, MainJPanel mainJPanel, StateJPanel stateJPanel, QuestJPanel questJPanel, StoreJPanel storeJPanel, LottoJPanel lottoJPanel, SubJPanel subJPanel) {
		main.pageMove(view, e, mainJPanel, stateJPanel, questJPanel, storeJPanel, lottoJPanel, subJPanel);
	}
	
}
