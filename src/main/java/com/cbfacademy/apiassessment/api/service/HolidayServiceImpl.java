package com.cbfacademy.apiassessment.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cbfacademy.apiassessment.api.entities.Holiday;
import com.cbfacademy.apiassessment.api.repositories.HolidayRepository;

@Service
public class HolidayServiceImpl implements HolidayService {

    private final HolidayRepository holidayRepository;

    public HolidayServiceImpl(HolidayRepository holidayRepository) {
        this.holidayRepository = holidayRepository;
    }

    public List<Holiday> getAllHolidays() {
        return holidayRepository.getAllHolidays();
    }

    public Holiday getHolidayByName(String name) {
        return holidayRepository.getHolidayByName(name);
    }
}
   
