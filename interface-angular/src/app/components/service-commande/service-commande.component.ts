import { Component, OnInit } from '@angular/core';
import {ApiCommandeService} from "../../service/api-commande.service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {Router} from "@angular/router";
import Commande from '../../model/Commande';

@Component({
  selector: 'app-service-commande',
  templateUrl: './service-commande.component.html',
  styleUrls: ['./service-commande.component.css']
})
export class ServiceCommandeComponent implements OnInit {
  newCommande: Commande = {
    numCommande: 0,
    numClient: 0,
    id: 0,
    prenom: '',
    nom:'',
    numero:'',
    dateCommande:new Date()
  };
  commandeToModify: Commande = {
    numCommande: 0,
    numClient: 0,
    id: 0,
    prenom: '',
    nom:'',
    numero:'',
    dateCommande:new Date()
  };
  commandes = new Array<Commande>()
  constructor(private apiCommande: ApiCommandeService,
              private modalService: NgbModal,
              private router: Router) { }

  ngOnInit(): void {
   this.getCommande();
  }
  getCommande(){
    this.apiCommande.getAllCommande().subscribe((results) => {
      console.log(this.commandes);
      this.commandes = results;
    })
  }



  
  open(content: any, index?: number) {
    this.modalService.open(content);
    if (index !== undefined) {
      this.commandeToModify = this.commandes[index]
    }
  }

  initNewCommande() {
    this.newCommande = {
      numCommande: 0,
    numClient: 0,
    id: 0,
    prenom: '',
    nom:'',
    numero:'',
    dateCommande:new Date()
    };
    this.commandeToModify = {
      numCommande: 0,
      numClient: 0,
      id: 0,
      prenom: '',
      nom:'',
      numero:'',
      dateCommande:new Date()
    };
  }

  enregistrerCommande() {
    try {
      this.apiCommande.ajoutCommande(this.newCommande).subscribe();
      const exitButton = document.getElementById("close-btn")
      if (exitButton != undefined){
        exitButton.click()
      }
      this.initNewCommande()
      this.getCommande();
      this.router.navigateByUrl('/service-commande') // rechargement rapide de la page pour recuperer les valeurs
    } catch (err) {
      console.log(err)
      alert("erreur lors de l'enregistrement de la commande")
      this.initNewCommande()
    }
  }

  modifierCommande() {
    try {
      this.apiCommande.modifierCommande(this.commandeToModify).subscribe();
      const exitButton = document.getElementById("close-btn-modify")
      if (exitButton != undefined){
        exitButton.click()
      }
      this.initNewCommande()
      this.getCommande();
    } catch (err) {
      console.log(err)
      alert("erreur lors de la modification de la commande")
      this.initNewCommande()
    }
  }

  supprimerCommande(numCommande: number) {
    try {
      let conf=confirm("Etes-vous sure de supprimer cet element?")
      if (conf){
      this.apiCommande.supprimerCommande(numCommande).subscribe()
      this.commandes = this.commandes.filter(com => com.numCommande !== numCommande)
      this.getCommande();
      }
    } catch (err) {
      console.log(err)
      alert("erreur lors de la suppression de la commande")
    }
  }


  
  RechercherCommande(value: { keyword: number; }) {
    try {
      this.apiCommande.getByNumeroCommande(value.keyword).subscribe((results) => {
        console.log(this.commandes);
        this.commandes = results;
    })
   } catch (err) {
      console.log(err)
      alert("erreur lors de la recherche de la commande")
      this.initNewCommande()
    }

    
  }


}
