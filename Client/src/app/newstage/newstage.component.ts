import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-newstage',
  templateUrl: './newstage.component.html',
  styleUrl: './newstage.component.css'
})
export class NewstageComponent implements  OnInit{

  newstageformgroup! : FormGroup;
  private stage: any[] = [];
  private errormessage: any;

  constructor(private fb: FormBuilder,private http : HttpClient,private router:Router) {
  }

  ngOnInit(): void {
    this.newstageformgroup = this.fb.group({
      typeStage: this.fb.control(null),
      dureeSemaines: this.fb.control(null),
      competences: this.fb.control(null),
      compteRendu: this.fb.control(null),
      /*tuteur: this.fb.control({ id: "nn" }), // Remp
      entreprise: this.fb.control({ id: 1}), // Remplacez par la valeur initiale souhaitée
      etudiante: this.fb.control({ id: 1}), // Remplacez par la valeur initiale souhaitée
      typestage: this.fb.control({code_type: 1})// Remplacez par la valeur initiale souhaitée*/
      tuteur: this.fb.group({
        id: [null, Validators.required]
      }),
      entreprise: this.fb.group({
        id: [null, Validators.required]
      }),
      etudiante: this.fb.group({
        id: [null, Validators.required]
      }),



    });




  }
  ajouterstage(data : any) {
    //let custumer = this.newetudiantformgroup.value;
    console.log('Données à envoyer :', data);
    this.http.post("http://localhost:8089/stages", data).subscribe({
      next: () => {
        alert("Bonne création");
      },
      error: (err) => {
        this.errormessage = err.error.message; // Accessing the error message correctly
      }
    });
  }

  naviguervers() {
    this.router.navigate(["/stage"]);
  }
}


