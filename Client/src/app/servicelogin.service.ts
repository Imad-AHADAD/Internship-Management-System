import { Injectable } from '@angular/core';
import {AppUser} from "./models/Authentification";
import {Observable, observable, of, throwError} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ServiceloginService {
  users: AppUser[]=[];
  authenuser!: AppUser;
  private errormessage!: String;
  constructor(public  http : HttpClient) {
    this.users.push({
      username:"husafcb001@gmail.com",
      password:"hamza11233"
      //roles:["USER"]
    });
    this.users.push({
        username:"mehdi",
        password:"kacm"
        //roles:["USER"]
      });
    this.users.push({
        username:"imad",
        password:"far"
        //roles:["USER"]
      });

    }
  public login(username: String,password:String):Observable<AppUser>{
     let AppUser = this.users.find(u=> u.username==username);
     if(!AppUser) return throwError(()=>new Error("User not found"))
     if(AppUser.password!=password) return throwError(()=>new Error("password incorrect"));
     return of(AppUser);
  }
  public autentifieruser(appuser: AppUser):Observable<Boolean>{
    this.authenuser=appuser;
    localStorage.setItem("autuser",JSON.stringify({username:appuser.username}))
    return of(true);


  }
  public isauthentificate():Boolean{
    return this.authenuser!=undefined;
  }
}
