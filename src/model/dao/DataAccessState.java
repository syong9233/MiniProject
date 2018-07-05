package model.dao;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

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
	
	public void extendLevelUp(Main main){	//ȸ��Ȯ�� ����
		int extendlevelMoney = 1500000 * state.getP_lvOfExtend();	//ȸ��Ȯ�� �ݾ�
		if(state.getP_lvOfExtend() < 10){
			if(main.getM_TotalOfMoney() > extendlevelMoney){	//�� �ݾ� > �����Ӵ�
				state.setP_lvOfExtend((byte)(state.getP_lvOfExtend() + 1));		//ȸ�� ���� +1
				main.setM_TotalOfMoney(main.getM_TotalOfMoney() - extendlevelMoney);	//���� �ݾ�. ��ü �� - �����Ӵ�
				main.setM_AmountOfAutoMoney(main.getM_AmountOfAutoMoney() * 20);//���� : ������ �ݾ�up
				System.out.println("ȸ�� Ȯ�� �Ϸ� (���� ȸ�� ���� : " + state.getP_lvOfExtend() + ")");
			}else{
				System.out.println("�ܾ��� �����մϴ�.(���� ȸ�� ���� :" + state.getP_lvOfExtend() + ")");
			}
		}else{
			System.out.println("10�����Դϴ�.");
		}
	}
	
	public void educateLevelUp(Main main){	//�����̼� ����
		int educateLevelMoney = 200000 * state.getP_lvOfEducate();				//�����̼� �ݾ�
		if(state.getP_lvOfExtend() > state.getP_lvOfEducate()){					//ȸ��Level > �����̼�Level
			if(main.getM_TotalOfMoney() > educateLevelMoney){					//��ü �� > �����̼� �ݾ�
				// ���� �ݾ�(��ü �� - (educateLevelMoney * �����̼� Level))
				main.setM_TotalOfMoney(main.getM_TotalOfMoney() - (200000 * state.getP_lvOfEducate()));	
				state.setP_lvOfEducate((byte)(state.getP_lvOfEducate() + 1));	//�����̼� ���� +1
				main.setM_AmountOfAutoMoney(main.getM_AmountOfAutoMoney() * 2);	//���� : ������x2
				System.out.println("�����̼� �Ϸ� (���� ���� �̼� ����" + state.getP_lvOfEducate() + ")");
			}else{
				System.out.println("�ܾ��� �����մϴ�. (���� ���� �̼� ���� " + state.getP_lvOfEducate() + ")");
			}
		}else{
			System.out.println("���� �Ұ��� (���� ���� �̼� ����" + state.getP_lvOfEducate() + ")");
		}
	}
	
	public void employLevelUp(Main main){	//������� ����
		int employLevelMoney = 300000 * state.getP_lvOfEmploy();				//������� �ݾ�
		if(state.getP_lvOfExtend() > state.getP_lvOfEmploy()){					//ȸ��Level > �������Level
			if(main.getM_TotalOfMoney() > employLevelMoney){					//��ü �� > ���ݾ�
				state.setP_lvOfEmploy((byte)(state.getP_lvOfEmploy() + 1));		//������� ���� +1
				main.setM_AmountOfTapMoney(main.getM_AmountOfTapMoney() * 2);	//���� : �� x 2
			}else{
				System.out.println("�ܾ��� �����մϴ�. (���� ���� ��� ����  : " + state.getP_lvOfEmploy() + ")");
			}
		}
	}

	public void computerLevelUp(Main main){	//��ǻ�ͻ�� ����
		if(state.getP_lvOfExtend() > state.getP_lvOfComputer()){
			state.setP_lvOfComputer((byte)(state.getP_lvOfComputer() + 1));	//��ǻ�� ��� ���� +1
			main.setM_TotalOfMoney(main.getM_TotalOfMoney() - (main.getM_TotalOfMoney() / 5));
		}
	}
	
	public void keyboardLevelUp(Main main){	//Ÿ�ڼ� ����
		if(state.getP_lvOfExtend() > state.getP_lvOfKeyboard()){
			state.setP_lvOfKeyboard((byte)(state.getP_lvOfKeyboard() + 1));	//Ÿ�ڼ� ���� +1
			main.setM_TotalOfMoney(main.getM_TotalOfMoney() - (main.getM_TotalOfMoney() / 5));
		}
	}
}
