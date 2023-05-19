package com.example.servicecommande.service;



import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.servicecommande.model.Client;

@FeignClient(url = "http://localhost:8081/client", name = "client-service-api")
public interface RestServiceToRegisterApi {

    @RequestMapping(method = RequestMethod.GET, value = "/{idClient}")
    ResponseEntity<Client> getClientById( @PathVariable("idClient") Long id);

}
