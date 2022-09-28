import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'unique'
})
export class UniquePipe implements PipeTransform {

  transform(value: any, ...args: any[]): any {
    var art = value.map((ele: { empId: { value: any; }[]; }) =>{
      return ele.empId.map((y: { value: any; })=>{return y.value})
    }).reduce((acc: string | any[],ee: any,i: any)=>{
      acc.concat(ee);
      return acc;
    });
    return new Set(art);
  }

}
