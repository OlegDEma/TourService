import { Component, OnInit } from '@angular/core';
import { User } from '../../model/User';
import { AuthenticationService } from '../../service/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  user:User = new User();
  constructor(private router: Router,private authenticationService:AuthenticationService) { }

  ngOnInit() {
  }

  register(){
    // console.log(this.user);
    this.authenticationService.register(this.user).subscribe(
      (data)=>{
        this.router.navigate(['login']);
      }
    );
  }

}
