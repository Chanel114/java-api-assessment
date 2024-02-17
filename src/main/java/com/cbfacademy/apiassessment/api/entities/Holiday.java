package com.cbfacademy.apiassessment.api.entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Holiday {
    //instance variables only be access in this class (getters and setters get/set the values)
    private String name; //reps holiday name E.g christmas
    private LocalDate date; // reps date of holiday
    private boolean publicHoliday; // boolean flag indicates if is public holiday

//Constructors (general object maker to make specific object maker (versioned object))
public Holiday(String name, LocalDate date, boolean publicHoliday){
    this.setName(name); // controls under rules of setName setter method - specific holiday names only
    this.setDate(date); // controls under rules of setDate setter method
    this.publicHoliday = publicHoliday;
}


//Public holiday testing
//use this constructor for test
public Holiday(boolean publicHoliday){
    this.publicHoliday = publicHoliday;

}

//Getter method for public holiday
public Boolean isPublicHoliday(){
          return publicHoliday;
    }

//Setter method for public holiday
public void setPublicHoliday(boolean publicHoliday){
          this.publicHoliday = publicHoliday;

    }
    

//Setter method for holiday date
public void setDate(LocalDate date) {
        this.date = date;
    }
    
//Getter method for local date (current date)
public LocalDate getDate(){
       return date;
    }
    
//Algorithm to calculate days until the next holiday
public LocalDate daysUntilNextHoliday(){
    LocalDate currentDate = LocalDate.now();
    //calculates the number of days between the current date and the specified date (date). 
    return currentDate.plusDays(ChronoUnit.DAYS.between (currentDate, date));
    }
    //reps difference in days


    //Getter Method for Holiday name
    public String getName(){
    return name;
    }

    //Setter method for holiday date
    public void setName(String name) {
        this.name = name;


}



@Override
public String toString(){
    return "Holiday" + " " + name + " " + date + " " + publicHoliday;  
}
     }

