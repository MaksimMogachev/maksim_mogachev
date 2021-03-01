package com.senlacourses.lecture3.task2;

import com.senlacourses.lecture3.task2.flowers.Flower;
import java.util.ArrayList;
import java.util.List;

public class FlowerShop {

  private List<BouquetOfFlowers> bouquets = new ArrayList<>();

  public void addNewBouquetToList(BouquetOfFlowers bouquetOfFlowers) {
    bouquets.add(bouquetOfFlowers);
  }

  public void showCurrentBouquets() {
    for (BouquetOfFlowers bouquetOfFlowers : bouquets) {
      for (int i = 0; i < bouquetOfFlowers.getBouquet().size(); i++) {
        System.out.println(bouquetOfFlowers.getBouquet().get(i).getName() + " - "
            + bouquetOfFlowers.getBouquet().get(i).getPrice());
      }
      System.out.println();
    }
  }

  public void findTheTotalCost(BouquetOfFlowers bouquet) {
    int totalCost = 0;

    for (Flower flower : bouquet.getBouquet()) {
      totalCost += flower.getPrice();
    }

    System.out.println("\n" + "total cost is " + totalCost + "\n");
  }
}
