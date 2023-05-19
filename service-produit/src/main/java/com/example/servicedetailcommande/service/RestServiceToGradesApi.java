package com.example.servicedetailcommande.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.servicedetailcommande.model.Commande;

import java.util.List;

@FeignClient(name = "examen-api", url = "http://localhost:8082/commande")
public interface RestServiceToGradesApi {

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    ResponseEntity<List<Commande>> getAllCommande();

    @RequestMapping(method = RequestMethod.GET, value = "/{numCommande}")
    ResponseEntity<Commande> getCommandeByNumCommande(@PathVariable("numCommande") long numCommande);

}
