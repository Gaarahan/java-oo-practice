package com.twu.model;

/**
 * @author gaarahan
 */
public class User {
  private final String userType;
  private final String userName;
  private int restVoteNum;

  public User(String userName, String userType) {
    this.userName = userName;
    this.userType = userType;
    this.restVoteNum = 10;
  }

  public String getUserType() {
    return userType;
  }

  public String getUserName() {
    return userName;
  }

  public int getRestVoteNum() {
    return restVoteNum;
  }

  public void removeVote(int heat) {
    this.restVoteNum -= heat;
  }
}
