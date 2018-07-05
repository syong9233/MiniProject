package model.dao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

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
	   System.out.println(main.getM_qtyOfLotto());
	   //JPanel fail을 생성
	   JPanel fail = new JPanel();
	   JPanel success = new JPanel();
	   
	   /*//당첨/꽝 이미지 넣기(try/catch/@override)
	   try {
		   lottoSuccessImage = ImageIO.read(new File("image/lotto/lotto_success.png"));
		   lottoFailImage = ImageIO.read(new File("image/lotto/lotto_fail.png"));		
	   } catch (IOException e1) {
		   e1.printStackTrace();
	   }*/
	   
	   
	   LottoJPanel da = new LottoJPanel();
	   //e.getSource() == btn1
	   if(e.getSource() instanceof YesJButton){
		   if(main.getM_qtyOfLotto() != 0){
			   //보유하고 있는 로또 개수 1 차감
			   main.setM_qtyOfLotto(main.getM_qtyOfLotto()-1);
			   int r = (int)(Math.random()*10)+1;

			   if( r == 1 ){
				   //yes탭 눌렀을 떄 당첨시
				   success.setLayout(null);
				   success.setBounds(0, 0, 350, 550);
				   success.setBackground(new Color(200, 200, 200));

				   //당첨 시 얻는 금액에 대한 내용 ( tap 당 금액의 250 배의 금액 )
				   main.setM_TotalOfMoney(main.getM_TotalOfMoney()+(main.getM_AmountOfTapMoney()*250));

				   lottoRegame.setVisible(true);
				   yesOrNoJPanel.setVisible(false);
				   lottoJPanel.add(success);
				   lottoJPanel.repaint();
				   
			   }else{
				   //Yes탭 눌렀을 떄 미 당첨시
				   fail.setLayout(null);
				   fail.setBounds(0, 0, 350, 550);
				   fail.setBackground(new Color(80, 50, 30));

				   //확인패널 없애줌
				   yesOrNoJPanel.setVisible(false);
				   lottoRegame.setVisible(true);
				   lottoJPanel.add(fail);
				   lottoJPanel.repaint();
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
	   }

   }
   
}
