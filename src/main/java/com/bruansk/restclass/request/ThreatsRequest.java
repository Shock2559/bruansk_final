package com.bruansk.restclass.request;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ThreatsRequest {

    private String name;
    private String description;

}
