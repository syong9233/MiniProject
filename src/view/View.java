package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.ControllerManager;
import view.jbutton.LottoBackJButton;
import view.jbutton.LottoJButton;
import view.jbutton.QuestBackJButton;
import view.jbutton.QuestJButton;
import view.jbutton.StateBackJButton;
import view.jbutton.StateJButton;
import view.jbutton.StoreBackJButton;
import view.jbutton.StoreJButton;
import view.jlabel.AutoMoneyJLabel;
import view.jlabel.NicknameJLabel;
import view.jlabel.TapMoneyJLabel;
import view.jlabel.TotalMoneyJLabel;
import view.jpanel.LottoJPanel;
import view.jpanel.MainJPanel;
import view.jpanel.QuestJPanel;
import view.jpanel.StateJPanel;
import view.jpanel.StoreJPanel;
import view.jpanel.SubJPanel;

public class View extends JFrame implements KeyListener, ActionListener{
	
	//***********Controller, JPanel, JLabel, JButton 등 객체 생성_180707_1************
	private static ControllerManager cm = new ControllerManager();
	
	private MainJPanel mainJPanel = new MainJPanel();
	private SubJPanel subJPanel = new SubJPanel();
	private StateJPanel stateJPanel = new StateJPanel(); 
	private QuestJPanel questJPanel = new QuestJPanel();
	private LottoJPanel lottoJPanel = new LottoJPanel();
	private StoreJPanel storeJPanel = new StoreJPanel();
	
	private NicknameJLabel nicknameJLabel = new NicknameJLabel();
	private TotalMoneyJLabel totalMoneyJLabel = new TotalMoneyJLabel();;
	private AutoMoneyJLabel autoMoneyJLabel = new AutoMoneyJLabel();
	private TapMoneyJLabel tapMoneyJLabel = new TapMoneyJLabel();

	private StateJButton stateJButton = new StateJButton();
	private QuestJButton questJButton = new QuestJButton();
	private StoreJButton storeJButton = new StoreJButton();
	private LottoJButton lottoJButton = new LottoJButton();
	private StateBackJButton stateBackJButton = new StateBackJButton();
	private QuestBackJButton questBackJButton= new QuestBackJButton();
	private LottoBackJButton lottoBackJButton= new LottoBackJButton();
	private StoreBackJButton storeBackJButton= new StoreBackJButton();
	//------------------------------------------------------------------------
	
	public View(){

		//***************MainJFrame_180707_1​****************
		super("TapCompany");
		setLayout(null);
		setBounds(1000, 15, 350, 600);

		Container container = getContentPane();
		Color color = new Color(74, 59, 38);
		container.setBackground(color);
		//--------------------------------------------------

		//***********add this, add action​_180707_1************
		stateJPanel.add(stateBackJButton);
		questJPanel.add(questBackJButton);
		storeJPanel.add(storeBackJButton);
		lottoJPanel.add(lottoBackJButton);
			
		mainJPanel.add(nicknameJLabel);
		mainJPanel.add(totalMoneyJLabel);
		mainJPanel.add(autoMoneyJLabel);
		mainJPanel.add(tapMoneyJLabel);
		
		subJPanel.add(stateJButton);
		subJPanel.add(questJButton);
		subJPanel.add(storeJButton);
		subJPanel.add(lottoJButton);
		
		lottoJPanel.backButton.addActionListener(this);
		storeBackJButton.addActionListener(this);
		stateBackJButton.addActionListener(this);
		questBackJButton.addActionListener(this);
		stateJButton.addActionListener(this);
		questJButton.addActionListener(this);
		storeJButton.addActionListener(this);
		lottoJButton.addActionListener(this);	
		this.addKeyListener(this);
		
		this.add(mainJPanel);
		this.add(subJPanel);
		
		this.setFocusable(true);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//--------------------------------------------------
		
		//**********new player​ or load player_180707_1*********
		cm.loadPlayer();
		cm.checkFisrtGame(this, nicknameJLabel, totalMoneyJLabel, autoMoneyJLabel, tapMoneyJLabel, mainJPanel);
		//--------------------------------------------
	}
	
	//*********JButton, JLabel 등의 이벤트 발생 시작 메소드_180707_1************
	@Override
	public void actionPerformed(ActionEvent e) {
		cm.pageMove(this, e, mainJPanel, stateJPanel, questJPanel,
				storeJPanel, lottoJPanel, subJPanel);
	}
	//------------------------------------------------------------------
	
	//*************SpaceBar의 이벤트 발생 시작 메소드_180707_1******************
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == 32){
			cm.keyReleased(totalMoneyJLabel, questJPanel.ingTap, 
							questJPanel.goalTap, questJPanel.ingMoney,
								questJPanel.goalMoney, questJPanel.button1, 
									questJPanel.button2);
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyPressed(KeyEvent e) {}
	//------------------------------------------------------------------
	
	//***********ControllerManaber의 공유 목적 메소드_180707_1****************
	public static ControllerManager cm(){
		return cm;
	}
	//------------------------------------------------------------------
	
	//**********게임 실행_180707_1*************
	public static void main(String[] args) {
		new View();
	}
	//--------------------------------------
}