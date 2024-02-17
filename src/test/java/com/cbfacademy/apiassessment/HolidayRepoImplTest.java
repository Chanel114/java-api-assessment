package com.cbfacademy.apiassessment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cbfacademy.apiassessment.api.entities.Holiday;
import com.cbfacademy.apiassessment.api.repositories.HolidayRepository;
import com.cbfacademy.apiassessment.api.repositories.HolidayRepositoryImpl;

public class HolidayRepoImplTest {
    private HolidayRepository holidayRepository;

    @BeforeEach
    void setUp() {
        // Initialize the repository before each test
        holidayRepository = new HolidayRepositoryImpl();
    }

    @Test
    void getAllHolidays_ShouldReturnNonEmptyList() {
        // GIVEN
        // Assume that the holiday data is not loaded initially

        // WHEN
        List<Holiday> holidays = holidayRepository.getAllHolidays();

        // THEN
        assertNotNull(holidays);
        assertEquals(1, holidays.size()); // Initially, the list should be empty
    }
}
