package org.example.logic;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.example.datatypes.properties.Property;

/**
 * This class is responsible for calculating the highest price of properties.
 *
 * @author Lorenz Boss
 * @version 2.0
 */
public class HighestPrice {

  /**
   * Prints the price of the most expensive properties.
   *
   * @param propertyList the list of properties
   * @param limit the number of properties to print
   */
  public static void mostExpensivePropertiesPrice(List<Property> propertyList, int limit) {
    AtomicInteger index = new AtomicInteger(1);
    System.out.println("\n\n");
    System.out.println("The price of the most expensive properties");
    propertyList.stream()
        .map(Property::price)
        .filter(Objects::nonNull)
        .sorted(Comparator.reverseOrder())
        .limit(limit)
        .toList()
        .forEach(
            price ->
                System.out.printf("%3d: selling price CHF: %d%n", index.getAndIncrement(), price));
  }

  /**
   * Prints the most expensive properties.
   *
   * @param propertyList the list of properties
   * @param limit the number of properties to print
   */
  public static void mostExpensiveProperties(List<Property> propertyList, int limit) {
    AtomicInteger index = new AtomicInteger(1);
    System.out.println("\n\n");
    System.out.println("The most expensive properties");
    System.out.printf(
        "%-4s %-5s %-10s %-10s %-10s%n", "", "Year", "District", "Rooms", "Price CHF");

    propertyList.stream()
        .filter(property -> property.price() != null)
        .sorted(Comparator.comparing(Property::price).reversed())
        .limit(limit)
        .forEach(
            property ->
                System.out.printf(
                    "%-4d %-5d %-10s %-10s %-10d%n",
                    index.getAndIncrement(),
                    property.year(),
                    property.district_number(),
                    property.rooms(),
                    property.price()));
  }
}
