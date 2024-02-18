package com.cbfacademy.apiassessment.api.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cbfacademy.apiassessment.api.entities.Holiday;
import com.cbfacademy.apiassessment.api.exceptions.HolidayNotFoundException;
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

    

    public Long daysUntilNextHoliday(String name) {
        // Retrieve the holiday by name
        Holiday holiday = holidayRepository.getHolidayByName(name);

        // Check if the holiday is found
        if (holiday != null) {
            // Calculate the days until the next holiday
           LocalDate currentDate = LocalDate.now();
           LocalDate nextHolidayDate = holiday.getDate();
           long daysUntilNextHoliday = currentDate.until(nextHolidayDate).getDays();
           return daysUntilNextHoliday;
            
        } else {
            // Handle the case where the holiday is not found
            throw new HolidayNotFoundException("Holiday not found");
        }
    }
}
