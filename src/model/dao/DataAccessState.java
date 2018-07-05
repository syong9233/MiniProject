package model.dao;

import java.awt.event.KeyEvent;

import javax.swing.JButton;

import model.vo.Main;
import model.vo.State;

public class DataAccessState {
	private State state;
	
	public DataAccessState(){
		state = new State();
	}
	
	public State getState(){
		return state;
	}

	public void stateLevelUp(KeyEvent e, Main main) {
		state.setP_lvOfExtend((byte)(state.getP_lvOfExtend() + 1));
		main.setM_AmountOfAutoMoney((long)(main.getM_AmountOfAutoMoney() * 1.5));
	}
}
