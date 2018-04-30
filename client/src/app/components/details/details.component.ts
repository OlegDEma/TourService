import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MainService } from '../../service/MainService';
import { Hotel } from '../../model/Hotel';
import { Flight } from '../../model/Flight';
import { Client } from '../../model/Client';
import { Pass } from '../../model/Pass';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {

  private id:string;
  public currentHotel:Hotel = new Hotel();
  public flights:Flight[];
  public newClient:Client= new Client();
  public client:Client = null;
  public changeObject:Client;
  public currentFlight:Flight = new Flight();
  public pass:Pass = new Pass();
  public showPass:boolean = false;
  public showClient:boolean = false;


  constructor(private route:ActivatedRoute,private mainService:MainService) { 
    
  }

  ngOnInit() {
    this.route.params.subscribe(
      data =>{
        this.id = data["id"];
        // console.log(data["id"]);
      }
    );

    this.mainService.getHotelById(this.id).subscribe(
      data =>{
        this.currentHotel = data;
        this.mainService.getFlightsByEndPlace(this.currentHotel.resort.country.name).subscribe(
          data =>{
            this.flights = data as Flight[];
          }
        );
      }
    );   
  }

  saveClient(){
    this.showPass = true;
    this.client = this.newClient;
    this.pass.client = this.client;
  }

  changeObj(){
    this.client.change = true;
  }

  saveChangeClient(){
    this.client.change = false;
  }

  selectFlight(flight){
    this.showClient = true;
    this.pass.flight = flight;
    this.pass.resort = this.currentHotel.resort;
    this.pass.hotel = this.currentHotel;
  }
}
