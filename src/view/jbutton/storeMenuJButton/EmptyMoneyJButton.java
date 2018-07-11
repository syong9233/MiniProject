package view.jbutton.storeMenuJButton;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class EmptyMoneyJButton extends JButton {

	public EmptyMoneyJButton(ImageIcon imageIcon) {

		super(imageIcon);
		
		setLocation(64, 120);
		setSize(155, 60);
		
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		
	}

}
