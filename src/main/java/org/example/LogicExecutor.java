package org.example;

import org.example.districts.DistrictService;
import org.example.properties.PropertyService;
import org.example.properties.logic.AveragePrice;
import org.example.properties.logic.HighestPrice;
import org.example.properties.logic.NumberOfSales;

public class LogicExecutor {
  private final PropertyService propertyService = new PropertyService();
  private final DistrictService districtService = new DistrictService();
  private final NumberOfSales numberOfSales = new NumberOfSales(propertyService);
  private final HighestPrice highestPrice = new HighestPrice(propertyService);
  private final AveragePrice averagePrice = new AveragePrice(propertyService);

  public void executePropertyLogic() {
    System.out.println("\n\nNumber of properties sold: " + numberOfSales.numberOfSales());

    System.out.println("\n\nNumber of sales per year:");
    numberOfSales
        .numberOfSalesPerYear()
        .forEach(
            entry ->
                System.out.printf("%d: Sold properties: %d%n", entry.getKey(), entry.getValue()));

    System.out.println("\n\nThe price of the most expensive properties:");
    highestPrice
        .mostExpensiveProperties(5)
        .forEach(
            entry ->
                System.out.printf(
                    "%3d: selling price CHF: %d%n", entry.getKey(), entry.getValue()));

    System.out.println("\n\nAverage price per number of rooms:");
    averagePrice
        .averagePricePerNumberOfRooms()
        .forEach(
            entry ->
                System.out.printf("Rooms: %9s, price: %.2f%n", entry.getKey(), entry.getValue()));

    System.out.println("\n\nAverage price per year for properties:");
    averagePrice
        .averagePricePerYear()
        .forEach(
            entry ->
                System.out.printf(
                    "year: %d, average price: %.2f%n", entry.getKey(), entry.getValue()));
  }

  public void executeDistrictLogic() {
    System.out.println("\n\nDistricts:");
    districtService.getDistricts().forEach(System.out::println);
  }
}
