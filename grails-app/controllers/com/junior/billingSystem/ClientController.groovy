package com.junior.billingSystem

class ClientController {
    static responseFormats = ['json']

    ClientService clientService

    def index() {
        respond clientService.list()
    }

    def show(Long id){
        Client client = clientService.get(id)
        if(!client){
            render status : 404
            return
        }
        respond client
    }

    def save() {
        Client client = clientService.create(request.JSON as Map)
        if (client.hasErrors()) {
            respond client.errors, status: 422
            return
        }
        respond client, status: 201
    }

}
