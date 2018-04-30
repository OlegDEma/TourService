import { Component, OnInit, EventEmitter } from '@angular/core';
import { AuthenticationService } from '../../service/authentication.service';
import { User } from '../../model/User';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  login:boolean = false;

  user:any;

  hasRole:string = 'USER';

  

  constructor(private router: Router,private authenticationService:AuthenticationService) { }

  ngOnInit() {
    if(this.authenticationService.gerCurrentUser() != null){
      this.login = true;
    }

    this.authenticationService.onLogIn.subscribe(
      (login:boolean)=>{
        
        this.login = login;
      }
    );

    this.authenticationService.currentUser.subscribe(
      (user:User)=>{
        this.hasRole = user.role;
      }
    );
    
  }

  logOut(){
    this.authenticationService.logout();  
    this.router.navigate(['header']);
    this.router.navigate(['/']);  
  }

}
