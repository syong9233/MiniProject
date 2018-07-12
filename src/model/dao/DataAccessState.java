package model.dao;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

import model.vo.Main;
import model.vo.State;
import view.View;
import view.jlabel.AutoMoneyJLabel;
import view.jlabel.NicknameJLabel;
import view.jlabel.TapMoneyJLabel;
import view.jlabel.TotalMoneyJLabel;
import view.jpanel.MainJPanel;
import view.jpanel.StateJPanel;

public class DataAccessState {
	private State state;

	public DataAccessState() {
		state = new State();
	}

	public State getState() {
		return state;
	}

	// ***************���� ��ư ���̽�****************
	public void choice(String choice, Main main, JProgressBar stateBar, MainJPanel mainJPanel, StateJPanel stateJPanel,
			View view, NicknameJLabel nicknameJLabel, TotalMoneyJLabel totalMoneyJLabel,
			AutoMoneyJLabel autoMoneyJLabel, TapMoneyJLabel tapMoneyJLabel) {
		if (choice.equals("ȸ�� Ȯ��")) {
			extendLevelUp(main, stateBar, mainJPanel, stateJPanel, view, totalMoneyJLabel, nicknameJLabel,
					autoMoneyJLabel, tapMoneyJLabel);
		} else if (choice.equals("���� �̼�")) {
			educateLevelUp(main, stateBar, autoMoneyJLabel, tapMoneyJLabel);
		} else if (choice.equals("���� ���")) {
			employLevelUp(main, stateBar, autoMoneyJLabel, tapMoneyJLabel);

		} else if (choice.equals("��ǻ�� ���")) {
			computerLevelUp(main, stateBar, autoMoneyJLabel, tapMoneyJLabel);
		} else if (choice.equals("Ÿ�ڼ�")) {
			keyboardLevelUp(main, stateBar, autoMoneyJLabel, tapMoneyJLabel);
		}
	}

