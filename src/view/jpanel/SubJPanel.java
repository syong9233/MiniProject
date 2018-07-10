package view.jpanel;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import view.View;
import view.jbutton.storeMenuJButton.UseAutoTapJButton;
import view.jbutton.storeMenuJButton.UsePotionJButton;

public class SubJPanel extends JPanel {

	private BufferedImage subBackgroundImage;
	public UsePotionJButton usePotionJButton = new UsePotionJButton(new ImageIcon("image/main/main_potion.png"));
	public UseAutoTapJButton useAutoTapJButton = new UseAutoTapJButton(new ImageIcon("image/main/main_cash.png"));

	public SubJPanel() {

		setBounds(3, 403, 338, 165);
		setOpaque(false);
		setLayout(null);
		
		usePotionJButton.setFocusable(false);
		useAutoTapJButton.setFocusable(false);
		
		this.add(usePotionJButton);
		this.add(useAutoTapJButton);
		
		try {
			subBackgroundImage = ImageIO.read(new File("image/main/main_sub.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 패널에 이미지 넣는방법
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(subBackgroundImage, 0, 0, null);

	}

	
}
