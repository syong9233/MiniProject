package view.jlabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class Lotto_LottoJLabel extends JLabel {

	public Lotto_LottoJLabel() {
		super("����");
		setHorizontalAlignment(JLabel.RIGHT);
		setFont(new Font("���� ���", Font.BOLD, 16));
		setForeground(new Color(20, 20, 0));
		setBounds(0, 7, 320, 27);
	}

}
