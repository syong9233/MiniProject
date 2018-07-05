package model.vo;

import javax.swing.JButton;
import javax.swing.JProgressBar;

import model.dao.DataAccessMain;

public class Quest {
	private int q_qtyOfTap;
	private long q_qtyOfTotalMoney;
	private JButton button1 = new JButton("ÅÇ ¼ö");
	private JButton button2 = new JButton("±Ý¾× ¾ç");
	//private JButton button3 = new JButton("Äù½ºÆ® ¿Ï·á1");
	//private JButton button4 = new JButton("Äù½ºÆ® ¿Ï·á2");
	private JProgressBar q_pb1 = new JProgressBar(); 
	private JProgressBar q_pb2 = new JProgressBar(); 
	
	
	public JButton getButton1() {
		return button1;
	}

	public JButton getButton2() {
		return button2;
	}

	public JProgressBar getQ_pb1() {
		return q_pb1;
	}

	public JProgressBar getQ_pb2() {
		return q_pb2;
	}

	public void setButton1(JButton button1) {
		this.button1 = button1;
	}

	public void setButton2(JButton button2) {
		this.button2 = button2;
	}

	public void setQ_pb1(JProgressBar q_pb1) {
		this.q_pb1 = q_pb1;
	}

	public void setQ_pb2(JProgressBar q_pb2) {
		this.q_pb2 = q_pb2;
	}

	//temp1 = Äù½ºÆ® È½¼ö , temp2 = ¸ñÇ¥±Ý¾× , reward1 = º¸»ó
	private int temp1 = 1, temp2 = 500000, reward1 = 500000;
	//tap1 = Äù½ºÆ® È½¼ö , tap2 = ¸ñÇ¥ÅÇ¼ö , reward2 = º¸»ó
	private int tap1 = 1, tap2 = 30, reward2 = 150000;
	
	public int getTemp1() {
		return temp1;
	}

	public int getTemp2() {
		return temp2;
	}

	public int getReward1() {
		return reward1;
	}

	public int getTap1() {
		return tap1;
	}

	public int getTap2() {
		return tap2;
	}

	public int getReward2() {
		return reward2;
	}

	public void setTemp1(int temp1) {
		this.temp1 = temp1;
	}

	public void setTemp2(int temp2) {
		this.temp2 = temp2;
	}

	public void setReward1(int reward1) {
		this.reward1 = reward1;
	}

	public void setTap1(int tap1) {
		this.tap1 = tap1;
	}

	public void setTap2(int tap2) {
		this.tap2 = tap2;
	}

	public void setReward2(int reward2) {
		this.reward2 = reward2;
	}

	public int getQ_qtyOfTap() {
		return q_qtyOfTap;
	}

	public void setQ_qtyOfTap(int q_qtyOfTap) {
		this.q_qtyOfTap = q_qtyOfTap;
	}
	
	public long getQ_qtyOfTotalMoney(){
		return q_qtyOfTotalMoney;
	}
	
	public void setQ_qtyOfTotalMoney(long q_qtyOfTotalMoney) {
		this.q_qtyOfTotalMoney = q_qtyOfTotalMoney;
	}
}
