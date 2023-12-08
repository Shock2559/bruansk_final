package com.bruansk.controller;

import com.bruansk.config.CheckToken;
import com.bruansk.restclass.request.RequestOne;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@CrossOrigin
@Controller
@RestController
@RequestMapping("/file_manager")
@Tag(name = "Контроллер для загрузки и скачивания файлов")
public class FileManager {

    @GetMapping("/get_file")
    @Operation(description = "Запрос принимает название файла")
    public ResponseEntity<Object> getFileFromServer(@RequestParam String name) {

        name += "-uploaded";

        String patch = "/opt/tomcat/input_files/" + name;

        try {
            BufferedInputStream stream = new BufferedInputStream(new FileInputStream(patch));

            return new ResponseEntity<>(stream.readAllBytes(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/save")
    public ResponseEntity<Object> saveFile(@RequestParam("file") MultipartFile file,
                                           @RequestParam("name") String name) {

        if(!file.isEmpty()) {

            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File("/opt/tomcat/input_files/" + name + "-uploaded")));
                stream.write(bytes);
                stream.close();

            } catch (Exception e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }


        } else {
            return new ResponseEntity<>("Error open file", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("ok", HttpStatus.OK);

    }



}
