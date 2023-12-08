package com.bruansk.restclass.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@Setter
@Getter
public class AnswerList {

    private List<Object> answer;

    public AnswerList() {
        this.answer = new ArrayList<>();
    }

    public AnswerList(List<Object> answer) {
        this.answer = answer;
    }

}
