package com.junior.billingSystem

import grails.gorm.transactions.Transactional


@Transactional
class ClientService {

    Client create(Map data){
        Client client = new Client(data)
        client.save()
        return client
    }

    List<Client> list(){
        Client.list()
    }

    Client get(Long id){
        Client.get(id)
    }
}