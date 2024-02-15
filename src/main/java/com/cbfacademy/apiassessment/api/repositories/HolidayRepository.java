package com.cbfacademy.apiassessment.api.repositories;

import java.util.List;

import com.cbfacademy.apiassessment.api.entities.Holiday;

public interface HolidayRepository {
    //Methods to be implemented by the repository implementation
    void addHoliday(Holiday holiday);
    List<Holiday> getAllHolidays();

    void removeHoliday(Holiday holiday);
}
