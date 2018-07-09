package view.jbutton;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class QuestBackJButton extends JButton{
	
	public QuestBackJButton(ImageIcon imageIcon){
		super(imageIcon);
		setSize(67, 67);
		setLocation(265, 190);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
	}
}
