package com.cbfacademy.apiassessment.api.controllers;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cbfacademy.apiassessment.api.entities.Holiday;
import com.cbfacademy.apiassessment.api.exceptions.HolidayNotFoundException;
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
public ResponseEntity<List<String>> getAllHolidayNames() {
    List<Holiday> holidays = holidayService.getAllHolidays();
    List<String> holidayNames = holidays.stream()
                                       .map(Holiday::getName)
                                       .collect(Collectors.toList());
    return new ResponseEntity<>(holidayNames, HttpStatus.OK);
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

  @GetMapping("/{name}/daysUntilNext")
  public ResponseEntity<Long> getDaysUntilNextHoliday(@PathVariable String name) {
    try {
      Long daysUntilNextHoliday = holidayService.daysUntilNextHoliday(name);
      return new ResponseEntity<>(daysUntilNextHoliday, HttpStatus.OK);
    } catch (HolidayNotFoundException e) {
      //handle if the holiday is not found
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}

