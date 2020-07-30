package com.twu.functions;

import com.twu.model.HotSearchItem;

import java.util.List;

/**
 * @author gaarahan
 */
public class GetHotSearchListFunction extends HotSearchFunction {
  public GetHotSearchListFunction() {
    super();
  }

  @Override
  public void run() {
    super.run();
    List<HotSearchItem> hotSearchItemSortedList = this.getHotSearchRankList().getSortedList();
    StringBuilder res = new StringBuilder("热搜排行榜 : \n");
    String tableFormat = "%-4s| %-20s| %-5s| %-5s\n";
    if (hotSearchItemSortedList.isEmpty()) {
      res.append("还没有热搜～");
    } else {
      String tableHead = String.format(tableFormat,"Num", "Desc", "Heat", "Super");
      res.append(tableHead);
      int count = 1;
      for(HotSearchItem itm: hotSearchItemSortedList) {
        res.append(String.format(tableFormat, count++, itm.getDesc(), itm.getHeat(), itm.isSuper() ? "S" : ""));
      }
    }

    System.out.println(res);
  }

  @Override
  public String getDesc() {
    return "获取热搜列表";
  }

  @Override
  public boolean checkAuthority(String curUserType) {
    return true;
  }
}
