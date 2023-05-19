package com.example.servicedetailcommande.service;

import com.example.servicedetailcommande.model.Commande;
import com.example.servicedetailcommande.model.DetailCommandePayload;
import com.example.servicedetailcommande.model.DetailsCommande;
import com.example.servicedetailcommande.model.Produit;
import com.example.servicedetailcommande.repository.DetailsRepository;
import com.example.servicedetailcommande.repository.ProduitRepository;
import com.example.serviceproduit.exception.CommandeInconnuException;
import com.example.serviceproduit.exception.InvalideCommandeException;
import feign.Client;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class DetailsService {
    @Autowired
    private DetailsRepository detailsRepository;
   
    @Autowired
    RestServiceToGradesApi restServiceToGradesApi; 
    /**
     * Ajout details commande pour un commande existant
     * @param commande
     * @throws Exception
     */
    public void ajoutDetailCommande(DetailCommandePayload detailcommande) throws Exception {
        if (detailcommande.getIdDetail() == null) {
            throw new InvalideCommandeException("Le numero de la detail commande ne doit pas etre null");
        }
        ResponseEntity<Commande> response =  restServiceToGradesApi.getCommandeByNumCommande(detailcommande.getNumCommande());
        Commande commande = response.getBody();
        if (commande == null) {
            throw new CommandeInconnuException("commande non enregistré dans la base de données, le commande n'est pas ajouter ");
        }
        DetailsCommande detailcommandeToSave = new DetailsCommande();
        detailcommandeToSave.setNumCommande(detailcommande.getNumCommande());
        detailcommandeToSave.setPrix(detailcommande.getPrix());
        detailcommandeToSave.setQuantite(detailcommande.getQuantite());
        detailcommandeToSave.setLibelle(detailcommande.getLibelle());
        detailcommandeToSave.setMontant(detailcommande.getPrix()*detailcommande.getQuantite());
        detailsRepository.save(detailcommandeToSave);
    }

    /**
     * Mise à jour de la commande pour un client
     * @param payload
     * @throws Exception
     */
    public void updateCommande(DetailCommandePayload payload) throws Exception {

        if (payload.getIdDetail() == null) {
            throw new InvalideCommandeException("Le numero ne doit pas etre null");
        }

        if (!detailsRepository.existsById(payload.getIdDetail())) {
            throw new CommandeInconnuException("Aucune commande enregistré pour ce numero de carte ");
        }
        DetailsCommande detailcommandeToUpdate = detailsRepository.findByIdDetail(payload.getIdDetail()); 
        detailcommandeToUpdate.setNumCommande(payload.getNumCommande());
        detailsRepository.save(detailcommandeToUpdate);
    }


    /**
     * suppression d'une detail commande via l'ID du commande
     * @param idcommande
     * @throws CommandeInconnuException
     */
    public void supprimerDetailCommande(Long numcommande) throws CommandeInconnuException {
        if (!detailsRepository.existsById(numcommande)) {
            throw new CommandeInconnuException("Aucune Detail enregistré pour ce numero de commande ");
        }
        detailsRepository.deleteById(numcommande);
    }

    /**
     * Recuperation de la liste des detailscommandes
     * @return
     */
    public List<DetailsCommande> getAllDetails() {
        return detailsRepository.findAll();
    }

    /**
     * Recuperation des details d'une commande via son ID
     * @param idclient
     * @return
     */
    public DetailsCommande getDetailsCommandeById(Long numcommande) {
        return detailsRepository.findByNumCommande(numcommande);
    }




}