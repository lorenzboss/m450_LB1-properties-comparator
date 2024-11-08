package org.example.properties.logic;

import java.util.*;
import java.util.stream.Collectors;
import org.example.properties.Property;
import org.example.properties.PropertyService;

/**
 * This class is responsible for calculating the number of sales in different formats.
 *
 * @author Lorenz Boss
 * @version 2.0
 */
public class NumberOfSales {

  /**
   * Calculates the number of sales.
   *
   * @return the number of sales
   */
  public static int numberOfSales() {
    List<Property> propertyList = PropertyService.getProperties();
    return propertyList.size();
  }

  /**
   * Calculates the number of sales per year.
   *
   * @return the list of sales per year
   */
  public static List<Map.Entry<Integer, Long>> numberOfSalesPerYear() {
    List<Property> propertyList = PropertyService.getProperties();

    return propertyList.stream()
        .collect(Collectors.groupingBy(Property::year, Collectors.counting()))
        .entrySet()
        .stream()
        .sorted(Map.Entry.comparingByKey())
        .toList();
  }
}
