package org.example.districts.logic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.*;

import org.example.districts.District;
import org.example.districts.DistrictService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class AverageAreaTest {

    private DistrictService districtServiceMock;
    private AverageArea averageArea;

    @BeforeEach
    void setUp() {
        districtServiceMock = Mockito.mock(DistrictService.class);
        averageArea = new AverageArea(districtServiceMock);
    }

    @Test
    void averageAreaTest(){
        List<District> districts = Arrays.asList(
                new District(1, "Arlesheim", 73000, 96, 42, 32000),
                new District(2, "Laufen", 19000, 92, 43, 8500),
                new District(3, "Liestal", 62000, 85, 41, 27000),
                new District(4, "Sissach", 37000, 140, 40, 15000),
                new District(5, "Waldenburg", 10000, 103, 45, 4300)
        );
        Mockito.when(districtServiceMock.getDistricts()).thenReturn(districts);

        double result = averageArea.averageDistrictArea();

        // Durchschnitt: (96 + 92 + 85 + 140 + 103) / 5 = 103.2
        assertEquals(103.2, result, 0.01);
    }

    @Test
    void averageAreaWithEmptyDistrictList() {
        Mockito.when(districtServiceMock.getDistricts()).thenReturn(Collections.emptyList());

        double result = averageArea.averageDistrictArea();

        assertEquals(0.0, result, 0.01);
    }

    @Test
    void averageAreaWithIdenticalAreas() {
        List<District> districts = Arrays.asList(
                new District(1, "Arlesheim", 73000, 100, 42, 32000),
                new District(2, "Laufen", 19000, 100, 43, 8500),
                new District(3, "Liestal", 62000, 100, 41, 27000)
        );
        Mockito.when(districtServiceMock.getDistricts()).thenReturn(districts);

        double result = averageArea.averageDistrictArea();

        assertEquals(100.0, result, 0.01);
    }


}