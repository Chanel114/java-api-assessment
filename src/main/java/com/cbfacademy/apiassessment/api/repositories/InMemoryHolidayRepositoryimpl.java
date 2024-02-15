package com.cbfacademy.apiassessment.api.repositories;

import java.util.ArrayList;
import java.util.List;

import com.cbfacademy.apiassessment.api.entities.Holiday;

//Implementation of Holiday Repository methods
public class InMemoryHolidayRepositoryimpl implements HolidayRepository {
    private List<Holiday> holidays;

    //Constructor to initialise the list of holidays
    public InMemoryHolidayRepositoryimpl(){
        this.holidays = new ArrayList<>();
    }

    // Implementation of the addHoliday method from the interace
    @Override
    public void addHoliday(Holiday holiday) {
        holidays.add(holiday);
    }

    // Implementation of the getAllHolidays method from the interace
    @Override
    public List<Holiday> getAllHolidays() {
        //Return a new list to prevent direct modification of the interface
        return new ArrayList<>(holidays);
    }

    // Implementation of the RemoveHoliday method from the interace
    @Override
    public void removeHoliday(Holiday holiday) {
       holidays.remove(holiday);
    }
    
}
