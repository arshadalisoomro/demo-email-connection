package com.ex.ample.contact.model;

import lombok.Data;
import lombok.ToString;

import java.util.Map;

/**
 * Created by Arshay on 10/10/2018.
 */
@Data
@ToString(includeFieldNames=true)
public class Email {

    private String name;
    private String from;
    private String to;
    private String subject;
    private String content;
    private Map<String , Object > model;

    public Email() {
    }

    public Email(String name, String from, String to, String subject, String content) {
        this.name = name;
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.content = content;
    }

}
