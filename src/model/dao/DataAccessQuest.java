package model.dao;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.vo.Main;
import model.vo.Quest;
import view.jlabel.TotalMoneyJLabel;


public class DataAccessQuest {
	private Quest quest;

	public DataAccessQuest(){
		quest = new Quest();
	}

	public Quest getQuest(){
		return quest;
	}
	
	//********************��� �Ϸ� ��ư�� ���� ������ üũ_180707_1************************
	public void qChoice(ActionEvent e, Main main, JButton button1, JButton button2) {
		if (e.getActionCommand().equals("T�Ϸ�")) {
			this.questAdd(main, button1);
		} else if (e.getActionCommand().equals("M�Ϸ�")) {
			this.questAdd2(main, button2);
		}
	}
	//------------------------------------------------------------------------

	//**************�� ��ǥġ �Ϸ� �� �� �Ϸ� ��ư�� ���� ��� ȣ��Ǵ� �޼ҵ�_180707_1******************
	public void questAdd(Main main, JButton button1) {
		if (quest.getQ_qtyOfTap() < quest.getTap2()) {
		} else if (quest.getQ_qtyOfTap() >= quest.getTap2()) {
			main.setM_TotalOfMoney(main.getM_TotalOfMoney() + (quest.getReward2() * quest.getTap1()));
			JOptionPane.showMessageDialog(null, (quest.getReward2() * quest.getTap1())+" ���� ������ �޾ҽ��ϴ�.",   "����", JOptionPane.WARNING_MESSAGE);
			quest.setTap2(quest.getTap2() * 5);
			quest.setTap1(quest.getTap1() + 1);
		}
	}
	//-------------------------------------------------------------------------------

	//*********���� �ݾ� ��ǥġ �Ϸ� �� ���� �ݾ� �Ϸ� ��ư�� ���� ��� ȣ��Ǵ� �޼ҵ�_180707_1*************
	public void questAdd2(Main main, JButton button2) {
		if (main.getM_TotalOfMoney() < quest.getTemp2()) {
		}else if(main.getM_TotalOfMoney() >= quest.getTemp2()){
			main.setM_TotalOfMoney(main.getM_TotalOfMoney() + (quest.getReward1() * quest.getTemp1()));
			JOptionPane.showMessageDialog(null, (quest.getReward1() * quest.getTemp1())+" ���� ������ �޾ҽ��ϴ�.",   "����", JOptionPane.WARNING_MESSAGE);
			quest.setTemp2(quest.getTemp2() * 5);
			quest.setTemp1(quest.getTemp1() + 1);
		}
	}
	//-------------------------------------------------------------------------------

	//****************QuestJPanel JLabel�� ����, Quest��ü �� ����_180707_1***********
	public void viewQuest(Main main, TotalMoneyJLabel totalMoneyJLabel, JLabel ingTap, JLabel goalTap, JLabel ingMoney, JLabel goalMoney) {
		goalTap.setText(quest.getTap2() + " ȸ");
		ingTap.setText((quest.getQ_qtyOfTap() + 1) + " ȸ");
		quest.setQ_qtyOfTap(quest.getQ_qtyOfTap() + 1);
		goalMoney.setText(String.format("%,d", quest.getTemp2()));
		ingMoney.setText(String.format("%,d", main.getM_TotalOfMoney()));
		quest.setQ_qtyOfTotalMoney(main.getM_TotalOfMoney());
	}
	//--------------------------------------------------------------------------
}