package view.jlabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class TapMoneyJLabel extends JLabel {

	public TapMoneyJLabel() {
		setHorizontalAlignment(JLabel.RIGHT);
		setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 11));
		setForeground(new Color(255, 247, 0));
		setBounds(0, 26, 312, 27);
	}

}
