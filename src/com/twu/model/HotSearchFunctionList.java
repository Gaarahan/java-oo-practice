package com.twu.model;

import com.twu.functions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gaarahan
 */
public class HotSearchFunctionList {
  private final ArrayList<HotSearchFunction> hotSearchFunctions;

  public HotSearchFunctionList() {
    this.hotSearchFunctions = new ArrayList<>();

    this.hotSearchFunctions.add(new GetHotSearchListFunction());
    this.hotSearchFunctions.add(new VoteHotSearchFunction());
    this.hotSearchFunctions.add(new BuyHotSearchFunciton());
    this.hotSearchFunctions.add(new AddSuperHotSearchFunction());
    this.hotSearchFunctions.add(new AddHotSearchFunction());
    this.hotSearchFunctions.add(new ExitFunction());
  }

  public List<HotSearchFunction> getMenuByUserType(String userType) {
    return hotSearchFunctions.stream()
        .filter(itm -> itm.checkAuthority(userType))
        .collect(Collectors.toList());
  }
}
