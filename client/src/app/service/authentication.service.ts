import { Injectable, EventEmitter } from '@angular/core';
import { Http, RequestOptions,Response,Headers } from '@angular/http';
import {User} from '../model/User';


@Injectable()
export class AuthenticationService {
  private authUrl = '/api/auth';
    static API_URL="http://localhost:8080";
    onLogIn = new EventEmitter<boolean>();
    currentUser = new EventEmitter<User>();

    constructor(private http: Http) { }

    public logIn(user: User){

        let headers = new Headers();
        headers.append('Accept', 'application/json')
        var base64Credential: string = btoa( user.username+ ':' + user.password);
        headers.append("Authorization", "Basic " + base64Credential);

        let options = new RequestOptions();
        options.headers=headers;

        return this.http.get(AuthenticationService.API_URL+"/account/login" ,   options)
            .map((response: Response) => {            
              console.log(response.json());
                let user:User = response.json();                
                if (user) {
                    localStorage.setItem('currentUser', JSON.stringify(user));
                    this.onLogIn.emit(true);
                    this.currentUser.emit(user);
                }
            });
    }

    public register(user:User){
      return  this.http.post(AuthenticationService.API_URL+'/account/sign-up',user).map(
          (response:Response)=>{
              console.log(response);
          }
      );    
    }

    logout() {
        console.log("EZ");
        // remove user from local storage to log user out
        // return this.http.post(AuthenticationService.API_URL+"/account/logout",{})
            // .map((response: Response) => {
                localStorage.removeItem('currentUser');
                this.currentUser.emit(new User);
                this.onLogIn.emit(false);
            // });
    
    
    
    }


    // logout() {
    //     // remove user from local storage to log user out
    //     return this.http.get("/account/out").map(
    //         data =>{
    //             console.log(data);
    //             localStorage.removeItem('currentUser');
                // this.currentUser.emit(new User);
                // this.onLogIn.emit(false);
    //         }
    //     );
    //     // localStorage.removeItem('currentUser');
    //     // this.currentUser.emit(new User);
    //     // this.onLogIn.emit(false);
    // }

    gerCurrentUser(){
        let user:User = JSON.parse(localStorage.getItem("currentUser"));
        return user
    }

    isAdmin(){
        let user:User = JSON.parse(localStorage.getItem("currentUser"));
        if(user.role == 'ADMIN'){
            return true;
        }else{
            return false;
        }
    }
}
