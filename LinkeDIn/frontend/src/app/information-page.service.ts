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


  changeBio(ip:informationPage,newbio:String) {
    console.log(ip, newbio);
    return this.http.get(this.backend_url + "/biochange/" + ip.id_information_page + "/" + newbio, {'headers': httpOptions});
  }

  changeWorkExp(ip:informationPage,newworkexp:String){
    console.log(ip,newworkexp);
    return this.http.get(this.backend_url+"/workexpchange/"+ip.id_information_page+"/"+newworkexp, {'headers': httpOptions});
  }


}
