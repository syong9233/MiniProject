package view.jpanel;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import view.jbutton.storeMenuJButton.UseAutoTapJButton;
import view.jbutton.storeMenuJButton.UsePotionJButton;

public class SubJPanel extends JPanel{
	
	public UsePotionJButton usePotionJButton = new UsePotionJButton(new ImageIcon("image/store/usePotion.png"));
	public UseAutoTapJButton useAutoTapJButton = new UseAutoTapJButton(new ImageIcon("image/store/useAutoTap.png"));
	
	public SubJPanel(){
		setBounds(3, 403, 338, 165);
		setOpaque(false);
		setLayout(null);

		usePotionJButton.setFocusable(false);
		useAutoTapJButton.setFocusable(false);

		add(usePotionJButton);
		add(useAutoTapJButton);	
	}
}