package model.dao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import model.vo.Main;
import model.vo.Player;
import model.vo.Quest;
import model.vo.State;
import view.View;
import view.jbutton.BackJButton;
import view.jbutton.LottoJButton;
import view.jbutton.QuestBackJButton;
import view.jbutton.QuestJButton;
import view.jbutton.StateBackJButton;
import view.jbutton.StateJButton;
import view.jbutton.StoreBackJButton;
import view.jbutton.StoreJButton;
import view.jbutton.storeMenuJButton.*;
import view.jlabel.AutoMoneyJLabel;
import view.jlabel.NicknameJLabel;
import view.jlabel.TapMoneyJLabel;
import view.jlabel.TotalMoneyJLabel;
import view.jpanel.LottoJPanel;
import view.jpanel.MainJPanel;
import view.jpanel.QuestJPanel;
import view.jpanel.StateJPanel;
import view.jpanel.StoreJPanel;
import view.jpanel.SubJPanel;

public class DataAccessMain {
	private Main main;

	public DataAccessMain() {
		main = new Main();
	}

	public Main getMain() {
		return main;
	}

	public void potionRun(int time) {
		main.setM_potiontime(time);
		return;
	}

	public void autoRun(int time) {
		main.setM_autotime(time);
		return;
	}

	public void autoRun(TotalMoneyJLabel totalMoneyJLabel, Main main, int time) {
		while (true) {

			if (main.getM_potiontime() > 0) {

				main.setM_AmountOfTapMoney(main.getM_AmountOfTapMoney() * 10);
				int tim = 0;

				for (int i = main.getM_potiontime(); i > 0; i--) {
					try {

						Thread.sleep(100);
						main.setM_potiontime(main.getM_potiontime() - 1);

						if (tim == 10) {
							main.setM_TotalOfMoney(main.getM_TotalOfMoney() + main.getM_AmountOfAutoMoney());
							totalMoneyJLabel.setText(String.format("%,d", main.getM_TotalOfMoney()) + " : 보유");
							tim = 0;
						}

						tim++;

						if (main.getM_autotime() > 0) {

							main.setM_TotalOfMoney(main.getM_TotalOfMoney() + main.getM_AmountOfTapMoney());
							totalMoneyJLabel.setText(String.format("%,d", main.getM_TotalOfMoney()) + " : 보유");

							main.setM_autotime(main.getM_autotime() - 1);
							System.out.println("auto in potion" + main.getM_autotime());

						}

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				main.setM_AmountOfTapMoney(main.getM_AmountOfTapMoney() / 10);

			}

			if (main.getM_autotime() > 0) {

				for (int i = main.getM_autotime(); i > 0; i--) {

					try {
						Thread.sleep(100);

						System.out.println("tap");

						main.setM_autotime(main.getM_autotime() - 1);
						totalMoneyJLabel.setText(String.format("%,d", main.getM_TotalOfMoney()) + " : 보유");
						main.setM_TotalOfMoney(main.getM_TotalOfMoney() + main.getM_AmountOfTapMoney());

						if (main.getM_potiontime() > 0)
							break;

					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}

			} else if (main.getM_autotime() > 0 && main.getM_potiontime() > 0)
				continue;

			try {
				System.out.println(main.getM_TotalOfMoney());
				Thread.sleep(1000);
				totalMoneyJLabel.setText(String.format("%,d", main.getM_TotalOfMoney()) + " : 보유");
				main.setM_TotalOfMoney(main.getM_TotalOfMoney() + main.getM_AmountOfAutoMoney());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void keyReleased(TotalMoneyJLabel totalMoneyJLabel, DataAccessQuest quest, JButton button3) {
		main.setM_TotalOfMoney(main.getM_TotalOfMoney() + main.getM_AmountOfTapMoney());
		totalMoneyJLabel.setText(String.format("%,d", main.getM_TotalOfMoney()) + " : 보유");
		// quest.함수
		quest.questAdd(main, totalMoneyJLabel, button3);
	}

	public void setMain(Player player, NicknameJLabel nicknameJLabel, TotalMoneyJLabel totalMoneyJLabel,
			AutoMoneyJLabel autoMoneyJLabel, TapMoneyJLabel tapMoneyJLabel) {
		nicknameJLabel.setText("player : " + player.getP_Nickname());
		totalMoneyJLabel.setText(String.format("%,d", (main.getM_TotalOfMoney())) + " : 보유");
		autoMoneyJLabel.setText(String.format("%,d", (main.getM_AmountOfAutoMoney())) + " : 자동");
		tapMoneyJLabel.setText(String.format("%,d", (main.getM_AmountOfTapMoney())) + " : 탭");
	}

	public void setPlayer(Player player, State state, Quest quest) {
		main.setM_AmountOfAutoMoney(player.getP_AmountOfAutoMoney());
		main.setM_AmountOfTapMoney(player.getP_AmountOfTapMoney());
		main.setM_qtyOfAutoTap(player.getP_qtyOfAutoTap());
		main.setM_qtyOfLotto(player.getP_qtyOfLotto());
		main.setM_qtyOfPotion(player.getP_qtyOfPotion());
		main.setM_TotalOfMoney(player.getP_TotalOfMoney());
		state.setP_lvOfComputer(player.getP_lvOfComputer());
		state.setP_lvOfEducate(player.getP_lvOfEducate());
		state.setP_lvOfEmploy(player.getP_lvOfEmploy());
		state.setP_lvOfExtend(player.getP_lvOfExtend());
		state.setP_lvOfKeyboard(player.getP_lvOfKeyboard());
		quest.setQ_qtyOfTap(player.getP_qtyOfTap());
	}

	// ----------0706 16:31------------
	public void checkFisrtGame(View view, DataAccessPlayer player, State state, Quest quest,
			NicknameJLabel nicknameJLabel, TotalMoneyJLabel totalMoneyJLabel, AutoMoneyJLabel autoMoneyJLabel,
			TapMoneyJLabel tapMoneyJLabel, MainJPanel mainJPanel) {
		if (player.getPlayer().getP_Nickname().equals("")) {
			int temp = 1;
			String nickname = "";
			while (temp == 1) {
				nickname = JOptionPane.showInputDialog(null, "닉네임 입력", "닉네임 설정", JOptionPane.OK_CANCEL_OPTION);
				if (nickname.length() != 0) {
					for (int i = 0; i < nickname.length(); i++) {
						if (nickname.charAt(i) == 32) {
							JOptionPane.showMessageDialog(null, "닉네임에 띄어쓰기를 넣을 수 없습니다");
							i = nickname.length();
						} else if (i == (nickname.length() - 1)) {
							temp = 2;
						}
					}
				} else {
					if (nickname.length() == 0) {
						JOptionPane.showMessageDialog(null, "닉네임은 공백일 수 없습니다");
					}
				}
			}

			if (!nickname.equals("")) {
				player.setP_Nickname(nickname);
				setPlayer(player.getPlayer(), state, quest);
				setMain(player.getPlayer(), nicknameJLabel, totalMoneyJLabel, autoMoneyJLabel, tapMoneyJLabel);
				autoRun(totalMoneyJLabel, this.getMain(), 0);
			} else {
				view.setVisible(false);
			}
		} else {
			setPlayer(player.getPlayer(), state, quest);
			setMain(player.getPlayer(), nicknameJLabel, totalMoneyJLabel, autoMoneyJLabel, tapMoneyJLabel);
			whileNotPlay(mainJPanel, player.getPlayer());
			autoRun(totalMoneyJLabel, this.getMain(), 0);
		}
	}

	public void whileNotPlay(MainJPanel mainJPanel, Player player) {
		JLabel noticeJLabel = new JLabel("플레이 하지 않은 동안 획득한 금액 ");
		JLabel noticeMoneyJLabel = new JLabel();
		int temp = (int) ((new Date().getTime() - player.getP_lastTime().getTime()) / 1000);

		main.setM_TotalOfMoney(main.getM_TotalOfMoney() + (main.getM_AmountOfTapMoney() * temp));

		noticeJLabel.setBounds(82, 80, 300, 50);
		noticeJLabel.setFont(new Font("맑은 고딕", Font.BOLD, 11));
		noticeJLabel.setForeground(new Color(255, 255, 255));
		noticeMoneyJLabel.setBounds(22, 100, 300, 50);
		noticeMoneyJLabel.setFont(new Font("맑은 고딕", Font.BOLD, 11));
		noticeMoneyJLabel.setForeground(new Color(255, 255, 255));
		noticeMoneyJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		noticeMoneyJLabel.setText(String.format("%,d", (main.getM_AmountOfTapMoney() * temp)));
		mainJPanel.add(noticeJLabel);
		mainJPanel.add(noticeMoneyJLabel);
		mainJPanel.repaint();
		try {
			Thread.sleep(3000);
			noticeJLabel.setVisible(false);
			noticeMoneyJLabel.setVisible(false);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return;
	}

	public void pageMove(View view, ActionEvent e, TotalMoneyJLabel totalMoneyJLabel, MainJPanel mainJPanel,
			DataAccessStore store, StateJPanel stateJPanel, QuestJPanel questJPanel, StoreJPanel storeJPanel,
			LottoJPanel lottoJPanel, SubJPanel subJPanel) {
		if (e.getSource() instanceof StateJButton) {
			stateJPanel.setVisible(true);
			subJPanel.setVisible(false);
			view.add(stateJPanel);
			view.add(mainJPanel);
			view.repaint();
		} else if (e.getSource() instanceof QuestJButton) {
			questJPanel.setVisible(true);
			subJPanel.setVisible(false);
			view.add(questJPanel);
			view.add(mainJPanel);
			view.repaint();
		} else if (e.getSource() instanceof StoreJButton) {
			storeJPanel.setVisible(true);
			subJPanel.setVisible(false);
			view.add(storeJPanel);
			view.add(mainJPanel);
			view.repaint();
		} else if (e.getSource() instanceof LottoJButton) {
			lottoJPanel.setVisible(true);
			subJPanel.setVisible(false);
			view.add(lottoJPanel);
			view.add(mainJPanel);
			view.repaint();
		} else if (e.getSource() instanceof StoreBackJButton) {
			subJPanel.setVisible(true);
			storeJPanel.setVisible(false);
			view.add(mainJPanel);
			view.add(subJPanel);
			view.repaint();
			View.cm().savePlayer();
		} else if (e.getSource() instanceof BackJButton) {
			lottoJPanel.setVisible(false);
			subJPanel.setVisible(true);
			view.add(mainJPanel);
			view.add(subJPanel);
			view.repaint();
		} else if (e.getSource() instanceof StateBackJButton) {
			stateJPanel.setVisible(false);
			subJPanel.setVisible(true);
			view.add(subJPanel);
			view.add(mainJPanel);
			view.repaint();
		} else if (e.getSource() instanceof QuestBackJButton) {
			questJPanel.setVisible(false);
			subJPanel.setVisible(true);
			view.add(subJPanel);
			view.add(mainJPanel);
			view.repaint();
		} else if (e.getSource() instanceof UsePotionJButton) {
			store.useItem(totalMoneyJLabel, mainJPanel, e, this);
		} else if (e.getSource() instanceof UseAutoTapJButton) {
			store.useItem(totalMoneyJLabel, mainJPanel, e, this);
		}

	}

}
