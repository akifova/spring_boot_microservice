package com.kazu.core.jpa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by sarparda on 31.07.2016.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public abstract class BaseDto {

    private String id;
    private String savesUser;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date insertDate;
    private boolean active;
    private Integer version;
}
