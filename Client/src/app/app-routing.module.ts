import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {EtudiantComponent} from "./etudiant/etudiant.component";
import {EntrepriseComponent} from "./entreprise/entreprise.component";
import {StageComponent} from "./stage/stage.component";
import {NewetudiantComponent} from "./newetudiant/newetudiant.component";
import {NewstageComponent} from "./newstage/newstage.component";
import {LoginComponent} from "./login/login.component";
import {authentificationGuard} from "./guards/authentification.guard";
import {AdminComponent} from "./admin/admin.component";

const routes: Routes = [
  { path : "admin", component : AdminComponent,canActivate : [authentificationGuard],children : [
      { path : "etudiant", component : EtudiantComponent,/**/},
      { path : "entreprise", component : EntrepriseComponent,/*canActivate : [authentificationGuard]*/},
      {path : "stage", component : StageComponent,/*canActivate : [authentificationGuard]*/},
      {path : "newetudiant", component : NewetudiantComponent,/*canActivate : [authentificationGuard]*/},
      {path : "newstage", component : NewstageComponent,/*canActivate : [authentificationGuard]*/}
    ]},

  {path : "login", component : LoginComponent},
  {path : "", component : LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
