package com.bruansk.controller;

import com.bruansk.config.CheckToken;
import com.bruansk.restclass.request.MaterialLinkRequest;
import com.bruansk.restclass.request.RequestDate;
import com.bruansk.restclass.request.RequestOne;
import com.bruansk.service.CalendarService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@CrossOrigin
@Controller
@RestController
@RequestMapping("/calendar")
@Tag(name = "Контроллер для работы с календарем")
public class CalendarController {

    @Autowired
    final private CalendarService calendarService;

    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @PostMapping("/get_task_by_date")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(
            schema = @Schema(implementation = RequestDate.class)))
    public ResponseEntity<Object> getTaskByDate(@RequestHeader("Authorization") String token,
                                                @RequestBody RequestDate request) {


        try{

            int responseCode = CheckToken.checkToken(token);

            if(responseCode == 401) {
                return new ResponseEntity<>("Invalid token", HttpStatus.FORBIDDEN);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return calendarService.getTaskByDate(request.getDate());


    }






}
