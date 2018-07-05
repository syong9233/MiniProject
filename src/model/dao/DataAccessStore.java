package model.dao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.vo.Main;
import model.vo.Player;
import model.vo.Store;
import view.View;
import view.jpanel.LottoJPanel;
import view.jpanel.StoreJPanel;
import view.jpanel.SubJPanel;
import java.util.Date;

public class DataAccessStore extends Thread {
	private Store store;

	public DataAccessStore() {
		store = new Store();
	}

	public Store getStore() {
		return store;
	}

	public void lottoStart(ActionEvent e, Main main, LottoJPanel lottoJPanel, JPanel yesOrNoJPanel,
			JButton lottoRegame) {
		System.out.println(main.getM_qtyOfLotto());
		// JPanel fail�� ����
		JPanel fail = new JPanel();
		JPanel success = new JPanel();

		if (e.getActionCommand().equals("Yes")) {
			if (main.getM_qtyOfLotto() != 0) {

				// �����ϰ� �ִ� �ζ� ���� 1 ����
				main.setM_qtyOfLotto(main.getM_qtyOfLotto() - 1);
				int r = (int) (Math.random() * 10) + 1;

				if (r == 1) {
					// yes�� ������ �� ��÷��
					success.setLayout(null);
					success.setBounds(0, 0, 350, 550);
					success.setBackground(new Color(80, 50, 30));

					// ��÷ �� ��� �ݾ׿� ���� ���� ( tap �� �ݾ��� 250 ���� �ݾ� )
					main.setM_TotalOfMoney(main.getM_TotalOfMoney() + (main.getM_AmountOfTapMoney() * 250));

					lottoRegame.add(success);

					lottoRegame.setVisible(true);

				} else {
					// Yes�� ������ �� �� ��÷��
					fail.setLayout(null);
					fail.setBounds(0, 0, 350, 550);
					fail.setBackground(new Color(80, 50, 30));

					// Ȯ���г� ������
					yesOrNoJPanel.setVisible(false);
					lottoRegame.setVisible(true);

					lottoJPanel.add(fail);
					lottoJPanel.repaint();
				}

			} else {
				// ������ ���ڶ�ٴ� �޽��� ���
				JOptionPane.showMessageDialog(null, "���� ������ �����մϴ�.", "Warning", JOptionPane.WARNING_MESSAGE);

			}
		} else if (e.getActionCommand().equals("No")) {
			this.No();

		} else if (e.getActionCommand().equals(" back ")) {
			// back��ư�� ������ �� lottoJPanel,yesOrNoPanel�� setvisible(true),
			// fail�� setVisible(false)�ؾ� �ٽ� ���󺹱� ��
			// lottoJPanel.repaint

			yesOrNoJPanel.setVisible(true);
			lottoJPanel.setVisible(true);

			fail.setVisible(false);
			success.setVisible(false);

			lottoJPanel.repaint();

		}

	}

	public void No() {

	}

	// ������ ���� ��

	// �����׸����� �̵�
	public void StoreMenu(StoreJPanel storeJPanel, ActionEvent e, Main main, Player player) {

		if (e.getActionCommand().equals("P")) {

			buyPotion(player);

		} else if (e.getActionCommand().equals("L")) {

			buyLotto(player);

		} else if (e.getActionCommand().equals("A")) {

			buyAutoTap(player);
			
		} else if (e.getActionCommand().equals("C")) {

			buyCash(player);

		}

	}

	public void useItem(SubJPanel subJPanel, ActionEvent e, Main main, Player player) {
		View.cm().loadPlayer();
		if (e.getActionCommand().equals("���ǻ��")) {
			if (player.getP_qtyOfPotion() <= 0) {
				System.out.println("���� �������� �����ϴ�.");
			} else {
				player.setP_qtyOfPotion(player.getP_qtyOfPotion() - 1);
				System.out.println("������ ���Ǿ����ϴ�");

				/* player.getP_lastTime().getTime()) / 1000); */
				// ��� ����
				// main.setM_AmountOfTapMoney(main.getM_AmountOfTapMoney() * 2);

				// �������
				// main.setM_AmountOfTapMoney(main.getM_AmountOfAutoMoney()/2);

				System.out.println(player.getP_qtyOfPotion() + "�� ���ҽ��ϴ�.");
				View.cm().savePlayer();

			}
		}

		if (e.getActionCommand().equals("���ۻ��")) {
			if (player.getP_qtyOfAutoTap() <= 0) {
				System.out.println("���� �������� �����ϴ�.");
			} else {
				player.setP_qtyOfAutoTap(player.getP_qtyOfAutoTap() - 1);
				System.out.println("������ ���Ǿ����ϴ�");
				// ��ɱ���
				System.out.println(player.getP_qtyOfAutoTap() + "�� ���ҽ��ϴ�.");
				View.cm().savePlayer();
			}
		}
	}

	public void buyCash(Player player) {

		player.setP_Cash(player.getP_Cash() + 1000);

		System.out.println("���� Cash : " + player.getP_Cash());

	}

	public void buyPotion(Player player) {

		if (player.getP_Cash() < store.getS_priceOfPotion()) {
			System.out.println("�ݾ��� �����մϴ�.");
			return;
		}

		player.setP_Cash(player.getP_Cash() - store.getS_priceOfPotion());
		player.setP_qtyOfPotion(player.getP_qtyOfPotion() + 1);

		System.out.println("���� ���� �Ϸ�(-1000)");
		System.out.println("���� Cash : " + player.getP_Cash());
		System.out.println("���� ���� ���� : " + player.getP_qtyOfPotion());

		return;

	}

	public void buyLotto(Player player) {

		if (player.getP_Cash() < store.getS_priceOfLotto()) {
			System.out.println("�ݾ��� �����մϴ�.");
			return;
		}
		player.setP_Cash(player.getP_Cash() - store.getS_priceOfLotto());
		player.setP_qtyOfLotto(player.getP_qtyOfLotto() + 1);

		System.out.println("���� ���� �Ϸ�(-2000)");
		System.out.println("���� Cash : " + player.getP_Cash());
		System.out.println("���� ���� ���� : " + player.getP_qtyOfLotto());

		return;

	}

	public void buyAutoTap(Player player) {

		if (player.getP_Cash() < store.getS_priceOfAutoTap()) {
			System.out.println("�ݾ��� �����մϴ�.");
			return;
		}
		player.setP_Cash(player.getP_Cash() - store.getS_priceOfAutoTap());
		player.setP_qtyOfAutoTap(player.getP_qtyOfAutoTap() + 1);

		System.out.println("���� ���� �Ϸ�(-500)");
		System.out.println("���� Cash : " + player.getP_Cash());
		System.out.println("���� ���� ���� : " + player.getP_qtyOfAutoTap());

		return;

	}

	public void check(Player player) {
		System.out.println("���� Cash : " + player.getP_Cash());
		System.out.println("���� ���� ���� : " + player.getP_qtyOfPotion());
		System.out.println("���� ���� ���� : " + player.getP_qtyOfLotto());
		System.out.println("���� ���� ���� : " + player.getP_qtyOfAutoTap());
	}

}
