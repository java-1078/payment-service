package com.practice.payment.controller;

import com.practice.payment.dto.UtilityPayment;
import com.practice.payment.exception.PaymentNotFoundException;
import com.practice.payment.request.UtilityPaymentsPageRequest;
import com.practice.payment.response.UtilityPaymentResponse;
import com.practice.payment.service.UtilityPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UtilityPaymentController {

    private final UtilityPaymentService utilityPaymentService;

    @PostMapping({"/payment"})
    public UtilityPaymentResponse processPayment(@RequestBody UtilityPayment utilityPayment) {
        return utilityPaymentService.processPayment(utilityPayment);
    }

    @GetMapping("{id}")
    public UtilityPayment readPayment(@PathVariable Long id) throws PaymentNotFoundException {
        return utilityPaymentService.readPayment(id);
    }

    @GetMapping
    public List<UtilityPayment> readPayments(UtilityPaymentsPageRequest utilityPaymentsPageRequest) {
        return utilityPaymentService.readPayments(utilityPaymentsPageRequest);
    }
}