package com.bruansk.restclass.request;

import lombok.*;

import java.util.UUID;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MaterialLinkRequest {

    private int type_id;
    private String name;
    private String link;
    private String link_preview;
    private int idTestCategory;

}
