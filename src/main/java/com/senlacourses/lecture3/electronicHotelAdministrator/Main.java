package com.senlacourses.lecture3.electronicHotelAdministrator;

public class Main {

  public static void main(String[] args) {
    Administrator administrator = new Administrator("kakoi-to administrator");

    administrator.getListOfRooms().addNewRoom(500, null);
    administrator.getListOfRooms().putInTheRoom(0, "kakoi-to zhilec", 2204014);
    administrator.getListOfRooms().showCurrentList();

    administrator.getListOfRooms().changePrice(0, 800);
    administrator.getListOfRooms().evictFromTheRoom(0);
    administrator.getListOfRooms().changeRoomCondition(0, RoomCondition.REPAIRED);
    administrator.getListOfRooms().showCurrentList();

    administrator.getServices().addNewService("pomit' pol", 1000);
    administrator.getServices().changePrice("pomit' pol", 2000);
    administrator.getServices().showCurrentServices();

  }

}
