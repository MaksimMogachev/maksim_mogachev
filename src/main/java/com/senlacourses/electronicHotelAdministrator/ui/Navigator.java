package com.senlacourses.electronicHotelAdministrator.ui;

public class Navigator {

  private Menu currentMenu = Menus.getRootMenu();

  public void printMenu() {
    System.out.println(currentMenu.getName() + "\n");

    for (MenuItem item : currentMenu.getMenuItems()) {
      System.out.println(item.title());
    }
  }

  public void navigate(int index) {
    if (index > currentMenu.getMenuItems().length || index < 0) {
      System.out.println("Incorrect index");
      return;
    }

    if (index == 0) {
      currentMenu = Menus.getRootMenu();
      return;
    }

    if (currentMenu.getMenuItems()[index - 1].nextMenu() != null) {
      currentMenu = currentMenu.getMenuItems()[index - 1].nextMenu();
    } else {
      currentMenu.getMenuItems()[index - 1].action().execute();
    }
  }
}
