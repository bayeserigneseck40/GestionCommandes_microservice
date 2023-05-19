package com.example.servicecommande.model;

import lombok.Data;

@Data
public class Client {
	
    private Long id;
    private String prenom;
    private String nom;
    private String numero;
  
	public Client() {
		super();
	}
	public Client(Long id, String prenom, String nom, String numero) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.numero = numero;
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
    
    
}
