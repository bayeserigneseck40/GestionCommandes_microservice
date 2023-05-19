import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ServiceClientComponent} from "./components/service-client/service-client.component";
import {ServiceCommandeComponent} from "./components/service-commande/service-commande.component";
import {ServiceProduitComponent} from "./components/service-produit/service-produit.component";
import {ServiceDetailCommandeComponent} from "./components/service-detailcommande/service-detailcommande.component";

const routes: Routes = [
  {
    component: ServiceClientComponent,
    path: 'service-client'
  },
  {
    component: ServiceCommandeComponent,
    path: 'service-commande'
  },
  {
    component: ServiceDetailCommandeComponent,
    path: 'service-detailcommande'
  },
  {
    component: ServiceProduitComponent,
    path: 'service-produit'
  },
  {
    path: '',
    component: ServiceClientComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
