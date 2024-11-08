package org.example.districts;

import java.io.IOException;
import java.util.List;

/**
 * This class gets the districts and executes the district logic.
 *
 * @version 1.0
 * @author Lorenz Boss
 */
public class DistrictService {
  /** Executes the district logic. */
  public void executeDistrictLogic() {
    List<District> districts = getDistricts();
    System.out.println("\nDistricts:");
    districts.forEach(System.out::println);
  }

  /**
   * Gets the districts.
   *
   * @return the list of districts
   */
  public static List<District> getDistricts() {
    try {
      return JsonToDistricts.convertJsonToDistricts("src/main/resources/districts.json");
    } catch (IOException e) {
      throw new RuntimeException("The file specified in the district service was not found!", e);
    }
  }
}
