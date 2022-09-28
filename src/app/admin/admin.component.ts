import { NgStyle } from '@angular/common';
import { identifierName } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { FetchDataService } from '../Services/fetch-data.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  data : any;
  empdata : any;
  datailTable : any;
  result : any;
  unique : any;
  arr : any;
  constructor(public service : FetchDataService) { }

  ngOnInit(): void {
    this.getAll();
    this.datailTable = false;
  }

  public getAll(){
    return this.service.getAllLeaves().subscribe(
      resp => {this.data = resp;
        this.data.forEach((element: any) => {
          element['isLogedIn'] = true;
        });

        this.unique = new Set();
        this.arr = []
        for(const ele of this.data){
          if(!this.unique.has(ele.empId)){
            this.arr.push(ele);
            this.unique.add(ele.empId);
          }
        } 
      });
  }

  public getEmployeeLeave(val :any){
    return this.service.getUserLeaves(val).subscribe(
      resp=>{this.empdata = resp;
        this.datailTable = true;
      console.log(this.empdata);
      }
    )
  }

}
