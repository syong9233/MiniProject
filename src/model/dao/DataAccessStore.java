package model.dao;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.vo.Main;
import model.vo.Store;
import view.jpanel.LottoJPanel;

public class DataAccessStore {
   private Store store;
   
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
      
      if(e.getActionCommand().equals("Yes")){
         if(main.getM_qtyOfLotto() != 0){
            
            //보유하고 있는 로또 개수 1 차감
            main.setM_qtyOfLotto(main.getM_qtyOfLotto()-1);
            int r = (int)(Math.random()*10)+1;
            
            
            if( r == 1){
            	//yes탭 눌렀을 떄 당첨시
            	success.setLayout(null);
            	success.setBounds(0, 0, 350, 550);
            	success.setBackground(new Color(80, 50, 30));
            	
            	
            	//당첨 시 얻는 금액에 대한 내용 ( tap 당 금액의 250 배의 금액 )
            	main.setM_TotalOfMoney(main.getM_TotalOfMoney()+(main.getM_AmountOfTapMoney()*250));
            	
            	lottoRegame.add(success);
            	
            	lottoRegame.setVisible(true);
            	
            	
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
      }else if(e.getActionCommand().equals("No")){
         this.No();
         
      
      }else if(e.getActionCommand().equals(" back ")){
         //back버튼을 눌렀을 때 lottoJPanel,yesOrNoPanel은 setvisible(true),
         //fail은 setVisible(false)해야 다시 원상복구 됨 
         //lottoJPanel.repaint
         
         yesOrNoJPanel.setVisible(true);
         lottoJPanel.setVisible(true);
       
         fail.setVisible(false);
         success.setVisible(false);
         
         lottoJPanel.repaint();

      }

   }
   
  
   public void No(){
      
   }
   
   
}
