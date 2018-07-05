package view.jpanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.View;

public class StoreJPanel extends JPanel implements ActionListener {

	private JPanel itemPanel = new JPanel();
	private JPanel adPanel = new JPanel();
	private JPanel checkPanel = new JPanel();

	private JButton buyPotion = new JButton("P");
	private JButton buyLotto = new JButton("L");
	private JButton buyAutoTap = new JButton("A");
	private JButton buyCash = new JButton("C");

	

	public StoreJPanel() {

		setLayout(null);
		setBounds(3, 52, 338, 516);
		// setBounds(3, 300, 338, 268);
		setBackground(new Color(100, 100, 100));

		itemPanel.setLocation(10, 30);
		itemPanel.setSize(245, 215);

		adPanel.setLocation(10, 255);
		adPanel.setSize(245, 235);
		
		
		
		

		checkPanel.setLocation(50, 50);
		checkPanel.setSize(150, 150);
		checkPanel.setBackground(new Color(100, 100, 100));

		buyPotion.setLocation(265, 30);
		buyPotion.setSize(68, 50);
		buyPotion.addActionListener(this);
		buyPotion.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));

		buyLotto.setLocation(265, 85);
		buyLotto.setSize(68, 50);
		buyLotto.addActionListener(this);
		buyLotto.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));

		buyAutoTap.setLocation(265, 140);
		buyAutoTap.setSize(68, 50);
		buyAutoTap.addActionListener(this);
		buyAutoTap.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));

		buyCash.setLocation(265, 195);
		buyCash.setSize(68, 50);
		buyCash.addActionListener(this);
		buyCash.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));

		this.add(itemPanel);
		this.add(adPanel);
		itemPanel.add(checkPanel);

		checkPanel.setVisible(false);

		this.add(buyPotion);
		this.add(buyLotto);
		this.add(buyAutoTap);
		this.add(buyCash);
	}

	public JPanel getCheckPanel() {
		return checkPanel;
	}

	public void setCheckPanel(JPanel checkPanel) {
		this.checkPanel = checkPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		View.cm().storeMenu(this, e);
	}

}
