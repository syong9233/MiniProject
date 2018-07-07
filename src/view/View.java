package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

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

	private StateJButton stateJButton = new StateJButton(new ImageIcon("image/sub/state.png"));
	private QuestJButton questJButton = new QuestJButton(new ImageIcon("image/sub/quest.png"));
	private StoreJButton storeJButton = new StoreJButton(new ImageIcon("image/sub/store.png"));
	private LottoJButton lottoJButton = new LottoJButton(new ImageIcon("image/sub/lotto.png"));
	
	private StateBackJButton stateBackJButton = new StateBackJButton();
	private QuestBackJButton questBackJButton= new QuestBackJButton();
	private LottoBackJButton lottoBackJButton= new LottoBackJButton();
	private StoreBackJButton storeBackJButton= new StoreBackJButton();
	
	public View(){
		
		super("TapCompany");
		//***************MainController​****************
		setLayout(null);
		setBounds(1000, 15, 350, 600);

		Container container = getContentPane();
		Color color = new Color(74, 59, 38);
		container.setBackground(color);
		//********************************************

		//******************add This​******************
		stateJPanel.add(stateBackJButton);
		questJPanel.add(questBackJButton);
		storeJPanel.add(storeBackJButton);
		//lottoJPanel.add(lottoBackJButton);
			
		mainJPanel.add(nicknameJLabel);
		mainJPanel.add(totalMoneyJLabel);
		mainJPanel.add(autoMoneyJLabel);
		mainJPanel.add(tapMoneyJLabel);
		
		subJPanel.add(stateJButton);
		subJPanel.add(questJButton);
		subJPanel.add(storeJButton);
		subJPanel.add(lottoJButton);
		
		this.add(mainJPanel);
		this.add(subJPanel);
		
		lottoJPanel.backButton.addActionListener(this);
		storeBackJButton.addActionListener(this);
		stateBackJButton.addActionListener(this);
		questBackJButton.addActionListener(this);
		stateJButton.addActionListener(this);
		questJButton.addActionListener(this);
		storeJButton.addActionListener(this);
		lottoJButton.addActionListener(this);	
		subJPanel.usePotionJButton.addActionListener(this);
		subJPanel.useAutoTapJButton.addActionListener(this);
		this.addKeyListener(this);
		
		this.setFocusable(true);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//********************************************


		//**********new player  or load player*********
		cm.loadPlayer();
		//----------0705 16:15------------
		cm.checkFisrtGame(this, nicknameJLabel, totalMoneyJLabel, autoMoneyJLabel, tapMoneyJLabel, mainJPanel);
		//********************************************

	}
	
	public static void main(String[] args) {
		new View();
	}

	//0706 17:50 변경

	@Override
	public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode() == 32){
			cm.keyReleased(totalMoneyJLabel, questJPanel.button3); // questJPanel.button1 //버튼 안의 내용변경하기 위해 객체를 가져옴.
		}
		
		if(e.getKeyCode() == 83){
			cm.savePlayer();
		}
	}

	//키보드 눌리는 순간
	@Override
	public void keyTyped(KeyEvent e) {}

	// 키보드의 키가 눌린 순간
	@Override
	public void keyPressed(KeyEvent e) {}

	//키보드의 키가 눌리고 떼이는 순간
	@Override
	public void actionPerformed(ActionEvent e) {
		cm.pageMove(this, e, questJPanel.button3, mainJPanel, totalMoneyJLabel, stateJPanel, questJPanel, storeJPanel, lottoJPanel, subJPanel);
	}
	
	public static ControllerManager cm(){
		return cm;
	}
	
	public View getView(){
		return this;
	}
}