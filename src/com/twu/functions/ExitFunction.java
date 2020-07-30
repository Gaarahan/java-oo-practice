package com.twu.functions;

import com.twu.storage.SingleContextStorage;

/**
 * @author gaarahan
 */
public class ExitFunction extends HotSearchFunction {
  @Override
  public void run() {
    SingleContextStorage.curUser = null;
  }

  @Override
  public String getDesc() {
    return "退出登录";
  }

  @Override
  public boolean checkAuthority(String curUserType) {
    return true;
  }
}
