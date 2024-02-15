package com.cbfacademy.apiassessment.api.repositories;

import java.util.List;

import com.cbfacademy.apiassessment.api.entities.Holiday;

public interface HolidayRepository {
    //Methods to be implemented by the repository implementation 
    //initialise getallholidays method  
    List<Holiday> getAllHolidays();
    Holiday getHolidayByName(String name);
}
