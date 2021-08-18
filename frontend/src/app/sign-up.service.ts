import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { User } from './User/user'

const httpOptions = new HttpHeaders()
  .set('Accept', 'application/json')
  .set('content-type', 'application/json')
  .set('Access-Control-Allow-Origin', '*');

@Injectable({
  providedIn: 'root'
})
export class SignUpService {
  private backend_url = "http://localhost:8080/users"
  constructor(private http: HttpClient) { }
  SignUp(user: User){
    console.log("Signing up user with email: " + user.email);
    return this.http.post(this.backend_url, user, {'headers': httpOptions}).subscribe(data => {
      console.log(data);
    })
  }
}
