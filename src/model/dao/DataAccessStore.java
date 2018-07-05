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
	   //당첨/꽝 이미지 넣기(try/catch/@override)
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
			   //보유하고 있는 로또 개수 1 차감
			   main.setM_qtyOfLotto(main.getM_qtyOfLotto()-1);
			   int r = (int)(Math.random()*2)+1;

			   if( r == 1 ){
				   //yes탭 눌렀을 떄 당첨시
				   success.setLayout(null);
				   success.setBounds(0, -35, 350, 550);
				   //당첨 시 얻는 금액에 대한 내용 ( tap 당 금액의 250 배의 금액 )
				   main.setM_TotalOfMoney(main.getM_TotalOfMoney()+(main.getM_AmountOfTapMoney()*250));

				   lottoJPanel.add(success);
				   lottoRegame.setVisible(true);
				   yesOrNoJPanel.setVisible(false);
				   success.setVisible(true);
				   
				  

			   }else{
				   //Yes탭 눌렀을 떄 미 당첨시

				   fail.setLayout(null);
				   fail.setBounds(0, -35, 350, 550);
				   fail.setBackground(new Color(80, 50, 30));

				   //확인패널 없애줌
				   lottoJPanel.add(fail);
				   yesOrNoJPanel.setVisible(false);
				   lottoRegame.setVisible(true);
				   fail.setVisible(true);
				   
				   
			   }
		   }else{
			   //개수가 모자라다는 메시지 출력
			   JOptionPane.showMessageDialog(null, "복권 개수가 부족합니다.",   "Warning", JOptionPane.WARNING_MESSAGE);
		   }
	   }else if(e.getSource() instanceof LottoRegameJButton){
		   //Regame 버튼을 눌렀을 때
		   
		   yesOrNoJPanel.setVisible(true);
		   lottoJPanel.setVisible(true);
		   fail.setVisible(false);
		   success.setVisible(false);
		   
		   lottoJPanel.repaint();
		   yesOrNoJPanel.repaint();
	   }
   }
}
