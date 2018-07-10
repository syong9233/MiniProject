package view.jbutton;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class StoreBackJButton extends JButton{
	
	public StoreBackJButton(ImageIcon imageIcon){
		super(imageIcon);
		setSize(67, 128);
		setLocation(265, 380);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
	}
}
