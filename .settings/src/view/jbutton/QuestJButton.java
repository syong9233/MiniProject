package view.jbutton;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class QuestJButton extends JButton{

	public QuestJButton(ImageIcon imageicon){
		super(imageicon);
		setSize(80, 70);
		setLocation(90, 70);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
	}
}
