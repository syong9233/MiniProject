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

	// ***************스탯 버튼 초이스****************
	public void choice(String choice, Main main, JProgressBar stateBar, 
			MainJPanel mainJPanel, StateJPanel stateJPanel, View view,
			NicknameJLabel nicknameJLabel, TotalMoneyJLabel totalMoneyJLabel,
			AutoMoneyJLabel autoMoneyJLabel, TapMoneyJLabel tapMoneyJLabel){
		if(choice.equals("회사 확장")){
			extendLevelUp(main, stateBar, mainJPanel, stateJPanel, view, totalMoneyJLabel,
					nicknameJLabel, autoMoneyJLabel, tapMoneyJLabel);
		}else if(choice.equals("교육 이수")){
			educateLevelUp(main, stateBar, autoMoneyJLabel, tapMoneyJLabel);
		}else if(choice.equals("직원 고용")){
			employLevelUp(main, stateBar, autoMoneyJLabel, tapMoneyJLabel);
		}else if(choice.equals("컴퓨터 사양")){
			computerLevelUp(main, stateBar, autoMoneyJLabel, tapMoneyJLabel);
		}else if(choice.equals("타자수")){
			keyboardLevelUp(main, stateBar, autoMoneyJLabel, tapMoneyJLabel);
		}
	}
	// ***************180710_회사확장 레벨_값 수정(회사Level * 2천만원, 보상:탭 x3)****************
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

		if(state.getP_lvOfExtend() < 10){                                    //회사Level < 10
			if(main.getM_TotalOfMoney() > (state.getP_lvOfExtend()* 20000000)){                     //총 금액 > 레벨머니
				main.setM_TotalOfMoney(main.getM_TotalOfMoney() - (state.getP_lvOfExtend()* 20000000));   //구매 금액. 전체 돈 - 레벨머니
				state.setP_lvOfExtend((byte)(state.getP_lvOfExtend() + 1));            //회사 레벨 +1
				main.setM_AmountOfTapMoney(main.getM_AmountOfTapMoney() * 3);      //보상 : 탭 x 3
				System.out.println(main.getM_AmountOfAutoMoney());
				extendBar.setValue(state.getP_lvOfExtend());                     
				extendBar.setString(state.getP_lvOfExtend() + "/" + extendBar.getMaximum());//1/10 bar추가
				View.cm().setMoneyJLabel(autoMoneyJLabel, tapMoneyJLabel);
				System.out.println("회사 확장 완료 (현재 회사 레벨 : " + state.getP_lvOfExtend() + ")");
			}else{
				System.out.println("잔액이 부족합니다.(현재 회사 레벨 :" + state.getP_lvOfExtend() + ")");
			}
		}else{
			System.out.println("10레벨입니다.");
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

	// ***************180710_교육이수 레벨_값 수정(교육이수Level * 800만원, 보상:오토탭 x5)****************
	public void educateLevelUp(Main main, JProgressBar educateBar, AutoMoneyJLabel autoMoneyJLabel, TapMoneyJLabel tapMoneyJLabel){ 
		int educateLevelMoney = 8000000 * state.getP_lvOfEducate();                  //교육이수 금액
		if(state.getP_lvOfExtend() > state.getP_lvOfEducate()){                     //회사Level > 교육이수Level
			if(main.getM_TotalOfMoney() > educateLevelMoney){                     //전체 돈 > 교육이수 금액
				main.setM_TotalOfMoney(main.getM_TotalOfMoney() - educateLevelMoney);   //전체금액 - 교육이수 금액
				state.setP_lvOfEducate((byte)(state.getP_lvOfEducate() + 1));         //교육이수 레벨 +1
				main.setM_AmountOfAutoMoney(main.getM_AmountOfAutoMoney() * 5);         //보상 : 오토탭 x 5
				educateBar.setValue(state.getP_lvOfEducate());
				educateBar.setString(state.getP_lvOfEducate() + "/" + educateBar.getMaximum());
				View.cm().setMoneyJLabel(autoMoneyJLabel, tapMoneyJLabel);
				System.out.println("교육이수 완료 (현재 교육 이수 레벨" + state.getP_lvOfEducate() + ")");
			}else{
				System.out.println("잔액이 부족합니다. (현재 교육 이수 레벨 " + state.getP_lvOfEducate() + ")");
			}
		}else{
			System.out.println("아직 불가능 (현재 교육 이수 레벨" + state.getP_lvOfEducate() + ")");
		}
	}

	// ***************180710_직원고용 레벨_값 수정(직원고용Level * 1000만원, 보상:탭 x2)****************
	public void employLevelUp(Main main, JProgressBar employBar, AutoMoneyJLabel autoMoneyJLabel, TapMoneyJLabel tapMoneyJLabel){
		int employLevelMoney = 10000000 * state.getP_lvOfEmploy();                  //직원고용 금액
		if(state.getP_lvOfExtend() > state.getP_lvOfEmploy()){                     //회사Level > 직원고용Level
			if(main.getM_TotalOfMoney() > employLevelMoney){                     //전체 돈 > 고용금액
				main.setM_TotalOfMoney(main.getM_TotalOfMoney() - employLevelMoney);   //전체금액 - 직원고용 금액
				state.setP_lvOfEmploy((byte)(state.getP_lvOfEmploy() + 1));            //직원고용 레벨 +1
				main.setM_AmountOfTapMoney(main.getM_AmountOfTapMoney() * 2);         //보상 : 탭 x 2
				employBar.setValue(state.getP_lvOfEmploy());
				employBar.setString(state.getP_lvOfEmploy() + "/" + employBar.getMaximum());
				View.cm().setMoneyJLabel(autoMoneyJLabel, tapMoneyJLabel);
				System.out.println("직원고용 완료 (현재 레벨 :" + state.getP_lvOfEmploy() + ")");
			}else{
				System.out.println("잔액이 부족합니다. (현재 직원 고용 레벨  : " + state.getP_lvOfEmploy() + ")");
			}
		}else{
			System.out.println("아직 불가능 (현재 직원 고용 레벨 : " + state.getP_lvOfEmploy() + ")");
		}
	}

	// ***************180710_컴퓨터 레벨_값 수정(컴퓨터Level * 700만원, 보상:오토탭 x4)****************
	public void computerLevelUp(Main main, JProgressBar computerBar, AutoMoneyJLabel autoMoneyJLabel, TapMoneyJLabel tapMoneyJLabel){
		int computerLevelMoney = 7000000 * state.getP_lvOfComputer();               //컴퓨터사양 금액
		if(state.getP_lvOfExtend() > state.getP_lvOfComputer()){                  //회사Level > 컴퓨터사양Level
			if(main.getM_TotalOfMoney() > computerLevelMoney){                     //전체돈 > 컴퓨터사양 금액
				main.setM_TotalOfMoney(main.getM_TotalOfMoney() - computerLevelMoney);   //전체금액 - 컴퓨터 금액
				state.setP_lvOfComputer((byte)(state.getP_lvOfComputer() + 1));         //컴퓨터 사양 레벨 +1
				main.setM_AmountOfAutoMoney(main.getM_AmountOfAutoMoney() * 4);         //보상: 오토탭 x 4
				computerBar.setValue(state.getP_lvOfComputer());
				computerBar.setString(state.getP_lvOfComputer() + "/" + computerBar.getMaximum());
				View.cm().setMoneyJLabel(autoMoneyJLabel, tapMoneyJLabel);
				System.out.println("컴퓨터사양 완료 (현재 레벨 : "+ state.getP_lvOfComputer() + ")" );
			}else{
				System.out.println("잔액이 부족합니다. (현재 컴퓨터사양 레벨 : " + state.getP_lvOfComputer() + ")");
			}
		}else{
			System.out.println("아직 불가능 (현재 컴퓨터사양 : " + state.getP_lvOfComputer() + ")");
		}
	}

	// ***************180710_타자수 레벨_값 수정(타자수Level * 700만원, 보상:오토탭 x4)****************
	public void keyboardLevelUp(Main main, JProgressBar keyboardBar, AutoMoneyJLabel autoMoneyJLabel, TapMoneyJLabel tapMoneyJLabel){   
		int keyboardLevelMoney = 7000000 * state.getP_lvOfKeyboard();               //타자수 금액
		if(state.getP_lvOfExtend() > state.getP_lvOfKeyboard()){                  //회사Level > 타자수Level
			if(main.getM_TotalOfMoney() > keyboardLevelMoney){                     //전체돈 > 타자수 금액
				main.setM_TotalOfMoney(main.getM_TotalOfMoney() - keyboardLevelMoney);   //전체금액 - 타자수 금액
				state.setP_lvOfKeyboard((byte)(state.getP_lvOfKeyboard() + 1));         //타자수 레벨 +1
				main.setM_AmountOfAutoMoney(main.getM_AmountOfAutoMoney() * 4);         //보상: 오토탭 x 4
				keyboardBar.setValue(state.getP_lvOfKeyboard());
				keyboardBar.setString(state.getP_lvOfKeyboard() + "/" + keyboardBar.getMaximum());
				View.cm().setMoneyJLabel(autoMoneyJLabel, tapMoneyJLabel);
				System.out.println("타자수 완료 (현재 레벨 : " + state.getP_lvOfKeyboard() + ")");
			}else{
				System.out.println("잔액이 부족합니다. (현재 타자수 레벨 : " + state.getP_lvOfKeyboard() + ")");
			}
		}else{
			System.out.println("아직 불가능 (현재 타자수 : " + state.getP_lvOfKeyboard() + ")");
		}
	}
	//************180710_텍스트값 부여 ***********
		//마우스 커서 올려놓으면 금액 뜸
		public void keyboardSpace(Main main, JButton extendJButton, JButton educateJButton, JButton employJButton,
											 JButton computerJButton, JButton keyboardJButton) {
		extendJButton.setToolTipText("다음 레벨까지 " + main.getM_TotalOfMoney() + " / " + (state.getP_lvOfExtend() * 20000000));
		educateJButton.setToolTipText("다음 레벨까지 " + main.getM_TotalOfMoney() + " / " + (state.getP_lvOfEducate() * 8000000));
		employJButton.setToolTipText("다음 레벨까지 " + main.getM_TotalOfMoney() + " / " + (state.getP_lvOfEmploy() * 10000000));
		computerJButton.setToolTipText("다음 레벨까지 " + main.getM_TotalOfMoney() + " / " + (state.getP_lvOfComputer() * 7000000));
		keyboardJButton.setToolTipText("다음 레벨까지 " + main.getM_TotalOfMoney() + " / " + (state.getP_lvOfKeyboard() * 7000000));
		}
}