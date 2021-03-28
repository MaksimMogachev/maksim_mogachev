package com.senlacourses.electronicHotelAdministrator.domain.service;

import com.senlacourses.electronicHotelAdministrator.Main;
import com.senlacourses.electronicHotelAdministrator.dao.HotelRoomDao;
import com.senlacourses.electronicHotelAdministrator.dao.ServiceDao;
import com.senlacourses.electronicHotelAdministrator.domain.model.HotelRoom;
import com.senlacourses.electronicHotelAdministrator.domain.model.Service;
import com.senlacourses.electronicHotelAdministrator.domain.model.criteriaForSorting.ServiceAndRoomSortingCriteria;
import com.senlacourses.electronicHotelAdministrator.domain.service.interfaces.IServiceService;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceService implements IServiceService {

  private ServiceDao serviceDao = ServiceDao.getInstance();
  private HotelRoomDao hotelRoomDao = HotelRoomDao.getInstance();
  private final static Logger logger = LoggerFactory.getLogger(Main.class);

  public List<Service> getServices() {
    return serviceDao.getAll();
  }

  @Override
  public void addNewService(String name, int price) {
    serviceDao.create(new Service(name, price));
  }

  @Override
  public void showCurrentServices() {
    serviceDao.getAll().forEach(service -> System.out.println(service.toString()));
  }

  @Override
  public void changeServicePrice(String nameOfService, int newPrice) {
    int indexOfService = findIndexOfService(nameOfService);

    if (indexOfService == -1) {
      logger.error("IllegalArgumentException(\"this service does not exist\")");
      throw new IllegalArgumentException("this service does not exist");
    }

    if (newPrice < 0) {
      logger.error("IllegalArgumentException(\"incorrect newPrice\")");
      throw new IllegalArgumentException("incorrect newPrice");
    }

    serviceDao.update(new Service(nameOfService, newPrice), indexOfService);
  }

  @Override
  public void showPriceOfServicesAndRoomsByCriterion(ServiceAndRoomSortingCriteria criterion) {

    switch (criterion) {

      case SECTION -> {
        showCurrentServices();
        hotelRoomDao.getAll().forEach(hotelRoom -> System.out.println("Hotel room: "
            + hotelRoom.getNumberOfRoom() + ": " + hotelRoom.getPrice()));
      }
      case PRICE -> {
        List<Service> services = new ArrayList<>(serviceDao.getAll());
        List<HotelRoom> hotelRooms = new ArrayList<>(hotelRoomDao.getAll());

        services.sort(Comparator.comparing(Service::getPrice));
        hotelRooms.sort(Comparator.comparing(HotelRoom::getPrice));

        services.forEach(service -> System.out.println(service.toString()));

        hotelRooms.forEach(hotelRoom -> System.out.println("Hotel room: "
            + hotelRoom.getNumberOfRoom() + ": " + hotelRoom.getPrice()));
      }
    }
  }

  private int findIndexOfService(String name) {
    int indexOfService = -1;

    for (int i = 0; i < serviceDao.getAll().size(); i++) {
      if (serviceDao.read(i).getName().equals(name)) {
        indexOfService = i;
        break;
      }
    }
    return indexOfService;
  }
}