	// ***************180711_ȸ��Ȯ�� ����_�� ����(ȸ��Level * 2õ����, ����:��
	// x3)****************
	public void extendLevelUp(Main main, JProgressBar extendBar, MainJPanel mainJPanel, StateJPanel stateJPanel,
			View view, TotalMoneyJLabel totalMoneyJLabel, NicknameJLabel nicknameJLabel,
			AutoMoneyJLabel autoMoneyJLabel, TapMoneyJLabel tapMoneyJLabel) {
		JLabel lv3JBackImageLabel = new JLabel(new ImageIcon(new ImageIcon("image/main/final_lv3.png").getImage()
				.getScaledInstance(338, 600, java.awt.Image.SCALE_SMOOTH)));
		JLabel lv5JBackImageLabel = new JLabel(new ImageIcon(new ImageIcon("image/main/final_lv5.png").getImage()
				.getScaledInstance(338, 600, java.awt.Image.SCALE_SMOOTH)));
		JLabel lv7JBackImageLabel = new JLabel(new ImageIcon(new ImageIcon("image/main/final_lv7.png").getImage()
				.getScaledInstance(338, 600, java.awt.Image.SCALE_SMOOTH)));
		JLabel lv10JBackImageLabel = new JLabel(new ImageIcon(new ImageIcon("image/main/final_lv9.png").getImage()
				.getScaledInstance(338, 600, java.awt.Image.SCALE_SMOOTH)));

		lv3JBackImageLabel.setSize(338, 600);
		lv5JBackImageLabel.setSize(338, 600);
		lv7JBackImageLabel.setSize(338, 600);
		lv10JBackImageLabel.setSize(338, 600);

		lv3JBackImageLabel.setLocation(0, -30);
		lv5JBackImageLabel.setLocation(0, -30);
		lv7JBackImageLabel.setLocation(0, -30);
		lv10JBackImageLabel.setLocation(0, -30);

		if (state.getP_lvOfExtend() < 10) { // ȸ��Level < 10
			if (state.getP_lvOfExtend() < 7) {
				if (main.getM_TotalOfMoney() > (state.getP_lvOfExtend() * 20000000)) { // ��
																						// �ݾ�
																						// >
																						// �����Ӵ�
					System.out.println(state.getP_lvOfExtend() * 20000000);
					main.setM_TotalOfMoney(main.getM_TotalOfMoney() - (state.getP_lvOfExtend() * 20000000)); // ����
																												// �ݾ�.
																												// ��ü
																												// ��
																												// -
																												// �����Ӵ�
					state.setP_lvOfExtend((byte) (state.getP_lvOfExtend() + 1)); // ȸ��
																					// ����
																					// +1
					main.setM_AmountOfTapMoney(main.getM_AmountOfTapMoney() * 2); // ����
																					// :
																					// ��
																					// x
																					// 3
					System.out.println(main.getM_AmountOfAutoMoney());
					extendBar.setValue(state.getP_lvOfExtend());
					extendBar.setString(state.getP_lvOfExtend() + "/" + extendBar.getMaximum());// 1/10
																								// bar�߰�
					View.cm().setMoneyJLabel(autoMoneyJLabel, tapMoneyJLabel);
					System.out.println("ȸ�� Ȯ�� �Ϸ� (���� ȸ�� ���� : " + state.getP_lvOfExtend() + ")");
					JOptionPane.showMessageDialog(null,
							"ȸ�� Ȯ�� �Ϸ�\n�� �ݾ��� 2�� �����Ͽ����ϴ�.\n���� ���� : " + state.getP_lvOfExtend(), "Complete",
							JOptionPane.WARNING_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "�ܾ��� �����մϴ�.", "Warning", JOptionPane.WARNING_MESSAGE);
					System.out.println("�ܾ��� �����մϴ�.(���� ȸ�� ���� :" + state.getP_lvOfExtend() + ")");
				}
			} else if (state.getP_lvOfExtend() == 7) {
				long num = 5000000000L; // 50��
				if (main.getM_TotalOfMoney() > num) { // �� �ݾ� > �����Ӵ�
					System.out.println(num);
					main.setM_TotalOfMoney(main.getM_TotalOfMoney() - num); // ����
																			// �ݾ�.
																			// ��ü
																			// ��
																			// -
																			// �����Ӵ�
					state.setP_lvOfExtend((byte) (state.getP_lvOfExtend() + 1)); // ȸ��
																					// ����
																					// +1
					main.setM_AmountOfTapMoney(main.getM_AmountOfTapMoney() * 2); // ����
																					// :
																					// ��
																					// x
																					// 2
					System.out.println(main.getM_AmountOfAutoMoney());
					extendBar.setValue(state.getP_lvOfExtend());
					extendBar.setString(state.getP_lvOfExtend() + "/" + extendBar.getMaximum());// 1/10
																								// bar�߰�
					View.cm().setMoneyJLabel(autoMoneyJLabel, tapMoneyJLabel);
					System.out.println("ȸ�� Ȯ�� �Ϸ� (���� ȸ�� ���� : " + state.getP_lvOfExtend() + ")");
					JOptionPane.showMessageDialog(null,
							"ȸ�� Ȯ�� �Ϸ�\n�� �ݾ��� 2�� �����Ͽ����ϴ�.\n���� ���� : " + state.getP_lvOfExtend(), "Complete",
							JOptionPane.WARNING_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "�ܾ��� �����մϴ�.", "Warning", JOptionPane.WARNING_MESSAGE);
					System.out.println("�ܾ��� �����մϴ�.(���� ȸ�� ���� :" + state.getP_lvOfExtend() + ")");
				}
			} else if (state.getP_lvOfExtend() == 8) {
				long num = 15000000000L; // 150��
				if (main.getM_TotalOfMoney() > num) { // �� �ݾ� > �����Ӵ�
					System.out.println(num);
					main.setM_TotalOfMoney(main.getM_TotalOfMoney() - num); // ����
																			// �ݾ�.
																			// ��ü
																			// ��
																			// -
																			// �����Ӵ�
					state.setP_lvOfExtend((byte) (state.getP_lvOfExtend() + 1)); // ȸ��
																					// ����
																					// +1
					main.setM_AmountOfTapMoney(main.getM_AmountOfTapMoney() * 2); // ����
																					// :
																					// ��
																					// x
																					// 2
					System.out.println(main.getM_AmountOfAutoMoney());
					extendBar.setValue(state.getP_lvOfExtend());
					extendBar.setString(state.getP_lvOfExtend() + "/" + extendBar.getMaximum());// 1/10
																								// bar�߰�
					View.cm().setMoneyJLabel(autoMoneyJLabel, tapMoneyJLabel);
					System.out.println("ȸ�� Ȯ�� �Ϸ� (���� ȸ�� ���� : " + state.getP_lvOfExtend() + ")");
					JOptionPane.showMessageDialog(null,
							"ȸ�� Ȯ�� �Ϸ�\n�� �ݾ��� 2�� �����Ͽ����ϴ�.\n���� ���� : " + state.getP_lvOfExtend(), "Complete",
							JOptionPane.WARNING_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "�ܾ��� �����մϴ�.", "Warning", JOptionPane.WARNING_MESSAGE);
					System.out.println("�ܾ��� �����մϴ�.(���� ȸ�� ���� :" + state.getP_lvOfExtend() + ")");
				}
			} else if (state.getP_lvOfExtend() == 9) {
				long num = 30000000000L; // 300��
				if (main.getM_TotalOfMoney() > num) { // �� �ݾ� > �����Ӵ�
					System.out.println(num);
					main.setM_TotalOfMoney(main.getM_TotalOfMoney() - num); // ����
																			// �ݾ�.
																			// ��ü
																			// ��
																			// -
																			// �����Ӵ�
					state.setP_lvOfExtend((byte) (state.getP_lvOfExtend() + 1)); // ȸ��
																					// ����
																					// +1
					main.setM_AmountOfTapMoney(main.getM_AmountOfTapMoney() * 2); // ����
																					// :
																					// ��
																					// x
																					// 2
					System.out.println(main.getM_AmountOfAutoMoney());
					extendBar.setValue(state.getP_lvOfExtend());
					extendBar.setString(state.getP_lvOfExtend() + "/" + extendBar.getMaximum());// 1/10
																								// bar�߰�
					View.cm().setMoneyJLabel(autoMoneyJLabel, tapMoneyJLabel);
					System.out.println("ȸ�� Ȯ�� �Ϸ� (���� ȸ�� ���� : " + state.getP_lvOfExtend() + ")");
					JOptionPane.showMessageDialog(null,
							"ȸ�� Ȯ�� �Ϸ�\n�� �ݾ��� 2�� �����Ͽ����ϴ�.\n���� ���� : " + state.getP_lvOfExtend(), "Complete",
							JOptionPane.WARNING_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "�ܾ��� �����մϴ�.", "Warning", JOptionPane.WARNING_MESSAGE);
					System.out.println("�ܾ��� �����մϴ�.(���� ȸ�� ���� :" + state.getP_lvOfExtend() + ")");
				}
			}

		} else {
			JOptionPane.showMessageDialog(null, "�ְ����Դϴ�.", "Complete", JOptionPane.WARNING_MESSAGE);
			System.out.println("10�����Դϴ�.");
		}

		if (state.getP_lvOfExtend() == 3) {
			mainJPanel.removeAll();
			mainJPanel.add(nicknameJLabel);
			mainJPanel.add(totalMoneyJLabel);
			mainJPanel.add(autoMoneyJLabel);
			mainJPanel.add(tapMoneyJLabel);
			mainJPanel.add(lv3JBackImageLabel);
			view.add(stateJPanel);
			view.add(mainJPanel);
			view.repaint();
		} else if (state.getP_lvOfExtend() == 5) {
			mainJPanel.removeAll();
			mainJPanel.add(nicknameJLabel);
			mainJPanel.add(totalMoneyJLabel);
			mainJPanel.add(autoMoneyJLabel);
			mainJPanel.add(tapMoneyJLabel);
			mainJPanel.add(lv5JBackImageLabel);
			view.add(stateJPanel);
			view.add(mainJPanel);
			view.repaint();
		} else if (state.getP_lvOfExtend() == 7) {
			mainJPanel.removeAll();
			mainJPanel.add(nicknameJLabel);
			mainJPanel.add(totalMoneyJLabel);
			mainJPanel.add(autoMoneyJLabel);
			mainJPanel.add(tapMoneyJLabel);
			mainJPanel.add(lv7JBackImageLabel);
			view.add(stateJPanel);
			view.add(mainJPanel);
			view.repaint();
		} else if (state.getP_lvOfExtend() == 10) {
			mainJPanel.removeAll();
			mainJPanel.add(nicknameJLabel);
			mainJPanel.add(totalMoneyJLabel);
			mainJPanel.add(autoMoneyJLabel);
			mainJPanel.add(tapMoneyJLabel);
			mainJPanel.add(lv10JBackImageLabel);
			view.add(stateJPanel);
			view.add(mainJPanel);
			view.repaint();
		}
	}

