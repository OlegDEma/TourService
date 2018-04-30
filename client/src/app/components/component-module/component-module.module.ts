import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MainService} from '../../service/MainService';

@NgModule({
  imports: [
    CommonModule
  ],
  providers:[MainService],
  declarations: []
})
export class ComponentModuleModule { }
