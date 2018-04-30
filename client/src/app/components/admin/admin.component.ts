import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Country} from '../../model/Country';
import {MainService} from '../../service/MainService';
import {Response} from '@angular/http';
import {Flight} from '../../model/Flight';
import {Client} from '../../model/Client';
import {Resort} from '../../model/Resort';
import {Hotel} from '../../model/Hotel';
import {Pass} from '../../model/Pass';
import { AuthenticationService } from '../../service/authentication.service';
import { User } from '../../model/User';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {


  private newFlight: Flight;
  private newCountry: Country;
  private newClient: Client;
  private newResort: Resort;
  private newHotel: Hotel;
  private newPass: Pass;
  private change: any;
  private countries: Country[];
  private flights: Flight[];
  private clients: Client[];
  private resorts: Resort[];
  private hotels: Hotel[];
  private passes: Pass[];
  private newFile: File;


  constructor(private router: Router,private http: HttpClient, private mainService: MainService,private authenticationService:AuthenticationService) {
  }

  ngOnInit() {

    console.log(this.authenticationService.gerCurrentUser())

   if(this.authenticationService.gerCurrentUser().role == 'ADMIN'){
    
   }else{
    this.router.navigate(['/']);
   }

    this.newCountry = new Country();
    this.newFlight = new Flight();
    this.newClient = new Client();
    this.newResort = new Resort();
    this.newPass = new Pass();
    this.newHotel = new Hotel();
    this.getCountry();
    this.getFlight();
    this.getClient();
    this.getResort();
    this.getPass();
    this.getHotel();
  }

  getCountry() {
    return this.http.get('http://localhost:8080/api/getCountry').subscribe(
      (response) => {
        this.countries = response as Country[];
        // console.log(response);
      }
    );
  }

  getFlight() {
    return this.http.get('http://localhost:8080/api/getFlight').subscribe(
      (response) => {
        this.flights = response as Flight[];
        // console.log(response);
      }
    );
  }


  deleteCountry(country) {
    let index = this.countries.indexOf(country);
    return this.http.get('http://localhost:8080/api/deleteCountry/' + country.id).subscribe(
      (response: Response) => {
        // console.log(response);
        this.countries.splice(index, 1);
      }
    );

  }

  deleteFlight(flight) {
    let index = this.flights.indexOf(flight);
    return this.http.get('http://localhost:8080/api/deleteFlight/' + flight.id).subscribe(
      (response: Response) => {
        // console.log(response);
        this.flights.splice(index, 1);
      }
    );
  }

  saveCountry() {
    // console.log(this.newCountry);
    return this.http.post('/api/save', this.newCountry).subscribe(
      (response) => {
        // console.log(response);
        this.countries.push(response as Country);
        this.newCountry = new Country();
      }
    );
  }

  saveFlight() {
    return this.http.post('/api/saveFlight', this.newFlight).subscribe(
      (response) => {
        // console.log(response);
        this.flights.push(response as Flight);
        this.newFlight = new Flight();
      }
    );
  }

  changeObj(object) {
    object.change = true;
    this.change = object;

  }

  saveChangeCountry() {
    return this.http.post('/api/save', this.change).subscribe(
      (response: Response) => {
        // console.log(response);
        // this.countries.push(response);
        this.change.change = false;
        this.change = null;
      }
    );
  }

  saveChangeFlight() {
    return this.http.post('/api/saveFlight', this.change).subscribe(
      (response: Response) => {
        this.change.change = false;
        this.change = null;
      }
    );
  }


  saveClient() {
    return this.http.post('/api/saveClient', this.newClient).subscribe(
      (response) => {
        this.clients.push(response as Client);
        this.newClient = new Client();
      }
    );
  }

  saveChangeClient() {
    return this.http.post('/api/saveClient', this.change).subscribe(
      (response: Response) => {
        this.change.change = false;
        this.change = null;
      }
    );
  }


  getClient() {
    return this.http.get('/api/getClient').subscribe(
      (response) => {
        this.clients = response as Client[];
      }
    );
  }


  deleteClient(client) {
    let index = this.clients.indexOf(client);
    return this.http.get('/api/deleteClient/' + client.id).subscribe(
      (response: Response) => {
        // console.log(response);
        this.clients.splice(index, 1);
      }
    );

  }

  ////////////RESORT
  ez() {
    alert('EZ');
  }

  saveResort() {
    const formData = new FormData();
    formData.append('file', this.newFile);
    this.newResort.photo = '../../../assets/img/' + this.newFile.name;

    // return this.http.post('/api/saveImageForProduct', formData)
    //   .subscribe(
    //     () => {
    //     }
    //   );

    this.http.post('/api/saveImageForProduct', formData);

    return this.http.post('/api/saveResort', this.newResort).subscribe(
      (response) => {
        this.resorts.push(response as Resort);
        this.newResort = new Resort();
      }
    );
  }

  saveChangeResort() {


    return this.http.post('/api/saveResort', this.change).subscribe(
      (response: Response) => {
        this.change.change = false;
        this.change = null;
      }
    );
  }


  getResort() {
    return this.http.get('/api/getResort').subscribe(
      (response) => {
        this.resorts = response as Resort[];
      }
    );
  }


  deleteResort(resort) {
    let index = this.resorts.indexOf(resort);
    return this.http.get('/api/deleteResort/' + resort.id).subscribe(
      (response: Response) => {
        // console.log(response);
        this.resorts.splice(index, 1);
      }
    );

  }

  savePhoto($event) {
    const files = $event.target.files || $event.srcElement.files;
    const file = files[0];
    this.newFile = file;
  }

  saveHotel() {
    // const formData = new FormData();
    // formData.append('file', this.newFile);
    // this.newResort.photo = '../../../assets/img/'+ this.newFile.name;

    // return this.http.post('/api/saveImageForProduct', formData)
    //   .subscribe(
    //     () => {
    //     }
      // );

    // this.http.post('/api/saveImageForProduct', formData);

    return this.http.post('/api/saveHotel', this.newHotel).subscribe(
      (response) => {
        this.hotels.push(response as Hotel);
        this.newHotel = new Hotel();
      }
    );
  }

  saveChangeHotel() {


    return this.http.post('/api/saveHotel', this.change).subscribe(
      (response: Response) => {
        this.change.change = false;
        this.change = null;
      }
    );
  }


  getHotel() {
    return this.http.get('/api/getHotel').subscribe(
      (response) => {
        this.hotels = response as Hotel[];
      }
    );
  }


  deleteHotel(hotel) {
    let index = this.hotels.indexOf(hotel);
    return this.http.get('/api/deleteHotel/' + hotel.id).subscribe(
      (response: Response) => {
        // console.log(response);
        this.hotels.splice(index, 1);
      }
    );

  }


  savePass() {
    // const formData = new FormData();
    // formData.append('file', this.newFile);
    // this.newResort.photo = '../../../assets/img/'+ this.newFile.name;

    // return this.http.post('/api/saveImageForProduct', formData)
    //   .subscribe(
    //     () => {
    //     }
    //   );

    // this.http.post('/api/saveImageForProduct', formData);

    return this.http.post('/api/savePass', this.newPass).subscribe(
      (response) => {
        this.passes.push(response as Pass);
        this.newPass = new Pass();
      }
    );
  }

  saveChangePass() {


    return this.http.post('/api/savePass', this.change).subscribe(
      (response: Response) => {
        this.change.change = false;
        this.change = null;
      }
    );
  }


  getPass() {
    return this.http.get('/api/getPass').subscribe(
      (response) => {
        this.passes = response as Pass[];
      }
    );
  }


  deletePass(pass) {
    let index = this.passes.indexOf(pass);
    return this.http.get('/api/deletePass/' + pass.id).subscribe(
      (response: Response) => {
        // console.log(response);
        this.passes.splice(index, 1);
      }
    );

  }


}
