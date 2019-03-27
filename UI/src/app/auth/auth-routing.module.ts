import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard }            from './auth.guard';
import { AuthService }          from './auth.service';
import { LoginComponent }       from './login/login.component';
//import { CoordGamesLoginFailedPageComponent } from '../coord-games-login-failed-page/coord-games-login-failed-page.component';
//import { CoordGamesLogoutPageComponent } from '../coord-games-logout-page/coord-games-logout-page.component';
//import { CoordGamesAccessDeniedPageComponent } from '../coord-games-access-denied-page/coord-games-access-denied-page.component';

const authRoutes: Routes = [
//  {
//    path: 'coord-games-access-denied-page',
//    component: CoordGamesAccessDeniedPageComponent
//  },
//  {
//    path: 'coord-games-logout-page',
//    component: CoordGamesLogoutPageComponent
//  },
//  {
//    path: 'coord-games-login-failed-page',
//    component: CoordGamesLoginFailedPageComponent
//  },
  { path: 'login', component: LoginComponent }
];

@NgModule({
  imports: [
    RouterModule.forChild(authRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class AuthRoutingModule {}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/