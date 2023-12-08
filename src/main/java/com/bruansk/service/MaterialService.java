package com.bruansk.service;

import com.bruansk.entity.MaterialLink;
import com.bruansk.entity.MaterialType;
import com.bruansk.repository.MaterialLinkRepository;
import com.bruansk.repository.MaterialTypeRepository;
import com.bruansk.restclass.request.MaterialLinkRequest;
import com.bruansk.restclass.response.AnswerList;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaterialService {

    @Autowired
    final private MaterialLinkRepository materialLinkRepository;

    @Autowired
    final private MaterialTypeRepository materialTypeRepository;

    public ResponseEntity<Object> getArticleList() {

        try{
            List<Object> list = materialLinkRepository.my_get_article_list();

            AnswerList answerList = new AnswerList();
            answerList.setAnswer(list);

            return new ResponseEntity<>(answerList, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Object> getRandomArticleList() {

        try {

            List<Object> list = materialLinkRepository.my_get_article_list();

            int numberArticle = (int) Math.random() * list.size();

            return new ResponseEntity<>(list.get(numberArticle), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<Object> postCreateArticle(MaterialLinkRequest request) {

        try {

            MaterialLink materialLink = new MaterialLink();

            materialLink.setName(request.getName());
            materialLink.setLink(request.getLink());
            materialLink.setMaterialType((MaterialType) materialTypeRepository.my_get_type_by_id(request.getType_id()).get(0));

            materialLinkRepository.save(materialLink);

            return new ResponseEntity<>("The article is successful", HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<Object> getAllVideoLinkList() {

        try{
            List<Object> list = materialLinkRepository.my_get_video_link_list();

            AnswerList answerList = new AnswerList();
            answerList.setAnswer(list);

            return new ResponseEntity<>(answerList, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<Object> getRandomVideoLink() {
        try {

            List<Object> list = materialLinkRepository.my_get_video_link_list();

            int numberArticle = (int) Math.random() * list.size();

            return new ResponseEntity<>(list.get(numberArticle), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Object> getAllArticle() {

        try{

            List<Object> list = materialLinkRepository.get_all_article();

            AnswerList answerList = new AnswerList();
            answerList.setAnswer(list);

            return new ResponseEntity<>(answerList, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

}
