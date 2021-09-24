import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { httpOptions } from './httpOptions';
import {User} from "./User/user";


@Injectable({
  providedIn: 'root'
})
export class SearchNameService {


  // proffessionals: User[]= new Array<User>();
  private backend_url = "http://localhost:8080/proffessionals"

  constructor(private http: HttpClient) { }

  searchName(name: String){
    console.log("Searching for proffessionals with " + name + " in their firstname or lastname");
    return this.http.get<Array<User>>(this.backend_url+"/search-"+name, {'headers': httpOptions});

  }

}
