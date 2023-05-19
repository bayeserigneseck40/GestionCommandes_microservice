import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {catchError} from "rxjs/operators";
import {Observable, ObservableInput} from "rxjs";
import Client from "../model/Client";
import Commande from '../model/Commande';

@Injectable({
  providedIn: 'root'
})
export class ApiCommandeService {

  private static urlApiCommande = "http://localhost:8082/commande"
  constructor(private http: HttpClient) { }

  getAllCommande() {
    return this.http.get(`${ApiCommandeService.urlApiCommande}/all`).pipe(catchError(this.handleError))
  }

  /**
   * ajout commande
   * @param commande
   */
  public ajoutCommande(commande: Commande) {
    return this.http.post(`${ApiCommandeService.urlApiCommande}`, commande).pipe(catchError(this.handleError))
  }


  /**
   * modification commande
   * @param commande
   */
  public modifierCommande(commande: Commande) {
    return this.http.put(`${ApiCommandeService.urlApiCommande}`, commande).pipe(catchError(this.handleError))
  }

  /**
   * suppression commande
   * @param numeroCarteEtudiant
   */
  public supprimerCommande(numCommande: number) {
    return this.http.delete(`${ApiCommandeService.urlApiCommande}/${numCommande}`).pipe(catchError(this.handleError))
  }

  handleError(error: any, caught: Observable<any>) : ObservableInput<any>{
    throw new Error(error)
  }


  getByNumeroCommande(numeroCommande: number) {
    return this.http.get(`${ApiCommandeService.urlApiCommande}/${numeroCommande}`).pipe(catchError(this.handleError))
  }
}
