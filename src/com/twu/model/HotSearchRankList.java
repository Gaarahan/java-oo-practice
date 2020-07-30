package com.twu.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gaarahan
 */
public class HotSearchRankList {
  private final ArrayList<HotSearchItem> hotSearchItemArrayList;

  public HotSearchRankList() {
    this.hotSearchItemArrayList = new ArrayList<>();
    //TODO init Data
    this.hotSearchItemArrayList.add(new HotSearchItem("Hot search 1"));
    this.hotSearchItemArrayList.add(new HotSearchItem("Hot search 2"));
    this.hotSearchItemArrayList.add(new HotSearchItem("Hot search 3"));
    this.hotSearchItemArrayList.add(new HotSearchItem("Hot search 4"));
    this.hotSearchItemArrayList.add(new HotSearchItem("Hot search 5"));
    this.hotSearchItemArrayList.add(new HotSearchItem("Super Hot Search 1", true));
  }

  public void add(String hotSearchDesc) {
    this.hotSearchItemArrayList.add(new HotSearchItem(hotSearchDesc));
  }

  public List<HotSearchItem> getSortedList() {
    List<HotSearchItem> sortedHotSearch = this.hotSearchItemArrayList.stream()
        .filter(itm -> itm.getPayRank() == 0)
        .sorted((a, b) -> b.getHeat() - a.getHeat())
        .collect(Collectors.toList());

    List<HotSearchItem> paidHotSearch = this.hotSearchItemArrayList.stream()
        .filter(itm -> itm.getPayRank() != 0)
        .collect(Collectors.toList());

    HashMap<Integer, HotSearchItem> paidItemMap = new HashMap<>(paidHotSearch.size());
    for (HotSearchItem itm:paidHotSearch) {
      HotSearchItem lastItem = paidItemMap.get(itm.getPayRank());
      if (lastItem == null || lastItem.getMoney() < itm.getMoney()) {
        paidItemMap.put(itm.getPayRank(), itm);
      }
    }

    new ArrayList<>(paidItemMap.keySet())
        .stream()
        .sorted()
        .forEach(itm -> {
          sortedHotSearch.add(itm - 1, paidItemMap.get(itm));
        });
    return sortedHotSearch;
  }

  public void addSuper(String hotSearchDesc) {
    this.hotSearchItemArrayList.add(new HotSearchItem(hotSearchDesc, true));
  }

  public HotSearchItem queryHotSearch(String desc) {
    for(HotSearchItem itm: this.hotSearchItemArrayList) {
      if (itm.getDesc().equals(desc)) {
        return itm;
      }
    }
    throw new RuntimeException("未找到该热搜");
  }
}
