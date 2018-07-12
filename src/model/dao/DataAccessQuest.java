package model.dao;

import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.vo.Main;
import model.vo.Quest;
import view.jbutton.questMenuJButton.questComplete_1;
import view.jbutton.questMenuJButton.questComplete_2;


public class DataAccessQuest {
	private Quest quest;

	public DataAccessQuest(){
		quest = new Quest();
	}

	public Quest getQuest(){
		return quest;
	}
	
	//********************��� �Ϸ� ��ư�� ���� ������ üũ_180707_1************************
	public void qChoice(ActionEvent e, Main main, questComplete_1 button1, questComplete_2 button2, JLabel ingTap, JLabel goalTap, JLabel ingMoney, JLabel goalMoney) {
		
		if (e.getSource() instanceof questComplete_1) {
			this.questAdd(main, ingTap, goalTap, ingMoney, goalMoney);
		} else if (e.getSource() instanceof questComplete_2) {
			this.questAdd2(main, ingTap, goalTap, ingMoney, goalMoney);
		}
	}
	//------------------------------------------------------------------------

	//**************�� ��ǥġ �Ϸ� �� �� �Ϸ� ��ư�� ���� ��� ȣ��Ǵ� �޼ҵ�_180707_1******************
	public void questAdd(Main main, JLabel ingTap, JLabel goalTap, JLabel ingMoney, JLabel goalMoney) {
		if (quest.getQ_qtyOfTap() < quest.getTap2()) {
		} else if (quest.getQ_qtyOfTap() >= quest.getTap2()) {
			main.setM_TotalOfMoney(main.getM_TotalOfMoney() + (quest.getReward2() * quest.getTap1()));
			JOptionPane.showMessageDialog(null, String.format("%,d", (quest.getReward2() * quest.getTap1()))+" ���� ������ �޾ҽ��ϴ�.",   
																"����", JOptionPane.WARNING_MESSAGE);
			goalTap.setText(quest.getTap2() + "");
			quest.setTap2(quest.getTap2() * 5);
			quest.setTap1(quest.getTap1() + 1);
			viewQuest( main,  ingTap,  goalTap,  ingMoney,  goalMoney);
			
		}
	}

	//-------------------------------------------------------------------------------

	//*********���� �ݾ� ��ǥġ �Ϸ� �� ���� �ݾ� �Ϸ� ��ư�� ���� ��� ȣ��Ǵ� �޼ҵ�_180707_1*************
	public void questAdd2(Main main, JLabel ingTap, JLabel goalTap, JLabel ingMoney, JLabel goalMoney) {
		if (main.getM_TotalOfMoney() < quest.getTemp2()) {
		}else if(main.getM_TotalOfMoney() >= quest.getTemp2()){
			main.setM_TotalOfMoney(main.getM_TotalOfMoney() + (quest.getReward1() * quest.getTemp1()));
			JOptionPane.showMessageDialog(null, String.format("%,d", (quest.getReward1() * quest.getTemp1()))+" ���� ������ �޾ҽ��ϴ�.",  
																"����", JOptionPane.WARNING_MESSAGE);
			goalMoney.setText(String.format("%,d", quest.getTemp2()));
			quest.setTemp2(quest.getTemp2() * 5);
			quest.setTemp1(quest.getTemp1() + 1);
			viewQuest( main,  ingTap,  goalTap,  ingMoney,  goalMoney);
		}
	}
	//-------------------------------------------------------------------------------

	//****************QuestJPanel JLabel�� ����, Quest��ü �� ����_180707_1***********
	public void viewQuest(Main main, JLabel ingTap, JLabel goalTap, JLabel ingMoney, JLabel goalMoney) {
		goalTap.setText(quest.getTap2() + "");
		ingTap.setText((quest.getQ_qtyOfTap() + 1) + "");
		quest.setQ_qtyOfTap(quest.getQ_qtyOfTap() + 1);
		goalMoney.setText(String.format("%,d", quest.getTemp2()));
		ingMoney.setText(String.format("%,d", main.getM_TotalOfMoney()));
		quest.setQ_qtyOfTotalMoney(main.getM_TotalOfMoney());
	}
	//--------------------------------------------------------------------------
}