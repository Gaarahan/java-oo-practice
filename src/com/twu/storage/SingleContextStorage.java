package com.twu.storage;

import com.twu.model.HotSearchFunctionList;
import com.twu.model.HotSearchRankList;
import com.twu.model.User;

/**
 * @author gaarahan
 */
public class SingleContextStorage {
  public static User curUser = null;
  public static HotSearchFunctionList functions = new HotSearchFunctionList();
  public static HotSearchRankList hotSearchRankList = new HotSearchRankList();

  private SingleContextStorage(){}

  public static void setCurUser(User curUser) {
    SingleContextStorage.curUser = curUser;
  }
}
