package com.cbfacademy.apiassessment.api.repositories;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cbfacademy.apiassessment.api.entities.Holiday;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class HolidayRepositoryImpl implements HolidayRepository{
//List to store holiday objects in memory initialised by empty array list
private List<Holiday> holidays = new ArrayList<>();

 // Constructor to load holiday data from JSON file during initialization
//  The `loadHolidayData` method reads the data from the "holidays.json" file in the classpath and initializes the in-memory holiday list
 public HolidayRepositoryImpl() {
        loadHolidayData();
    }

    // Method to load holiday data from the JSON file
    private void loadHolidayData() {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Holiday>> typeReference = new TypeReference<>() {};
      
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("holidays.json")) {
            holidays = objectMapper.readValue(inputStream, typeReference);
            if (inputStream != null) {
                // Read JSON data into a list of Holiday objects
                holidays = objectMapper.readValue(inputStream, typeReference);
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
    public List<Holiday> getAllHolidays(){
        //return a new arraylist containing ALL holidays 
        return new ArrayList<>(holidays);
    }

    //this is implementation of get holiday by name method from interface
    @Override
    public Holiday getHolidayByName(String name) {
       //uses Java Streams to filter holiday or null if no holiday is found
        return holidays.stream().filter(holiday -> holiday.getName().equalsIgnoreCase(name)).findFirst().orElse(null);

    }
    
    
}
