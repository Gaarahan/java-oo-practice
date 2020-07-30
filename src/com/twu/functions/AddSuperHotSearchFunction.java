package com.twu.functions;

import com.twu.utils.Constants;

import java.util.Scanner;

/**
 * @author gaarahan
 */
public class AddSuperHotSearchFunction extends HotSearchFunction {

  public AddSuperHotSearchFunction() {
    super();
    this.setActiveUserType(Constants.ADMIN);
  }

  @Override
  public void run() {
    super.run();
    Scanner in = new Scanner(System.in);
    System.out.println("请输入超级热搜内容:");
    String mes = in.nextLine();
    this.getHotSearchRankList().addSuper(mes);
  }

  @Override
  public String getDesc() {
    return "添加超级热搜";
  }
}
