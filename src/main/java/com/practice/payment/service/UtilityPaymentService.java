package com.practice.payment.service;

import com.practice.payment.dto.PaymentStatus;
import com.practice.payment.dto.UtilityPayment;
import com.practice.payment.model.UtilityPaymentEntity;
import com.practice.payment.exception.PaymentNotFoundException;
import com.practice.payment.mapper.UtilityPaymentMapper;
import com.practice.payment.model.TransactionStatus;
import com.practice.payment.repository.UtilityPaymentRepository;
import com.practice.payment.request.UtilityPaymentsPageRequest;
import com.practice.payment.response.UtilityPaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UtilityPaymentService {

    private final UtilityPaymentRepository utilityPaymentRepository;

    public UtilityPaymentResponse processPayment(UtilityPayment utilityPayment) {
        UtilityPaymentMapper utilityPaymentMapper = new UtilityPaymentMapper();
        UtilityPaymentEntity utilityPaymentEntity = utilityPaymentMapper.convertToEntity(utilityPayment);
        //
        PaymentStatus paymentStatus = makePayment(utilityPayment);
        utilityPaymentEntity.setStatus(paymentStatus.getStatus());
        utilityPaymentEntity.setTransactionId(paymentStatus.getTransactionId());
        UtilityPaymentEntity updatedUtilityPaymentEntity = utilityPaymentRepository.save(utilityPaymentEntity);//
        //
        UtilityPaymentResponse utilityPaymentResponse = new UtilityPaymentResponse();
        utilityPaymentResponse.setTransactionId(paymentStatus.getTransactionId());
        if(paymentStatus.getStatus().equals(TransactionStatus.FAILED)){
            utilityPaymentResponse.setMessage("Your payment Failed ");
        } else if (paymentStatus.getStatus().equals(TransactionStatus.PROCESSING)) {
            utilityPaymentResponse.setMessage("Your payment is in processing");
        }else {
            utilityPaymentResponse.setMessage("Your payment is done");
        }
        return utilityPaymentResponse;
    }

    public UtilityPayment readPayment(Long id) throws PaymentNotFoundException {
        Optional<UtilityPaymentEntity> utilityPaymentEntityOptional = utilityPaymentRepository.findById(id);
        if (utilityPaymentEntityOptional.isPresent()) {
            UtilityPaymentEntity utilityPaymentEntity = utilityPaymentEntityOptional.get();
            UtilityPaymentMapper utilityPaymentMapper = new UtilityPaymentMapper();
            return utilityPaymentMapper.convertToDto(utilityPaymentEntity);
        } else {
            throw new PaymentNotFoundException();
        }
    }

    public List<UtilityPayment> readPayments(UtilityPaymentsPageRequest utilityPaymentsPageRequest) {
        Pageable pageable = PageRequest.of(utilityPaymentsPageRequest.getPageNo(), utilityPaymentsPageRequest.getPageSize());
        Page<UtilityPaymentEntity> pageData = utilityPaymentRepository.findAll(pageable);
        Stream<UtilityPaymentEntity> stream = pageData.get();
        UtilityPaymentMapper utilityPaymentMapper = new UtilityPaymentMapper();
        return utilityPaymentMapper.convertToDtoList(stream);
    }

    private PaymentStatus makePayment(UtilityPayment utilityPayment){
        PaymentStatus paymentStatus = new PaymentStatus();
        paymentStatus.setStatus(TransactionStatus.SUCCESS);
        paymentStatus.setTransactionId(UUID.randomUUID().toString());
        return paymentStatus;
    }
}
