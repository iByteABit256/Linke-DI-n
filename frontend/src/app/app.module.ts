import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule, RoutingComponent } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignUpService } from './sign-up.service';
import { NetworkComponent } from './network/network.component';
import { JobOffersComponent } from './job-offers/job-offers.component';
import { DiscussionsComponent } from './discussions/discussions.component';
import { NotificationsComponent } from './notifications/notifications.component';
import { PersonalInfoComponent } from './personal-info/personal-info.component';
import { SettingsComponent } from './settings/settings.component';
import { TopNavBarComponent } from './top-nav-bar/top-nav-bar.component';

@NgModule({
  declarations: [
    AppComponent,
    RoutingComponent,
    NetworkComponent,
    JobOffersComponent,
    DiscussionsComponent,
    NotificationsComponent,
    PersonalInfoComponent,
    SettingsComponent,
    TopNavBarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [SignUpService],
  bootstrap: [AppComponent]
})
export class AppModule { }
