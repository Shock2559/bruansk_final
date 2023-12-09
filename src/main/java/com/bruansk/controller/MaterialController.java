package com.bruansk.controller;

import com.bruansk.config.CheckToken;
import com.bruansk.restclass.request.MaterialLinkRequest;
import com.bruansk.restclass.request.MessageRequest;
import com.bruansk.service.DefaultEmailService;
import com.bruansk.service.MaterialService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RestController
@RequestMapping("/material")
@Tag(name = "Контроллер для получения материалов")
public class MaterialController {

    @Autowired
    final private MaterialService materialService;

    @Autowired
    final private DefaultEmailService defaultEmailService;

    public MaterialController(MaterialService materialService, DefaultEmailService defaultEmailService) {
        this.materialService = materialService;
        this.defaultEmailService = defaultEmailService;
    }


    @GetMapping("/article_list")
    @Operation(description = "Получение списка всех статей")
    public ResponseEntity<Object> getArticleList(@RequestHeader("Authorization") String token) {

        try{

            int responseCode = CheckToken.checkToken(token);

            if(responseCode == 401) {
                return new ResponseEntity<>("Invalid token", HttpStatus.FORBIDDEN);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return materialService.getArticleList();
    }

    @GetMapping("/random_article_list")
    @Operation(description = "Получение рандомной статьи")
    public ResponseEntity<Object> getRandomArticleList(@RequestHeader("Authorization") String token) {

        try{

            int responseCode = CheckToken.checkToken(token);

            if(responseCode == 401) {
                return new ResponseEntity<>("Invalid token", HttpStatus.FORBIDDEN);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return materialService.getRandomArticleList();
    }

    @PostMapping("/create_article")
    @Operation(description = "Создание ссылки на статью или видео")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(
            schema = @Schema(implementation = MaterialLinkRequest.class)))
    public ResponseEntity<Object> postCrateArticle(@RequestHeader("Authorization") String token,
                                                   @RequestBody MaterialLinkRequest materialLink) {

        try{

            int responseCode = CheckToken.checkToken(token);

            if(responseCode == 401) {
                return new ResponseEntity<>("Invalid token", HttpStatus.FORBIDDEN);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return materialService.postCreateArticle(materialLink);
    }

    @GetMapping("/video_link_list")
    @Operation(description = "Получение список ссылок на видео")
    public ResponseEntity<Object> getAllVideoLinkList(@RequestHeader("Authorization") String token) {

        try{

            int responseCode = CheckToken.checkToken(token);

            if(responseCode == 401) {
                return new ResponseEntity<>("Invalid token", HttpStatus.FORBIDDEN);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return materialService.getAllVideoLinkList();
    }

    @GetMapping("/random_video_list")
    @Operation(description = "Получение рандомной ссылки на видео")
    public ResponseEntity<Object> getRandomVideoLink(@RequestHeader("Authorization") String token) {
        try{

            int responseCode = CheckToken.checkToken(token);

            if(responseCode == 401) {
                return new ResponseEntity<>("Invalid token", HttpStatus.FORBIDDEN);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return materialService.getRandomVideoLink();
    }

    @GetMapping("/get_all_article")
    @Operation(description = "Получить список всех статей")
    public ResponseEntity<Object> getAllArticle(@RequestHeader("Authorization") String token) {
        try{

            int responseCode = CheckToken.checkToken(token);

            if(responseCode == 401) {
                return new ResponseEntity<>("Invalid token", HttpStatus.FORBIDDEN);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return materialService.getAllArticle();
    }

    @GetMapping("/get_all_article_by_id_age")
    @Operation(description = "Возвращает все материалы по id age")
    public ResponseEntity<Object> getAllArticleByAge(@RequestHeader("Authorization") String token,
                                                     @RequestParam Integer id) {

        try{

            int responseCode = CheckToken.checkToken(token);

            if(responseCode == 401) {
                return new ResponseEntity<>("Invalid token", HttpStatus.FORBIDDEN);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return materialService.getAllArticleByAge(id);
    }


    @GetMapping("/get_article_by_id_age")
    @Operation(description = "Вовзаращет список статей по id age")
    public ResponseEntity<Object> getArticleByAge(@RequestHeader("Authorization") String token,
                                                  @RequestParam Integer id) {

        try{

            int responseCode = CheckToken.checkToken(token);

            if(responseCode == 401) {
                return new ResponseEntity<>("Invalid token", HttpStatus.FORBIDDEN);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return materialService.getArticleByAge(id);

    }


    @GetMapping("/get_video_link_by_id_age")
    @Operation(description = "Возвращает список ссылок на видео ролик по id age")
    public ResponseEntity<Object> getVideoLinkByAge(@RequestHeader("Authorization") String token,
                                                    @RequestParam Integer id) {

        try{

            int responseCode = CheckToken.checkToken(token);

            if(responseCode == 401) {
                return new ResponseEntity<>("Invalid token", HttpStatus.FORBIDDEN);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return materialService.getVideoLinkByAge(id);

    }






//    @PostMapping("/send_email")
//    public ResponseEntity<Object> sendMessage(@RequestHeader("Authorization") String token,
//                                              @RequestBody MessageRequest messageRequest) {
//
//        try{
//
//            int responseCode = CheckToken.checkToken(token);
//
//            if(responseCode == 401) {
//                return new ResponseEntity<>("Invalid token", HttpStatus.FORBIDDEN);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//
//
//        defaultEmailService.send(messageRequest.getTo(), messageRequest.getSubject(), messageRequest.getSubject());
//
//        return new ResponseEntity<>("Email send", HttpStatus.OK);
//    }


}
