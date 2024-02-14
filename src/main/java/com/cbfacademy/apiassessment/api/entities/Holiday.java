package com.cbfacademy.apiassessment.api.entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Holiday {
    private String name; //reps holiday name E.g christmas
    private LocalDate date; // reps date of holiday
    private boolean publicHoliday; // boolean flag indicates if is public holiday

//Constructor
    public Holiday(String name, LocalDate date, boolean publicHoliday){
        this.name = name;
        this.date = date;
        this.publicHoliday = publicHoliday;
    }

    //Getter then setter method for public holiday
    public boolean isPublicHoliday(){
        return publicHoliday;
    }

    public void setPublicHoliday(boolean publicHoliday){
        this.publicHoliday = publicHoliday;
        
    }

    //Setter method for holiday date
    public void setDate(LocalDate date) {
        this.date = date;
    }

    //Algorithm to calculate days until the next holiday
        public int daysUntilNextHoliday(){
        LocalDate currentDate = LocalDate.now();
            return (int)
        ChronoUnit.DAYS.between (currentDate, date);
    }

    //Getter Method for Holiday name
    public void getName(String name){
    this.name = name;
}

     }

