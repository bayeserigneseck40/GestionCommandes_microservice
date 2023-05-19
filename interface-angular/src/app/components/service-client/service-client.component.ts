import { Component, OnInit } from '@angular/core';
import {ApiClientService} from "../../service/api-client.service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import Client from '../../model/Client';

@Component({
  selector: 'app-service-client',
  templateUrl: './service-client.component.html',
  styleUrls: ['./service-client.component.css']
})
export class ServiceClientComponent implements OnInit {
  newClient: Client = {
    nom: '',
    prenom: '',
    id: 0,
    numero: ''

    
  };
  clientToModify: Client = {
    nom: '',
    prenom: '',
    id: 0,
    numero: ''
  };

  clients = new Array<Client>();
  constructor(private apiClientService: ApiClientService,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.getClient();

  }
  getClient(){
    this.apiClientService.getListeClient().subscribe((results) => {
      console.log(results)
      this.clients = results;
    })
  }

  open(content: any, index?: number) {
    this.modalService.open(content);
    if (index !== undefined) {
      this.clientToModify = this.clients[index]
    }
  }

  initNewClient() {
    this.newClient = {
      nom: '',
      prenom: '',
      id: 0,
      numero: ''
    };
    this.clientToModify = {
      nom: '',
      prenom: '',
      id: 0,
      numero: ''
    };
  }

  enregistrerClient() {
    try {
      this.apiClientService.ajoutClient(this.newClient).subscribe();
      const exitButton = document.getElementById("close-btn")
      if (exitButton != undefined){
        exitButton.click()
      }
      this.clients.push(this.newClient)
      this.initNewClient()
      this.getClient();
    } catch (err) {
      console.log(err)
      alert("erreur lors de l'enregistrement du client")
      this.initNewClient()
    }
  }

  modifierClient() {
    try {
      this.apiClientService.modifierClient(this.clientToModify).subscribe();
      const exitButton = document.getElementById("close-btn-modify")
      if (exitButton != undefined){
        exitButton.click()
      }
      this.initNewClient()
      this.getClient();
    } catch (err) {
      console.log(err)
      alert("erreur lors de la modification du client")
      this.initNewClient()
    }
  }

  supprimerClient(id: number) {
    try {
      let conf=confirm("Etes-vous sure de supprimer cet element?")
      if (conf){
      this.apiClientService.supprimerClient(id).subscribe()
      this.clients = this.clients.filter(etu => etu.id !== id)
      this.getClient();
      }
    } catch (err) {
      console.log(err)
      alert("erreur lors de la suppression de client")
    }
  }

}
