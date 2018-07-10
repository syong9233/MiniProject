package view;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.net.MalformedURLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.ControllerManager;
import model.vo.Music;
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
import view.jpanel.FirstGame;
import view.jpanel.LottoJPanel;
import view.jpanel.MainJPanel;
import view.jpanel.QuestJPanel;
import view.jpanel.StateJPanel;
import view.jpanel.StoreJPanel;
import view.jpanel.SubJPanel;

public class View extends JFrame implements KeyListener, ActionListener{
	
	//***********Controller, JPanel, JLabel, JButton 등 객체 생성_180707_1************
	private static ControllerManager cm = new ControllerManager();
	
	public static View view;
	public static FirstGame checkGame;
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

	private StateBackJButton stateBackJButton = new StateBackJButton(new ImageIcon("image/store/common_backButton.png"));
	private QuestBackJButton questBackJButton= new QuestBackJButton(new ImageIcon("image/store/common_backButton.png"));
	private StoreBackJButton storeBackJButton= new StoreBackJButton(new ImageIcon("image/store/common_backButton.png"));
	private StateJButton stateJButton = new StateJButton(new ImageIcon("image/main/main_state.png"));
	private QuestJButton questJButton = new QuestJButton(new ImageIcon("image/main/main_Quest.png"));
	private StoreJButton storeJButton = new StoreJButton(new ImageIcon("image/main/main_store.png"));
	private LottoJButton lottoJButton = new LottoJButton(new ImageIcon("image/main/main_lotto.png"));
	
	//sound
	File file = new File("sound/buttonEffect_click.wav");
	AudioClip clip;
	
	//------------------------------------------------------------------------
	
	public View(){

		//***************MainJFrame_180707_1​****************
		super("TapCompany");
		setLayout(null);
		setBounds(1000, 15, 350, 600);
		getContentPane().setBackground(Color.BLACK);
		
		JLabel lv1JBackImageLabel = new JLabel(new ImageIcon(new ImageIcon("image/main/final_lv1.png").getImage().getScaledInstance(338, 600, java.awt.Image.SCALE_SMOOTH)));
		lv1JBackImageLabel.setLocation(0, -30);
		lv1JBackImageLabel.setSize(338, 600);
		
		JLabel subJBackImageLabel = new JLabel(new ImageIcon(new ImageIcon("image/sub/subJPanel_panel.png").getImage().getScaledInstance(338, 165, java.awt.Image.SCALE_SMOOTH)));
		subJBackImageLabel.setLocation(0, 0);
		subJBackImageLabel.setSize(338, 165);
		//--------------------------------------------------

		//***********add this, add action​_180707_1************
		stateJPanel.add(stateBackJButton);
		questJPanel.add(questBackJButton);
		storeJPanel.add(storeBackJButton);
			
		subJPanel.add(stateJButton);
		subJPanel.add(questJButton);
		subJPanel.add(storeJButton);
		subJPanel.add(lottoJButton);
		subJPanel.add(subJBackImageLabel);
		
		mainJPanel.add(nicknameJLabel);
		mainJPanel.add(totalMoneyJLabel);
		mainJPanel.add(autoMoneyJLabel);
		mainJPanel.add(tapMoneyJLabel);
		mainJPanel.add(lv1JBackImageLabel);
		
		stateJPanel.extendJButton.addActionListener(this);
		stateJPanel.educateJButton.addActionListener(this);
		stateJPanel.employJButton.addActionListener(this);
		stateJPanel.computerJButton.addActionListener(this);
		stateJPanel.keyboardJButton.addActionListener(this);

		lottoJPanel.backButton.addActionListener(this);
		storeBackJButton.addActionListener(this);
		stateBackJButton.addActionListener(this);
		questBackJButton.addActionListener(this);
		stateJButton.addActionListener(this);
		questJButton.addActionListener(this);
		storeJButton.addActionListener(this);
		lottoJButton.addActionListener(this);	
		this.addKeyListener(this);
		subJPanel.usePotionJButton.addActionListener(this);
		subJPanel.useAutoTapJButton.addActionListener(this);
		
		this.add(subJPanel);
		this.add(mainJPanel);
		
		this.setFocusable(true);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//--------------------------------------------------
		
		//**********new player​ or load player_180707_1*********
		cm.loadPlayer();
		cm.checkFisrtGame(this, nicknameJLabel, totalMoneyJLabel, autoMoneyJLabel, tapMoneyJLabel, 
				mainJPanel, subJPanel, stateJPanel.extendBar, stateJPanel.educateBar, stateJPanel.employBar,
				stateJPanel.computerBar, stateJPanel.keyboardBar);//--------------------------------------------
	}
	
	//*********JButton, JLabel 등의 이벤트 발생 시작 메소드_180707_1************

	public void actionPerformed(ActionEvent e) {

		try {
			AudioClip clip = Applet.newAudioClip(file.toURI().toURL());
			clip.play();


		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}

		cm.pageMove(this, e, mainJPanel, stateJPanel, questJPanel,
				storeJPanel, lottoJPanel, subJPanel, stateJPanel.extendJButton,
				stateJPanel.educateJButton, stateJPanel.employJButton,
				stateJPanel.computerJButton, stateJPanel.keyboardJButton, 
				stateJPanel.extendBar, stateJPanel.educateBar, stateJPanel.employBar,
				stateJPanel.computerBar, stateJPanel.keyboardBar,
				nicknameJLabel, totalMoneyJLabel, autoMoneyJLabel, tapMoneyJLabel);
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
		if(e.getKeyCode() == 83){
			cm.savePlayer();
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
		new Music().start();
		new View();
	}
	//--------------------------------------
}