package com.practice.payment.mapper;

import com.practice.payment.model.UtilityPayment;
import com.practice.payment.model.UtilityPaymentEntity;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilityPaymentMapper extends BaseMapper<UtilityPaymentEntity,UtilityPayment> {


    public UtilityPaymentEntity convertToEntity(UtilityPayment dto) {
        UtilityPaymentEntity entity = new UtilityPaymentEntity();
        if (dto != null) {
            BeanUtils.copyProperties(dto, entity);
        }
        return entity;
    }


    public UtilityPayment convertToDto(UtilityPaymentEntity entity) {
        UtilityPayment dto = new UtilityPayment();
        if (entity != null) {
            BeanUtils.copyProperties(entity, dto);
        }
        return dto;
    }

}
