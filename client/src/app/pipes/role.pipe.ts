import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'role'
})
export class RolePipe implements PipeTransform {

  transform(value: any, args?: any): any {
    if(value == 'ADMIN'){
      return true
    }else if(value == 'USER' || undefined){
      return false;
    }
  }

}
