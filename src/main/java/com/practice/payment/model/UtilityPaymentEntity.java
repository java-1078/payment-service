package com.practice.payment.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="utility_payment")
public class UtilityPaymentEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Long providerId;
    private Float amount;
    private String referenceNumber;
    private String account;
    private String transactionId;
    private String userId;
    private String emailStatus;
    private String smsStatus;
    @Enumerated
    private TransactionStatus status;
}
