import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { httpOptions } from './httpOptions';
import {Post} from "./Post/post";
import {JobOffer} from "./JobOffer/joboffer";
import { UserDataService } from './user-data.service';


@Injectable({
  providedIn: 'root'
})
export class JobOfferService {
  private backend_url = "http://localhost:8080/joboffers"
  joboffers!: JobOffer[];
  constructor(private http: HttpClient, private userData: UserDataService) { }

  createJobOffer(joboffer: JobOffer){
    console.log("Creating job offer: " + joboffer);
    return this.http.post<JobOffer>(this.backend_url, joboffer, {'headers': httpOptions});
  }

  async getJobOffers(): Promise<JobOffer[]>{
    console.log("Getting job offers");

    await this.http.get<JobOffer[]>(this.backend_url+"/prof-"+this.userData.proffessional.id_proffessional, {'headers': httpOptions})
      .toPromise()
      .then(data => {
        this.joboffers = data;
      });
    return this.joboffers;
  }

}
