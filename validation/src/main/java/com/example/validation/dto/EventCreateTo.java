package com.example.validation.dto;

import com.example.validation.validator.DateRange;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@DateRange
public class EventCreateTo {

    private String name;

    private OffsetDateTime fromDate;

    private OffsetDateTime toDate;

}
