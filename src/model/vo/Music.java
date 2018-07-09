package model.vo;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;

public class Music extends Thread{
	
	@Override
	public void run(){
		File file = new File("sound/maple_bgm2.wav");
		try {
			AudioClip clip = Applet.newAudioClip(file.toURI().toURL());
			clip.play();


		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	
	}

}
