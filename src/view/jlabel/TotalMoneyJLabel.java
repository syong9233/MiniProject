package view.jlabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class TotalMoneyJLabel extends JLabel{
	
	public TotalMoneyJLabel(){
		setHorizontalAlignment(JLabel.RIGHT);
		setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 11));
		setForeground(new Color(255, 247, 0));
		setBounds(22, 0, 315, 20);
	}

}
