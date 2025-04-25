package com.practice.payment.request;

import lombok.Data;

@Data
public class UtilityPaymentRequest {

    private Long providerId;
    private Float amount;
    private String referenceNumber;
    private String account;
    private String userId;
}
