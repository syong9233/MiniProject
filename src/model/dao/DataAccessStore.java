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
import model.vo.Player;
import model.vo.Store;
import view.View;
import view.jbutton.LottoRegameJButton;
import view.jbutton.YesJButton;
import view.jpanel.LottoJPanel;
import view.jpanel.StoreJPanel;
import view.jpanel.SubJPanel;

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
   
   
// 아이템 구매 탭

	// 구매항목으로 이동
	public void StoreMenu(StoreJPanel storeJPanel, ActionEvent e, Main main, Player player) {

		if (e.getActionCommand().equals("P")) {

			buyPotion(player, main);

		} else if (e.getActionCommand().equals("L")) {

			buyLotto(player, main);

		} else if (e.getActionCommand().equals("A")) {

			buyAutoTap(player, main);
			
		} else if (e.getActionCommand().equals("C")) {

			buyCash(player);

		}

	}

	public void useItem(SubJPanel subJPanel, ActionEvent e, Main main, Player player) {
	
		if (e.getActionCommand().equals("포션사용")) {
			if (main.getM_qtyOfPotion() <= 0) {
				System.out.println("포션 보유량이 없습니다.");
			} else {
				main.setM_qtyOfPotion(main.getM_qtyOfPotion() - 1);
				System.out.println("포션이 사용되었습니다");

				/* player.getP_lastTime().getTime()) / 1000); */
				// 기능 구현
				// main.setM_AmountOfTapMoney(main.getM_AmountOfTapMoney() * 2);

				// 기능해제
				// main.setM_AmountOfTapMoney(main.getM_AmountOfAutoMoney()/2);

				System.out.println(main.getM_qtyOfPotion() + "개 남았습니다.");
				View.cm().savePlayer();

			}
		}

		if (e.getActionCommand().equals("헬퍼사용")) {
			if (main.getM_qtyOfAutoTap() <= 0) {
				System.out.println("헬퍼 보유량이 없습니다.");
			} else {
				main.setM_qtyOfAutoTap(player.getP_qtyOfAutoTap() - 1);
				System.out.println("헬퍼가 사용되었습니다");
				// 기능구현
				System.out.println(main.getM_qtyOfAutoTap() + "개 남았습니다.");
				View.cm().savePlayer();
			}
		}
	}

	public void buyCash(Player player) {

		player.setP_Cash(player.getP_Cash() + 1000);

		System.out.println("현재 Cash : " + player.getP_Cash());

	}

	public void buyPotion(Player player, Main main) {

		if (player.getP_Cash() < store.getS_priceOfPotion()) {
			System.out.println("금액이 부족합니다.");
			return;
		}

		player.setP_Cash(player.getP_Cash() - store.getS_priceOfPotion());
		main.setM_qtyOfPotion(main.getM_qtyOfPotion() + 1);

		System.out.println("포션 구매 완료(-1000)");
		System.out.println("현재 Cash : " + player.getP_Cash());
		System.out.println("현재 포션 개수 : " + main.getM_qtyOfPotion());

		return;

	}

	public void buyLotto(Player player, Main main) {

		if (player.getP_Cash() < store.getS_priceOfLotto()) {
			System.out.println("금액이 부족합니다.");
			return;
		}
		player.setP_Cash(player.getP_Cash() - store.getS_priceOfLotto());
		main.setM_qtyOfLotto(main.getM_qtyOfLotto() + 1);

		System.out.println("복권 구매 완료(-2000)");
		System.out.println("현재 Cash : " + player.getP_Cash());
		System.out.println("현재 복권 개수 : " + main.getM_qtyOfLotto());

		return;

	}

	public void buyAutoTap(Player player, Main main) {

		if (player.getP_Cash() < store.getS_priceOfAutoTap()) {
			System.out.println("금액이 부족합니다.");
			return;
		}
		player.setP_Cash(player.getP_Cash() - store.getS_priceOfAutoTap());
		main.setM_qtyOfAutoTap(main.getM_qtyOfAutoTap() + 1);

		System.out.println("헬퍼 구매 완료(-500)");
		System.out.println("현재 Cash : " + player.getP_Cash());
		System.out.println("현재 헬퍼 개수 : " + main.getM_qtyOfAutoTap());

		return;

	}

	public void check(Player player, Main main) {
		System.out.println("현재 Cash : " + player.getP_Cash());
		System.out.println("현재 포션 개수 : " + main.getM_qtyOfPotion());
		System.out.println("현재 복권 개수 : " + main.getM_qtyOfLotto());
		System.out.println("현재 헬퍼 개수 : " + main.getM_qtyOfAutoTap());
	}

}
