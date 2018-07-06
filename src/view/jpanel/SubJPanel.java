package view.jpanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.ControllerManager;
import view.View;


public class SubJPanel extends JPanel implements ActionListener{
	
	
	
	private JButton usePotion = new JButton("포션사용");
	private JButton useAutotap = new JButton("헬퍼사용");
	
	
	public SubJPanel(){
		setBounds(3, 403, 338, 165);
		setBackground(new Color(100, 100, 100));
		setLayout(null);
		
		usePotion.setSize(30, 30);
		usePotion.setLocation(270, 5);
		usePotion.addActionListener(this);
		
		useAutotap.setSize(30, 30);
		useAutotap.setLocation(305, 5);
		useAutotap.addActionListener(this);
		
		this.add(usePotion);
		this.add(useAutotap);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		View.cm().useItem(this, e);
	}
	
	
	
}