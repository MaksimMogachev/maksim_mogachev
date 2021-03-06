package com.senlacourses.electronicHotelAdministrator.ui.actions.hotelResident;

import com.senlacourses.electronicHotelAdministrator.domain.controller.interfaces.IHotelResidentController;
import com.senlacourses.electronicHotelAdministrator.ui.IAction;

public class ShowAllResidentsAction implements IAction {

  private final IHotelResidentController controller;

  public ShowAllResidentsAction(IHotelResidentController controller) {
    this.controller = controller;
  }

  @Override
  public void execute() {
    controller.showAllResidents();
  }
}
