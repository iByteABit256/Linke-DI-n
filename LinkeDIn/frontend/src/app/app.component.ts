import { Component } from '@angular/core';
import { UserDataService } from './user-data.service';
import { Observable } from 'rxjs';
import { User } from './User/user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  user: boolean = false;
  title = 'LinkeDIn';

  constructor(private userData: UserDataService) {
  }

  ngOnInit() {
    this.userData.loggedIn$.subscribe((loggedIn: boolean) => {
      console.log("Logged in: " + loggedIn);
      this.user = loggedIn;
    })
  }
}
