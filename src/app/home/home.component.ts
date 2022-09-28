import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs/internal/Observable';
import { FetchDataService } from '../Services/fetch-data.service';
import { UserComponent } from '../user/user.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  isLoggedIn : any;
  role : any;

  constructor(private auth_service : FetchDataService,private router : Router) { }


  ngOnInit(): void {
    this.isLoggedIn = true;
    this.role = localStorage.getItem('Role');
  }


  public logout(){
    this.isLoggedIn = false;
    localStorage.clear();
    this.router.navigate(['login']);
  }

}
