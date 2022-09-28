import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Element } from '@angular/compiler';

@Injectable({
  providedIn: 'root'
})
export class FetchDataService {

  constructor(private _httpclient : HttpClient) { }

  public getAllLeaves() {
    return this._httpclient.get('http://localhost:8080/leaves');
  }

  public getUserLeaves(id: any) {
    return this._httpclient.get('http://localhost:8080/leaves/' + id);
  }

  public AddUserLeaves(obj: any) {
    return this._httpclient.post('http://localhost:8080/addleave', obj);
  }

  public UpdateUserLeave(obj:any){
    return this._httpclient.put('http://localhost:8080/addleave',obj);
  }

  public getToken(obj: any) {
    return this._httpclient.post('http://localhost:8081/authenticate', obj);
  }

}