	// ***************180711_�����̼� ����_�� ����(�����̼�Level * 1000����, ����:
	// ��x2)****************
	public void educateLevelUp(Main main, JProgressBar educateBar, AutoMoneyJLabel autoMoneyJLabel,
			TapMoneyJLabel tapMoneyJLabel) {
		int educateLevelMoney = 10000000 * state.getP_lvOfEducate(); // �����̼� �ݾ�
		if (state.getP_lvOfExtend() > state.getP_lvOfEducate()) { // ȸ��Level >
																	// �����̼�Level
			if (main.getM_TotalOfMoney() > educateLevelMoney) { // ��ü �� > �����̼�
																// �ݾ�
				main.setM_TotalOfMoney(main.getM_TotalOfMoney() - educateLevelMoney); // ��ü�ݾ�
																						// -
																						// �����̼�
																						// �ݾ�
				state.setP_lvOfEducate((byte) (state.getP_lvOfEducate() + 1)); // �����̼�
																				// ����
																				// +1
				main.setM_AmountOfTapMoney(main.getM_AmountOfTapMoney() * 2); // ����
																				// :
																				// ��
																				// x
																				// 2
				educateBar.setValue(state.getP_lvOfEducate());
				educateBar.setString(state.getP_lvOfEducate() + "/" + educateBar.getMaximum());
				View.cm().setMoneyJLabel(autoMoneyJLabel, tapMoneyJLabel);
				JOptionPane.showMessageDialog(null, "���� �̼� �Ϸ�\n�� �ݾ��� 2�� �����Ͽ����ϴ�.\n���� ���� : " + state.getP_lvOfEducate(),
						"Complete", JOptionPane.WARNING_MESSAGE);
				System.out.println("�����̼� �Ϸ� (���� ���� �̼� ����" + state.getP_lvOfEducate() + ")");
			} else {
				JOptionPane.showMessageDialog(null, "�ܾ��� �����մϴ�.", "Warning", JOptionPane.WARNING_MESSAGE);
				System.out.println("�ܾ��� �����մϴ�. (���� ���� �̼� ���� " + state.getP_lvOfEducate() + ")");
			}
		} else if (state.getP_lvOfEducate() != 10) {
			JOptionPane.showMessageDialog(null, "ȸ�� ������ �����ϴ�.", "Warning", JOptionPane.WARNING_MESSAGE);
			System.out.println("���� �Ұ��� (���� ���� �̼� ����" + state.getP_lvOfEducate() + ")");
		} else if (state.getP_lvOfEducate() == 10) {
			JOptionPane.showMessageDialog(null, "�ְ����Դϴ�.", "Warning", JOptionPane.WARNING_MESSAGE);

		}
	}

