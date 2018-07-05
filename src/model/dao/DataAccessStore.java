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
		// JPanel fail을 생성
		JPanel fail = new JPanel();
		JPanel success = new JPanel();

		if (e.getActionCommand().equals("Yes")) {
			if (main.getM_qtyOfLotto() != 0) {

				// 보유하고 있는 로또 개수 1 차감
				main.setM_qtyOfLotto(main.getM_qtyOfLotto() - 1);
				int r = (int) (Math.random() * 10) + 1;

				if (r == 1) {
					// yes탭 눌렀을 떄 당첨시
					success.setLayout(null);
					success.setBounds(0, 0, 350, 550);
					success.setBackground(new Color(80, 50, 30));

					// 당첨 시 얻는 금액에 대한 내용 ( tap 당 금액의 250 배의 금액 )
					main.setM_TotalOfMoney(main.getM_TotalOfMoney() + (main.getM_AmountOfTapMoney() * 250));

					lottoRegame.add(success);

					lottoRegame.setVisible(true);

				} else {
					// Yes탭 눌렀을 떄 미 당첨시
					fail.setLayout(null);
					fail.setBounds(0, 0, 350, 550);
					fail.setBackground(new Color(80, 50, 30));

					// 확인패널 없애줌
					yesOrNoJPanel.setVisible(false);
					lottoRegame.setVisible(true);

					lottoJPanel.add(fail);
					lottoJPanel.repaint();
				}

			} else {
				// 개수가 모자라다는 메시지 출력
				JOptionPane.showMessageDialog(null, "복권 개수가 부족합니다.", "Warning", JOptionPane.WARNING_MESSAGE);

			}
		} else if (e.getActionCommand().equals("No")) {
			this.No();

		} else if (e.getActionCommand().equals(" back ")) {
			// back버튼을 눌렀을 때 lottoJPanel,yesOrNoPanel은 setvisible(true),
			// fail은 setVisible(false)해야 다시 원상복구 됨
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

	// 아이템 구매 탭

	// 구매항목으로 이동
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
		if (e.getActionCommand().equals("포션사용")) {
			if (player.getP_qtyOfPotion() <= 0) {
				System.out.println("포션 보유량이 없습니다.");
			} else {
				player.setP_qtyOfPotion(player.getP_qtyOfPotion() - 1);
				System.out.println("포션이 사용되었습니다");

				/* player.getP_lastTime().getTime()) / 1000); */
				// 기능 구현
				// main.setM_AmountOfTapMoney(main.getM_AmountOfTapMoney() * 2);

				// 기능해제
				// main.setM_AmountOfTapMoney(main.getM_AmountOfAutoMoney()/2);

				System.out.println(player.getP_qtyOfPotion() + "개 남았습니다.");
				View.cm().savePlayer();

			}
		}

		if (e.getActionCommand().equals("헬퍼사용")) {
			if (player.getP_qtyOfAutoTap() <= 0) {
				System.out.println("헬퍼 보유량이 없습니다.");
			} else {
				player.setP_qtyOfAutoTap(player.getP_qtyOfAutoTap() - 1);
				System.out.println("포션이 사용되었습니다");
				// 기능구현
				System.out.println(player.getP_qtyOfAutoTap() + "개 남았습니다.");
				View.cm().savePlayer();
			}
		}
	}

	public void buyCash(Player player) {

		player.setP_Cash(player.getP_Cash() + 1000);

		System.out.println("현재 Cash : " + player.getP_Cash());

	}

	public void buyPotion(Player player) {

		if (player.getP_Cash() < store.getS_priceOfPotion()) {
			System.out.println("금액이 부족합니다.");
			return;
		}

		player.setP_Cash(player.getP_Cash() - store.getS_priceOfPotion());
		player.setP_qtyOfPotion(player.getP_qtyOfPotion() + 1);

		System.out.println("포션 구매 완료(-1000)");
		System.out.println("현재 Cash : " + player.getP_Cash());
		System.out.println("현재 포션 개수 : " + player.getP_qtyOfPotion());

		return;

	}

	public void buyLotto(Player player) {

		if (player.getP_Cash() < store.getS_priceOfLotto()) {
			System.out.println("금액이 부족합니다.");
			return;
		}
		player.setP_Cash(player.getP_Cash() - store.getS_priceOfLotto());
		player.setP_qtyOfLotto(player.getP_qtyOfLotto() + 1);

		System.out.println("복권 구매 완료(-2000)");
		System.out.println("현재 Cash : " + player.getP_Cash());
		System.out.println("현재 복권 개수 : " + player.getP_qtyOfLotto());

		return;

	}

	public void buyAutoTap(Player player) {

		if (player.getP_Cash() < store.getS_priceOfAutoTap()) {
			System.out.println("금액이 부족합니다.");
			return;
		}
		player.setP_Cash(player.getP_Cash() - store.getS_priceOfAutoTap());
		player.setP_qtyOfAutoTap(player.getP_qtyOfAutoTap() + 1);

		System.out.println("헬퍼 구매 완료(-500)");
		System.out.println("현재 Cash : " + player.getP_Cash());
		System.out.println("현재 헬퍼 개수 : " + player.getP_qtyOfAutoTap());

		return;

	}

	public void check(Player player) {
		System.out.println("현재 Cash : " + player.getP_Cash());
		System.out.println("현재 포션 개수 : " + player.getP_qtyOfPotion());
		System.out.println("현재 복권 개수 : " + player.getP_qtyOfLotto());
		System.out.println("현재 헬퍼 개수 : " + player.getP_qtyOfAutoTap());
	}

}
