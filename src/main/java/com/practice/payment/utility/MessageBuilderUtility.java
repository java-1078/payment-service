package com.practice.payment.utility;

import com.practice.payment.model.TransactionStatus;
import com.practice.payment.model.UtilityPaymentEntity;

public class MessageBuilderUtility {
    public String buildNotifyMessage(UtilityPaymentEntity utilityPaymentEntity){
        if(utilityPaymentEntity.getStatus().equals(TransactionStatus.SUCCESS)){
            return "Payment is Successful: "+"$"+utilityPaymentEntity.getAmount()+"is paid to electricity";
        }
        return null;
    }
}
