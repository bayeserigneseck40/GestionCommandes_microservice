package com.example.servicecommande.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.servicecommande.model.Commande;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
	  Commande findByNumClient(Long id);
	  Commande findByNumCommande(Long numCommande);
	  Commande findCommandeByNom(String nom);
}
