import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { WelcomePageComponent } from './welcome-page/welcome-page.component';
import { SignUpPageComponent } from './sign-up-page/sign-up-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { ProfHomepageComponent } from './prof-homepage/prof-homepage.component';
import { ProffessionalGuard } from './proffessional.guard';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'welcome',
    pathMatch: 'full',
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
    path: 'homepage',
    component: WelcomePageComponent,
  },
  {
    path: 'network',
    component: WelcomePageComponent,
  },
  {
    path: 'joboffers',
    component: WelcomePageComponent,
  },
  {
    path: 'discussions',
    component: WelcomePageComponent,
  },
  {
    path: 'notifications',
    component: WelcomePageComponent,
  },
  {
    path: 'personalinfo',
    component: WelcomePageComponent,
  },
  {
    path: 'settings',
    component: WelcomePageComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const RoutingComponent = [SignUpPageComponent, LoginPageComponent, WelcomePageComponent, ProfHomepageComponent];
