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
import view.jbutton.StoreBackJButton;
import view.jbutton.YesJButton;
import view.jbutton.storeMenuJButton.*;

import view.jlabel.TotalMoneyJLabel;
import view.jpanel.LottoJPanel;
import view.jpanel.MainJPanel;
import view.jpanel.StoreJPanel;

public class DataAccessStore {
	private Store store;
	

	public DataAccessStore() {
		store = new Store();
	}

	public Store getStore() {
		return store;
	}

	public void lottoStart(ActionEvent e, Main main, LottoJPanel lottoJPanel, JPanel yesOrNoJPanel,
			JButton lottoRegame, JPanel success, JPanel fail) {
		// ��÷/�� �̹��� �ֱ�(try/catch/@override)
		
		if (e.getSource() instanceof YesJButton) {

			if (main.getM_qtyOfLotto() != 0) {
				// �����ϰ� �ִ� �ζ� ���� 1 ����
				main.setM_qtyOfLotto(main.getM_qtyOfLotto() - 1);
				int r = (int) (Math.random() * 2) + 1;
				View.cm().savePlayer();

				if (r == 1) {

					// yes�� ������ �� ��÷��
					success.setLayout(null);
					success.setBounds(0, -35, 350, 550);
					// ��÷ �� ��� �ݾ׿� ���� ���� ( tap �� �ݾ��� 250 ���� �ݾ� )
					main.setM_TotalOfMoney(main.getM_TotalOfMoney() + (main.getM_AmountOfTapMoney() * 250));

					lottoJPanel.add(success);
					lottoRegame.setVisible(true);
					yesOrNoJPanel.setVisible(false);
					success.setVisible(true);

				} else {

					// Yes�� ������ �� �� ��÷��

					fail.setLayout(null);
					fail.setBounds(0, -35, 350, 550);
					fail.setBackground(new Color(80, 50, 30));

					// Ȯ���г� ������
					lottoJPanel.add(fail);
					yesOrNoJPanel.setVisible(false);
					lottoRegame.setVisible(true);
					fail.setVisible(true);

				}
			} else {
				// ������ ���ڶ�ٴ� �޽��� ���

				JOptionPane.showMessageDialog(null, "���� ������ �����մϴ�.", "Warning", JOptionPane.WARNING_MESSAGE);
			}
		} else if (e.getSource() instanceof LottoRegameJButton) {
			// Regame ��ư�� ������ ��

			fail.setVisible(false);
			success.setVisible(false);

			yesOrNoJPanel.setVisible(true);
			lottoJPanel.setVisible(true);

			lottoJPanel.repaint();
			yesOrNoJPanel.repaint();
		}
	}

	// ������ ���� ��

	// �����׸����� �̵�
	public void StoreMenu(StoreJPanel storeJPanel, ActionEvent e, Main main, Player player, JPanel emptyMoneyJPanel,
			BuyPotionJButton buyPotionJButton, BuyAutoTapJButton buyAutoTapJButton, BuyLottoJButton buyLottoJButton,
			BuyCashJButton buyCashJButton, JPanel buyCashJPanel, CashCloseJButton cashCloseJButton) {

		if (e.getSource() instanceof BuyPotionJButton) {

			buyPotion(storeJPanel, player, main, emptyMoneyJPanel, buyPotionJButton, buyAutoTapJButton, buyLottoJButton,
					buyCashJButton);

		} else if (e.getSource() instanceof BuyAutoTapJButton) {

			buyAutoTap(storeJPanel, player, main, emptyMoneyJPanel, buyPotionJButton, buyAutoTapJButton,
					buyLottoJButton, buyCashJButton);

		} else if (e.getSource() instanceof BuyLottoJButton) {

			buyLotto(storeJPanel, player, main, emptyMoneyJPanel, buyPotionJButton, buyAutoTapJButton, buyLottoJButton,
					buyCashJButton);

		} else if (e.getSource() instanceof BuyCashJButton || e.getSource() instanceof Cash1000JButton
				|| e.getSource() instanceof Cash3000JButton || e.getSource() instanceof Cash5000JButton
				|| e.getSource() instanceof CashCloseJButton) {

			buyCash(player, buyPotionJButton, buyAutoTapJButton, buyLottoJButton, buyCashJButton, buyCashJPanel, e, cashCloseJButton);

		} else if (e.getSource() instanceof EmptyMoneyJButton) {

			emptyMoneyJPanel.setVisible(false);
			buyPotionJButton.setVisible(true);
			buyAutoTapJButton.setVisible(true);
			buyLottoJButton.setVisible(true);
			buyCashJButton.setVisible(true);

		}

	}

	public void emptyMoney(JPanel emptyMoneyJPanel, ActionEvent e) {

	}

	public void potionTime(int time) {
		View.cm().potionTime(time);
	}

	public void autoTime(int time) {
		View.cm().autoTime(time);
	}

