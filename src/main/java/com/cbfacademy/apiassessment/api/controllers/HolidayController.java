package com.cbfacademy.apiassessment.api.controllers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cbfacademy.apiassessment.api.entities.Holiday;
import com.cbfacademy.apiassessment.api.service.HolidayService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("holidays")
public class HolidayController {

@Autowired
private HolidayService holidayService;

public HolidayController(HolidayService holidayService){
  this.holidayService = holidayService;
}

@GetMapping
public ResponseEntity<List<Map<String, String>>> getAllHolidayDetails() {
    List<Holiday> holidays = holidayService.getAllHolidays();
    List<Map<String, String>> holidayDetails = holidays.stream()
            .map(holiday -> {
                Map<String, String> details = new HashMap<>();
                details.put("name", holiday.getName());
                details.put("date", holiday.getDate());
                return details;
            })
            .collect(Collectors.toList());

    return new ResponseEntity<>(holidayDetails, HttpStatus.OK);
}

  @GetMapping("/{name}")
  public ResponseEntity<Holiday> getHolidayByName(@PathVariable String name) {
    Holiday holiday = holidayService.getHolidayByName(name);
    if (holiday != null) {
      return new ResponseEntity<>(holiday, HttpStatus.OK);
    } else {
    return new ResponseEntity<>(holiday, HttpStatus.NOT_FOUND);
    }
  }


  @GetMapping("/publicHolidays")
    public ResponseEntity<List<Holiday>> getPublicHolidays() {
        List<Holiday> publicHolidays = holidayService.getPublicHolidays();
        return new ResponseEntity<>(publicHolidays, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addHoliday(@RequestBody Holiday newHoliday) {
        try {
            // Your algorithm to add a new holiday to the repository
            holidayService.addHoliday(newHoliday);
            return new ResponseEntity<>("Holiday added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add holiday: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
      }
      
      @PutMapping("/{name}")
      public ResponseEntity<String> updateHoliday(@PathVariable String name, @RequestBody Holiday updateHoliday) {
      try {
        // the algorithm to update existing holiday in the repository
        holidayService.updateHoliday(name, updateHoliday);
        return new ResponseEntity<>("Holiday updated successfully", HttpStatus.OK);
      } catch (Exception e) {
        return new ResponseEntity<>("Failed to update holiday: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


      @DeleteMapping("/{name}")
      public ResponseEntity<String> deleteHoliday(@PathVariable String name) {
        try {
          // The algorithm to delete existing holiday in the repository
          holidayService.deleteHoliday(name);
          return new ResponseEntity<>("Holiday deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
          return new ResponseEntity<>("Failed to deleteholiday: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
}
      }
}