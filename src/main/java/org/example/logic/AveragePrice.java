package org.example.logic;

import java.util.*;
import java.util.stream.Collectors;
import org.example.properties.District;
import org.example.properties.Property;

/**
 * This class is responsible for calculating the average price of properties in different formats.
 *
 * @author Lorenz Boss
 * @version 2.0
 */
public class AveragePrice {

  /**
   * Prints the average price per district.
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
   * Prints the average price per district.
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

  /**
   * Prints the average price per district and year.
   *
   * @param propertyList the list of properties
   */
  public static void averagePricePerYearDistrict(List<Property> propertyList) {
    System.out.println("\n\n");
    System.out.println("Average price per year and district");

    final Map<Integer, Map<District, Double>> salesPerYearDistrict =
        propertyList.stream()
            .filter(property -> property.price() != null)
            .collect(
                Collectors.groupingBy(
                    Property::year,
                    Collectors.groupingBy(
                        Property::district, Collectors.averagingInt(Property::price))));

    final Set<Integer> years = new TreeSet<>(salesPerYearDistrict.keySet());
    // TreeSet verwenden, um Districts zu sortieren
    final Set<District> districts = new TreeSet<>(Comparator.comparingInt(District::getSortOrder));
    salesPerYearDistrict.values().forEach(map -> districts.addAll(map.keySet()));

    // Header ausgeben
    System.out.print("year");
    System.out.print(
        districts.stream()
            .map(district -> String.format("%12s", district))
            .collect(Collectors.joining()));
    System.out.println();

    // Durchschnittspreise ausgeben
    years.stream()
        .map(
            year ->
                String.format("%4d", year)
                    + districts.stream()
                        .map(
                            district ->
                                String.format(
                                    "%12.2f",
                                    salesPerYearDistrict
                                        .getOrDefault(year, Collections.emptyMap())
                                        .getOrDefault(district, 0.0)))
                        .collect(Collectors.joining()))
        .forEach(System.out::println);
  }
}
