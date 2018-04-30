import {Client} from './Client';
import {Flight} from './Flight';
import {Country} from './Country';
import {Resort} from './Resort';
import {Hotel} from './Hotel';

export class Pass{
  public id:number;
  public transport: string;
  public change:boolean = false;
  public client:Client;
  public flight:Flight;
  public country:Country;
  public resort:Resort;
  public hotel:Hotel;


}
