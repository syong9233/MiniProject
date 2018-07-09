package view.jpanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import view.jbutton.storeMenuJButton.*;


public class SubJPanel extends JPanel{
	
	private BufferedImage subBackgroundImage;
	public UsePotionJButton usePotionJButton = new UsePotionJButton(new ImageIcon("image/store/main_potion.png"));
	public UseAutoTapJButton useAutoTapJButton = new UseAutoTapJButton(new ImageIcon("image/store/main_cash.png"));
	
	public SubJPanel(){
		setBounds(3, 403, 352, 189);
		setLayout(null);
		this.setOpaque(false);
		
		try {
			subBackgroundImage = ImageIO.read(new File("image/main/main_sub.png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		usePotionJButton.setFocusable(false);
		useAutoTapJButton.setFocusable(false);
		
		this.add(usePotionJButton);
		this.add(useAutoTapJButton);
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(subBackgroundImage, 0, 0, null);

	}
	

}