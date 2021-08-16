import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { User } from './User/user'

@Injectable({
  providedIn: 'root'
})
export class SignUpService {
  private backend_url = "https://localhost:8080/users"
  constructor(private http: HttpClient) { }
  SignUp(user: User){
    console.log("Signing up user with ID: " + user.id);
    return this.http.post<Article>(this.backend_url, user).subscribe(data => {
      console.log("Response ID: " + data.id);
      console.log("Response Title: " + data.title);
    })
  }
}

interface Article {
  id: number;
  title: string;
}
