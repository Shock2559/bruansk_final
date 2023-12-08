package com.bruansk.service;

import com.bruansk.repository.ScammerCheckRepository;
import com.bruansk.restclass.response.AnswerStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScammerCheckService {

    @Autowired
    final private ScammerCheckRepository scammerCheckRepository;

    public ScammerCheckService(ScammerCheckRepository scammerCheckRepository) {
        this.scammerCheckRepository = scammerCheckRepository;
    }


    public ResponseEntity<Object> getCheckScammer(int type, String name) {

        List<Object> list = scammerCheckRepository.get_scammers_by_type_and_name(type, name);

        if(list.size() > 0) {
            AnswerStatus answerStatus = new AnswerStatus();
            answerStatus.setStatus("No");

            return new ResponseEntity<>(answerStatus, HttpStatus.OK);
        } else {
            AnswerStatus answerStatus = new AnswerStatus();
            answerStatus.setStatus("Ok");

            return new ResponseEntity<>(answerStatus, HttpStatus.OK);
        }

    }



}
