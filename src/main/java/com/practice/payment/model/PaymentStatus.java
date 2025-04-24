package com.practice.payment.model;

import lombok.Data;

@Data
public class PaymentStatus {
    private TransactionStatus status;
    private String transactionId;
}
