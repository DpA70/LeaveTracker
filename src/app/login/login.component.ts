import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { FetchDataService } from '../Services/fetch-data.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  data : any;

  constructor(private router : Router, private service : FetchDataService) { }

  ngOnInit(): void {

  }

  profileForm = new FormGroup({
    id: new FormControl(),
    userName: new FormControl(),
    password: new FormControl()
  });

  ret : any;
  public onSubmit(obj : any){
    console.log(obj)
    this.service.getToken(obj).subscribe(resp=>{
      this.data = resp;
      localStorage.setItem("access-token",this.data.jwtToken);
      localStorage.setItem("EmpId",this.data.user.id)
      localStorage.setItem("Role",this.data.user.role);
      if(this.data.user.role == "Admin"){
        this.router.navigate(['admin']);
      }else{
        this.router.navigate(['user'])
      }
      
    }
    )
    this.profileForm.reset();
  }



}
