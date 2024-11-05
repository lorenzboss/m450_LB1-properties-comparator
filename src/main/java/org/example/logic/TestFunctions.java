package org.example.logic;

import java.util.List;
import org.example.datatypes.properties.Property;

/**
 * This class executes all logic methods once for the functional and once for the imperative
 *
 * @author Lorenz Boss
 * @version 1.0
 */
public class TestFunctions {

  /**
   * Executes all logic methods once for the functional and once for the imperative
   *
   * @param propertyList the list of properties
   */
  public static void testFunction(List<Property> propertyList) {
    PropertiesInfo.propertiesInfo(propertyList, 5);
    PropertiesInfo.propertiesInfoCompact(propertyList, 5);
    NumberOfSales.numberOfSales(propertyList);
    NumberOfSales.numberOfSalesPerYear(propertyList);
    HighestPrice.mostExpensivePropertiesPrice(propertyList, 5);
    HighestPrice.mostExpensiveProperties(propertyList, 5);
    AveragePrice.averagePricePerNumberOfRooms(propertyList);
    AveragePrice.averagePricePerYear(propertyList);
  }
}
