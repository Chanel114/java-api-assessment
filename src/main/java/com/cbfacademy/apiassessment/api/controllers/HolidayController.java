package com.cbfacademy.apiassessment.api.controllers;



 import java.time.LocalDate;
 import java.util.List;

 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.RestController;

 import com.cbfacademy.apiassessment.api.entities.Holiday;



@RestController
public class HolidayController {
    @GetMapping("api/v1/holidays")
     public List<Holiday> holiday() {
         return List.of(
           new Holiday("Valentine's Day",
                           LocalDate.now().plusDays(5),
                             false));

 }
}