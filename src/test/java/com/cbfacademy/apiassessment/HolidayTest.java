package com.cbfacademy.apiassessment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;


import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.cbfacademy.apiassessment.api.entities.Holiday;
import com.cbfacademy.apiassessment.api.repositories.InMemoryHolidayRepositoryimpl;

public class HolidayTest {
    //Create an instance of the Holiday class
    Holiday holiday = new Holiday();

    @Test
    @Order(1)
    void daysUntilNextHoliday() {
//GIVEN
//set a future date for the holiday (5 days from today) (simulates a scenario where holiday is in the future)
    holiday.setDate(LocalDate.now().plusDays(5)); 
    
//WHEN
//Call the daysUntilNextHoliday method to calculate the days until the next holiday date (under test)
        int daysUntilNextHoliday = holiday.daysUntilNextHoliday();
//THEN
//Asserts that the calculated days are equal to the expected value (5)
        assertEquals(5, daysUntilNextHoliday); 

    }
    @Test
    @Order(2)
    void addAnotherHolidayAndCheckIfPresent() {
        InMemoryHolidayRepositoryimpl holidayRepository = new InMemoryHolidayRepositoryimpl();

        Holiday holiday = new Holiday();
        holiday.setDate(LocalDate.now().plusDays(10));
        holidayRepository.addHoliday(holiday);

        assertTrue(holidayRepository.getAllHolidays().contains(holiday));
    }




}
