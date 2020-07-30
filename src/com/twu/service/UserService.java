package com.twu.service;

import com.twu.model.User;
import com.twu.storage.UserStorage;

/**
 * @author gaarahan
 */
public class UserService {
  private final static UserStorage USER_STORAGE = new UserStorage();

  public static User userLogin(String loginFlag, String userName) {
    User curUser = USER_STORAGE.getUserByName(userName);
    if (curUser == null || !curUser.getUserType().equals(loginFlag)) {
      throw new RuntimeException("Wrong username or type.");
    }
    return curUser;
  }
}
