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
export class LoginService {
  private backend_url = "http://localhost:8080/users/authentication-"
  isValid = false;

  constructor(private http: HttpClient) { }
  Login(email: String){
    console.log("Searching user with email: " + email);
    return this.http.get<User>(this.backend_url+email, {'headers': httpOptions});
  }
}
