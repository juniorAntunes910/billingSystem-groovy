package com.junior.billingSystem

import grails.gorm.transactions.Transactional

import java.time.LocalDate

@Transactional
class ChargeService {

    Charge create(Map data){
        Charge charge = new Charge(
                client: Client.get(data.clientId as Long),
                amount: data.amount as BigDecimal,
                dueDate: data.dueDate ? LocalDate.parse(data.dueDate as String ) : null,
                paymentMethod: data.paymentMethod as PaymentMethod
        )
        charge.save()
        return charge
    }

    List<Charge> list(String status) {
        status ? Charge.findAllByStatus(status as ChargeStatus) : Charge.list()
    }

    Charge get(Long id) {
        Charge.get(id)
    }

}