	// ***************180710_������� ����_�� ����(�������Level * 1000����, ����:������
	// x5)****************
	public void employLevelUp(Main main, JProgressBar employBar, AutoMoneyJLabel autoMoneyJLabel,
			TapMoneyJLabel tapMoneyJLabel) {
		int employLevelMoney = 10000000 * state.getP_lvOfEmploy(); // ������� �ݾ�
		if (state.getP_lvOfExtend() > state.getP_lvOfEmploy()) { // ȸ��Level >
																	// �������Level
			if (main.getM_TotalOfMoney() > employLevelMoney) { // ��ü �� > ���ݾ�
				main.setM_TotalOfMoney(main.getM_TotalOfMoney() - employLevelMoney); // ��ü�ݾ�
																						// -
																						// �������
																						// �ݾ�
				state.setP_lvOfEmploy((byte) (state.getP_lvOfEmploy() + 1)); // �������
																				// ����
																				// +1
				main.setM_AmountOfAutoMoney(main.getM_AmountOfAutoMoney() * 2); // ����
																				// :
																				// ������
																				// x
																				// 5
				employBar.setValue(state.getP_lvOfEmploy());
				employBar.setString(state.getP_lvOfEmploy() + "/" + employBar.getMaximum());
				View.cm().setMoneyJLabel(autoMoneyJLabel, tapMoneyJLabel);
				JOptionPane.showMessageDialog(null, "���� �̼� �Ϸ�\n������ �ݾ��� 5�� �����Ͽ����ϴ�.\n���� ���� : " + state.getP_lvOfEmploy(),
						"Complete", JOptionPane.WARNING_MESSAGE);
				System.out.println("������� �Ϸ� (���� ���� :" + state.getP_lvOfEmploy() + ")");
			} else {
				JOptionPane.showMessageDialog(null, "�ܾ��� �����մϴ�.", "Warning", JOptionPane.WARNING_MESSAGE);
				System.out.println("�ܾ��� �����մϴ�. (���� ���� ��� ����  : " + state.getP_lvOfEmploy() + ")");
			}
		} else if (state.getP_lvOfEmploy() != 10) {
			JOptionPane.showMessageDialog(null, "ȸ�� ������ �����ϴ�.", "Warning", JOptionPane.WARNING_MESSAGE);
			System.out.println("���� �Ұ��� (���� ���� �̼� ����" + state.getP_lvOfEducate() + ")");
		} else if (state.getP_lvOfEmploy() == 10) {
			JOptionPane.showMessageDialog(null, "�ְ����Դϴ�.", "Warning", JOptionPane.WARNING_MESSAGE);

		}
	}

