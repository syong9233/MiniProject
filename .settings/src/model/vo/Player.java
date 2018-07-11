package model.vo;

import java.util.Date;

public class Player implements java.io.Serializable{
   //회원 정보 변수
   private String p_Nickname;
   private Date p_lastTime;
   private long p_TotalOfMoney;
   private long p_AmountOfAutoMoney;
   private long p_AmountOfTapMoney;
   private int p_Cash;
   private int p_qtyOfLotto;
   private int p_qtyOfPotion;
   private int p_qtyOfAutoTap;
   
   //상태 변수
   private byte p_lvOfComputer;
   private byte p_lvOfKeyboard;
   private byte p_lvOfEducate;
   private byte p_lvOfEmploy;
   private byte p_lvOfExtend;
   
   //퀘스트 변수
   private int p_qtyOfTap;
   private long p_qtyOfTotalMoney;
   private long tap1 = 1, tap2 = 30, reward2 = 150000;
   private long temp1 = 1, temp2 = 500000, reward1 = 500000;
   
   
   
   public long getP_qtyOfTotalMoney() {
      return p_qtyOfTotalMoney;
   }

   public void setP_qtyOfTotalMoney(long p_qtyOfTotalMoney) {
      this.p_qtyOfTotalMoney = p_qtyOfTotalMoney;
   }

   public long getTap1() {
      return tap1;
   }

   public void setTap1(long tap1) {
      this.tap1 = tap1;
   }

   public long getTap2() {
      return tap2;
   }

   public void setTap2(long tap2) {
      this.tap2 = tap2;
   }

   public long getReward2() {
      return reward2;
   }

   public void setReward2(long reward2) {
      this.reward2 = reward2;
   }

   public long getTemp1() {
      return temp1;
   }

   public void setTemp1(long temp1) {
      this.temp1 = temp1;
   }

   public long getTemp2() {
      return temp2;
   }

   public void setTemp2(long temp2) {
      this.temp2 = temp2;
   }

   public long getReward1() {
      return reward1;
   }

   public void setReward1(long reward1) {
      this.reward1 = reward1;
   }

   public Player(){
      super();
      this.p_Nickname = "";
      this.p_AmountOfAutoMoney = 10;
      this.p_AmountOfTapMoney = 7530; 
      this.p_TotalOfMoney = 0;
      this.p_Cash = 0;
      this.p_qtyOfLotto = 10;
      this.p_qtyOfPotion = 0;
      this.p_qtyOfAutoTap = 0;
      this.p_lvOfComputer = 1;
      this.p_lvOfKeyboard = 1;
      this.p_lvOfEducate = 1;
      this.p_lvOfEmploy = 1;
      this.p_lvOfExtend = 1;
      this.p_qtyOfTap = 0;
   }

   public String getP_Nickname() {
      return p_Nickname;
   }

   public void setP_Nickname(String p_Nickname) {
      this.p_Nickname = p_Nickname;
   }

   public long getP_AmountOfAutoMoney() {
      return p_AmountOfAutoMoney;
   }

   public void setP_AmountOfAutoMoney(long p_AmountOfAutoMoney) {
      this.p_AmountOfAutoMoney = p_AmountOfAutoMoney;
   }

   public byte getP_lvOfComputer() {
      return p_lvOfComputer;
   }

   public void setP_lvOfComputer(byte p_lvOfComputer) {
      this.p_lvOfComputer = p_lvOfComputer;
   }

   public byte getP_lvOfKeyboard() {
      return p_lvOfKeyboard;
   }

   public void setP_lvOfKeyboard(byte p_lvOfKeyboard) {
      this.p_lvOfKeyboard = p_lvOfKeyboard;
   }

   public byte getP_lvOfEducate() {
      return p_lvOfEducate;
   }

   public void setP_lvOfEducate(byte p_lvOfEducate) {
      this.p_lvOfEducate = p_lvOfEducate;
   }

   public byte getP_lvOfEmploy() {
      return p_lvOfEmploy;
   }

   public void setP_lvOfEmploy(byte p_lvOfEmploy) {
      this.p_lvOfEmploy = p_lvOfEmploy;
   }

   public byte getP_lvOfExtend() {
      return p_lvOfExtend;
   }

   public void setP_lvOfExtend(byte p_lvOfExtend) {
      this.p_lvOfExtend = p_lvOfExtend;
   }

   public int getP_Cash() {
      return p_Cash;
   }

   public void setP_Cash(int p_Cash) {
      this.p_Cash = p_Cash;
   }

   public int getP_qtyOfLotto() {
      return p_qtyOfLotto;
   }

   public void setP_qtyOfLotto(int p_qtyOfLotto) {
      this.p_qtyOfLotto = p_qtyOfLotto;
   }

   public int getP_qtyOfPotion() {
      return p_qtyOfPotion;
   }

   public void setP_qtyOfPotion(int p_qtyOfPotion) {
      this.p_qtyOfPotion = p_qtyOfPotion;
   }

   public int getP_qtyOfAutoTap() {
      return p_qtyOfAutoTap;
   }

   public void setP_qtyOfAutoTap(int p_qtyOfAutoTap) {
      this.p_qtyOfAutoTap = p_qtyOfAutoTap;
   }

   public Date getP_lastTime() {
      return p_lastTime;
   }

   public void setP_lastTime(Date p_lastTime) {
      this.p_lastTime = p_lastTime;
   }
   
   public int getP_qtyOfTap() {
      return p_qtyOfTap;
   }

   public void setP_qtyOfTap(int p_qtyOfTap) {
      this.p_qtyOfTap = p_qtyOfTap;
   }

   public long getP_TotalOfMoney() {
      return p_TotalOfMoney;
   }

   public void setP_TotalOfMoney(long p_TotalOfMoney) {
      this.p_TotalOfMoney = p_TotalOfMoney;
   }

   public long getP_AmountOfTapMoney() {
      return p_AmountOfTapMoney;
   }

   public void setP_AmountOfTapMoney(long p_AmountOfTapMoney) {
      this.p_AmountOfTapMoney = p_AmountOfTapMoney;
   }   
}
