package com.twu.functions;

import com.twu.model.HotSearchItem;
import com.twu.utils.Constants;

import java.util.Scanner;

/**
 * @author gaarahan
 */
public class BuyHotSearchFunciton extends HotSearchFunction {
  public BuyHotSearchFunciton() {
    super();
    this.setActiveUserType(Constants.NORMAL_USER);
  }

  @Override
  public void run() {
    super.run();
    System.out.println("请输入购买热搜名称：");
    Scanner in = new Scanner(System.in);
    String name = in.nextLine();
    HotSearchItem hotSearch = this.getHotSearchRankList().queryHotSearch(name.trim());
    System.out.println("请输入购买排名:");
    int rank = in.nextInt();
    System.out.println("请输入购买金额:");
    int money = in.nextInt();
    hotSearch.buy(rank, money);
  }

  @Override
  public String getDesc() {
    return "买热搜";
  }
}
