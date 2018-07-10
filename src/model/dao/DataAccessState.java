package model.dao;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import model.vo.Main;
import model.vo.State;
import view.View;
import view.jlabel.AutoMoneyJLabel;
import view.jlabel.NicknameJLabel;
import view.jlabel.TapMoneyJLabel;
import view.jlabel.TotalMoneyJLabel;
import view.jpanel.MainJPanel;
import view.jpanel.StateJPanel;

public class DataAccessState {
	private State state;

	public DataAccessState(){
		state = new State();
	}

	public State getState(){
		return state;
	}

	// ***************���� ��ư ���̽�****************
	public void choice(String choice, Main main, JProgressBar stateBar, 
			MainJPanel mainJPanel, StateJPanel stateJPanel, View view,
			NicknameJLabel nicknameJLabel, TotalMoneyJLabel totalMoneyJLabel,
			AutoMoneyJLabel autoMoneyJLabel, TapMoneyJLabel tapMoneyJLabel){
		if(choice.equals("ȸ�� Ȯ��")){
			extendLevelUp(main, stateBar, mainJPanel, stateJPanel, view, totalMoneyJLabel,
					nicknameJLabel, autoMoneyJLabel, tapMoneyJLabel);
		}else if(choice.equals("���� �̼�")){
			educateLevelUp(main, stateBar, autoMoneyJLabel, tapMoneyJLabel);
		}else if(choice.equals("���� ���")){
			employLevelUp(main, stateBar, autoMoneyJLabel, tapMoneyJLabel);
		}else if(choice.equals("��ǻ�� ���")){
			computerLevelUp(main, stateBar, autoMoneyJLabel, tapMoneyJLabel);
		}else if(choice.equals("Ÿ�ڼ�")){
			keyboardLevelUp(main, stateBar, autoMoneyJLabel, tapMoneyJLabel);
		}
	}
	// ***************180710_ȸ��Ȯ�� ����_�� ����(ȸ��Level * 2õ����, ����:�� x3)****************
	public void extendLevelUp(Main main, JProgressBar extendBar, MainJPanel mainJPanel,
			StateJPanel stateJPanel, View view, TotalMoneyJLabel totalMoneyJLabel,
			NicknameJLabel nicknameJLabel, AutoMoneyJLabel autoMoneyJLabel, TapMoneyJLabel tapMoneyJLabel){
		JLabel lv3JBackImageLabel = new JLabel(new ImageIcon(new ImageIcon("image/main/final_lv3.png").getImage().getScaledInstance(338, 600, java.awt.Image.SCALE_SMOOTH)));
		JLabel lv5JBackImageLabel = new JLabel(new ImageIcon(new ImageIcon("image/main/final_lv5.png").getImage().getScaledInstance(338, 600, java.awt.Image.SCALE_SMOOTH)));
		JLabel lv7JBackImageLabel = new JLabel(new ImageIcon(new ImageIcon("image/main/final_lv7.png").getImage().getScaledInstance(338, 600, java.awt.Image.SCALE_SMOOTH)));
		JLabel lv10JBackImageLabel = new JLabel(new ImageIcon(new ImageIcon("image/main/final_lv3.png").getImage().getScaledInstance(338, 600, java.awt.Image.SCALE_SMOOTH)));

		lv3JBackImageLabel.setSize(338, 600);
		lv5JBackImageLabel.setSize(338, 600);
		lv7JBackImageLabel.setSize(338, 600);
		lv10JBackImageLabel.setSize(338, 600);
		
		lv3JBackImageLabel.setLocation(0, -30);
		lv5JBackImageLabel.setLocation(0, -30);
		lv7JBackImageLabel.setLocation(0, -30);
		lv10JBackImageLabel.setLocation(0, -30);

		if(state.getP_lvOfExtend() < 10){                                    //ȸ��Level < 10
			if(main.getM_TotalOfMoney() > (state.getP_lvOfExtend()* 20000000)){                     //�� �ݾ� > �����Ӵ�
				main.setM_TotalOfMoney(main.getM_TotalOfMoney() - (state.getP_lvOfExtend()* 20000000));   //���� �ݾ�. ��ü �� - �����Ӵ�
				state.setP_lvOfExtend((byte)(state.getP_lvOfExtend() + 1));            //ȸ�� ���� +1
				main.setM_AmountOfTapMoney(main.getM_AmountOfTapMoney() * 3);      //���� : �� x 3
				System.out.println(main.getM_AmountOfAutoMoney());
				extendBar.setValue(state.getP_lvOfExtend());                     
				extendBar.setString(state.getP_lvOfExtend() + "/" + extendBar.getMaximum());//1/10 bar�߰�
				View.cm().setMoneyJLabel(autoMoneyJLabel, tapMoneyJLabel);
				System.out.println("ȸ�� Ȯ�� �Ϸ� (���� ȸ�� ���� : " + state.getP_lvOfExtend() + ")");
			}else{
				System.out.println("�ܾ��� �����մϴ�.(���� ȸ�� ���� :" + state.getP_lvOfExtend() + ")");
			}
		}else{
			System.out.println("10�����Դϴ�.");
		}

		if(state.getP_lvOfExtend() == 2){
			mainJPanel.removeAll();
			mainJPanel.add(nicknameJLabel); 
			mainJPanel.add(totalMoneyJLabel);
			mainJPanel.add(autoMoneyJLabel);
			mainJPanel.add(tapMoneyJLabel);
			mainJPanel.add(lv3JBackImageLabel);
			view.add(stateJPanel);
			view.add(mainJPanel);
			view.repaint();
		}else if(state.getP_lvOfExtend() == 5){
			mainJPanel.removeAll();
			mainJPanel.add(nicknameJLabel); 
			mainJPanel.add(totalMoneyJLabel);
			mainJPanel.add(autoMoneyJLabel);
			mainJPanel.add(tapMoneyJLabel);
			mainJPanel.add(lv5JBackImageLabel);
			view.add(stateJPanel);
			view.add(mainJPanel);
			view.repaint();
		}else if(state.getP_lvOfExtend() == 7){
			mainJPanel.removeAll();
			mainJPanel.add(nicknameJLabel); 
			mainJPanel.add(totalMoneyJLabel);
			mainJPanel.add(autoMoneyJLabel);
			mainJPanel.add(tapMoneyJLabel);
			mainJPanel.add(lv7JBackImageLabel);
			view.add(stateJPanel);
			view.add(mainJPanel);
			view.repaint();
		}else if(state.getP_lvOfExtend() == 10){
			mainJPanel.removeAll();
			mainJPanel.add(nicknameJLabel); 
			mainJPanel.add(totalMoneyJLabel);
			mainJPanel.add(autoMoneyJLabel);
			mainJPanel.add(tapMoneyJLabel);
			mainJPanel.add(lv10JBackImageLabel);
			view.add(stateJPanel);
			view.add(mainJPanel);
			view.repaint();
		}
	}

