package model.dao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.vo.Main;
import model.vo.Quest;
import view.View;
import view.jlabel.TotalMoneyJLabel;

public class DataAccessQuest{
	private Quest quest;

	public DataAccessQuest() {
		quest = new Quest();
	}

	public Quest getQuest() {
		return quest;
	}

	public void questAdd(Main main, TotalMoneyJLabel totalMoneyJLabel, JButton button3) {

		// temp1 = ����Ʈ Ƚ�� , temp2 = ��ǥ�ݾ� , reward1 = ����
		// tap1 = ����Ʈ Ƚ�� , tap2 = ��ǥ�Ǽ� , reward2 = ����

		quest.setQ_qtyOfTap(quest.getQ_qtyOfTap() + 1);
		System.out.println("�Ǽ� : " + quest.getQ_qtyOfTap());
		System.out.println("���� �ݾ� : " + main.getM_TotalOfMoney());

		if (quest.getTap1() < 11) {
			if (quest.getQ_qtyOfTap() == quest.getTap2()) {
				System.out.println("����Ʈ Ƚ�� : " + quest.getTap1() + "/" + 10);
				System.out.println("�� �� : " + quest.getQ_qtyOfTap() + "ȸ �޼�!");
				totalTapQuest(main, button3);
			}

			if (quest.getQ_qtyOfTap() >= quest.getTap2()) {
				
				main.setM_TotalOfMoney(main.getM_TotalOfMoney() + (quest.getReward2() * quest.getTap1()));
				quest.setQ_qtyOfTotalMoney(main.getM_TotalOfMoney());
				System.out.println("���� �ݾ� : " + (quest.getReward2() * quest.getTap1()));
				System.out.println("�� �ݾ� : " + quest.getQ_qtyOfTotalMoney());

				quest.setTap2(quest.getTap2() * 5);
				quest.setTap1(quest.getTap1() + 1);

			}
		}
	}

	public void questAdd2(DataAccessMain main, TotalMoneyJLabel totalMoneyJLabel) {

		if (quest.getTemp1() < 11) {
			if (quest.getQ_qtyOfTotalMoney() >= quest.getTemp2()) {
				System.out.println("����Ʈ Ƚ�� : " + quest.getTemp1() + "/" + 10);
				System.out.println("��ǥ�ݾ� : " + quest.getTemp2() + quest.getTemp2());
				System.out.println("�� ȹ�� �ݾ� ����Ʈ" + quest.getTemp1() + "�ϼ�!");
				main.getMain().setM_TotalOfMoney(
						main.getMain().getM_TotalOfMoney() + (quest.getReward1() * quest.getTemp1()));
				totalMoneyJLabel.setText(String.format("%,d", main.getMain().getM_TotalOfMoney()) + " : ����");
				System.out.println("�ѱݾ� : " + main.getMain().getM_TotalOfMoney());
				quest.setTemp2(quest.getTemp2() * 5);
				quest.setTemp1(quest.getTemp1() + 1);
			}
		}

	}

	public void choice(ActionEvent e, Main main, JButton button3, JButton button4) {
		if (e.getActionCommand().equals("����Ʈ �Ϸ�1")) {
			this.totalTapQuest(main, button3);
		} else if (e.getActionCommand().equals("����Ʈ �Ϸ�2")) {
			this.totalGetMoney(main, button4);
		}

	}

	public void totalTapQuest (Main main, JButton button3) {
		System.out.println("��ư3������");
		
		// ��ư3 �������� ����
		
		if(quest.getQ_qtyOfTap() < quest.getTap2()){
			
			button3.setEnabled(false);
			
		}else if(quest.getQ_qtyOfTap() >= quest.getTap2()){
			
			button3.setEnabled(true);
			
		}
	
		
		
	}
		

	public void totalGetMoney(Main main, JButton button4) {
		// ��ư4 �������� ����
	}



}
