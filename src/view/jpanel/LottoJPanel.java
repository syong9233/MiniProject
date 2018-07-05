package view.jpanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import view.View;

public class LottoJPanel extends JPanel implements ActionListener{
	private JButton lottoBackButton = new JButton(" back ");
	
	public LottoJPanel(){
		this.setLayout(null);
		this.setBounds(3, 300, 338, 268);
		this.setBackground(new Color(100, 100, 100));
		
		lottoBackButton.setSize(68, 20);
		lottoBackButton.setLocation(265, 3);
		lottoBackButton.addActionListener(this);
		
		this.add(lottoBackButton);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}