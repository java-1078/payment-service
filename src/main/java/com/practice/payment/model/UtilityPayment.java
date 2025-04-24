package com.practice.payment.model;

import lombok.Data;

@Data
public class UtilityPayment {

    private Long providerId;
    private Float amount;
    private String referenceNumber;
    private String account;
    private String paymentTarget;


}
