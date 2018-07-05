package model.dao;


import java.awt.event.ActionEvent;

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
	
	// ***************���� ��ư ���̽�****************
	public void choice(ActionEvent e, Main main){
		if(e.getActionCommand().equals("ȸ�� Ȯ��")){
			this.extendLevelUp(main);
		}else if(e.getActionCommand().equals("���� �̼�")){
			this.educateLevelUp(main);
		}else if(e.getActionCommand().equals("���� ���")){
			this.employLevelUp(main);
		}else if(e.getActionCommand().equals("��ǻ�� ���")){
			this.computerLevelUp(main);
		}else if(e.getActionCommand().equals("Ÿ�ڼ�")){
			this.keyboardLevelUp(main);
		}
	}
	
	// ***************ȸ��Ȯ�� ����****************
	public void extendLevelUp(Main main){
		
		int extendlevelMoney = 1500000 * state.getP_lvOfExtend();					//ȸ��Ȯ�� �ݾ�
		if(state.getP_lvOfExtend() < 10){												//ȸ��Level < 10
			if(main.getM_TotalOfMoney() > extendlevelMoney){							//�� �ݾ� > �����Ӵ�
				main.setM_TotalOfMoney(main.getM_TotalOfMoney() - extendlevelMoney);	//���� �ݾ�. ��ü �� - �����Ӵ�
				state.setP_lvOfExtend((byte)(state.getP_lvOfExtend() + 1));				//ȸ�� ���� +1
				main.setM_AmountOfAutoMoney(main.getM_AmountOfAutoMoney() * 10);		//���� : ������ x 10
				System.out.println("ȸ�� Ȯ�� �Ϸ� (���� ȸ�� ���� : " + state.getP_lvOfExtend() + ")");
			}else{
				System.out.println("�ܾ��� �����մϴ�.(���� ȸ�� ���� :" + state.getP_lvOfExtend() + ")");
			}
		}else{
			System.out.println("10�����Դϴ�.");
		}
	}
	
	// ***************�����̼� ����****************
	public void educateLevelUp(Main main){ 
		int educateLevelMoney = 200000 * state.getP_lvOfEducate();						//�����̼� �ݾ�
		if(state.getP_lvOfExtend() > state.getP_lvOfEducate()){							//ȸ��Level > �����̼�Level
			if(main.getM_TotalOfMoney() > educateLevelMoney){							//��ü �� > �����̼� �ݾ�
				main.setM_TotalOfMoney(main.getM_TotalOfMoney() - educateLevelMoney);	//��ü�ݾ� - �����̼� �ݾ�
				state.setP_lvOfEducate((byte)(state.getP_lvOfEducate() + 1));			//�����̼� ���� +1
				main.setM_AmountOfAutoMoney(main.getM_AmountOfAutoMoney() * 2);			//���� : ������ x 2
				System.out.println("�����̼� �Ϸ� (���� ���� �̼� ����" + state.getP_lvOfEducate() + ")");
			}else{
				System.out.println("�ܾ��� �����մϴ�. (���� ���� �̼� ���� " + state.getP_lvOfEducate() + ")");
			}
		}else{
			System.out.println("���� �Ұ��� (���� ���� �̼� ����" + state.getP_lvOfEducate() + ")");
		}
	}
	
	// ***************������� ����****************
	public void employLevelUp(Main main){
		int employLevelMoney = 300000 * state.getP_lvOfEmploy();						//������� �ݾ�
		if(state.getP_lvOfExtend() > state.getP_lvOfEmploy()){							//ȸ��Level > �������Level
			if(main.getM_TotalOfMoney() > employLevelMoney){							//��ü �� > ���ݾ�
				main.setM_TotalOfMoney(main.getM_TotalOfMoney() - employLevelMoney);	//��ü�ݾ� - ������� �ݾ�
				state.setP_lvOfEmploy((byte)(state.getP_lvOfEmploy() + 1));				//������� ���� +1
				main.setM_AmountOfTapMoney(main.getM_AmountOfTapMoney() * 2);			//���� : �� x 2
				System.out.println("������� �Ϸ� (���� ���� :" + state.getP_lvOfEmploy() + ")");
			}else{
				System.out.println("�ܾ��� �����մϴ�. (���� ���� ��� ����  : " + state.getP_lvOfEmploy() + ")");
			}
		}else{
			System.out.println("���� �Ұ��� (���� ���� ��� ���� : " + state.getP_lvOfEmploy() + ")");
		}
	}
	
	// ***************��ǻ�ͻ�� ����****************
	public void computerLevelUp(Main main){
		int computerLevelMoney = 300000 * state.getP_lvOfComputer();					//��ǻ�ͻ�� �ݾ�
		if(state.getP_lvOfExtend() > state.getP_lvOfComputer()){						//ȸ��Level > ��ǻ�ͻ��Level
			if(main.getM_TotalOfMoney() > computerLevelMoney){							//��ü�� > ��ǻ�ͻ�� �ݾ�
				main.setM_TotalOfMoney(main.getM_TotalOfMoney() - computerLevelMoney);	//��ü�ݾ� - ��ǻ�� �ݾ�
				state.setP_lvOfComputer((byte)(state.getP_lvOfComputer() + 1));			//��ǻ�� ��� ���� +1
				main.setM_AmountOfTapMoney(main.getM_AmountOfTapMoney() * 2);			//����: �� x 2
				System.out.println("��ǻ�ͻ�� �Ϸ� (���� ���� : "+ state.getP_lvOfComputer() + ")" );
			}else{
				System.out.println("�ܾ��� �����մϴ�. (���� ��ǻ�ͻ�� ���� : " + state.getP_lvOfComputer() + ")");
			}
		}else{
			System.out.println("���� �Ұ��� (���� ��ǻ�ͻ�� : " + state.getP_lvOfComputer() + ")");
		}
	}
	
	// ***************Ÿ�ڼ� ����****************
	public void keyboardLevelUp(Main main){	
		int keyboardLevelMoney = 300000 * state.getP_lvOfKeyboard();					//Ÿ�ڼ� �ݾ�
		if(state.getP_lvOfExtend() > state.getP_lvOfKeyboard()){						//ȸ��Level > Ÿ�ڼ�Level
			if(main.getM_TotalOfMoney() > keyboardLevelMoney){							//��ü�� > Ÿ�ڼ� �ݾ�
				main.setM_TotalOfMoney(main.getM_TotalOfMoney() - keyboardLevelMoney);	//��ü�ݾ� - Ÿ�ڼ� �ݾ�
				state.setP_lvOfKeyboard((byte)(state.getP_lvOfKeyboard() + 1));			//Ÿ�ڼ� ���� +1
				main.setM_AmountOfTapMoney(main.getM_AmountOfTapMoney() * 2);			//����: �� x 2
				System.out.println("Ÿ�ڼ� �Ϸ� (���� ���� : " + state.getP_lvOfKeyboard() + ")");
			}else{
				System.out.println("�ܾ��� �����մϴ�. (���� Ÿ�ڼ� ���� : " + state.getP_lvOfKeyboard() + ")");
			}
		}else{
			System.out.println("���� �Ұ��� (���� Ÿ�ڼ� : " + state.getP_lvOfKeyboard() + ")");
		}
	}
}
