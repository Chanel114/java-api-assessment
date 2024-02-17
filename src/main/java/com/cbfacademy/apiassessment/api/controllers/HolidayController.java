package com.cbfacademy.apiassessment.api.controllers;



//  import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

 import com.cbfacademy.apiassessment.api.entities.Holiday;
import com.cbfacademy.apiassessment.api.service.HolidayService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@RequestMapping("api/v1/holidays")

public class HolidayController {

private final HolidayService holidayService;

public HolidayController(HolidayService holidayService){
  this.holidayService = holidayService;
}

  @GetMapping
  public List<Holiday> getAllHolidays(){
    return holidayService.getAllHolidays();
  }

  
  @GetMapping("/{name}")
  public Holiday getHolidayByName(@PathVariable String name) {
    return holidayService.getHolidayByName(name);
  }

  @GetMapping("/{name}/daysUntilNext")
  public int getDaysUntilNextHoliday(@RequestParam String name) {
      return holidayService.daysUntilNextHoliday(name);
  }
  
// for test 

//     @GetMapping("api/v1/holidays")
//      public List<Holiday> holiday() {
//          return List.of(
//            new Holiday("Valentine's Day",
//                            LocalDate.now().plusDays(5),
//                              false));

//  }

}

