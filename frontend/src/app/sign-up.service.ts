import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { User } from './User/user'
import { informationPage } from './InformationPage/informationPage';
import { proffessional } from './Proffessional/proffessional';

const httpOptions = new HttpHeaders()
  .set('Accept', 'application/json')
  .set('content-type', 'application/json')
  .set('Access-Control-Allow-Origin', '*');

@Injectable({
  providedIn: 'root'
})
export class SignUpService {
  private backend_url = "http://localhost:8080/"
  private userId: any;
  private informationPageId: any;

  constructor(private http: HttpClient) { }
  SignUp(user: User){
    console.log("Signing up user with email: " + user.email);
    this.http.post<User>(this.backend_url+"users", user, {'headers': httpOptions}).subscribe(data => {
      console.log(data);
      this.userId = data.user_id;
    });

    // this.http.post<informationPage>(this.backend_url+"informationpages", new informationPage("", ""), {'headers': httpOptions}).subscribe(data => {
    //   console.log(data);
    //   this.informationPageId = data.informationPage_id;
    // });
    //
    // //TODO : post request only has proffessional_id for some reason
    //
    // this.http.post<proffessional>(this.backend_url+"proffessionals", new proffessional(this.userId, this.informationPageId), {'headers': httpOptions}).subscribe(data => {
    //   console.log(this.userId);
    //   console.log(this.informationPageId);
    //   console.log(data);
    // });
  }
}
