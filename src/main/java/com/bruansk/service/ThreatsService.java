package com.bruansk.service;

import com.bruansk.entity.Threats;
import com.bruansk.repository.ThreatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class ThreatsService {

    @Autowired
    final private ThreatsRepository threatsRepository;

    public ThreatsService(ThreatsRepository threatsRepository) {
        this.threatsRepository = threatsRepository;
    }

    public ResponseEntity<Object> createThreats(String name, String description) {

        try {
            Threats threats = new Threats();
            threats.setName(name);
            threats.setDescription(description);

            threatsRepository.save(threats);


            String text = "Name " + threats.getName() + " Description " + threats.getDescription();

            URL url = new URL("https://af48-195-239-50-94.ngrok-free.app/send_message_bot");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");

            connection.setRequestProperty("message", text);

            connection.getResponseCode();


            return new ResponseEntity<>("Ok", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
