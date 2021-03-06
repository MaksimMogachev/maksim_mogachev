package com.senlacourses.electronicHotelAdministrator.ui.actions.service;

import com.senlacourses.electronicHotelAdministrator.domain.controller.interfaces.IServiceController;
import com.senlacourses.electronicHotelAdministrator.ui.IAction;
import java.util.Scanner;

public class AddNewServiceAction implements IAction {

  private final IServiceController controller;

  public AddNewServiceAction(IServiceController controller) {
    this.controller = controller;
  }

  @Override
  public void execute() {
    Scanner scanner = new Scanner(System.in);
    String name;
    int price;

    System.out.print("Enter name of service: ");
    name = scanner.nextLine();
    System.out.print("\nEnter price of service: ");
    price = scanner.nextInt();
    controller.addNewService(name, price);
  }
}
