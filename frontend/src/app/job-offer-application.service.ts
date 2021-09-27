import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { httpOptions } from './httpOptions';


@Injectable({
  providedIn: 'root'
})
export class JobOfferApplicationService {
  private backend_url = "http://localhost:8080/jobofferapplications"

  constructor(private http: HttpClient) { }

  makeJobApplication(id_proffessional: Number, id_job_offer: Number){
    this.http.post(this.backend_url, {id_proffessional, id_job_offer}, {'headers': httpOptions}).subscribe(data => {
      console.log(data);
    });
  }

  getApplications(id_job_offer: Number){
    return this.http.get<Number>(this.backend_url+"/joboffer-"+id_job_offer, {'headers': httpOptions});
  }

}
