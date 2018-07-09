package model.dao;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JProgressBar;

import model.vo.*;

public class DataAccessState {
	private State state;

	public DataAccessState(){
		state = new State();
	}

	public State getState(){
		return state;
	}

	// ***************스탯 버튼 초이스****************
	public void choice(ActionEvent e, Main main, JProgressBar extendBar,  JProgressBar educateBar,
			JProgressBar employBar, JProgressBar computerBar, JProgressBar keyboardBar,
			JButton educateJButton){
		if(e.getActionCommand().equals("회사 확장")){
			this.extendLevelUp(main, extendBar);
		}else if(e.getActionCommand().equals("교육 이수")){
			this.educateLevelUp(main, educateBar, educateJButton);
		}else if(e.getActionCommand().equals("직원 고용")){
			this.employLevelUp(main, employBar);
		}else if(e.getActionCommand().equals("컴퓨터 사양")){
			this.computerLevelUp(main, computerBar);
		}else if(e.getActionCommand().equals("타자수")){
			this.keyboardLevelUp(main, keyboardBar);
		}
	}
	// ***************회사확장 레벨****************
	public void extendLevelUp(Main main, JProgressBar extendBar){
		int extendlevelMoney = 1500000 * state.getP_lvOfExtend();               //회사확장 금액
		if(state.getP_lvOfExtend() < 10){                                    //회사Level < 10
			if(main.getM_TotalOfMoney() > extendlevelMoney){                     //총 금액 > 레벨머니
				main.setM_TotalOfMoney(main.getM_TotalOfMoney() - extendlevelMoney);   //구매 금액. 전체 돈 - 레벨머니
				state.setP_lvOfExtend((byte)(state.getP_lvOfExtend() + 1));            //회사 레벨 +1
				main.setM_AmountOfAutoMoney(main.getM_AmountOfAutoMoney() * 10);      //보상 : 오토탭 x 10
				extendBar.setValue(state.getP_lvOfExtend());                     
				extendBar.setString(state.getP_lvOfExtend() + "/" + extendBar.getMaximum());//1/10 bar추가
				System.out.println("회사 확장 완료 (현재 회사 레벨 : " + state.getP_lvOfExtend() + ")");
			}else{
				System.out.println("잔액이 부족합니다.(현재 회사 레벨 :" + state.getP_lvOfExtend() + ")");
			}
		}else{
			System.out.println("10레벨입니다.");
		}
	}

	// ***************교육이수 레벨****************
	public void educateLevelUp(Main main, JProgressBar educateBar, JButton educateJButton){ 
		int educateLevelMoney = 200000 * state.getP_lvOfEducate();                  //교육이수 금액
		if(state.getP_lvOfExtend() > state.getP_lvOfEducate()){                     //회사Level > 교육이수Level
			educateJButton.setEnabled(true);
			if(main.getM_TotalOfMoney() > educateLevelMoney){                     //전체 돈 > 교육이수 금액
				main.setM_TotalOfMoney(main.getM_TotalOfMoney() - educateLevelMoney);   //전체금액 - 교육이수 금액
				state.setP_lvOfEducate((byte)(state.getP_lvOfEducate() + 1));         //교육이수 레벨 +1
				main.setM_AmountOfAutoMoney(main.getM_AmountOfAutoMoney() * 2);         //보상 : 오토탭 x 2
				educateBar.setValue(state.getP_lvOfEducate());
				educateBar.setString(state.getP_lvOfEducate() + "/" + educateBar.getMaximum());
				System.out.println("교육이수 완료 (현재 교육 이수 레벨" + state.getP_lvOfEducate() + ")");
			}else{
				educateJButton.setEnabled(false);
				System.out.println("잔액이 부족합니다. (현재 교육 이수 레벨 " + state.getP_lvOfEducate() + ")");
			}
		}else{
			educateJButton.setEnabled(false);
			System.out.println("아직 불가능 (현재 교육 이수 레벨" + state.getP_lvOfEducate() + ")");
		}
	}

