package org.example.logic;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.example.properties.District;
import org.example.properties.Property;
import org.example.properties.Rooms;

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
    System.out.println("Number of properties sold: " + propertyList.stream().count());
  }

  /**
   * Prints the number of sales per district.
   *
   * @param propertyList the list of properties
   */
  public static void numberOfSalesPerDistrict(List<Property> propertyList) {
    System.out.println("\n\n");
    System.out.println("Number of sales per district: ");
    propertyList.stream()
        .collect(Collectors.groupingBy(Property::district, Collectors.counting()))
        .entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .forEach(
            entry ->
                System.out.printf("District: %-10s Sales: %d%n", entry.getKey(), entry.getValue()));
  }

  /**
   * Prints the number of sales per rooms.
   *
   * @param propertyList the list of properties
   */
  public static void numberOfSalesPerRooms(List<Property> propertyList) {
    System.out.println("\n\n");
    System.out.println("Number of sales per rooms: ");

    propertyList.stream()
            .collect(Collectors.groupingBy(Property::rooms, Collectors.counting()))
            .entrySet()
            .stream()
            .sorted(Map.Entry.comparingByKey(Comparator.comparingInt(Rooms::getSortOrder)))
            .forEach(
                    entry ->
                            System.out.printf("Rooms: %-10s Sales: %d%n", entry.getKey(), entry.getValue()));
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

  /**
   * Prints the number of sales per year and rooms.
   *
   * @param propertyList the list of properties
   */
  public static void numberOfSalesPerYearRooms(List<Property> propertyList) {
    System.out.println("\n\n");
    System.out.println("Number of sales per year and number of rooms: ");

    Map<Integer, Map<Rooms, Long>> data =
        propertyList.stream()
            .collect(
                Collectors.groupingBy(
                    Property::year, Collectors.groupingBy(Property::rooms, Collectors.counting())));

    System.out.print("Year");
    data.values().stream()
        .flatMap(map -> map.keySet().stream())
        .distinct()
        .sorted()
        .forEach(rooms -> System.out.printf("%11s", rooms));
    System.out.println();

    data.entrySet().stream()
        .sorted(Map.Entry.comparingByKey())
        .forEach(
            entry -> {
              System.out.printf("%4d", entry.getKey());
              data.values().stream()
                  .flatMap(map -> map.keySet().stream())
                  .distinct()
                  .sorted()
                  .forEach(
                      rooms -> System.out.printf("%11d", entry.getValue().getOrDefault(rooms, 0L)));
              System.out.println();
            });
  }

  /**
   * Prints the number of sales per year and district.
   *
   * @param propertyList the list of properties
   */
  public static void numberOfSalesPerYearDistrict(List<Property> propertyList) {
    System.out.println("\n\n");
    System.out.println("Number of sales per year and district: ");

    final Map<Integer, Map<District, Long>> salesPerYearDistrict =
        propertyList.stream()
            .collect(
                Collectors.groupingBy(
                    Property::year,
                    Collectors.groupingBy(Property::district, Collectors.counting())));

    final Set<Integer> years = new TreeSet<>(salesPerYearDistrict.keySet());
    final List<District> districts =
        salesPerYearDistrict.values().stream()
            .flatMap(map -> map.keySet().stream())
            .distinct()
            .sorted(Comparator.comparingInt(District::getSortOrder))
            .toList();

    Stream.concat(
            Stream.of(
                "Year"
                    + districts.stream()
                        .map(district -> String.format("%12s", district))
                        .collect(Collectors.joining())),
            years.stream()
                .map(
                    year ->
                        String.format("%4d", year)
                            + districts.stream()
                                .map(
                                    district ->
                                        String.format(
                                            "%12d",
                                            salesPerYearDistrict
                                                .getOrDefault(year, Collections.emptyMap())
                                                .getOrDefault(district, 0L)))
                                .collect(Collectors.joining())))
        .toList()
        .forEach(System.out::println);
  }
}
