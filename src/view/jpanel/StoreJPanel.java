package view.jpanel;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.View;
import view.jbutton.YesJButton;
import view.jbutton.storeMenuJButton.*;

public class StoreJPanel extends JPanel implements ActionListener {
	
	private BuyPotionJButton buyPotionJButton = new BuyPotionJButton(new ImageIcon("image/store/potion.png"));
	private BuyAutoTapJButton buyAutoTapJButton = new BuyAutoTapJButton(new ImageIcon("image/store/autoTap.png"));
	private BuyLottoJButton buyLottoJButton = new BuyLottoJButton(new ImageIcon("image/store/lotto.png"));
	private BuyCashJButton buyCashJButton = new BuyCashJButton(new ImageIcon("image/store/cash.png"));
 
	private BufferedImage  storeBackGroundImage;

	public StoreJPanel() {

		setLayout(null);
		setBounds(3, 52, 338, 610);
		setBackground(new Color(100, 100, 100));
		
		
		try {
			storeBackGroundImage = ImageIO.read(new File("image/store/testBackGround.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.add(buyPotionJButton);
		this.add(buyAutoTapJButton);
		this.add(buyLottoJButton);
		this.add(buyCashJButton);

		buyPotionJButton.addActionListener(this);
		buyAutoTapJButton.addActionListener(this);
		buyLottoJButton.addActionListener(this);
		buyCashJButton.addActionListener(this);
		
	}

	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(storeBackGroundImage, 0, -93, null);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		View.cm().storeMenu(this, e);
	}

}
