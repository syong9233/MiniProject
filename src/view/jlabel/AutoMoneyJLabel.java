package view.jlabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class AutoMoneyJLabel extends JLabel {
	
	public AutoMoneyJLabel(){
		setHorizontalAlignment(JLabel.RIGHT);
		setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 11));
		setForeground(new Color(255, 247, 0));
		setBounds(0, 13, 335, 20);
	}
	
}