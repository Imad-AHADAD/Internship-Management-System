import {
  ActivatedRouteSnapshot,
  CanActivate,
  CanActivateFn,
  Router,
  RouterStateSnapshot,
  UrlTree
} from '@angular/router';
import {ServiceloginService} from "../servicelogin.service";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
@Injectable({
  providedIn: 'root'
})
/*export const authentificationGuard: CanActivateFn = (route:ActivatedRouteSnapshot, state:RouterStateSnapshot,auservice:ServiceloginService) => {
  return auservice.isauthentificate();
};*/
export class authentificationGuard implements CanActivate{
  constructor(private auservice:ServiceloginService,private router:Router) {
  }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
     let a = this.auservice.isauthentificate();
     if(a==false){
       this.router.navigateByUrl("/login");
       return false;
     }
     else {
       return true;
     }
  }

}
