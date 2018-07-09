package model.vo;

public class Quest {
	private int q_qtyOfTap;
	private long q_qtyOfTotalMoney;
	private int temp1 = 1, temp2 = 500000, reward1 = 500000;
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
