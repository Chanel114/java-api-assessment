package com.cbfacademy.apiassessment.api.repositories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cbfacademy.apiassessment.api.entities.Holiday;

public class HolidayRepositoryImpl implements HolidayRepository {

    // List to store holiday objects in memory initialized by empty array list
    private List<Holiday> holidays = new ArrayList<>();

    // Constructor to initialize the list and add a sample holiday for testing
    public HolidayRepositoryImpl() {
        holidays.add(new Holiday("Good Friday", LocalDate.of(2024, 3, 29), false));
    }

    // Implement get all holiday method from holiday repo interface
    @Override
    public List<Holiday> getAllHolidays() {
        // Return a new ArrayList containing ALL holidays
        return new ArrayList<>(holidays);
    }

    // This is the implementation of the get holiday by name method from the interface
    @Override
    public Holiday getHolidayByName(String name) {
        // Uses Java Streams to filter holiday or return null if no holiday is found
        return holidays.stream().filter(holiday -> holiday.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
}