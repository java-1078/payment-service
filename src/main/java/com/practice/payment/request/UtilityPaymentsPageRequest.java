package com.practice.payment.request;

import lombok.Data;

@Data
public class UtilityPaymentsPageRequest {
    private Long pageNo;
    private Integer pageSize;
}
