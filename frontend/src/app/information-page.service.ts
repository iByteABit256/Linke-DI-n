import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { httpOptions } from './httpOptions';
import {informationPage} from "./InformationPage/informationPage";

@Injectable({
  providedIn: 'root'
})
export class InformationPageService {
  private  backend_url = "http://localhost:8080/informationpages"
  constructor(private http: HttpClient) { }

  getInformationPage(id_user:Number){
    return this.http.get<informationPage>(this.backend_url+"/user-"+id_user, {'headers': httpOptions});
  }


}
