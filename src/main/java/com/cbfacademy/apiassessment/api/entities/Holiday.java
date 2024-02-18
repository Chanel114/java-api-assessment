package com.cbfacademy.apiassessment.api.entities;


public class Holiday {
//instance variables only be access in this class (getters and setters get/set the values)
    private String name; 
    private String date; 
    private boolean publicHoliday; 
  
//default constructor
    public Holiday(){}

//Constructors (general object maker to make specific object maker (versioned object))
public Holiday(String name, String date, boolean publicHoliday){
    this.name = name; 
    this.date = date; 
    this.publicHoliday = publicHoliday;
}

//Getter Method for Holiday name
public String getName() {
    return name;
    }

//Setter method for holiday date
public void setName(String name) {
    this.name = name;
} 

//Getter method for public holiday
public boolean isPublicHoliday(){
    return publicHoliday;
    }

//Setter method for public holiday
public void setPublicHoliday(boolean publicHoliday){
    this.publicHoliday = publicHoliday;
    }

//Getter method for holiday date
public String getDate(){
    return date;
    }
    

//Setter method for holiday date
public void setDate(String date) {
        this.date = date;
    }


@Override
public String toString(){
    return "Holiday{" +
    "name='" + name + '\'' +
    ", date='" + date + '\'' +
    ", publicHoliday=" + publicHoliday +
    '}';
}
     }

