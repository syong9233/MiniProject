package model.vo;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;

public class Music extends Thread{
   
   @Override
   public void run(){
      File file = new File("sound/bgm.wav");
      try {
         AudioClip clip = Applet.newAudioClip(file.toURI().toURL());
         clip.play();
         clip.loop();
         
         Thread.sleep(2000);

      } catch (MalformedURLException e) {
         e.printStackTrace();
      } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   
   }

}