	// ***************180710_�����̼� ����_�� ����(�����̼�Level * 800����, ����:������ x5)****************
	public void educateLevelUp(Main main, JProgressBar educateBar, AutoMoneyJLabel autoMoneyJLabel, TapMoneyJLabel tapMoneyJLabel){ 
		int educateLevelMoney = 8000000 * state.getP_lvOfEducate();                  //�����̼� �ݾ�
		if(state.getP_lvOfExtend() > state.getP_lvOfEducate()){                     //ȸ��Level > �����̼�Level
			if(main.getM_TotalOfMoney() > educateLevelMoney){                     //��ü �� > �����̼� �ݾ�
				main.setM_TotalOfMoney(main.getM_TotalOfMoney() - educateLevelMoney);   //��ü�ݾ� - �����̼� �ݾ�
				state.setP_lvOfEducate((byte)(state.getP_lvOfEducate() + 1));         //�����̼� ���� +1
				main.setM_AmountOfAutoMoney(main.getM_AmountOfAutoMoney() * 5);         //���� : ������ x 5
				educateBar.setValue(state.getP_lvOfEducate());
				educateBar.setString(state.getP_lvOfEducate() + "/" + educateBar.getMaximum());
				View.cm().setMoneyJLabel(autoMoneyJLabel, tapMoneyJLabel);
				System.out.println("�����̼� �Ϸ� (���� ���� �̼� ����" + state.getP_lvOfEducate() + ")");
			}else{
				System.out.println("�ܾ��� �����մϴ�. (���� ���� �̼� ���� " + state.getP_lvOfEducate() + ")");
			}
		}else{
			System.out.println("���� �Ұ��� (���� ���� �̼� ����" + state.getP_lvOfEducate() + ")");
		}
	}

	// ***************180710_������� ����_�� ����(�������Level * 1000����, ����:�� x2)****************
	public void employLevelUp(Main main, JProgressBar employBar, AutoMoneyJLabel autoMoneyJLabel, TapMoneyJLabel tapMoneyJLabel){
		int employLevelMoney = 10000000 * state.getP_lvOfEmploy();                  //������� �ݾ�
		if(state.getP_lvOfExtend() > state.getP_lvOfEmploy()){                     //ȸ��Level > �������Level
			if(main.getM_TotalOfMoney() > employLevelMoney){                     //��ü �� > ���ݾ�
				main.setM_TotalOfMoney(main.getM_TotalOfMoney() - employLevelMoney);   //��ü�ݾ� - ������� �ݾ�
				state.setP_lvOfEmploy((byte)(state.getP_lvOfEmploy() + 1));            //������� ���� +1
				main.setM_AmountOfTapMoney(main.getM_AmountOfTapMoney() * 2);         //���� : �� x 2
				employBar.setValue(state.getP_lvOfEmploy());
				employBar.setString(state.getP_lvOfEmploy() + "/" + employBar.getMaximum());
				View.cm().setMoneyJLabel(autoMoneyJLabel, tapMoneyJLabel);
				System.out.println("������� �Ϸ� (���� ���� :" + state.getP_lvOfEmploy() + ")");
			}else{
				System.out.println("�ܾ��� �����մϴ�. (���� ���� ��� ����  : " + state.getP_lvOfEmploy() + ")");
			}
		}else{
			System.out.println("���� �Ұ��� (���� ���� ��� ���� : " + state.getP_lvOfEmploy() + ")");
		}
	}

