package model.dao;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;

import model.vo.Main;
import model.vo.Quest;
import view.View;
import view.jlabel.TotalMoneyJLabel;

public class DataAccessQuest {
	private Quest quest;
	
	public DataAccessQuest(){
		quest = new Quest();
	}
	
	public Quest getQuest(){
		return quest;
	}
	
public void questAdd(DataAccessMain main, TotalMoneyJLabel totalMoneyJLabel) {
		
		quest.setQ_qtyOfTap(quest.getQ_qtyOfTap() + 1);
		System.out.println("�Ǽ� : " + quest.getQ_qtyOfTap());
		if(quest.getTap1() < 11){
			if(quest.getQ_qtyOfTap() >= quest.getTap2()){
				System.out.println("����Ʈ Ƚ�� : " + quest.getTap1() +"/"+ 10);
				System.out.println("�� �� : " + quest.getQ_qtyOfTap() + "ȸ �޼�!");
				main.getMain().setM_TotalOfMoney(main.getMain().getM_TotalOfMoney() + (quest.getReward2() * quest.getTap1()));
				quest.setTap2(quest.getTap2() * 5 );
				quest.setTap1(quest.getTap1() +1);
			}	
		}	
	}
	

	public void questAdd2(DataAccessMain main, TotalMoneyJLabel totalMoneyJLabel) {
		quest.setQ_qtyOfTotalMoney(main.getMain().getM_TotalOfMoney());
		System.out.println("�� �ݾ� : " + quest.getQ_qtyOfTotalMoney());
		
		if(quest.getTap1() < 11){
			if(quest.getQ_qtyOfTotalMoney() >= quest.getTemp2()){
				System.out.println("����Ʈ Ƚ�� : " + quest.getTemp1() +"/"+10);
				System.out.println("��ǥ�ݾ� : " + quest.getTemp2() + quest.getTemp2());
				System.out.println("�� ȹ�� �ݾ� ����Ʈ"+ quest.getTemp1() +"�ϼ�!");
				main.getMain().setM_TotalOfMoney(main.getMain().getM_TotalOfMoney() + (quest.getReward1() * quest.getTemp1()));
				totalMoneyJLabel.setText(String.format("%,d", main.getMain().getM_TotalOfMoney()) + " : ����");
				System.out.println("�ѱݾ� : " + main.getMain().getM_TotalOfMoney());
				quest.setTemp2(quest.getTemp2() * 5);
				quest.setTemp1(quest.getTemp1() + 1);
			}
		}
		
	}
	public void questBar(DataAccessMain main){
		
    /*setLayout(null);
    setBounds(3, 300, 338, 268);
    setBackground(new Color(100, 100, 100));*/
    quest.getQ_pb1().setMinimum(quest.getQ_qtyOfTap());
    Integer pb2 = (int)(long)main.getMain().getM_TotalOfMoney();
    quest.getQ_pb2().setMinimum(pb2);
    quest.getQ_pb1().setMaximum(quest.getTap2());
    quest.getQ_pb2().setMaximum((int)quest.getTemp2());
    quest.getQ_pb1().setStringPainted(true);
    quest.getQ_pb2().setStringPainted(true);
    
    quest.getQ_pb1().setString(quest.getQ_qtyOfTap()+"/"+quest.getTap2());
    if(quest.getTemp2()/((100000000)*(100000000)) >= 1){
    	quest.getQ_pb2().setString(main.getMain().getM_TotalOfMoney()+"/"+(quest.getTemp2()/((100000000)*(100000000)))+"��");
    }else if(quest.getTemp2()/((1000000)*(1000000)) >= 1){
    	 quest.getQ_pb2().setString(main.getMain().getM_TotalOfMoney()+"/"+(quest.getTemp2()/((1000000)*(1000000)))+"��");
    }else if(quest.getTemp2()/((10000)*(10000)) >=1){
    	 quest.getQ_pb2().setString(main.getMain().getM_TotalOfMoney()+"/"+(quest.getTemp2()/((10000)*(10000)))+"��");
    }else if(quest.getTemp2()/ 10000 >= 1){
    	 quest.getQ_pb2().setString(main.getMain().getM_TotalOfMoney()+"/"+(quest.getTemp2()/10000)+"��");
    }
    
    while( quest.getQ_pb1().getMinimum() <=  quest.getQ_pb1().getMaximum()){
       
    }
    
    
    
	
 }



public void choice(ActionEvent e, Main main) {
	if(e.getActionCommand().equals("����Ʈ �Ϸ�1")){//��ư�޴°�
		this.totalTapQuest(main);
	}else if(e.getActionCommand().equals("����Ʈ �Ϸ�2")){
		this.totalGetMoney(main);
	}
	
	
}

public void totalTapQuest(Main main){
	//��ư1 �������� ����
	//���ϸ� ���� �޼ҵ忡�� ����Ʈ �޼ҵ�(quest dao)�� �ҷ��;���.
	if(quest.getTap1() < 11){
		if(quest.getQ_qtyOfTap() >= quest.getTap2()){
			System.out.println("����Ʈ Ƚ�� : " + quest.getTap1() +"/"+ 10);
			System.out.println("�� �� : " + quest.getQ_qtyOfTap() + "ȸ �޼�!");
			main.setM_TotalOfMoney(main.getM_TotalOfMoney() + (quest.getReward2() * quest.getTap1()));
			quest.setTap2(quest.getTap2() * 5 );
			quest.setTap1(quest.getTap1() +1);
		}	
	}	
}

public void totalGetMoney(Main main){
	//��ư2 �������� ����
}
}












































