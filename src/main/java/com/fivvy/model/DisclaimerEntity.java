package com.fivvy.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection="disclaimer")
public class DisclaimerEntity {

    @Transient
    public static final String SEQUENCE_NAME = "disclaimer_sequence";

    @Id
    private long id;
    private String name;
    private String text;
    private String version;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private AcceptanceEntity acceptanceEntity;
}
