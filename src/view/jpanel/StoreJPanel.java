package view.jpanel;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowFocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.View;
import view.jbutton.storeMenuJButton.*;

public class StoreJPanel extends JPanel implements ActionListener{
	
	private BuyPotionJButton buyPotionJButton = new BuyPotionJButton(new ImageIcon("image/store/potion.png"));
	private BuyAutoTapJButton buyAutoTapJButton = new BuyAutoTapJButton(new ImageIcon("image/store/autoTap.png"));
	private BuyLottoJButton buyLottoJButton = new BuyLottoJButton(new ImageIcon("image/store/lotto.png"));
	
	private BuyCashJButton buyCashJButton = new BuyCashJButton(new ImageIcon("image/store/cash.png"));
	private Cash1000JButton Cash1000JButton = new Cash1000JButton(new ImageIcon("image/store/store_1000cash.png"));
	private Cash3000JButton Cash3000JButton = new Cash3000JButton(new ImageIcon("image/store/store_3000cash.png"));
	private Cash5000JButton Cash5000JButton = new Cash5000JButton(new ImageIcon("image/store/store_5000cash.png"));
	private CashCloseJButton cashCloseJButton = new CashCloseJButton(new ImageIcon("image/store/common_backButton.png"));
	
	private EmptyMoneyJButton emptyMoneyJButton = new EmptyMoneyJButton(new ImageIcon("image/store/store_moreMoneyButton.png"));
	
	
	
	

	private	JPanel emptyMoneyJPanel ;
	private JPanel buyCashJPanel ;
	
	private BufferedImage  storeBackGroundImage;
	private BufferedImage  emptyPanelImage;
	private BufferedImage  buyCashJPanelImage;
	
	public StoreJPanel() {

		setLayout(null);
		setBounds(3, 56, 350,600 );
		
		emptyMoneyJPanel = new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(emptyPanelImage, 0, 0, null); 
			}
		};
		
		buyCashJPanel = new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(buyCashJPanelImage, 0, 0, null); 
			}
		};
		
		emptyMoneyJPanel.setBounds(23, 170, 320, 280);
		emptyMoneyJPanel.add(emptyMoneyJButton);
		emptyMoneyJPanel.setVisible(false);
		emptyMoneyJPanel.setLayout(null);
		emptyMoneyJPanel.setOpaque(false);
		
		buyCashJPanel.setBounds(10, 110, 319, 356);
		buyCashJPanel.setVisible(false);
		buyCashJPanel.add(Cash1000JButton);
		buyCashJPanel.add(Cash3000JButton);
		buyCashJPanel.add(Cash5000JButton);
		buyCashJPanel.add(cashCloseJButton);
		buyCashJPanel.setLayout(null);
		buyCashJPanel.setOpaque(false);
		
		try {
			storeBackGroundImage = ImageIO.read(new File("image/store/store_background.png"));
			emptyPanelImage = ImageIO.read(new File("image/store/store_moreMoney.png"));
			buyCashJPanelImage = ImageIO.read(new File("image/store/store_cash_payBackground.png"));
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	      //**********버튼투명************
	      buyPotionJButton.setBorderPainted(false);
	      buyPotionJButton.setContentAreaFilled(false);
	      buyPotionJButton.setFocusPainted(false);

	      buyAutoTapJButton.setBorderPainted(false);
	      buyAutoTapJButton.setContentAreaFilled(false);
	      buyAutoTapJButton.setFocusPainted(false);

	      buyLottoJButton.setBorderPainted(false);
	      buyLottoJButton.setContentAreaFilled(false);
	      buyLottoJButton.setFocusPainted(false);

	      buyCashJButton.setBorderPainted(false);
	      buyCashJButton.setContentAreaFilled(false);
	      buyCashJButton.setFocusPainted(false);
		
		
		this.add(emptyMoneyJPanel);
		this.add(buyCashJPanel);
		
		this.add(buyPotionJButton);
		this.add(buyAutoTapJButton);
		this.add(buyLottoJButton);
		this.add(buyCashJButton);
		
		buyPotionJButton.addActionListener(this);
		buyAutoTapJButton.addActionListener(this);
		buyLottoJButton.addActionListener(this);
		buyCashJButton.addActionListener(this);
		emptyMoneyJButton.addActionListener(this);
		Cash1000JButton.addActionListener(this);
		Cash3000JButton.addActionListener(this);
		Cash5000JButton.addActionListener(this);
		cashCloseJButton.addActionListener(this);


	}

	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(storeBackGroundImage, 0, -93, null);

	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		View.cm().storeMenu(this, e, emptyMoneyJPanel, buyPotionJButton, buyAutoTapJButton, buyLottoJButton, 
				buyCashJButton, buyCashJPanel, cashCloseJButton);
	}
	
	

}
