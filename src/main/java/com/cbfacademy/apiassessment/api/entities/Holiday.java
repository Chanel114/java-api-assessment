package com.cbfacademy.apiassessment.api.entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Holiday {
    private String name;
    private LocalDate date;

    //Setter method for holiday date
    public void setDate(LocalDate date) {
        this.date = date;
    }

    // Constructors, getters and setters
    //Algorithm to calculate days until the next holiday
        public int daysUntilNextHoliday(){


        LocalDate currentDate = LocalDate.now();
            return (int)
        ChronoUnit.DAYS.between (currentDate, date);
    }

    }

