package com.twu.storage;

import com.twu.utils.Constants;
import com.twu.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gaarahan
 */
public class UserStorage {
  private final Map<String, User> userMap;

  public UserStorage() {
    this.userMap = new HashMap<>();
    this.init();
  }

  public void add(User user) {
    if (this.userMap.containsKey(user.getUserName())) {
      throw new IllegalArgumentException("user " + user.getUserName() + " existed");
    }
    this.userMap.put(user.getUserName(), user);
  }

  public void init() {
    User gaarahan = new User("gaarahan", Constants.NORMAL_USER);
    User admin = new User("admin", Constants.ADMIN);

    this.userMap.put(gaarahan.getUserName(), gaarahan);
    this.userMap.put(admin.getUserName(), admin);
  }

  public User getUserByName(String userName) {
    return this.userMap.get(userName);
  }
}
