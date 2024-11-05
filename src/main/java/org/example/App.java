package org.example;

import java.io.IOException;
import java.util.List;

import org.example.datatypes.districts.District;
import org.example.datatypes.districts.JsonToDistricts;
import org.example.logic.TestFunctions;
import org.example.datatypes.properties.JsonToProperties;
import org.example.datatypes.properties.Property;

/**
 * This class is responsible for executing the logic methods.
 *
 * @author Lorenz Boss
 * @version 1.0
 */
public class App {
  public static void main(String[] args) throws IOException {

    List<Property> properties =
        JsonToProperties.convertJsonToProperties("src/main/resources/properties.json");

    TestFunctions.testFunction(properties);

    List<District> districts =
        JsonToDistricts.convertJsonToDistricts("src/main/resources/districts.json");
    System.out.println(districts);
  }
}
