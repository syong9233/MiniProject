package view.jpanel;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import view.jbutton.storeMenuJButton.*;


public class SubJPanel extends JPanel{
	
	public UsePotionJButton usePotionJButton = new UsePotionJButton(new ImageIcon("image/store/usePotion.png"));
	public UseAutoTapJButton useAutoTapJButton = new UseAutoTapJButton(new ImageIcon("image/store/useAutoTap.png"));
	
	public SubJPanel(){
		setBounds(3, 403, 338, 165);
		setBackground(new Color(100, 100, 100));
		setLayout(null);
		
		
		
		usePotionJButton.setFocusable(false);
		useAutoTapJButton.setFocusable(false);
		
		this.add(usePotionJButton);
		this.add(useAutoTapJButton);
		
	}

}