package org.example.logic;

import java.util.*;
import java.util.stream.Collectors;
import org.example.properties.Property;
import org.example.properties.PropertyService;
import org.example.properties.Rooms;

/**
 * This class is responsible for calculating the average price of properties in different formats.
 *
 * @author Lorenz Boss
 * @version 2.0
 */
public class AveragePrice {

  /**
   * Prints the average price per district_number.
   *
   * @return the list of the average price per district_number
   */
  public static List<Map.Entry<Rooms, Double>> averagePricePerNumberOfRooms() {
    List<Property> propertyList = PropertyService.getProperties();

    return propertyList.stream()
        .filter(property -> property.price() != null)
        .collect(Collectors.groupingBy(Property::rooms, Collectors.averagingInt(Property::price)))
        .entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .toList();
  }

  /**
   * Prints the average price per year.
   *
   * @return the list of the average price per year
   */
  public static List<Map.Entry<Integer, Double>> averagePricePerYear() {
    List<Property> propertyList = PropertyService.getProperties();

    return propertyList.stream()
        .filter(property -> property.price() != null)
        .collect(Collectors.groupingBy(Property::year, Collectors.averagingInt(Property::price)))
        .entrySet()
        .stream()
        .sorted(Map.Entry.comparingByKey())
        .toList();
  }
}