	// ***************180710_��ǻ�� ����_�� ����(��ǻ��Level * 700����, ����:������
	// x4)****************
	public void computerLevelUp(Main main, JProgressBar computerBar, AutoMoneyJLabel autoMoneyJLabel,
			TapMoneyJLabel tapMoneyJLabel) {
		int computerLevelMoney = 7000000 * state.getP_lvOfComputer(); // ��ǻ�ͻ��
																		// �ݾ�
		if (state.getP_lvOfExtend() > state.getP_lvOfComputer()) { // ȸ��Level >
																	// ��ǻ�ͻ��Level
			if (main.getM_TotalOfMoney() > computerLevelMoney) { // ��ü�� > ��ǻ�ͻ��
																	// �ݾ�
				main.setM_TotalOfMoney(main.getM_TotalOfMoney() - computerLevelMoney); // ��ü�ݾ�
																						// -
																						// ��ǻ��
																						// �ݾ�
				state.setP_lvOfComputer((byte) (state.getP_lvOfComputer() + 1)); // ��ǻ��
																					// ���
																					// ����
																					// +1
				main.setM_AmountOfAutoMoney(main.getM_AmountOfAutoMoney() * 2); // ����:
																				// ������
																				// x
																				// 4
				computerBar.setValue(state.getP_lvOfComputer());
				computerBar.setString(state.getP_lvOfComputer() + "/" + computerBar.getMaximum());
				View.cm().setMoneyJLabel(autoMoneyJLabel, tapMoneyJLabel);
				System.out.println("��ǻ�ͻ�� �Ϸ� (���� ���� : " + state.getP_lvOfComputer() + ")");
				JOptionPane.showMessageDialog(null,
						"��ǻ�� ��� �Ϸ�\n������ �ݾ��� 4�� �����Ͽ����ϴ�.\n���� ���� : " + state.getP_lvOfComputer(), "Complete",
						JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "�ܾ��� �����մϴ�.", "Warning", JOptionPane.WARNING_MESSAGE);
				System.out.println("�ܾ��� �����մϴ�. (���� ��ǻ�ͻ�� ���� : " + state.getP_lvOfComputer() + ")");
			}
		} else if (state.getP_lvOfComputer() != 10) {
			JOptionPane.showMessageDialog(null, "ȸ�� ������ �����ϴ�.", "Warning", JOptionPane.WARNING_MESSAGE);
			System.out.println("���� �Ұ��� (���� ���� �̼� ����" + state.getP_lvOfEducate() + ")");
		} else if (state.getP_lvOfComputer() == 10) {
			JOptionPane.showMessageDialog(null, "�ְ����Դϴ�.", "Warning", JOptionPane.WARNING_MESSAGE);
		}
	}

