import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { WelcomePageComponent } from './welcome-page/welcome-page.component';
import { SignUpPageComponent } from './sign-up-page/sign-up-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { ProfHomepageComponent } from './prof-homepage/prof-homepage.component';
import { ProffessionalGuard } from './proffessional.guard';
import { JobOffersComponent } from './job-offers/job-offers.component';
import { DiscussionsComponent } from './discussions/discussions.component';
import { NetworkComponent } from './network/network.component';
import { NotificationsComponent } from './notifications/notifications.component';
import { PersonalInfoComponent } from './personal-info/personal-info.component';
import { SettingsComponent } from './settings/settings.component';
import {UserPageComponent} from "./user-page/user-page.component";

const routes: Routes = [
  {
    path: '',
    redirectTo: 'welcome',
    pathMatch: 'full',
  },
  {
    path: 'user-page',
    component: UserPageComponent
    //canActivate: [UserGuard],
  },
  {
    path: 'welcome',
    component: WelcomePageComponent,
  },
  {
    path: 'profHomepage',
    component: ProfHomepageComponent,
    canActivate: [ProffessionalGuard],
  },
  {
    path: 'network',
    component: NetworkComponent,
  },
  {
    path: 'joboffers',
    component: JobOffersComponent,
  },
  {
    path: 'discussions',
    component: DiscussionsComponent,
  },
  {
    path: 'notifications',
    component: NotificationsComponent,
  },
  {
    path: 'personalinfo',
    component: PersonalInfoComponent,
  },
  {
    path: 'settings',
    component: SettingsComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const RoutingComponent = [SignUpPageComponent, LoginPageComponent, WelcomePageComponent, ProfHomepageComponent
, DiscussionsComponent, NetworkComponent, NotificationsComponent, PersonalInfoComponent, SettingsComponent, JobOffersComponent];
