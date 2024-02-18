package com.cbfacademy.apiassessment.api.service;

import java.util.List;
import java.util.stream.Collectors;

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
    
    //Algotrithm
    @Override
    public List<Holiday> getPublicHolidays() {
    return holidayRepository.getAllHolidays().stream()
            .filter(Holiday::isPublicHoliday)
            .collect(Collectors.toList());
    }

    public void addHoliday(Holiday holiday){
        //Logic to add a new holiday to the repository
        holidayRepository.addHoliday(holiday);
    }

    @Override
    public void updateHoliday(String name, Holiday updatedHoliday) {
        holidayRepository.updateHoliday(name, updatedHoliday);
    }

    @Override
    public void deleteHoliday(String name) {
        holidayRepository.deleteHoliday(name);
    }
}

   
