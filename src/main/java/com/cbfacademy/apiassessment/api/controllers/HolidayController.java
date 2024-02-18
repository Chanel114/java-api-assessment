package com.cbfacademy.apiassessment.api.controllers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cbfacademy.apiassessment.api.entities.Holiday;
import com.cbfacademy.apiassessment.api.service.HolidayService;

import org.springframework.web.bind.annotation.RequestMapping;



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


  @GetMapping("/isPublicHoliday/{date}")
  public ResponseEntity<Boolean> isPublicHoliday(@PathVariable String date) {
    boolean isPublicHoliday = holidayService.isPublicHoliday(date);
      return new ResponseEntity<>(isPublicHoliday, HttpStatus.NOT_FOUND);
  }
  
}

