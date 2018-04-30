import {Injectable, OnInit} from '@angular/core';
import * as Rx from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/publish';
import {HttpClient} from '@angular/common/http';
import {Country} from '../model/Country';
import {Pass} from '../model/Pass';
import { Observable } from "rxjs/Rx"
import { Flight } from '../model/Flight';
import { Client } from '../model/Client';

@Injectable()
export class MainService{

  public countries: Country[];
  public passes:Pass[];
  public flights:Flight[];
  public clients:Client[];


  constructor(private http: HttpClient) {
  }

  

  getHotel() {  
    return this.http.get('http://localhost:8080/api/getHotel')
      .map((response: any[]) => {return response as any[]});
  }

  getFlights() {  
    return this.http.get('http://localhost:8080/api/getFlight')
      .map((data: any) => {return data});
  }

  getFlightsByEndPlace(endPlace:string) {  
    return this.http.get('http://localhost:8080/api/getFlightByCountry/'+endPlace)
      .map((data: any) => {return data});
  }

  getClients() {  
    return this.http.get('http://localhost:8080/api/getClient')
      .map((data: any) => {return data});
  }

  getHotelById(id){
    return this.http.get('http://localhost:8080/api/getHotel/'+id)
    .map((data: any) => {return data});
  }



}
