package com.example.servicedetailcommande.model;

import lombok.Data;

@Data
public class Commande {
	private Long id;
	private Long numClient; 
	private String prenom;
    private String nom;
    private String numero;
    private Long numCommande;
		public Commande() {
			super();
		}
		public Commande(Long id, Long numClient, String prenom, String nom, String numero, Long numCommande) {
			super();
			this.id = id;
			this.numClient = numClient;
			this.prenom = prenom;
			this.nom = nom;
			this.numero = numero;
			this.numCommande = numCommande;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Long getNumClient() {
			return numClient;
		}
		public void setNumClient(Long numClient) {
			this.numClient = numClient;
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
		public Long getNumCommande() {
			return numCommande;
		}
		public void setNumCommande(Long numCommande) {
			this.numCommande = numCommande;
		}
		
}
