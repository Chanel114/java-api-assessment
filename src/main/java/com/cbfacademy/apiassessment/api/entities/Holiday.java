package com.cbfacademy.apiassessment.api.entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Holiday {
    private LocalDate date;

    // Constructors, getters and setters
    //Algorithm to calculate days until the next holiday
    public int daysUntilNextHoliday(){
    LocalDate currentDate = LocalDate.now();
        return (int)
    ChronoUnit.DAYS.between (currentDate, date);
    }
    


    public void setDate(LocalDate plusDays) {
        throw new UnsupportedOperationException("Unimplemented method 'setDate'");
    }
    
}
