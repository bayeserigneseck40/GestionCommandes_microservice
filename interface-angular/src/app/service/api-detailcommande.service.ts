import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {catchError} from "rxjs/operators";
import {Observable, ObservableInput} from "rxjs";
import DetailCommande from '../model/DetailCommande';


@Injectable({
  providedIn: 'root'
})
export class ApiDetailCommandeService {
  private static urlDetailCommandeApi = "http://localhost:8083/Details"
  constructor(private http: HttpClient) { }

  /**
   * Recuperation de la liste des details commande
   * ApiDetailCommandeService
   */
  public getListeDetailCommande() {
    return this.http.get(`${ApiDetailCommandeService.urlDetailCommandeApi}/all`).pipe(catchError(this.handleError))
  }

  /**
   * ajout detailcommande
   * @param detailcommande
   */
  public ajoutDetailCommande(detailcommande: DetailCommande) {
    return this.http.post(`${ApiDetailCommandeService.urlDetailCommandeApi}`, detailcommande).pipe(catchError(this.handleError))
  }


  /**
   * modification detailcommande
   * @param detailcommande
   */
  public modifierDetailCommande(detailcommande: DetailCommande) {
    return this.http.put(`${ApiDetailCommandeService.urlDetailCommandeApi}`, detailcommande).pipe(catchError(this.handleError))
  }

  /**
   * suppression detail commande
   * @param detail commande
   */
  public supprimerDetailCommande(idDetail: number) {
    return this.http.delete(`${ApiDetailCommandeService.urlDetailCommandeApi}/${idDetail}`).pipe(catchError(this.handleError))
  }

  handleError(error: any, caught: Observable<any>) : ObservableInput<any>{
    throw new Error(error)
  }


}
