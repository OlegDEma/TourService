import {Component, OnInit} from '@angular/core';
import {MainService} from '../../service/MainService';
import {Pass} from '../../model/Pass';
import {Hotel} from '../../model/Hotel';
import { Observable } from "rxjs/Rx"
import * as Rx from 'rxjs/Rx';
import {Router, NavigationExtras} from "@angular/router";
import { PagerService } from '../../service/pager.service';

@Component({
  selector: 'app-tours',
  templateUrl: './tours.component.html',
  styleUrls: ['./tours.component.css']
})
export class ToursComponent implements OnInit {

  passes:Pass[] = [];
  hotels:Hotel[] = [];

  private allItems: any[];

    pager: any = {};
    pagedItems: any[];
    
  constructor(private mainService: MainService,private router: Router,private pagerService:PagerService) {
  }

  ngOnInit() {
   this.mainService.getHotel().
     subscribe(
     (data:any[]) =>{
       this.allItems = data;
       this.setPage(1); 
     }
   ); 
    
  }

  setPage(page: number) {
    if (page < 1 || page > this.pager.totalPages) {
        return;
    }
    this.pager = this.pagerService.getPager(this.allItems.length, page);
    this.pagedItems = this.allItems.slice(this.pager.startIndex, this.pager.endIndex + 1);
}


  show(hotel:Hotel){
    console.log(hotel);
    let navigationExtras: NavigationExtras = {
      queryParams: {
          "id": hotel.id.toString()
      }
    }
    this.router.navigate(["details",{id:hotel.id}]);
  }

  load(){
    this.passes = this.mainService.passes;
  }

}
