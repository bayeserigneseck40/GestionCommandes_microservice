package com.example.servicecommande.service;

import com.example.servicecommande.exception.ClientInconnuException;

import com.example.servicecommande.exception.CommandeInconnuException;
import com.example.servicecommande.exception.InvalideCommandeException;
import com.example.servicecommande.model.Client;
import com.example.servicecommande.model.Commande;
import com.example.servicecommande.model.CommandePayload;
import com.example.servicecommande.repository.CommandeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeService {
    @Autowired
    CommandeRepository commandeRepository;

    @Autowired
    RestServiceToRegisterApi restServiceToRegisterApi;

    /**
     * Ajout d'une commande pour un client existant
     * @param commande
     * @throws Exception
     */
    public void ajoutCommande(CommandePayload commande) throws Exception {
        if (commande.getNumClient() == null  ) {
            throw new InvalideCommandeException("Le numero de client ne doit pas etre null");
        }
        //ResponseEntity<Produit> responseproduit = restServiceToRgistApi.getProduitById(commande.getIdproduit());
        ResponseEntity<Client> response = restServiceToRegisterApi.getClientById(commande.getNumClient());
        
        Client client = response.getBody();
        //Produit produit = responseproduit.getBody();
        if (client == null) {
            throw new ClientInconnuException("client  non enregistré dans la base de données, le client n'est pas inscrit ");
        }
        Commande commandeToSave = new Commande();
        commandeToSave.setNumCommande(commande.getNumCommande());
        commandeToSave.setDateCommande(commande.getDateCommande());
        commandeToSave.setNumClient(client.getId());
        commandeToSave.setNom(client.getNom());
        commandeToSave.setPrenom(client.getPrenom());
        commandeToSave.setNumero(client.getNumero());
        commandeRepository.save(commandeToSave);
    }

    /**
     * Mise à jour de la commande pour un client
     * @param payload
     * @throws Exception
     */
    public void updateCommande(CommandePayload payload) throws Exception {

        if (payload.getNumClient() == null) {
            throw new InvalideCommandeException("Le numero  ne doit pas etre null");
        }

        if (!commandeRepository.existsById(payload.getNumClient())) {
            throw new CommandeInconnuException("Aucune commande enregistré pour ce numero de carte ");
        }
        Commande commandeToUpdate = commandeRepository.findByNumClient(payload.getNumClient());
        commandeToUpdate.setNumCommande(payload.getNumCommande());
        commandeRepository.save(commandeToUpdate);
    }


    /**
     * suppression d'une commande via l'ID du client
     * @param idclient
     * @throws CommandeInconnuException
     */
    public void supprimerCommande(Long idclient) throws CommandeInconnuException {
        if (!commandeRepository.existsById(idclient)) {
            throw new CommandeInconnuException("Aucune commande enregistré pour ce numero de client ");
        }
        commandeRepository.deleteById(idclient);
    }
    /**
     * Recuperation de la liste des commandes
     * @return
     */
    public List<Commande> getAll() {
        return commandeRepository.findAll();
    }
    /**
     * Recuperation de la commande d'un client via son ID
     * @param idclient
     * @return
     */
    public Commande getCommandeById(Long idclient) {
        return commandeRepository.findByNumClient(idclient);
    }
    /**
     * Recuperation de la commande d'un client via son ID
     * @param idclient
     * @return
     */
    
    public Commande getCommandeByNumCommande(Long numcommande) {
        return commandeRepository.findByNumCommande(numcommande);
    }
    
    /**
     * Recuperation de la commande d'un client via son Nom
     * @param Nomclient
     * @return
     */
    public Commande getCommandeByNomClient(String nom) {
        return commandeRepository.findCommandeByNom(nom);
    }
    
   
    
 



}
