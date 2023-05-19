package com.example.servicecommande.model;

import lombok.Data;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Commande {
    private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long numClient; 
	private String prenom;
    private String nom;
    private String numero;
    private Long numCommande;
    private Date dateCommande;

	public Commande() {
		super();
	}
	

	public Commande(Long id, Long numClient, String prenom, String nom, String numero, Long numCommande,
			Date dateCommande) {
		super();
		this.id = id;
		this.numClient = numClient;
		this.prenom = prenom;
		this.nom = nom;
		this.numero = numero;
		this.numCommande = numCommande;
		this.dateCommande = dateCommande;
	}


	public Long getNumClient() {
		return numClient;
	}

	public void setNumClient(Long numClient) {
		this.numClient = numClient;
	}

	public Long getNumCommande() {
		return numCommande;
	}
	
	public void setNumCommande(Long numCommande) {
		this.numCommande = numCommande;
	}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}


	public Date getDateCommande() {
		return dateCommande;
	}


	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	
	

}
