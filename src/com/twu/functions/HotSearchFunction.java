package com.twu.functions;

import com.twu.model.HotSearchRankList;
import com.twu.storage.SingleContextStorage;

/**
 * @author gaarahan
 */
public class HotSearchFunction {
  private final HotSearchRankList hotSearchRankList = new HotSearchRankList();

  private String activeUserType;

  public void setActiveUserType(String activeUserType) {
    this.activeUserType = activeUserType;
  }

  public HotSearchFunction() {
    this.activeUserType = "";
  }

  public void run () { }

  public String getDesc() {
    return "";
  }

  public HotSearchRankList getHotSearchRankList() {
    return SingleContextStorage.hotSearchRankList;
  }

  public boolean checkAuthority(String curUserType) {
    return this.activeUserType.equals(curUserType);
  }
}
