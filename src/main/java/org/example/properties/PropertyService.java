package org.example.properties;

import java.io.IOException;
import java.util.List;
import org.example.logic.AveragePrice;
import org.example.logic.HighestPrice;
import org.example.logic.NumberOfSales;

/**
 * This class gets the properties and executes the property logic.
 *
 * @version 1.0
 * @author Lorenz Boss
 */
public class PropertyService {
  /** Executes the property logic. */
  public void executePropertyLogic() {
    System.out.println("\n\nNumber of properties sold: " + NumberOfSales.numberOfSales());

    System.out.println("\n\nNumber of sales per year:");
    NumberOfSales.numberOfSalesPerYear()
        .forEach(
            entry ->
                System.out.printf("%d: Sold properties: %d%n", entry.getKey(), entry.getValue()));

    System.out.println("\n\nThe price of the most expensive properties:");
    HighestPrice.mostExpensivePropertiesPrice(5)
        .forEach(
            entry ->
                System.out.printf(
                    "%3d: selling price CHF: %d%n", entry.getKey(), entry.getValue()));

    System.out.println("\n\nThe most expensive properties:");
    System.out.printf(
        "%-4s %-5s %-10s %-10s %-10s%n", "", "Year", "District", "Rooms", "Price CHF");
    HighestPrice.mostExpensiveProperties(5)
        .forEach(
            entry ->
                System.out.printf(
                    "%-4d %-5d %-10s %-10s %-10d%n",
                    entry.getKey(),
                    entry.getValue().year(),
                    entry.getValue().district_number(),
                    entry.getValue().rooms(),
                    entry.getValue().price()));

    System.out.println("\n\nAverage price per number of rooms:");
    AveragePrice.averagePricePerNumberOfRooms()
        .forEach(
            entry ->
                System.out.printf("Rooms: %9s, price: %.2f%n", entry.getKey(), entry.getValue()));

    System.out.println("\n\nAverage price per year for properties:");
    AveragePrice.averagePricePerYear()
        .forEach(
            entry ->
                System.out.printf(
                    "year: %d, average price: %.2f%n", entry.getKey(), entry.getValue()));
  }

  /**
   * Gets the properties.
   *
   * @return the list of properties
   */
  public static List<Property> getProperties() {
    try {
      return JsonToProperties.convertJsonToProperties("src/main/resources/properties.json");
    } catch (IOException e) {
      throw new RuntimeException("The file specified in the property service was not found!", e);
    }
  }
}
