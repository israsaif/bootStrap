package com.codeline.demo.Mail.models;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmailDetalis {
    private List<String>recipient;
    private String msgBody;
    private String subject;
    private String attachment;
}
