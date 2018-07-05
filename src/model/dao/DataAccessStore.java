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
      //JPanel fail�� ����
      JPanel fail = new JPanel();
      JPanel success = new JPanel();
      
      if(e.getActionCommand().equals("Yes")){
         if(main.getM_qtyOfLotto() != 0){
            
            //�����ϰ� �ִ� �ζ� ���� 1 ����
            main.setM_qtyOfLotto(main.getM_qtyOfLotto()-1);
            int r = (int)(Math.random()*10)+1;
            
            
            if( r == 1){
            	//yes�� ������ �� ��÷��
            	success.setLayout(null);
            	success.setBounds(0, 0, 350, 550);
            	success.setBackground(new Color(80, 50, 30));
            	
            	
            	//��÷ �� ��� �ݾ׿� ���� ���� ( tap �� �ݾ��� 250 ���� �ݾ� )
            	main.setM_TotalOfMoney(main.getM_TotalOfMoney()+(main.getM_AmountOfTapMoney()*250));
            	
            	lottoRegame.add(success);
            	
            	lottoRegame.setVisible(true);
            	
            	
            }else{
            	//Yes�� ������ �� �� ��÷��
            	fail.setLayout(null);
            	fail.setBounds(0, 0, 350, 550);
            	fail.setBackground(new Color(80, 50, 30));

            	//Ȯ���г� ������
            	yesOrNoJPanel.setVisible(false);
            	lottoRegame.setVisible(true);
            	


            	lottoJPanel.add(fail);
            	lottoJPanel.repaint();
            }
            
         }else{
            //������ ���ڶ�ٴ� �޽��� ���
            JOptionPane.showMessageDialog(null, "���� ������ �����մϴ�.",   "Warning", JOptionPane.WARNING_MESSAGE);
                                    
         }
      }else if(e.getActionCommand().equals("No")){
         this.No();
         
      
      }else if(e.getActionCommand().equals(" back ")){
         //back��ư�� ������ �� lottoJPanel,yesOrNoPanel�� setvisible(true),
         //fail�� setVisible(false)�ؾ� �ٽ� ���󺹱� �� 
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