	// ***************180710_Ÿ�ڼ� ����_�� ����(Ÿ�ڼ�Level * 700����, ����:������
	// x4)****************
	public void keyboardLevelUp(Main main, JProgressBar keyboardBar, AutoMoneyJLabel autoMoneyJLabel,
			TapMoneyJLabel tapMoneyJLabel) {
		int keyboardLevelMoney = 7000000 * state.getP_lvOfKeyboard(); // Ÿ�ڼ� �ݾ�
		if (state.getP_lvOfExtend() > state.getP_lvOfKeyboard()) { // ȸ��Level >
																	// Ÿ�ڼ�Level
			if (main.getM_TotalOfMoney() > keyboardLevelMoney) { // ��ü�� > Ÿ�ڼ� �ݾ�
				main.setM_TotalOfMoney(main.getM_TotalOfMoney() - keyboardLevelMoney); // ��ü�ݾ�
																						// -
																						// Ÿ�ڼ�
																						// �ݾ�
				state.setP_lvOfKeyboard((byte) (state.getP_lvOfKeyboard() + 1)); // Ÿ�ڼ�
																					// ����
																					// +1
				main.setM_AmountOfAutoMoney(main.getM_AmountOfAutoMoney() * 2); // ����:
																				// ������
																				// x
																				// 4
				keyboardBar.setValue(state.getP_lvOfKeyboard());
				keyboardBar.setString(state.getP_lvOfKeyboard() + "/" + keyboardBar.getMaximum());
				View.cm().setMoneyJLabel(autoMoneyJLabel, tapMoneyJLabel);
				System.out.println("Ÿ�ڼ� �Ϸ� (���� ���� : " + state.getP_lvOfKeyboard() + ")");
				JOptionPane.showMessageDialog(null, "Ÿ�ڼ� �Ϸ�\n������ �ݾ��� 4�� �����Ͽ����ϴ�.\n���� ���� : " + state.getP_lvOfKeyboard(),
						"Complete", JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "�ܾ��� �����մϴ�.", "Warning", JOptionPane.WARNING_MESSAGE);
				System.out.println("�ܾ��� �����մϴ�. (���� Ÿ�ڼ� ���� : " + state.getP_lvOfKeyboard() + ")");
			}
		} else if (state.getP_lvOfKeyboard() != 10) {
			JOptionPane.showMessageDialog(null, "ȸ�� ������ �����ϴ�.", "Warning", JOptionPane.WARNING_MESSAGE);
			System.out.println("���� �Ұ��� (���� ���� �̼� ����" + state.getP_lvOfEducate() + ")");
		} else if (state.getP_lvOfKeyboard() == 10) {
			JOptionPane.showMessageDialog(null, "�ְ����Դϴ�.", "Warning", JOptionPane.WARNING_MESSAGE);
		}
	}

