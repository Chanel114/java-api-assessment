package com.cbfacademy.apiassessment.api.repositories;

import java.util.ArrayList;
import java.util.List;

import com.cbfacademy.apiassessment.api.entities.Holiday;

public class HolidayRepositoryImpl implements HolidayRepository{
//List to store holiday objects in memory initialised by empty array list
private List<Holiday> holidays = new ArrayList<>();

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
