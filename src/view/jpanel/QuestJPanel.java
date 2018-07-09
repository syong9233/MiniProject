package view.jpanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.View;

public class QuestJPanel extends JPanel implements ActionListener{
	
	//***********JButton 객체 생성 및 변수 선언_180707_1************
	public JButton button1 = new JButton("T완료");
	public JButton button2 = new JButton("M완료");
	public JLabel questLabel = new JLabel("퀘스트");
	public JLabel goal = new JLabel("목표");
	public JLabel ingQuest = new JLabel("현재");
	public JLabel goalTap = new JLabel();
	public JLabel ingTap = new JLabel();
	public JLabel goalMoney = new JLabel();
	public JLabel ingMoney = new JLabel();
	//------------------------------------------------------------------------

	public QuestJPanel(){
		//***************QuestJPanel_180707_1​****************
		setLayout(null);
		setBounds(3, 300, 338, 268);
		setBackground(new Color(100, 100, 100));
		//------------------------------------------------------

		//****************각각의 JButton Setting_180707_1****************
		questLabel.setLocation(30, 20);
		goal.setLocation(30, 60);
		ingQuest.setLocation(170, 68);
		goalTap.setLocation(30, 130);
		ingTap.setLocation(170, 130);
		goalMoney.setLocation(30, 200);
		ingMoney.setLocation(170, 200);
		button1.setLocation(260, 130);
		button2.setLocation(260, 200);
		
		questLabel.setSize(100, 30);
		goal.setSize(100, 50);
		ingQuest.setSize(100, 30);
		goalTap.setSize(60, 30);
		ingTap.setSize(60, 30);
		goalMoney.setSize(90, 30);
		ingMoney.setSize(90, 30);
		button1.setSize(70, 30);
		button2.setSize(70,30);
		
		button1.setFocusable(false);
		button2.setFocusable(false);
		//------------------------------------------------------------
		
		//***********add this, add action​_180707_1************
		button1.addActionListener(this);
		button2.addActionListener(this);
		
		add(questLabel);
		add(goal);
		add(ingQuest);
		add(goalTap);
		add(ingTap);
		add(goalMoney);
		add(ingMoney);
		add(button1);
		add(button2);
		//--------------------------------------------------------
	}

	//*********JButton 이벤트 발생 시작 메소드_180707_1************
	@Override
	public void actionPerformed(ActionEvent e) {
		View.cm().questChoice(e, button1, button2);
	}
	//---------------------------------------------------------
}
