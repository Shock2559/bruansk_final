package com.bruansk.controller;

import com.bruansk.config.CheckToken;
import com.bruansk.restclass.request.CheckScammerRequest;
import com.bruansk.service.ScammerCheckService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
@RestController
@RequestMapping("/scammer")
@Tag(name = "Проверка мошенников")
public class ScammerCheck {

    @Autowired
    final private ScammerCheckService scammerCheckService;

    public ScammerCheck(ScammerCheckService scammerCheckService) {
        this.scammerCheckService = scammerCheckService;
    }

    @CrossOrigin
    @PostMapping("/check")
    public ResponseEntity<Object> getCheckScammer(@RequestHeader("Authorization") String token,
                                                  @RequestBody CheckScammerRequest request) {

        try {

            int responseCode = CheckToken.checkToken(token);

            if (responseCode == 401) {
                return new ResponseEntity<>("Invalid token", HttpStatus.FORBIDDEN);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return scammerCheckService.getCheckScammer(request.getType(), request.getName());

    }


}
