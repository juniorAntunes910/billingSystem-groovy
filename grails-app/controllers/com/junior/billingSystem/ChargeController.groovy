package com.junior.billingSystem

class ChargeController {
    static responseFormats = ['json']

    ChargeService chargeService

    def index(String status) {
        respond chargeService.list(status)
    }

    def show(Long id) {
        Charge charge = chargeService.get(id)
        if (!charge) {
            render status: 404
            return
        }
        respond charge
    }

    def save() {
        Charge charge = chargeService.create(request.JSON as Map)
        if (charge.hasErrors()) {
            respond charge.errors, status: 422
            return
        }
        respond charge, status: 201
    }
}