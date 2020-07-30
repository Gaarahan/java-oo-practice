package com.twu.model;

import com.twu.storage.SingleContextStorage;

/**
 * @author gaarahan
 */
public class HotSearchItem {
  private final boolean isSuper;
  private final String desc;
  private int heat;
  private int money;
  private int payRank;

  public HotSearchItem(String hotSearchDesc) {
    this.desc = hotSearchDesc;
    this.heat = 0;
    this.isSuper = false;
    this.money = 0;
    this.payRank = 0;
  }

  public HotSearchItem(String hotSearchDesc, boolean isSuper) {
    this.desc = hotSearchDesc;
    this.heat = 0;
    this.isSuper = isSuper;
    this.money = 0;
    this.payRank = 0;
  }

  public String getDesc() {
    return desc;
  }

  public int getHeat() {
    return heat;
  }

  public boolean isSuper() {
    return isSuper;
  }

  public int getMoney() {
    return money;
  }

  public int getPayRank() {
    return payRank;
  }

  public void vote(int heat) {
    SingleContextStorage.curUser.removeVote(heat);
    this.heat += this.isSuper ? heat*2: heat;
  }

  public void buy(int rank, int money) {
    this.payRank = rank;
    this.money = money;
  }
}