	// ***************180710_��ǻ�� ����_�� ����(��ǻ��Level * 700����, ����:������ x4)****************
	public void computerLevelUp(Main main, JProgressBar computerBar, AutoMoneyJLabel autoMoneyJLabel, TapMoneyJLabel tapMoneyJLabel){
		int computerLevelMoney = 7000000 * state.getP_lvOfComputer();               //��ǻ�ͻ�� �ݾ�
		if(state.getP_lvOfExtend() > state.getP_lvOfComputer()){                  //ȸ��Level > ��ǻ�ͻ��Level
			if(main.getM_TotalOfMoney() > computerLevelMoney){                     //��ü�� > ��ǻ�ͻ�� �ݾ�
				main.setM_TotalOfMoney(main.getM_TotalOfMoney() - computerLevelMoney);   //��ü�ݾ� - ��ǻ�� �ݾ�
				state.setP_lvOfComputer((byte)(state.getP_lvOfComputer() + 1));         //��ǻ�� ��� ���� +1
				main.setM_AmountOfAutoMoney(main.getM_AmountOfAutoMoney() * 4);         //����: ������ x 4
				computerBar.setValue(state.getP_lvOfComputer());
				computerBar.setString(state.getP_lvOfComputer() + "/" + computerBar.getMaximum());
				View.cm().setMoneyJLabel(autoMoneyJLabel, tapMoneyJLabel);
				System.out.println("��ǻ�ͻ�� �Ϸ� (���� ���� : "+ state.getP_lvOfComputer() + ")" );
			}else{
				System.out.println("�ܾ��� �����մϴ�. (���� ��ǻ�ͻ�� ���� : " + state.getP_lvOfComputer() + ")");
			}
		}else{
			System.out.println("���� �Ұ��� (���� ��ǻ�ͻ�� : " + state.getP_lvOfComputer() + ")");
		}
	}

	// ***************180710_Ÿ�ڼ� ����_�� ����(Ÿ�ڼ�Level * 700����, ����:������ x4)****************
	public void keyboardLevelUp(Main main, JProgressBar keyboardBar, AutoMoneyJLabel autoMoneyJLabel, TapMoneyJLabel tapMoneyJLabel){   
		int keyboardLevelMoney = 7000000 * state.getP_lvOfKeyboard();               //Ÿ�ڼ� �ݾ�
		if(state.getP_lvOfExtend() > state.getP_lvOfKeyboard()){                  //ȸ��Level > Ÿ�ڼ�Level
			if(main.getM_TotalOfMoney() > keyboardLevelMoney){                     //��ü�� > Ÿ�ڼ� �ݾ�
				main.setM_TotalOfMoney(main.getM_TotalOfMoney() - keyboardLevelMoney);   //��ü�ݾ� - Ÿ�ڼ� �ݾ�
				state.setP_lvOfKeyboard((byte)(state.getP_lvOfKeyboard() + 1));         //Ÿ�ڼ� ���� +1
				main.setM_AmountOfAutoMoney(main.getM_AmountOfAutoMoney() * 4);         //����: ������ x 4
				keyboardBar.setValue(state.getP_lvOfKeyboard());
				keyboardBar.setString(state.getP_lvOfKeyboard() + "/" + keyboardBar.getMaximum());
				View.cm().setMoneyJLabel(autoMoneyJLabel, tapMoneyJLabel);
				System.out.println("Ÿ�ڼ� �Ϸ� (���� ���� : " + state.getP_lvOfKeyboard() + ")");
			}else{
				System.out.println("�ܾ��� �����մϴ�. (���� Ÿ�ڼ� ���� : " + state.getP_lvOfKeyboard() + ")");
			}
		}else{
			System.out.println("���� �Ұ��� (���� Ÿ�ڼ� : " + state.getP_lvOfKeyboard() + ")");
		}
	}
	//************180710_�ؽ�Ʈ�� �ο� ***********
		//���콺 Ŀ�� �÷������� �ݾ� ��
		public void keyboardSpace(Main main, JButton extendJButton, JButton educateJButton, JButton employJButton,
											 JButton computerJButton, JButton keyboardJButton) {
		extendJButton.setToolTipText("���� �������� " + main.getM_TotalOfMoney() + " / " + (state.getP_lvOfExtend() * 20000000));
		educateJButton.setToolTipText("���� �������� " + main.getM_TotalOfMoney() + " / " + (state.getP_lvOfEducate() * 8000000));
		employJButton.setToolTipText("���� �������� " + main.getM_TotalOfMoney() + " / " + (state.getP_lvOfEmploy() * 10000000));
		computerJButton.setToolTipText("���� �������� " + main.getM_TotalOfMoney() + " / " + (state.getP_lvOfComputer() * 7000000));
		keyboardJButton.setToolTipText("���� �������� " + main.getM_TotalOfMoney() + " / " + (state.getP_lvOfKeyboard() * 7000000));
		}
}