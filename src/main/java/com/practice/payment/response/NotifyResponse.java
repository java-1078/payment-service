package com.practice.payment.response;

import lombok.Data;

@Data
public class NotifyResponse {
    private String emailStatus;
    private String smsStatus;
}
