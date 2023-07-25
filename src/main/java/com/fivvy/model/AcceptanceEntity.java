package com.fivvy.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection="acceptance")
public class AcceptanceEntity {
    @Transient
    public static final String SEQUENCE_NAME = "acceptance_sequence";

    @Id
    private Long disclaimerId;
    private Long userId;
    private LocalDateTime createAt;


}
