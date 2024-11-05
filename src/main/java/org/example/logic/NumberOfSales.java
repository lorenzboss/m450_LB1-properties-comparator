package org.example.logic;

import java.util.*;
import java.util.stream.Collectors;
import org.example.properties.Property;

/**
 * This class is responsible for calculating the number of sales in different formats.
 *
 * @author Lorenz Boss
 * @version 2.0
 */
public class NumberOfSales {

  /**
   * Prints the number of properties sold.
   *
   * @param propertyList the list of properties
   */
  public static void numberOfSales(List<Property> propertyList) {
    System.out.println("\n\n");
    System.out.println("Number of properties sold: " + propertyList.size());
  }

  /**
   * Prints the number of sales per year.
   *
   * @param propertyList the list of properties
   */
  public static void numberOfSalesPerYear(List<Property> propertyList) {
    System.out.println("\n\n");
    System.out.println("Number of sales per year: ");
    propertyList.stream()
        .collect(Collectors.groupingBy(Property::year, Collectors.counting()))
        .entrySet()
        .stream()
        .sorted(Map.Entry.comparingByKey())
        .forEach(
            entry ->
                System.out.printf("%d: Sold properties: %d%n", entry.getKey(), entry.getValue()));
  }
}
