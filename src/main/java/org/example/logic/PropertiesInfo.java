package org.example.logic;

import java.util.List;
import org.example.properties.Property;

/**
 * This class is responsible for printing the properties in different formats.
 *
 * @author Lorenz Boss
 * @version 2.0
 */
public class PropertiesInfo {

  /**
   * Prints the properties in the normal format.
   *
   * @param propertyList the list of properties
   * @param limit the number of properties to print
   */
  public static void propertiesInfo(List<Property> propertyList, Integer limit) {
    System.out.println("\n\n");
    System.out.println(
        limit == null ? "All properties:" : String.format("The first %d properties", limit));
    propertyList.stream()
        .limit(limit != null ? limit : propertyList.size())
        .forEach(
            property -> {
              System.out.println("Year:     " + property.year());
              System.out.println("District: " + property.district_number());
              System.out.println("Rooms:    " + property.rooms());
              System.out.println("Price:    " + property.price());
              System.out.println();
            });
  }

  /**
   * Prints the properties in a compact format.
   *
   * @param propertyList the list of properties
   * @param limit the number of properties to print
   */
  public static void propertiesInfoCompact(List<Property> propertyList, Integer limit) {
    System.out.println("\n\n");
    System.out.println(
        limit == null
            ? "All properties in compact form:"
            : String.format("The first %d properties in compact form:", limit));

    System.out.printf("%s %-10s %-9s %7s%n", "Year", "Distract", "Rooms", "Price");

    propertyList.stream()
        .limit(limit != null ? limit : propertyList.size())
        .forEach(
            property ->
                System.out.printf(
                    "%d %-10s %-9s %7d%n",
                    property.year(),
                    property.district_number(),
                    property.rooms(),
                    property.price()));
  }
}
