package org.example;

import java.io.IOException;
import java.util.List;
import org.example.logic.TestFunctions;
import org.example.properties.District;
import org.example.properties.JsonToProperties;
import org.example.properties.Property;
import org.example.properties.Rooms;

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
  }
}
