package com.bruansk.restclass.request;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MessageRequest {

    private String to;
    private String subject;
    private String text;

}
