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

		// temp1 = Äù½ºÆ® È½¼ö , temp2 = ¸ñÇ¥±Ý¾× , reward1 = º¸»ó
		// tap1 = Äù½ºÆ® È½¼ö , tap2 = ¸ñÇ¥ÅÇ¼ö , reward2 = º¸»ó

		quest.setQ_qtyOfTap(quest.getQ_qtyOfTap() + 1);
		System.out.println("ÅÇ¼ö : " + quest.getQ_qtyOfTap());
		System.out.println("ÇöÀç ±Ý¾× : " + main.getM_TotalOfMoney());

		if (quest.getTap1() < 11) {
			if (quest.getQ_qtyOfTap() == quest.getTap2()) {
				System.out.println("Äù½ºÆ® È½¼ö : " + quest.getTap1() + "/" + 10);
				System.out.println("ÃÑ ÅÇ : " + quest.getQ_qtyOfTap() + "È¸ ´Þ¼º!");
				totalTapQuest(main, button3);
			}

			if (quest.getQ_qtyOfTap() >= quest.getTap2()) {
				
				main.setM_TotalOfMoney(main.getM_TotalOfMoney() + (quest.getReward2() * quest.getTap1()));
				quest.setQ_qtyOfTotalMoney(main.getM_TotalOfMoney());
				System.out.println("º¸»ó ±Ý¾× : " + (quest.getReward2() * quest.getTap1()));
				System.out.println("ÃÑ ±Ý¾× : " + quest.getQ_qtyOfTotalMoney());

				quest.setTap2(quest.getTap2() * 5);
				quest.setTap1(quest.getTap1() + 1);

			}
		}
	}

	public void questAdd2(DataAccessMain main, TotalMoneyJLabel totalMoneyJLabel) {

		if (quest.getTemp1() < 11) {
			if (quest.getQ_qtyOfTotalMoney() >= quest.getTemp2()) {
				System.out.println("Äù½ºÆ® È½¼ö : " + quest.getTemp1() + "/" + 10);
				System.out.println("¸ñÇ¥±Ý¾× : " + quest.getTemp2() + quest.getTemp2());
				System.out.println("ÃÑ È¹µæ ±Ý¾× Äù½ºÆ®" + quest.getTemp1() + "¿Ï¼º!");
				main.getMain().setM_TotalOfMoney(
						main.getMain().getM_TotalOfMoney() + (quest.getReward1() * quest.getTemp1()));
				totalMoneyJLabel.setText(String.format("%,d", main.getMain().getM_TotalOfMoney()) + " : º¸À¯");
				System.out.println("ÃÑ±Ý¾× : " + main.getMain().getM_TotalOfMoney());
				quest.setTemp2(quest.getTemp2() * 5);
				quest.setTemp1(quest.getTemp1() + 1);
			}
		}

	}

	public void choice(ActionEvent e, Main main, JButton button3, JButton button4) {
		if (e.getActionCommand().equals("Äù½ºÆ® ¿Ï·á1")) {
			this.totalTapQuest(main, button3);
		} else if (e.getActionCommand().equals("Äù½ºÆ® ¿Ï·á2")) {
			this.totalGetMoney(main, button4);
		}

	}

	public void totalTapQuest (Main main, JButton button3) {
		System.out.println("¹öÆ°3¹ø´­¸²");
		
		// ¹öÆ°3 ´­·¶À»¶§ ±¸Çö
		
		if(quest.getQ_qtyOfTap() < quest.getTap2()){
			
			button3.setEnabled(false);
			
		}else if(quest.getQ_qtyOfTap() >= quest.getTap2()){
			
			button3.setEnabled(true);
			
		}
	
		
		
	}
		

	public void totalGetMoney(Main main, JButton button4) {
		// ¹öÆ°4 ´­·¶À»¶§ ±¸Çö
	}



}
