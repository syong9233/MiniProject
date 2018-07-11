package view.jpanel;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.View;
import view.jbutton.questMenuJButton.questComplete_1;
import view.jbutton.questMenuJButton.questComplete_2;
//import view.jbutton.questMenuJButton.questComplete;

public class QuestJPanel extends JPanel implements ActionListener{
   
   //***********JButton 객체 생성 및 변수 선언_180707_1************
   public questComplete_1 button1 = new questComplete_1(new ImageIcon("image/quest/quest_complete.png"));
   public questComplete_2 button2 = new questComplete_2(new ImageIcon("image/quest/quest_complete.png"));
   public JLabel questLabel = new JLabel(new ImageIcon("image/quest/quest_name.png"));
   
   public JLabel goalTap = new JLabel();
   public JLabel ingTap = new JLabel();
   public JLabel goalMoney = new JLabel();
   public JLabel ingMoney = new JLabel();
   
   private BufferedImage questPanelImage;
   //------------------------------------------------------------------------
   
   
   
   public QuestJPanel(){
      //***************QuestJPanel_180707_1 ****************
      setLayout(null);
      setBounds(0, 212, 360, 380);
      //------------------------------------------------------
      
      try {
         questPanelImage = ImageIO.read(new File("image/quest/quest_subpanel_background.png"));
      } catch (IOException e) {

         e.printStackTrace();
      }

      //****************각각의 JButton Setting_180707_1****************
      questLabel.setLocation(225, 10); //퀘스트 네임
      
      
      goalTap.setLocation(50, 110);
      ingTap.setLocation(190, 110);
      goalMoney.setLocation(30, 240);
      ingMoney.setLocation(160, 240);
      
      button1.setLocation(275, 100);
      button2.setLocation(275, 230);
      
      questLabel.setSize(100, 30);
      
      goalTap.setSize(130, 50);
      ingTap.setSize(130, 50);
      goalMoney.setSize(150, 50);
      ingMoney.setSize(150, 50);
      
      Font f1 = new Font("궁서", Font.BOLD, 20);
      Font f2 = new Font("궁서", Font.BOLD, 20);
      Font f3 = new Font("궁서", Font.BOLD, 12);
      Font f4 = new Font("궁서", Font.BOLD, 12);
      
      goalTap.setFont(f1);
      ingTap.setFont(f2);
      goalMoney.setFont(f3);
      ingMoney.setFont(f4);
      
      button1.setSize(70, 65);
      button2.setSize(70, 65);
      
      button1.setFocusable(false);
      button2.setFocusable(false);
      //------------------------------------------------------------
      
      //***********add this, add action _180707_1************
      button1.addActionListener(this);
      button2.addActionListener(this);
      
      add(questLabel);
      
      add(goalTap);
      add(ingTap);
      add(goalMoney);
      add(ingMoney);
      
      add(button1);
      add(button2);
      
      //--------------------------------------------------------
      button1.setBorderPainted(false);
      button1.setContentAreaFilled(false);
      button1.setFocusPainted(false);
      
      button2.setBorderPainted(false);
      button2.setContentAreaFilled(false);
      button2.setFocusPainted(false);
      
      this.setOpaque(false);
   }

   //*********JButton 이벤트 발생 시작 메소드_180707_1************
   @Override
   public void actionPerformed(ActionEvent e) {
      View.cm().questChoice(e, button1, button2);
   }
   //---------------------------------------------------------
   @Override
   protected void paintComponent(Graphics g){
      super.paintComponent(g);
      g.drawImage(questPanelImage, -1, 1, null);

   }
}
