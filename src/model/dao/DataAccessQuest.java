package model.dao;

import model.vo.Quest;

public class DataAccessQuest {
	private Quest quest;
	
	public DataAccessQuest(){
		quest = new Quest();
	}
	
	public Quest getQuest(){
		return quest;
	}
}
