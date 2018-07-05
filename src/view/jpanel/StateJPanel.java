package view.jpanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.dao.DataAccessMain;
import view.View;

public class StateJPanel extends JPanel implements ActionListener{
	
	private JButton extendJButton = new JButton("ȸ�� Ȯ��");
	private JButton educateJButton = new JButton("���� �̼�");
	private JButton employJButton = new JButton("���� ���");
	private JButton computerJbutton = new JButton("��ǻ�� ���");
	private JButton keyboardJButton = new JButton("Ÿ�ڼ�");
	
	public StateJPanel(){
		setLayout(null);
		setBounds(3, 300, 338, 268);
		setBackground(new Color(100, 100, 100));
		
		extendJButton.setBounds(10, 10, 110, 30);		
		educateJButton.setBounds(10, 65, 110, 30);
		employJButton.setBounds(10, 120, 110, 30);
		computerJbutton.setBounds(10, 175, 110, 30);
		keyboardJButton.setBounds(10, 225, 110, 30);
		
		extendJButton.addActionListener(this);
		educateJButton.addActionListener(this);
		employJButton.addActionListener(this);
		computerJbutton.addActionListener(this);
		keyboardJButton.addActionListener(this);
		
		this.add(extendJButton);
		this.add(educateJButton);
		this.add(employJButton);
		this.add(computerJbutton);
		this.add(keyboardJButton);
		
		extendJButton.setFocusable(false);
		educateJButton.setFocusable(false);
		employJButton.setFocusable(false);
		computerJbutton.setFocusable(false);
		keyboardJButton.setFocusable(false);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		View.cm().stateChoice(e);
	}
}