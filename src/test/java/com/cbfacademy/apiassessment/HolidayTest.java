package com.cbfacademy.apiassessment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.cbfacademy.apiassessment.api.entities.Holiday;

public class HolidayTest {

    @Test
    void daysUntilNextHoliday() {
//Create an instance of the Holiday class
        Holiday holiday = new Holiday();
        
//set a future date for the holiday (5 days from today) (simulates a scenario where holiday is in the future)
    holiday.setDate(LocalDate.now().plusDays(5)); 
    
//WHEN
//Call the daysUntilNextHoliday method to calculate the days until the next holiday date (under test)
        int daysUntilNextHoliday = holiday.daysUntilNextHoliday();
//THEN
//Asserts that the calculated days are equal to the expected value (5)
        assertEquals(5, daysUntilNextHoliday); 

        
    }

}
