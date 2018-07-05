package view.jpanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ControllerManager;
import view.View;

public class LottoJPanel extends JPanel implements ActionListener{
   private JButton button1 = new JButton("Yes");
   private JButton button2 = new JButton("��������");
   private JPanel yesOrNoJPanel = new JPanel();
   private JLabel confirm = new JLabel("������ Ȯ���Ͻðڽ��ϱ�?");
   private JButton lottoRegame = new JButton("Regame");
   

   public LottoJPanel(){
	   this.setLayout(null);
	   this.setBounds(0, 50, 350, 600);
	   this.setBackground(new Color(100, 100, 100));


	   //******�ζ� back��ư*************
	   lottoRegame.setSize(100, 20);
	   lottoRegame.setLocation(235, 470);
	   lottoRegame.addActionListener(this);
	   lottoRegame.setVisible(false);


	   this.add(lottoRegame);


	   //********************************
	   yesOrNoJPanel.setLayout(null);
	   yesOrNoJPanel.setBounds(23, 300, 300, 150);
	   this.add(yesOrNoJPanel);

	   //*******yes no ��ư �߰� **********
	   button1.setLocation(35,100);
	   button1.setSize(110,30);
	   yesOrNoJPanel.add(button1);

	   button2.setLocation(155, 100);
	   button2.setSize(110,30);
	   yesOrNoJPanel.add(button2);

	   //*******"������ �����ðڽ��ϱ�?"���� �ִ� ��********
	   confirm.setHorizontalAlignment(JLabel.RIGHT);
	   confirm.setFont(new Font("�������", Font.BOLD, 15));
	   confirm.setForeground(new Color(0,0,0));
	   confirm.setBounds(14,0,220,100);

	   yesOrNoJPanel.add(confirm);

	   //this�� ���� Ŭ����
	   //button�� ��ư �׼��� �߰���
	   button1.addActionListener(this);
	   button2.addActionListener(this);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
	   
	   View.cm().lottoStart(e, this, yesOrNoJPanel, lottoRegame);
	  
   }

   
}