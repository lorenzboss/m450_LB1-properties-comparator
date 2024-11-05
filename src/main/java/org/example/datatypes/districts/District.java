package org.example.datatypes.districts;

public record District(
    int district_number,
    String name,
    int population,
    int area,
    int average_age,
    int number_of_households) {}
