package com.twu;

import com.twu.functions.HotSearchFunction;
import com.twu.service.UserService;
import com.twu.storage.SingleContextStorage;
import com.twu.utils.Constants;

import java.util.List;
import java.util.Scanner;

/**
 * @author gaarahan
 */
public class HotSearchRankListSystem {
  private String cliState;
  private List<HotSearchFunction> menu;

  private final Scanner in;

  public HotSearchRankListSystem() {
    this.cliState = Constants.CLI_RUNNING;
    this.in = new Scanner(System.in);
  }

  public void startCli() {
    while (cliState.equals(Constants.CLI_RUNNING)) {
      try {
        if (SingleContextStorage.curUser == null) {
          this.handleLoginMenu();
        }
        else {
          this.handleMainMenu();
        }
      } catch (RuntimeException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  private void handleLoginMenu() {
    System.out.println("欢迎来到热搜排行榜，你是？\n1. 用户\n2. 管理员\n3. 退出\n");
    switch (this.in.nextLine()) {
      case "1": this.login(Constants.NORMAL_USER);break;
      case "2": this.login(Constants.ADMIN);break;
      default:
        System.out.println("Thanks for use !");
        this.cliState = Constants.CLI_STOP;
        break;
    }
  }

  private void login(String loginFlag) {
    System.out.println("请输入用户名：");
    String userName = this.in.nextLine();
    SingleContextStorage.setCurUser(UserService.userLogin(loginFlag, userName));
  }

  private void handleMainMenu() {
    System.out.println(this.getMainMenuStr());
    String input = this.in.nextLine();
    if (input == null) {
      throw new RuntimeException("请选择一个功能执行 ~");
    }
    int num = Integer.parseInt(input);
    if (num < 0 || num > this.menu.size()) {
      throw new RuntimeException("请输入正确的序号 ~");
    }
    this.menu.get(num - 1).run();
  }

  private String getMainMenuStr() {
    this.menu = SingleContextStorage.functions.getMenuByUserType(SingleContextStorage.curUser.getUserType());
    StringBuilder res = new StringBuilder(String.format("你好, %s, 你可以：\n", SingleContextStorage.curUser.getUserName()));
    for(int i = 0; i < this.menu.size(); i++) {
      res.append(String.format("%s. %s\n", i+1, this.menu.get(i).getDesc()));
    }
    return res.toString();
  }
}
