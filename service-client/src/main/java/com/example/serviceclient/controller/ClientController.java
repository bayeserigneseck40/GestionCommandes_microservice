package com.example.serviceclient.controller;


import com.example.serviceclient.exception.ClientInconnuExecption;
import com.example.serviceclient.exception.InvalideClientException;
import com.example.serviceclient.model.Client;
import com.example.serviceclient.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


/**
 * Rest controller permettant d'exposer le service d'inscription des clients
 */
@RestController
@RequestMapping("client")
@CrossOrigin("*")
public class ClientController {
    @Autowired
    private ClientService clientService;

    /**
     * Recuperation de la liste des clients
     * @return Liste des clients
     */
    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllEtudiant() {
        return ResponseEntity.ok(clientService.getAllClient());
    }

    /**
     * recuperation client par son ID
     * @param id
     * @return
     */
    @GetMapping("/{idClient}")
    public ResponseEntity<Optional<Client>> getClientById(
            @PathVariable("idClient") Long id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    /**
     * Ajout d'un nouveau client
     * @param client
     * @return reponse vide avec un statut 200 pour indiquer que tout s'est bien passé
     * @throws InvalideClientException
     */
    @PostMapping
    public ResponseEntity ajouterClient(
            @RequestBody  Client client) throws InvalideClientException {
        clientService.ajouterNouveauClient(client);
        return ResponseEntity.ok().build();
    }


    /**
     * modification d'un client
     * @param client
     * @return reponse vide avec un statut 200 pour indiquer que tout s'est bien passé
     * @throws ClientInconnuExecption
     */
    @PutMapping
    public ResponseEntity modifierClient(
            @RequestBody  Client client) throws ClientInconnuExecption {
        clientService.updateClient(client);
        return ResponseEntity.ok().build();
    }
    /**
     * suppression d'un client
     * @param id
     * @return reponse vide avec un statut 200 pour indiquer que tout s'est bien passé
     * @throws ClientInconnuExecption
     */
    @DeleteMapping("/{idClient}")
    public ResponseEntity supprimerClient(
            @PathVariable("idClient") Long id
    ) throws ClientInconnuExecption {
        clientService.supprimerClient(id);
        return ResponseEntity.ok().build();
    }


}
