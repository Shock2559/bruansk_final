package com.bruansk.controller;

import com.bruansk.config.CheckToken;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@CrossOrigin
@RestController
@RequestMapping(name = "/test")
@Tag(name = "Контроллер для теста")
public class TestAuth {

    @CrossOrigin
    @GetMapping("/test")
    @Operation(description = "Тест авторизации")
    public ResponseEntity<Object> getTest(@RequestHeader("Authorization") String token) {

        try {

            int responseCode = CheckToken.checkToken(token);

            if(responseCode == 401) {
                return new ResponseEntity<>("Invalid token", HttpStatus.FORBIDDEN);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Hello", HttpStatus.OK);

    }


}
