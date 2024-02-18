package com.cbfacademy.apiassessment.api.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cbfacademy.apiassessment.api.entities.Holiday;

@Repository
public interface HolidayRepository {
    //Methods to be implemented by the repository implementation 
    //initialise getallholidays method  
    List<Holiday> getAllHolidays();
    Holiday getHolidayByName(String name);
    void addHoliday(Holiday holiday);
    void updateHoliday(String name, Holiday updatedHoliday);
    void deleteHoliday(String name);

}
