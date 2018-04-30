import { Component, OnInit } from '@angular/core';
import { User } from '../../model/User';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../service/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loading = false;
    error = '';
    model: User=new User();

    constructor(
        private router: Router,
        private authenticationService: AuthenticationService) { }

    ngOnInit() {
        
    }

    login(){
        this.authenticationService.logIn(this.model)
            .subscribe(data=>{
                    console.log(data);
                    this.authenticationService.onLogIn.emit(true);
                    this.router.navigate(['header']);
                    this.router.navigate(['/']);
                },err=>{
                    this.error="error :  Username or password is incorrect";
                }
            )
    }
}
