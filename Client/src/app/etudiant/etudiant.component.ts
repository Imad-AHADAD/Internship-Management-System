import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FormBuilder, FormGroup} from "@angular/forms";
import {Router} from '@angular/router';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-etudiant',
  templateUrl: './etudiant.component.html',
  styleUrl: './etudiant.component.css'
})
export class EtudiantComponent implements  OnInit{
  etudiants : any[] = [];
  errormessage! : String ;
  formgroup! : FormGroup;
  etudiant : any;
  constructor(private http:HttpClient,private fb : FormBuilder,public router: Router,private routr: ActivatedRoute) {
  }
  ngOnInit(): void {
    this.formgroup=this.fb.group({
      keyword: this.fb.control("")
    })
    this.http.get("http://localhost:8089/etudiants").subscribe({
      next : (data)=>{
        if (Array.isArray(data)){
          this.etudiants=data;
        }
      },
      error : (err)=>{
        this.errormessage=err.message;
      }
    });
  }
  handleSearchEtudiant() {
    let kw=this.formgroup.value.keyword;
    let id= +kw;
    this.http.get("http://localhost:8089/etudiants/"+id).subscribe({
      next : (data)=>{
        this.etudiants=[data];
      },
      error : (err)=>{
        this.errormessage=err.message;
      }
    });
  }

  Deleteetudiant(c: any) {
    let conf = confirm("Are you sure");
    if(!conf) return;
    this.http.delete("http://localhost:8089/etudiants/" + c.id).subscribe({
      next:() => {
        // Succès de la suppression, recharger la page
        location.reload();
      },
      error: (err) => {
        this.errormessage = err.message;
      }
    });

  }

  navigatetonewroute() {
    this.router.navigate(['/newetudiant']);
  }
}
