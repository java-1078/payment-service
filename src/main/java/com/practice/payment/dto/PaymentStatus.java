package com.practice.payment.dto;

import com.practice.payment.model.TransactionStatus;
import lombok.Data;

@Data
public class PaymentStatus {
    private TransactionStatus status;
    private String transactionId;
}