	// ***************직원고용 레벨****************
	public void employLevelUp(Main main, JProgressBar employBar){
		int employLevelMoney = 300000 * state.getP_lvOfEmploy();                  //직원고용 금액
		if(state.getP_lvOfExtend() > state.getP_lvOfEmploy()){                     //회사Level > 직원고용Level
			if(main.getM_TotalOfMoney() > employLevelMoney){                     //전체 돈 > 고용금액
				main.setM_TotalOfMoney(main.getM_TotalOfMoney() - employLevelMoney);   //전체금액 - 직원고용 금액
				state.setP_lvOfEmploy((byte)(state.getP_lvOfEmploy() + 1));            //직원고용 레벨 +1
				main.setM_AmountOfTapMoney(main.getM_AmountOfTapMoney() * 2);         //보상 : 탭 x 2
				employBar.setValue(state.getP_lvOfEmploy());
				employBar.setString(state.getP_lvOfEmploy() + "/" + employBar.getMaximum());
				System.out.println("직원고용 완료 (현재 레벨 :" + state.getP_lvOfEmploy() + ")");
			}else{
				System.out.println("잔액이 부족합니다. (현재 직원 고용 레벨  : " + state.getP_lvOfEmploy() + ")");
			}
		}else{
			System.out.println("아직 불가능 (현재 직원 고용 레벨 : " + state.getP_lvOfEmploy() + ")");
		}
	}

	// ***************컴퓨터사양 레벨****************
	public void computerLevelUp(Main main, JProgressBar computerBar){
		int computerLevelMoney = 300000 * state.getP_lvOfComputer();               //컴퓨터사양 금액
		if(state.getP_lvOfExtend() > state.getP_lvOfComputer()){                  //회사Level > 컴퓨터사양Level
			if(main.getM_TotalOfMoney() > computerLevelMoney){                     //전체돈 > 컴퓨터사양 금액
				main.setM_TotalOfMoney(main.getM_TotalOfMoney() - computerLevelMoney);   //전체금액 - 컴퓨터 금액
				state.setP_lvOfComputer((byte)(state.getP_lvOfComputer() + 1));         //컴퓨터 사양 레벨 +1
				main.setM_AmountOfTapMoney(main.getM_AmountOfTapMoney() * 2);         //보상: 탭 x 2
				computerBar.setValue(state.getP_lvOfComputer());
				computerBar.setString(state.getP_lvOfComputer() + "/" + computerBar.getMaximum());
				System.out.println("컴퓨터사양 완료 (현재 레벨 : "+ state.getP_lvOfComputer() + ")" );
			}else{
				System.out.println("잔액이 부족합니다. (현재 컴퓨터사양 레벨 : " + state.getP_lvOfComputer() + ")");
			}
		}else{
			System.out.println("아직 불가능 (현재 컴퓨터사양 : " + state.getP_lvOfComputer() + ")");
		}
	}

	// ***************타자수 레벨****************
	public void keyboardLevelUp(Main main, JProgressBar keyboardBar){   
		int keyboardLevelMoney = 300000 * state.getP_lvOfKeyboard();               //타자수 금액
		if(state.getP_lvOfExtend() > state.getP_lvOfKeyboard()){                  //회사Level > 타자수Level
			if(main.getM_TotalOfMoney() > keyboardLevelMoney){                     //전체돈 > 타자수 금액
				main.setM_TotalOfMoney(main.getM_TotalOfMoney() - keyboardLevelMoney);   //전체금액 - 타자수 금액
				state.setP_lvOfKeyboard((byte)(state.getP_lvOfKeyboard() + 1));         //타자수 레벨 +1
				main.setM_AmountOfTapMoney(main.getM_AmountOfTapMoney() * 2);         //보상: 탭 x 2
				keyboardBar.setValue(state.getP_lvOfKeyboard());
				keyboardBar.setString(state.getP_lvOfKeyboard() + "/" + keyboardBar.getMaximum());
				System.out.println("타자수 완료 (현재 레벨 : " + state.getP_lvOfKeyboard() + ")");
			}else{
				System.out.println("잔액이 부족합니다. (현재 타자수 레벨 : " + state.getP_lvOfKeyboard() + ")");
			}
		}else{
			System.out.println("아직 불가능 (현재 타자수 : " + state.getP_lvOfKeyboard() + ")");
		}
	}
}