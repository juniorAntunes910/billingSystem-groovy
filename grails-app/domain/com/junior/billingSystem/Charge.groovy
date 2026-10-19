package com.junior.billingSystem

import java.time.LocalDate

class Charge {
    Client client
    BigDecimal amount
    LocalDate dueDate
    PaymentMethod paymentMethod
    ChargeStatus status = ChargeStatus.PENDING
    LocalDate paymentDate
    Date dateCreated

    static constraints = {
        amount min: 5.0
        paymentDate nullable: true
        dueDate validator: { val, obj ->
            if (!obj.id && val < LocalDate.now()) {
                return 'past'
            }
        }
    }
}