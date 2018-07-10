package view.jbutton.storeMenuJButton;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Cash5000JButton extends JButton {

	public Cash5000JButton(ImageIcon imageIcon) {

		super(imageIcon);

		setLocation(5, 200);
		setSize(300, 55);

		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
	}
}
