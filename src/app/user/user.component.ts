import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { FetchDataService } from '../Services/fetch-data.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  data: any;
  first: any;
  last: any;
  id: any;
  edit: any;
  addNew = false;
  empId: any;

  constructor(public service: FetchDataService) {
  }

  updateLeave = new FormGroup({
    startDate: new FormControl(),
    endDate: new FormControl(),
    reason: new FormControl()
  });

  ngOnInit(): void {
    this.getUserData();
  }

  x = localStorage.getItem('EmpId');

  public getUserData() {
    return this.service.getUserLeaves(this.x).subscribe(resp => {
      this.data = resp;
      this.first = this.data[0].firstName;
      this.last = this.data[0].lastName;
      this.id = this.data[0].empId;
      this.data.forEach((element: any) => {
        element['isEdit'] = false;
      });
      console.log(this.data);
      return this.data;
    }
    )
  }

  public addNewLeave() {
    this.addNew = !this.addNew
  }

  today = new Date();

  public isEditable(user: any) {
    let str = user.startDate;
    let backendDate = str.slice(-2);
    let backendMonth = str.slice(5, 7);
    let backendYear = str.slice(0, 4);
    let todayDate = this.today.getDate() + 7;
    let todayMonth = this.today.getMonth() + 1;
    let todayYear = this.today.getFullYear();
    let datesub = backendDate - todayDate;
    let monthsub = backendMonth - todayMonth;
    let yearsub = backendYear - todayYear;
    console.log(yearsub);


    if (datesub >= 0) {
      user.isEdit = true;
    } else if (monthsub >= 1) {
      user.isEdit = true;
    } else if (yearsub >= 1) {
      user.isEdit = true;
    } else {
      user.isEdit = false;
      alert("Cannot Edit");
    }
    // console.log(this.data.isEdit)
  }

  StartDate: any;
  EndDate: any;
  ReasonOfLeave: any;

  public onSubmit() {
    const obj = {
      "empId": localStorage.getItem('EmpId'),
      "firstName" : this.first,
      "lastName" : this.last,
      "startDate": this.StartDate,
      "endDate": this.EndDate,
      "reason": this.ReasonOfLeave
    }
    this.service.AddUserLeaves(obj).subscribe(resp => {
      console.log(resp);
      this.getUserData();
      this.addNew = false;
    }
    );
  }

  public isnotEditable(user: any) {
    user.isEdit = false;
  }

}
