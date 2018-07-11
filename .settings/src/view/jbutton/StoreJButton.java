package view.jbutton;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class StoreJButton extends JButton{

	public StoreJButton(ImageIcon imageicon){
		super(imageicon);
		setSize(80, 70);
		setLocation(173, 70);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
	}
}
