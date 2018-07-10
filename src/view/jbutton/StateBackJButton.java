package view.jbutton;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class StateBackJButton extends JButton{
	
	public StateBackJButton(ImageIcon imageIcon){
		super(imageIcon);
		setSize(67, 115);
		setLocation(272, 268);
		
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
	}
}
