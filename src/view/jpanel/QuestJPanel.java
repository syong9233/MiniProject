package view.jpanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import view.View;

public class QuestJPanel extends JPanel implements ActionListener{
	public JButton button1 = new JButton("ÅÇ Äù½ºÆ®");
	public JButton button2 = new JButton("µ· È¹µæ Äù½ºÆ®");
	public JButton button3 = new JButton("Äù½ºÆ® ¿Ï·á2");
	public JButton button4 = new JButton("Äù½ºÆ® ¿Ï·á2");
	
	public QuestJPanel(){
		
		setLayout(null);
		setBounds(3, 300, 338, 268);
		setBackground(new Color(100, 100, 100));
		
		 
		 button1.setLocation(10, 20);
	     button1.setSize(100,20);
	      
	     button2.setLocation(10, 130);
	     button2.setSize(100,20);
	      
	     button3.setLocation(200, 70);
	     button3.setSize(120,30);
	      
	     button4.setLocation(200, 180);
	     button4.setSize(120,30);
	      
	     add(button1);
	     add(button2);
	     add(button3);
	     add(button4);
	     
	     button1.addActionListener(this);
	     button2.addActionListener(this);
	     button3.addActionListener(this);
	     button4.addActionListener(this);
	    
	    button1.setFocusable(false);	//¹öÆ° Æ÷Ä¿½º º¯°æ
	    button2.setFocusable(false);
	    button3.setFocusable(false);
	    button4.setFocusable(false);
	    
	    
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		View.cm().questChoice(e, button3, button4);
		
	}
}
