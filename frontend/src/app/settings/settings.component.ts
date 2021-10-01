import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.css']
})
export class SettingsComponent implements OnInit {
  
  emailForm: any;
  passwordForm: any;

  constructor() { }

  ngOnInit(): void {
  }
  
  onClickEmail(data: any){
  }
  
  onClickPassword(data: any){
  }

}
