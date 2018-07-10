package view.jbutton.questMenuJButton;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class questComplete_2 extends JButton implements ActionListener{
	File file = new File("sound/buttonEffect_click.wav");
	AudioClip clip;
	
	public questComplete_2(ImageIcon imageIcon) {
		

		
		super(imageIcon);
		this.addActionListener(this);
		
		setLocation(275, 230);
		setSize(70, 65);
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			AudioClip clip = Applet.newAudioClip(file.toURI().toURL());
			clip.play();


		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}

	}
}