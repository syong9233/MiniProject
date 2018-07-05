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
   
   
   
   public void lottoStart(ActionEvent e, Main main, LottoJPanel lottoJPanel, JPanel yesOrNoJPanel, JButton lottoBackButton){
      System.out.println(main.getM_qtyOfLotto());
      //JPanel fail을 다시 만들어서 
      JPanel fail;
      if(e.getActionCommand().equals("Yes")){
         if(main.getM_qtyOfLotto() != 0){
            
            //보유하고 있는 로또 개수 1 차감
            main.setM_qtyOfLotto(main.getM_qtyOfLotto()-1);
            int r = (int)(Math.random()*10)+1;
            
            
            //Yes탭 눌렀을 때 당첨시
            //당첨 시 얻는 금액에 대한 내용 ( tap 당 금액의 250 배의 금액 )
            if( r == 1){
               main.setM_TotalOfMoney(main.getM_TotalOfMoney()+(main.getM_AmountOfTapMoney()*250));
               
            //Yes탭 눌렀을 떄 미 당첨시
            }else{
               fail = new JPanel();
               fail.setLayout(null);
               fail.setBounds(0, 0, 350, 550);
               fail.setBackground(new Color(80, 50, 30));
               
               //확인패널 없애줌
               yesOrNoJPanel.setVisible(false);
               
               
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
         lottoBackButton.setVisible(false);
         lottoJPanel.repaint();

         //******반복실행이 안됨 ㅠㅠ*******



      }

   }
   
   public void yes(Main main, LottoJPanel lottoJPanel, JPanel yesOrNoJPanel){
      
      //보유하고 있는 로또 개수 1 차감
      main.setM_qtyOfLotto(main.getM_qtyOfLotto()-1);
      int r = (int)(Math.random()*10)+1;
      
      //당첨 시 얻는 금액에 대한 내용 ( tap 당 금액의 250 배의 금액 )
      if( r == 1){
         main.setM_TotalOfMoney(main.getM_TotalOfMoney()+(main.getM_AmountOfTapMoney()*250));
      }else{
         JPanel fail = new JPanel();
         
         fail.setLayout(null);
         fail.setBounds(0, 0, 350, 550);
         fail.setBackground(new Color(80, 50, 30));
         yesOrNoJPanel.setVisible(false);
         lottoJPanel.add(fail);
         lottoJPanel.repaint();
      }
      
   }
   public void No(){
      
   }
   
   
}
