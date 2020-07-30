package com.twu.functions;

import com.twu.model.HotSearchItem;
import com.twu.storage.SingleContextStorage;
import com.twu.utils.Constants;

import java.util.Scanner;

/**
 * @author gaarahan
 */
public class VoteHotSearchFunction extends HotSearchFunction{
  public VoteHotSearchFunction() {
    super();
    this.setActiveUserType(Constants.NORMAL_USER);
  }

  @Override
  public void run() {
    super.run();
    Scanner in = new Scanner(System.in);
    System.out.println("请输入热搜内容:");
    String mes = in.nextLine();
    HotSearchItem hotSearch = this.getHotSearchRankList().queryHotSearch(mes.trim());
    System.out.println(String.format("请输入你要投的票数: (你目前还有%d票)", SingleContextStorage.curUser.getRestVoteNum()));
    int heat = in.nextInt();
    while(true) {
      if (heat <=0 || heat > SingleContextStorage.curUser.getRestVoteNum()) {
        System.out.println("输入票数有误, 请重新输入:");
        heat = in.nextInt();
      }
      else {
        break;
      }
    }
    hotSearch.vote(heat);
  }

  @Override
  public String getDesc() {
    return "给热搜投票";
  }

}
