package org.example.districts.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.example.districts.District;
import org.example.districts.DistrictService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class HighestPopulationTest {

  private DistrictService districtServiceMock;
  private HighestPopulation highestPopulation;

  @BeforeEach
  void setUp() {
    districtServiceMock = Mockito.mock(DistrictService.class);
    highestPopulation = new HighestPopulation(districtServiceMock);
  }

  @Test
  void highestPopulationTest() {
    List<District> districts =
        Arrays.asList(
            new District(1, "Arlesheim", 73000, 96, 42, 32000),
            new District(2, "Laufen", 19000, 92, 43, 8500),
            new District(3, "Liestal", 62000, 85, 41, 27000),
            new District(4, "Sissach", 37000, 140, 40, 15000),
            new District(5, "Waldenburg", 10000, 103, 45, 4300));

    Mockito.when(districtServiceMock.getDistricts()).thenReturn(districts);

    int highestPopulationResult = highestPopulation.highestPopulation();

    assertEquals(73_000, highestPopulationResult);
  }

  @Test
  void highestPopulationWithEmptyDistrictList() {
    Mockito.when(districtServiceMock.getDistricts()).thenReturn(Collections.emptyList());

    int result = highestPopulation.highestPopulation();

    assertEquals(0, result);
  }

  @Test
  void highestPopulationWithSingleDistrict() {
    List<District> districts = List.of(new District(1, "Arlesheim", 45000, 96, 42, 32000));
    Mockito.when(districtServiceMock.getDistricts()).thenReturn(districts);

    int result = highestPopulation.highestPopulation();

    assertEquals(45000, result);
  }

  @Test
  void highestPopulationWithNegativePopulation() {
    List<District> districts =
        Arrays.asList(
            new District(1, "Arlesheim", -1000, 96, 42, 32000),
            new District(2, "Laufen", 30000, 92, 43, 8500),
            new District(3, "Liestal", 20000, 85, 41, 27000));
    Mockito.when(districtServiceMock.getDistricts()).thenReturn(districts);

    int result = highestPopulation.highestPopulation();

    assertEquals(30000, result);
  }
}
