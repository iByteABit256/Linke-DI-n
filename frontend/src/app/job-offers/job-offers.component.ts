import { Component, OnInit } from '@angular/core';
import { JobOffer } from "../JobOffer/joboffer";
import {FormControl, FormGroup} from "@angular/forms";
import {Post} from "../Post/post";
import {formatDate} from "@angular/common";
import {proffessional} from "../Proffessional/proffessional";
import {UserDataService} from "../user-data.service";
import {JobOfferService} from "../job-offer.service";
import {forkJoin} from "rxjs";
import {JobOfferApplicationService} from "../job-offer-application.service";


@Component({
  selector: 'app-job-offers',
  templateUrl: './job-offers.component.html',
  styleUrls: ['./job-offers.component.css']
})
export class JobOffersComponent implements OnInit {

  generaljoboffers: JobOffer[]= new Array<JobOffer>();
  recommendedjoboffers: JobOffer[]= new Array<JobOffer>();
  formdata: any;
  joboffer: any;
  proffessional: proffessional;




  constructor(private userData: UserDataService,private jos:JobOfferService,private joas:JobOfferApplicationService) {
    this.proffessional = this.userData.proffessional;
  }

  ngOnInit(): void {

    this.formdata = new FormGroup({
      title: new FormControl(""),
      body: new FormControl(""),
    });

    this.jos.getJobOffers().then(data => {
      this.generaljoboffers = data;
      
      this.jos.getRecommendedJobOffers().then(data => {
        let recommendations: JobOffer[] = data;
        for(let i = 0; i < recommendations.length; i++){
          recommendations[i].recommended = true;
          this.generaljoboffers.unshift(recommendations[i]);
        }

        let observables = this.generaljoboffers.map(p => this.joas.getApplications(p.id_job_offer));
        let source = forkJoin(observables);
        source.subscribe(data => {
          for(let i = 0; i < this.generaljoboffers.length; i++){
            this.generaljoboffers[i].applications = data[i];
          }
        });

      });
    });

  }

  onClickSubmit(data: any) {
    this.joboffer = new JobOffer(this.proffessional.id_proffessional, data.title, data.body);
    console.log("Created job offer: " + this.joboffer);
    this.jos.createJobOffer(this.joboffer).subscribe(data => {
      console.log(data)
      this.ngOnInit();
    })
  }

  makeApplication(joboffer: JobOffer){
    console.log(joboffer);
    this.joas.makeJobApplication(this.proffessional.id_proffessional,joboffer.id_job_offer);
    this.ngOnInit();
  }

}
