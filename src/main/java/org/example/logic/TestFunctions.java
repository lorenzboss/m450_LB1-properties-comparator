package org.example.logic;

import java.util.List;
import org.example.properties.Property;
import org.example.properties.Rooms;

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
    NumberOfSales.numberOfSalesPerDistrict(propertyList);
    NumberOfSales.numberOfSalesPerRooms(propertyList);
    NumberOfSales.numberOfSalesPerYear(propertyList);
    NumberOfSales.numberOfSalesPerYearRooms(propertyList);
    NumberOfSales.numberOfSalesPerYearDistrict(propertyList);
    HighestPrice.mostExpensivePropertiesPrice(propertyList, 5);
    HighestPrice.mostExpensiveProperties(propertyList, 5);
    AveragePrice.averagePricePerNumberOfRooms(propertyList);
    AveragePrice.averagePricePerYear(propertyList);
    AveragePrice.averagePricePerYearDistrict(propertyList);
    PriceDifference.priceDifferencePerYear(propertyList, Rooms.TWO, Rooms.ONE);
    PriceDifference.priceDifferencePerDistrict(propertyList, Rooms.TWO, Rooms.ONE);
    PriceDevelopment.priceDevelopmentPerDistrict(propertyList, 2020, 2021);
    PriceDevelopment.priceDevelopmentPerNumberOfRooms(propertyList, 2013, 2021);
  }
}
