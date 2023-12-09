package com.bruansk.controller;

import com.bruansk.config.CheckToken;
import com.bruansk.restclass.request.RequestDate;
import com.bruansk.restclass.request.ThreatsRequest;
import com.bruansk.service.ThreatsService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
@RestController
@RequestMapping("/threats")
@Tag(name = "Контроллер для работы со списком угроз")
public class ThreatsController {

    @Autowired
    final private ThreatsService threatsService;


    public ThreatsController(ThreatsService threatsService) {
        this.threatsService = threatsService;
    }



    @PostMapping("/create")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(
            schema = @Schema(implementation = ThreatsRequest.class)))
    public ResponseEntity<Object> createThreats(@RequestBody ThreatsRequest request) {
        return threatsService.createThreats(request.getName(), request.getDescription());
    }


}
