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
   
   
// ������ ���� ��

	// �����׸����� �̵�
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
	
		if (e.getActionCommand().equals("���ǻ��")) {
			if (main.getM_qtyOfPotion() <= 0) {
				System.out.println("���� �������� �����ϴ�.");
			} else {
				main.setM_qtyOfPotion(main.getM_qtyOfPotion() - 1);
				System.out.println("������ ���Ǿ����ϴ�");

				/* player.getP_lastTime().getTime()) / 1000); */
				// ��� ����
				// main.setM_AmountOfTapMoney(main.getM_AmountOfTapMoney() * 2);

				// �������
				// main.setM_AmountOfTapMoney(main.getM_AmountOfAutoMoney()/2);

				System.out.println(main.getM_qtyOfPotion() + "�� ���ҽ��ϴ�.");
				View.cm().savePlayer();

			}
		}

		if (e.getActionCommand().equals("���ۻ��")) {
			if (main.getM_qtyOfAutoTap() <= 0) {
				System.out.println("���� �������� �����ϴ�.");
			} else {
				main.setM_qtyOfAutoTap(player.getP_qtyOfAutoTap() - 1);
				System.out.println("���۰� ���Ǿ����ϴ�");
				// ��ɱ���
				System.out.println(main.getM_qtyOfAutoTap() + "�� ���ҽ��ϴ�.");
				View.cm().savePlayer();
			}
		}
	}

	public void buyCash(Player player) {

		player.setP_Cash(player.getP_Cash() + 1000);

		System.out.println("���� Cash : " + player.getP_Cash());

	}

	public void buyPotion(Player player, Main main) {

		if (player.getP_Cash() < store.getS_priceOfPotion()) {
			System.out.println("�ݾ��� �����մϴ�.");
			return;
		}

		player.setP_Cash(player.getP_Cash() - store.getS_priceOfPotion());
		main.setM_qtyOfPotion(main.getM_qtyOfPotion() + 1);

		System.out.println("���� ���� �Ϸ�(-1000)");
		System.out.println("���� Cash : " + player.getP_Cash());
		System.out.println("���� ���� ���� : " + main.getM_qtyOfPotion());

		return;

	}

	public void buyLotto(Player player, Main main) {

		if (player.getP_Cash() < store.getS_priceOfLotto()) {
			System.out.println("�ݾ��� �����մϴ�.");
			return;
		}
		player.setP_Cash(player.getP_Cash() - store.getS_priceOfLotto());
		main.setM_qtyOfLotto(main.getM_qtyOfLotto() + 1);

		System.out.println("���� ���� �Ϸ�(-2000)");
		System.out.println("���� Cash : " + player.getP_Cash());
		System.out.println("���� ���� ���� : " + main.getM_qtyOfLotto());

		return;

	}

	public void buyAutoTap(Player player, Main main) {

		if (player.getP_Cash() < store.getS_priceOfAutoTap()) {
			System.out.println("�ݾ��� �����մϴ�.");
			return;
		}
		player.setP_Cash(player.getP_Cash() - store.getS_priceOfAutoTap());
		main.setM_qtyOfAutoTap(main.getM_qtyOfAutoTap() + 1);

		System.out.println("���� ���� �Ϸ�(-500)");
		System.out.println("���� Cash : " + player.getP_Cash());
		System.out.println("���� ���� ���� : " + main.getM_qtyOfAutoTap());

		return;

	}

	public void check(Player player, Main main) {
		System.out.println("���� Cash : " + player.getP_Cash());
		System.out.println("���� ���� ���� : " + main.getM_qtyOfPotion());
		System.out.println("���� ���� ���� : " + main.getM_qtyOfLotto());
		System.out.println("���� ���� ���� : " + main.getM_qtyOfAutoTap());
	}

}
