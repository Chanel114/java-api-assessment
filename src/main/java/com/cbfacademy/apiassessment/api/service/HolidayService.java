package com.cbfacademy.apiassessment.api.service;


import java.util.List;

import com.cbfacademy.apiassessment.api.entities.Holiday;

public interface HolidayService {
    List<Holiday> getAllHolidays();
    Holiday getHolidayByName(String name);

    //will determine if holiday chosen is a public holiday
    List<Holiday> getPublicHolidays();

    //Adds a holiday to the list
    void addHoliday(Holiday holiday);

    // Edit existing Holiday
    void updateHoliday(String name, Holiday updatedHoliday);
    
    // Delete existing Holiday
    void deleteHoliday(String name);
}

