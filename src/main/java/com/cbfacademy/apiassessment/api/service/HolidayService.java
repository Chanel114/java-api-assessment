package com.cbfacademy.apiassessment.api.service;


import java.util.List;

import com.cbfacademy.apiassessment.api.entities.Holiday;

public interface HolidayService {
    List<Holiday> getAllHolidays();
    Holiday getHolidayByName(String name);
}