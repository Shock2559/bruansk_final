package com.bruansk.service;

import com.bruansk.repository.CalendarRepository;
import com.bruansk.restclass.response.AnswerList;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class CalendarService {

    @Autowired
    final private CalendarRepository calendarRepository;


    public ResponseEntity<Object> getTaskByDate(Date dateStart) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateStart);
        calendar.add(Calendar.DAY_OF_YEAR, 14);
        Date dateEnd = calendar.getTime();

        try {

            List<Object> list = calendarRepository.get_task_by_date(dateStart, dateEnd);

            AnswerList answerList = new AnswerList();
            answerList.setAnswer(list);

            return new ResponseEntity<>(answerList, HttpStatus.OK);

        } catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
