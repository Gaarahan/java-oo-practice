package com.twu.functions;

import java.util.Scanner;

/**
 * @author gaarahan
 */
public class AddHotSearchFunction extends HotSearchFunction {

  @Override
  public void run() {
    super.run();
    Scanner in = new Scanner(System.in);
    System.out.println("请输入热搜内容:");
    String mes = in.nextLine();
    this.getHotSearchRankList().add(mes);
  }

  @Override
  public String getDesc() {
    return "添加热搜";
  }

  @Override
  public boolean checkAuthority(String curUserType) {
    return true;
  }
}
