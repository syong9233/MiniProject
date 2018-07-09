package view.jbutton;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class StateBackJButton extends JButton{
	
	public StateBackJButton(ImageIcon imageIcon){
		super(imageIcon);
		setSize(67, 117);
		setLocation(265, 243);
		
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
	}
}
