import { Injectable } from '@angular/core';
import {Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { AuthenticationService } from '../../../service/authentication.service';

@Injectable()
export class AdminGuard implements CanActivate {

  constructor(private authenticationService:AuthenticationService,private router: Router){

  }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
      if(this.authenticationService.isAdmin()){
      return true;
  }else{
    this.router.navigate(['/']);
    return false;
  }
  }
}
