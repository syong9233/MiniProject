package view.jbutton;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class StateJButton extends JButton{
	
	public StateJButton(ImageIcon imageicon){
		super(imageicon);
		setSize(80, 70);
		setLocation(7, 70);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
	}
	
}