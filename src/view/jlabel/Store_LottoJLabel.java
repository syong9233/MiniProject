package view.jlabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class Store_LottoJLabel extends JLabel {

	public Store_LottoJLabel() {
		super("����");
		setHorizontalAlignment(JLabel.RIGHT);
		setFont(new Font("���� ����", Font.BOLD, 16));
		setForeground(new Color(0, 0, 0));
		setBounds(0, 0, 325, 27);
	}

}
