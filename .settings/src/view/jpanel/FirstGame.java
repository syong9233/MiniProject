package view.jpanel;

import javax.swing.JPanel;

import view.View;

public class FirstGame extends Thread{

	@Override
	public void run(){
		JPanel p = new JPanel();
		
		p.setBounds(3, 3, 338, 420);
		p.setLayout(null);
	}
	
	public FirstGame getFisrtGame(){
		return this;
	}
}
