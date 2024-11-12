package org.example.properties.logic;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import org.example.properties.Property;
import org.example.properties.PropertyService;
import org.example.properties.Rooms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class AveragePriceTest {

  private PropertyService propertyServiceMock;
  private AveragePrice averagePrice;

  @BeforeEach
  void setUp() {
    propertyServiceMock = Mockito.mock(PropertyService.class);
    averagePrice = new AveragePrice(propertyServiceMock);
  }

  @Test
  void testAveragePricePerYearWithMultipleProperties() {
    List<Property> properties =
        List.of(
            new Property(2021, 1, Rooms.ONE, 1000),
            new Property(2021, 2, Rooms.TWO, 2000),
            new Property(2022, 1, Rooms.THREE, 1500),
            new Property(2022, 3, Rooms.FOUR, 2570),
            new Property(2022, 1, Rooms.TWO, 6250));

    Mockito.when(propertyServiceMock.getProperties()).thenReturn(properties);

    List<Map.Entry<Integer, Double>> result = averagePrice.averagePricePerYear();

    assertEquals(2, result.size());
    assertEquals(1500.0, result.get(0).getValue());
    assertEquals(3440, result.get(1).getValue());
  }

  @Test
  void testAveragePricePerYearWithNoProperties() {
    Mockito.when(propertyServiceMock.getProperties()).thenReturn(Collections.emptyList());

    List<Map.Entry<Integer, Double>> result = averagePrice.averagePricePerYear();

    assertTrue(result.isEmpty());
  }

  @Test
  void testAveragePricePerYearWithNullPrices() {
    List<Property> properties =
        List.of(new Property(2021, 1, Rooms.ONE, null), new Property(2022, 2, Rooms.TWO, null));

    Mockito.when(propertyServiceMock.getProperties()).thenReturn(properties);

    List<Map.Entry<Integer, Double>> result = averagePrice.averagePricePerYear();

    assertTrue(result.isEmpty());
  }

  @Test
  void testAveragePricePerYearWithBoundaryYearValues() {
    List<Property> properties =
        List.of(
            new Property(Integer.MIN_VALUE, 1, Rooms.ONE, 1000),
            new Property(2022, 2, Rooms.TWO, 2000),
            new Property(Integer.MAX_VALUE, 3, Rooms.THREE, 3000));

    Mockito.when(propertyServiceMock.getProperties()).thenReturn(properties);

    List<Map.Entry<Integer, Double>> result = averagePrice.averagePricePerYear();

    assertEquals(3, result.size());
    assertEquals(1000.0, result.get(0).getValue());
    assertEquals(2000.0, result.get(1).getValue());
    assertEquals(3000.0, result.get(2).getValue());
  }

  @Test
  void testAveragePricePerYearWithEmptyPrice() {
    List<Property> properties =
        List.of(new Property(2021, 1, Rooms.ONE, null), new Property(2021, 2, Rooms.TWO, null));

    Mockito.when(propertyServiceMock.getProperties()).thenReturn(properties);

    List<Map.Entry<Integer, Double>> result = averagePrice.averagePricePerYear();

    assertTrue(result.isEmpty());
  }
}
