import { Component, OnInit } from '@angular/core';
import { UserDataService } from '../user-data.service';


@Component({
  selector: 'app-prof-homepage',
  templateUrl: './prof-homepage.component.html',
  styleUrls: ['./prof-homepage.component.css']
})
export class ProfHomepageComponent implements OnInit {

  loggedIn: Boolean = false;

  constructor(private userData: UserDataService) { };

  ngOnInit(): void {
    this.userData.loggedIn$.subscribe((loggedIn: boolean) => {
      console.log("Logged in: " + loggedIn);
      this.loggedIn = loggedIn;
    })
  }
}
