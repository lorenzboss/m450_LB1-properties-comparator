package org.example;

import java.util.List;
import org.example.logic.TestFunctions;
import org.example.properties.District;
import org.example.properties.Property;
import org.example.properties.Rooms;

/**
 * This class is responsible for executing the logic methods.
 *
 * @author Lorenz Boss
 * @version 1.0
 */
public class App {
  public static void main(String[] args) {
    Property property1 = new Property(2020, District.SISSACH, Rooms.FIVE_PLUS, 50000);
    Property property2 = new Property(2015, District.ARLESHEIM, Rooms.FOUR, 30000);
    List<Property> properties = List.of(property1, property2);
    TestFunctions.testFunction(properties);
  }
}
