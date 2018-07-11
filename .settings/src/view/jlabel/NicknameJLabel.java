package view.jlabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class NicknameJLabel extends JLabel{
	
	public NicknameJLabel(){
		super("player : ");
		setHorizontalAlignment(JLabel.LEFT);
		setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 11));
		setForeground(new Color(255, 247, 0));
		setBounds(0, 0, 100, 20);
	}
}