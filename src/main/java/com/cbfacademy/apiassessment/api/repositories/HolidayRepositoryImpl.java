package com.cbfacademy.apiassessment.api.repositories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cbfacademy.apiassessment.api.entities.Holiday;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Repository
public class HolidayRepositoryImpl implements HolidayRepository{
    
//List to store holiday objects in memory initialised by empty array list
private List<Holiday> holidays = new ArrayList<>();

 // Constructor to load holiday data from JSON file during initialization
//  The `loadHolidayData` method reads the data from the "holidays.json" file in the classpath and initializes the in-memory holiday list
 public HolidayRepositoryImpl() {
        loadHolidayData();
    }

    // Method to load holiday data from the JSON file using Gson
    private void loadHolidayData() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("holidays.json")) {
            if (inputStream != null) {
                // Read JSON data into a list of Holiday objects
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                holidays = new Gson().fromJson(reader, new TypeToken<List<Holiday>>() {}.getType());
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
}