	// ************180710_�ؽ�Ʈ�� �ο� ***********
	// ���콺 Ŀ�� �÷������� �ݾ� ��
	public void keyboardSpace(Main main, JButton extendJButton, JButton educateJButton, JButton employJButton,
			JButton computerJButton, JButton keyboardJButton) {
		String extendMoney = "";
		String educateMoney = "";
		String employMoney = "";
		String computerMoney = "";
		String keyboardMoney = "";

		if (state.getP_lvOfExtend() < 10) {
			if (state.getP_lvOfExtend() < 7) {
				extendMoney = String.format("%,d", (state.getP_lvOfExtend() * 20000000));
				educateMoney = String.format("%,d", (state.getP_lvOfEducate() * 8000000));
				employMoney = String.format("%,d", (state.getP_lvOfEmploy() * 10000000));
				computerMoney = String.format("%,d", (state.getP_lvOfComputer() * 7000000));
				keyboardMoney = String.format("%,d", (state.getP_lvOfKeyboard() * 7000000));
			}
			if (state.getP_lvOfExtend() == 7) {
				extendMoney = String.format("%,d", 5000000000L);// 50��
				educateMoney = String.format("%,d", (state.getP_lvOfEducate() * 8000000));
				employMoney = String.format("%,d", (state.getP_lvOfEmploy() * 10000000));
				computerMoney = String.format("%,d", (state.getP_lvOfComputer() * 7000000));
				keyboardMoney = String.format("%,d", (state.getP_lvOfKeyboard() * 7000000));
			} else if (state.getP_lvOfExtend() == 8) {
				extendMoney = String.format("%,d", 15000000000L);// 150��
				educateMoney = String.format("%,d", (state.getP_lvOfEducate() * 8000000));
				employMoney = String.format("%,d", (state.getP_lvOfEmploy() * 10000000));
				computerMoney = String.format("%,d", (state.getP_lvOfComputer() * 7000000));
				keyboardMoney = String.format("%,d", (state.getP_lvOfKeyboard() * 7000000));
			} else if (state.getP_lvOfExtend() == 9) {
				extendMoney = String.format("%,d", 30000000000L);// 300��
				educateMoney = String.format("%,d", (state.getP_lvOfEducate() * 8000000));
				employMoney = String.format("%,d", (state.getP_lvOfEmploy() * 10000000));
				computerMoney = String.format("%,d", (state.getP_lvOfComputer() * 7000000));
				keyboardMoney = String.format("%,d", (state.getP_lvOfKeyboard() * 7000000));
			}
		}
		String current = String.format("%,d", main.getM_TotalOfMoney());

		extendJButton.setToolTipText("���� �������� �ʿ�ݾ� : " + current + "�� / " + extendMoney + "��");
		educateJButton.setToolTipText("���� �������� �ʿ�ݾ� :" + current + "�� / " + educateMoney + "��");
		employJButton.setToolTipText("���� �������� �ʿ�ݾ� : " + current + "�� / " + employMoney + "��");
		computerJButton.setToolTipText("���� �������� �ʿ�ݾ� : " + current + "�� / " + computerMoney + "��");
		keyboardJButton.setToolTipText("���� �������� �ʿ�ݾ� : " + current + "�� / " + keyboardMoney + "��");
	}
}