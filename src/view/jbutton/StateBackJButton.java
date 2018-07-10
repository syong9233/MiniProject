package view.jbutton;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class StateBackJButton extends JButton{
	
	public StateBackJButton(ImageIcon imageIcon){
		super(imageIcon);
		setSize(67, 67);
		setLocation(265, 0);
		
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
	}
}
