package org.example;

import org.example.districts.DistrictService;
import org.example.properties.PropertyService;

/**
 * This class is responsible for executing the logic methods.
 *
 * @author Lorenz Boss
 * @version 1.0
 */
public class App {
  public static void main(String[] args) {

    PropertyService propertyService = new PropertyService();
    DistrictService districtService = new DistrictService();

    propertyService.executePropertyLogic();
    districtService.executeDistrictLogic();
  }
}
