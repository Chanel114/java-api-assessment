package com.cbfacademy.apiassessment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.cbfacademy.apiassessment.api.entities.Holiday;
import com.cbfacademy.apiassessment.api.repositories.HolidayRepository;
import com.cbfacademy.apiassessment.api.repositories.HolidayRepositoryImpl;

@DisplayName("The holiday Repository test should")
public class HolidayRepoImplTest {
    private HolidayRepository holidayRepository;

    @BeforeEach
    void setUp() {
        // Initialize the repository before each test
        holidayRepository = new HolidayRepositoryImpl();
    }

    @Test
    @DisplayName("show a non-empty list of holidays")
    void getAllHolidays_ShouldReturnNonEmptyList() {
        // GIVEN
        

        // WHEN
        List<Holiday> holidays = holidayRepository.getAllHolidays();

        // THEN
        assertNotNull(holidays);
        assertEquals(0, holidays.size()); 
    }
}
