package view.jlabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class TapMoneyJLabel extends JLabel{
	
	public TapMoneyJLabel(){
		setHorizontalAlignment(JLabel.RIGHT);
		setFont(new Font("���� ����", Font.BOLD, 11));
		setForeground(new Color(255, 247, 0));
		setBounds(2, 30, 310, 20);
	}
	
}
