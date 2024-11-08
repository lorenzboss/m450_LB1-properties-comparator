package org.example.logic;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.example.properties.Property;
import org.example.properties.PropertyService;

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
   * @param limit the number of properties to print
   * @return the list of the most expensive properties
   */
  public static List<Map.Entry<Integer, Integer>> mostExpensivePropertiesPrice(int limit) {
    List<Property> propertyList = PropertyService.getProperties();
    AtomicInteger index = new AtomicInteger(1);

    return propertyList.stream()
        .map(Property::price)
        .filter(Objects::nonNull)
        .sorted(Comparator.reverseOrder())
        .limit(limit)
        .map(price -> Map.entry(index.getAndIncrement(), price))
        .toList();
  }

  /**
   * Prints the most expensive properties.
   *
   * @param limit the number of properties to print
   * @return the list of the most expensive properties
   */
  public static List<Map.Entry<Integer, Property>> mostExpensiveProperties(int limit) {
    List<Property> propertyList = PropertyService.getProperties();
    AtomicInteger index = new AtomicInteger(1);

    return propertyList.stream()
        .filter(property -> property.price() != null)
        .sorted(Comparator.comparing(Property::price).reversed())
        .limit(limit)
        .map(property -> Map.entry(index.getAndIncrement(), property))
        .toList();
  }
}
