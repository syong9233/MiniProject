package model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.Date;

import model.vo.*;

public class DataAccessPlayer {
	private Player player;
	
	public DataAccessPlayer(){
		player = new Player();
	}
	
	public Player getPlayer(){
		return player;
	}
	
	//************************ȸ�� ���� �ҷ�����_180707_1**************************
	public void load(){
		try (ObjectInputStream ois = 
				new ObjectInputStream(
					new FileInputStream("player_list.dat"))){
			while(true){
				player = (Player)ois.readObject();
				System.out.println("ȸ�� ���� �ҷ����� �Ϸ�");
			}
		} catch (EOFException e){
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//-------------------------------------------------------------------
	
	//************************ȸ�� ���� ����_180707_1**************************
	public void save(Main main, Quest quest, State state, Store store) {
		player.setP_lastTime(new Date());
		player.setP_qtyOfTap(quest.getQ_qtyOfTap());
		player.setP_qtyOfTotalMoney(quest.getQ_qtyOfTotalMoney());
		player.setP_TotalOfMoney(main.getM_TotalOfMoney());
		player.setP_AmountOfAutoMoney(main.getM_AmountOfAutoMoney());
		player.setP_AmountOfTapMoney(main.getM_AmountOfTapMoney());
		player.setP_lvOfComputer(state.getP_lvOfComputer());
		player.setP_lvOfKeyboard(state.getP_lvOfKeyboard());
		player.setP_lvOfEducate(state.getP_lvOfEducate());
		player.setP_lvOfEmploy(state.getP_lvOfEmploy());
		player.setP_lvOfExtend(state.getP_lvOfExtend());
		
		try (ObjectOutputStream oos = 
				new ObjectOutputStream(new FileOutputStream("player_list.dat"))){
			oos.writeObject(player);
			System.out.println("ȸ�� ���� ���� �Ϸ�");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//-------------------------------------------------------------------

	//************************ù ������ ��� �г��� ����_180707_1**************************
	public void setP_Nickname(String nickname) {
		player.setP_Nickname(nickname);		
	}
	//-------------------------------------------------------------------

}
