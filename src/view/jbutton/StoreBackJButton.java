package view.jbutton;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class StoreBackJButton extends JButton{
	
	public StoreBackJButton(ImageIcon imageIcon){
		super(imageIcon);
		setSize(67, 67);
		setLocation(265, 440);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
	}
}
