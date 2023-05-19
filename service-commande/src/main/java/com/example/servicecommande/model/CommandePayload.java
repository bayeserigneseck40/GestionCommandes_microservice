package com.example.servicecommande.model;

import java.util.Date;

import lombok.Data;

@Data
public class CommandePayload {
	 private Long numCommande;
    private Long numClient;
    private Date dateCommande;
    
	public CommandePayload() {
		super();
	}


	public CommandePayload(Long numCommande, Long numClient, Date dateCommande) {
		super();
		this.numCommande = numCommande;
		this.numClient = numClient;
		this.dateCommande = dateCommande;
	}


	public Long getNumCommande() {
		return numCommande;
	}

	public void setNumCommande(Long numCommande) {
		this.numCommande = numCommande;
	}

	public Long getNumClient() {
		return numClient;
	}

	public void setNumClient(Long numClient) {
		this.numClient = numClient;
	}


	public Date getDateCommande() {
		return dateCommande;
	}


	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

    
}
