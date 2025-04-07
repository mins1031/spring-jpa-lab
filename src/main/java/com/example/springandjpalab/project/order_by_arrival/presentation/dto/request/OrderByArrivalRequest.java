package com.example.springandjpalab.project.order_by_arrival.presentation.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class OrderByArrivalRequest {
    private Long userId;
    @JsonProperty("isAgree")
    private boolean isAgree;
}