	public void useItem(TotalMoneyJLabel totalMoneyJLabel, MainJPanel mainJPanel, ActionEvent e, DataAccessMain main) {

		if (e.getSource() instanceof UsePotionJButton) {
			if (main.getMain().getM_qtyOfPotion() <= 0) {
				System.out.println("���� �������� �����ϴ�.");
			} else {
				main.getMain().setM_qtyOfPotion(main.getMain().getM_qtyOfPotion() - 1);
				System.out.println("������ ���Ǿ����ϴ�");

				System.out.println(main.getMain().getM_qtyOfPotion() + "�� ���ҽ��ϴ�.");
				View.cm().savePlayer();

				main.getMain().setM_PotionTime(main.getMain().getM_PotionTime() + (5 * 10));
				potionTime(main.getMain().getM_PotionTime());
			}
		}

		if (e.getSource() instanceof UseAutoTapJButton) {
			System.out.println("21");
			if (main.getMain().getM_qtyOfAutoTap() <= 0) {
				System.out.println("���� �������� �����ϴ�.");
			} else {
				main.getMain().setM_qtyOfAutoTap(main.getMain().getM_qtyOfAutoTap() - 1);
				System.out.println("���۰� ���Ǿ����ϴ�");
				// ��ɱ���
				System.out.println(main.getMain().getM_qtyOfAutoTap() + "�� ���ҽ��ϴ�.");
				View.cm().savePlayer();

				main.getMain().setM_AutoTime(main.getMain().getM_AutoTime() + (5 * 10));
				autoTime(main.getMain().getM_AutoTime());

			}
		}
	}

	public void buyCash(Player player, BuyPotionJButton buyPotionJButton, BuyAutoTapJButton buyAutoTapJButton,
			BuyLottoJButton buyLottoJButton, BuyCashJButton buyCashJButton, JPanel buyCashJPanel, ActionEvent e,
			CashCloseJButton cashCloseJButton) {

		buyPotionJButton.setVisible(false);
		buyAutoTapJButton.setVisible(false);
		buyLottoJButton.setVisible(false);
		buyCashJButton.setVisible(false);
		buyCashJPanel.setVisible(true);

		if (e.getSource() instanceof CashCloseJButton) {

			buyCashJPanel.setVisible(false);
			buyPotionJButton.setVisible(true);
			buyAutoTapJButton.setVisible(true);
			buyLottoJButton.setVisible(true);
			buyCashJButton.setVisible(true);
			View.cm().savePlayer();

		} else if (e.getSource() instanceof Cash1000JButton) {
			player.setP_Cash(player.getP_Cash() + 1000);
		} else if (e.getSource() instanceof Cash3000JButton) {
			player.setP_Cash(player.getP_Cash() + 3000);
		} else if (e.getSource() instanceof Cash5000JButton) {
			player.setP_Cash(player.getP_Cash() + 5000);
		}

		System.out.println("���� Cash : " + player.getP_Cash());

	}

	public void buyPotion(StoreJPanel storeJPanel, Player player, Main main, JPanel emptyMoneyJPanel,
			BuyPotionJButton buyPotionJButton, BuyAutoTapJButton buyAutoTapJButton, BuyLottoJButton buyLottoJButton,
			BuyCashJButton buyCashJButton) {

		if (player.getP_Cash() < store.getS_priceOfPotion()) {

			emptyMoneyJPanel.setVisible(true);
			buyPotionJButton.setVisible(false);
			buyAutoTapJButton.setVisible(false);
			buyLottoJButton.setVisible(false);
			buyCashJButton.setVisible(false);

			System.out.println("�ݾ��� �����մϴ�.");

			return;
		}

		player.setP_Cash(player.getP_Cash() - store.getS_priceOfPotion());
		main.setM_qtyOfPotion(main.getM_qtyOfPotion() + 10);

		System.out.println("���� ���� �Ϸ�(-1000)");
		System.out.println("���� Cash : " + player.getP_Cash());
		System.out.println("���� ���� ���� : " + main.getM_qtyOfPotion());

		return;

	}

	public void buyLotto(StoreJPanel storeJPanel, Player player, Main main, JPanel emptyMoneyJPanel,
			BuyPotionJButton buyPotionJButton, BuyAutoTapJButton buyAutoTapJButton, BuyLottoJButton buyLottoJButton,
			BuyCashJButton buyCashJButton) {

		if (player.getP_Cash() < store.getS_priceOfLotto()) {
			emptyMoneyJPanel.setVisible(true);
			buyPotionJButton.setVisible(false);
			buyAutoTapJButton.setVisible(false);
			buyLottoJButton.setVisible(false);
			buyCashJButton.setVisible(false);
			System.out.println("�ݾ��� �����մϴ�.");
			return;
		}
		player.setP_Cash(player.getP_Cash() - store.getS_priceOfLotto());
		main.setM_qtyOfLotto(main.getM_qtyOfLotto() + 5);

		System.out.println("���� ���� �Ϸ�(-2000)");
		System.out.println("���� Cash : " + player.getP_Cash());
		System.out.println("���� ���� ���� : " + main.getM_qtyOfLotto());

		return;

	}

	public void buyAutoTap(StoreJPanel storeJPanel, Player player, Main main, JPanel emptyMoneyJPanel,
			BuyPotionJButton buyPotionJButton, BuyAutoTapJButton buyAutoTapJButton, BuyLottoJButton buyLottoJButton,
			BuyCashJButton buyCashJButton) {

		if (player.getP_Cash() < store.getS_priceOfAutoTap()) {
			emptyMoneyJPanel.setVisible(true);
			buyPotionJButton.setVisible(false);
			buyAutoTapJButton.setVisible(false);
			buyLottoJButton.setVisible(false);
			buyCashJButton.setVisible(false);
			System.out.println("�ݾ��� �����մϴ�.");
			return;
		}
		player.setP_Cash(player.getP_Cash() - store.getS_priceOfAutoTap());
		main.setM_qtyOfAutoTap(main.getM_qtyOfAutoTap() + 5);

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
