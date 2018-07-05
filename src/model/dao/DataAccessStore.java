package model.dao;

import java.awt.event.ActionEvent;

import model.vo.Store;

public class DataAccessStore {
	private Store store;
	
	public DataAccessStore(){
		store = new Store();
	}
	
	public Store getStore(){
		return store;
	}
	
	public void start(ActionEvent e){
		
	}
	
}

