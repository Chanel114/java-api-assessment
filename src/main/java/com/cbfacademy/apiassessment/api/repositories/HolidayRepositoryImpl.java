package com.cbfacademy.apiassessment.api.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cbfacademy.apiassessment.api.entities.Holiday;


@Repository
public class HolidayRepositoryImpl implements HolidayRepository{
    
//List to store holiday objects in memory initialised by empty array list
private List<Holiday> holidays = new ArrayList<>();

 // Constructor to load holiday data from JSON file during initialization
//  The `loadHolidayData` method reads the data from the "holidays.json" file in the classpath and initializes the in-memory holiday list
 public HolidayRepositoryImpl() {
        loadHolidayData();
    }

    // Method to load holiday data from the JSON file using Jackson
    private void loadHolidayData() {

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("holidays.json")) {
            if (inputStream != null) {
                // Read JSON data into a list of Holiday objects
                ObjectMapper objectMapper = new ObjectMapper();
                holidays = objectMapper.readValue(inputStream, new TypeReference<List<Holiday>>() {});
            } else {
                // Handle the case where the JSON file is not found
                System.err.println("ERROR: Unable to find 'holidays.json' file in the classpath.");
            }
        } catch (IOException e) {
            // Handle the exception appropriately in a real application
            e.printStackTrace();  //Log the exception or use a logging framework
        }
    }

    //implement get all holiday method from holiday repo interface 
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

    @Override
    public void addHoliday(Holiday holiday) {
       holidays.add(holiday);
    }

    @Override
    public void updateHoliday(String name, Holiday updatedHoliday) {
    //logic to update exisiting holiday
    Holiday existingHoliday = getHolidayByName(name);
    if (existingHoliday != null) {
        //update existing holiday's variables
    existingHoliday.setName(updatedHoliday.getName());
    existingHoliday.setDate(updatedHoliday.getDate());
    existingHoliday.setPublicHoliday(updatedHoliday.isPublicHoliday());
    }
    }

    @Override
    public void deleteHoliday(String name) {
        // Logic to delete a holiday by name
        holidays.removeIf(holiday -> holiday.getName().equalsIgnoreCase(name));
    }
}
