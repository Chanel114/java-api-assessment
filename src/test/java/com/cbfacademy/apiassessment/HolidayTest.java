package com.cbfacademy.apiassessment;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.cbfacademy.apiassessment.api.entities.Holiday;

@DisplayName("The holiday test should")
public class HolidayTest {
    //Create an instance of the Holiday class
    Holiday holidayUnderTest = new Holiday("Christmas", LocalDate.now().plusDays(5), true);

    @Test
    @DisplayName("show how many days until the next holiday from today")
    void daysUntilNextHoliday() {
//GIVEN
//set a future date for the holiday (5 days from today) (simulates a scenario where holiday is in the future)
    holidayUnderTest.setDate(LocalDate.now().plusDays(5)); 
    
//WHEN
//Call the daysUntilNextHoliday method to calculate the days until the next holiday date (under test)
        int daysUntilNextHoliday = holidayUnderTest.daysUntilNextHoliday();
//THEN
//Asserts that the calculated days are equal to the expected value (5)
        assertEquals(5, daysUntilNextHoliday); 

    }
 




}
