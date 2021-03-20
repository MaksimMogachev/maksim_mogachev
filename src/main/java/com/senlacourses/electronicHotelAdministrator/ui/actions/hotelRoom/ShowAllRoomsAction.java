package com.senlacourses.electronicHotelAdministrator.ui.actions.hotelRoom;

import com.senlacourses.electronicHotelAdministrator.domain.service.HotelRoomService;
import com.senlacourses.electronicHotelAdministrator.ui.IAction;

public class ShowAllRoomsAction implements IAction {

  @Override
  public void execute() {
    new HotelRoomService().showAllRooms();
  }
}