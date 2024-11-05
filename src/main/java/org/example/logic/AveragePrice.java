package org.example.logic;

import java.util.*;
import java.util.stream.Collectors;
import org.example.datatypes.properties.Property;

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
   * @param propertyList the list of properties
   */
  public static void averagePricePerNumberOfRooms(List<Property> propertyList) {
    System.out.println("\n\n");
    System.out.println("Average price per number of rooms");
    propertyList.stream()
        .filter(property -> property.price() != null)
        .collect(Collectors.groupingBy(Property::rooms, Collectors.averagingInt(Property::price)))
        .entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .forEach(
            entry ->
                System.out.printf("Rooms: %9s, price: %.2f%n", entry.getKey(), entry.getValue()));
  }

  /**
   * Prints the average price per district_number.
   *
   * @param propertyList the list of properties
   */
  public static void averagePricePerYear(List<Property> propertyList) {
    System.out.println("\n\n");
    System.out.println("Average price per year for properties.");

    propertyList.stream()
        .filter(property -> property.price() != null)
        .collect(Collectors.groupingBy(Property::year, Collectors.averagingInt(Property::price)))
        .entrySet()
        .stream()
        .sorted(Map.Entry.comparingByKey())
        .toList()
        .forEach(
            integerDoubleEntry ->
                System.out.printf(
                    "year: %d, average price: %.2f%n",
                    integerDoubleEntry.getKey(), integerDoubleEntry.getValue()));
  }
}
