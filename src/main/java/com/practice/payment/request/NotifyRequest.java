package com.practice.payment.request;

import lombok.Data;

@Data
public class NotifyRequest {
    private String userId;
    private String message;
}
