package com.bruansk.restclass.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CheckScammerRequest {
    private int type;
    private String name;
}
