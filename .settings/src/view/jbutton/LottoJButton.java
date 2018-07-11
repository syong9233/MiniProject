package view.jbutton;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class LottoJButton extends JButton{

	public LottoJButton(ImageIcon imageicon){
		super(imageicon);
		setSize(80, 70);
		setLocation(255, 70);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
	}
}
