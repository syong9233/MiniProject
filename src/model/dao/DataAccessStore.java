package model.dao;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.vo.Main;
import model.vo.Store;
import view.jbutton.LottoRegameJButton;
import view.jbutton.YesJButton;
import view.jpanel.LottoJPanel;

public class DataAccessStore {
   private Store store;
   private BufferedImage lottoSuccessImage;
   private BufferedImage lottoFailImage;
   
   public DataAccessStore(){
      store = new Store();
   }
   
   public Store getStore(){
      return store;
   }
      
   public void lottoStart(ActionEvent e, Main main, LottoJPanel lottoJPanel, JPanel yesOrNoJPanel, JButton lottoRegame){
	   //��÷/�� �̹��� �ֱ�(try/catch/@override)
	   try {
		   lottoSuccessImage = ImageIO.read(new File("image/lotto/lotto_success.png"));
		   lottoFailImage = ImageIO.read(new File("image/lotto/lotto_fail.png"));
	   } catch (IOException e1) {

		   e1.printStackTrace();
	   }


	   System.out.println(main.getM_qtyOfLotto());
	   JPanel success = new JPanel(){
		   protected void paintComponent(Graphics g){
			   super.paintComponent(g);
			   g.drawImage(lottoSuccessImage, 0, 5, null); 
		   }
	   };
	   
	   JPanel fail = new JPanel(){
		   protected void paintComponent(Graphics g){
			   super.paintComponent(g);
			   g.drawImage(lottoFailImage, 0, 5, null); 
		   }
	   };
	   fail.setVisible(false);
	   success.setVisible(false);

	   if(e.getSource() instanceof YesJButton){
		   
		   if(main.getM_qtyOfLotto() != 0){
			   //�����ϰ� �ִ� �ζ� ���� 1 ����
			   main.setM_qtyOfLotto(main.getM_qtyOfLotto()-1);
			   int r = (int)(Math.random()*2)+1;

			   if( r == 1 ){
				   //yes�� ������ �� ��÷��
				   success.setLayout(null);
				   success.setBounds(0, -35, 350, 550);
				   //��÷ �� ��� �ݾ׿� ���� ���� ( tap �� �ݾ��� 250 ���� �ݾ� )
				   main.setM_TotalOfMoney(main.getM_TotalOfMoney()+(main.getM_AmountOfTapMoney()*250));

				   lottoJPanel.add(success);
				   lottoRegame.setVisible(true);
				   yesOrNoJPanel.setVisible(false);
				   success.setVisible(true);
				   
				  

			   }else{
				   //Yes�� ������ �� �� ��÷��

				   fail.setLayout(null);
				   fail.setBounds(0, -35, 350, 550);
				   fail.setBackground(new Color(80, 50, 30));

				   //Ȯ���г� ������
				   lottoJPanel.add(fail);
				   yesOrNoJPanel.setVisible(false);
				   lottoRegame.setVisible(true);
				   fail.setVisible(true);
				   
				   
			   }
		   }else{
			   //������ ���ڶ�ٴ� �޽��� ���
			   JOptionPane.showMessageDialog(null, "���� ������ �����մϴ�.",   "Warning", JOptionPane.WARNING_MESSAGE);
		   }
	   }else if(e.getSource() instanceof LottoRegameJButton){
		   //Regame ��ư�� ������ ��
		   
		   yesOrNoJPanel.setVisible(true);
		   lottoJPanel.setVisible(true);
		   fail.setVisible(false);
		   success.setVisible(false);
		   
		   lottoJPanel.repaint();
		   yesOrNoJPanel.repaint();
	   }
   }
}
