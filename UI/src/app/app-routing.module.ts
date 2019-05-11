import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

//import { ComposeMessageComponent }  from './compose-message/compose-message.component';
import { PageNotFoundComponent }    from './page-not-found/page-not-found.component';
import { CoordGamesMainPageComponent }    from './coord-games-main-page/coord-games-main-page.component';
import { CoordGamesFinalPageComponent }    from './coord-games-final-page/coord-games-final-page.component';
import { CoordGamesFeedbackPageComponent }    from './coord-games-feedback-page/coord-games-feedback-page.component';
import { CoordGamesGameplayPageComponent }    from './coord-games-gameplay-page/coord-games-gameplay-page.component';
import { CoordGamesAdminGamesPageComponent }    from './coord-games-admin-games-page/coord-games-admin-games-page.component';
import { CoordGamesAdminAddGamePageComponent }    from './coord-games-admin-add-game-page/coord-games-admin-add-game-page.component';
import { GraphEditorComponent } from './graph-editor/graph-editor.component';
import { CoordGamesFeedbackReceivedPageComponent } from './coord-games-feedback-received-page/coord-games-feedback-received-page.component';
import { CoordGamesLoginFailedPageComponent } from './coord-games-login-failed-page/coord-games-login-failed-page.component';
import { CoordGamesLogoutPageComponent } from './coord-games-logout-page/coord-games-logout-page.component';
import { CoordGamesAccessDeniedPageComponent } from './coord-games-access-denied-page/coord-games-access-denied-page.component';
import { CoordGamesAdminChooseFromListPageComponent } from './coord-games-admin-choose-from-list-page/coord-games-admin-choose-from-list-page.component';
import { CoordGamesAddCategoryPageComponent } from './coord-games-add-category-page/coord-games-add-category-page.component';
import { CoordGamesExtendedMainPagesComponent } from './coord-games-extended-main-pages/coord-games-extended-main-pages.component';
import { CoordGamesAdminReportPageComponent } from './coord-games-admin-report-page/coord-games-admin-report-page.component';
import { ShowGamePageComponent } from './show-game-page/show-game-page.component';

import { AuthGuard }                          from './auth/auth.guard';
import { SelectivePreloadingStrategyService } from './selective-preloading-strategy.service';

const appRoutes: Routes = [
//  {
//    path: 'compose',
//    component: ComposeMessageComponent,
//    outlet: 'popup'
//  },
  {
    path: 'coord-games-admin-report-page',
    component: CoordGamesAdminReportPageComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'coord-games-extended-main-pages',
    component: CoordGamesExtendedMainPagesComponent
  },
  {
    path: 'coord-games-add-category-page',
    component: CoordGamesAddCategoryPageComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'coord-games-admin-games-page',
    component: CoordGamesAdminGamesPageComponent,
    canActivate: [AuthGuard]
  },
  {
   path: 'coord-games-admin-choose-from-list-page',
   component: CoordGamesAdminChooseFromListPageComponent,
   canActivate: [AuthGuard]
  },
  {
    path: 'coord-games-access-denied-page',
    component: CoordGamesAccessDeniedPageComponent
  },
  {
    path: 'coord-games-logout-page',
    component: CoordGamesLogoutPageComponent
  },
  {
    path: 'coord-games-login-failed-page',
    component: CoordGamesLoginFailedPageComponent
  },
  {
    path: 'coord-games-feedback-received-page',
    component: CoordGamesFeedbackReceivedPageComponent
  },
  {
   path: 'graph-editor',
   component: GraphEditorComponent,
   canActivate: [AuthGuard]
  },
  {
    path: 'coord-games-admin-add-game-page',
    component: CoordGamesAdminAddGamePageComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'coord-games-gameplay-page',
    component: CoordGamesGameplayPageComponent
  },
  {
    path: 'coord-games-feedback-page',
    component: CoordGamesFeedbackPageComponent
  },
  {
    path: 'coord-games-final-page',
    component: CoordGamesFinalPageComponent
  },
  {
    path: 'show-game-page',
    component: ShowGamePageComponent
  },
  {
    path: 'admin',
    loadChildren: './admin/admin.module#AdminModule',
    canLoad: [AuthGuard]
    //canActivate: [AuthGuard]
  },
  {
    path: 'coord-games-main-page',
    component: CoordGamesMainPageComponent
  },
  { path: '',   redirectTo: '/coord-games-main-page', pathMatch: 'full' },
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [
    RouterModule.forRoot(
      appRoutes,
      {
        enableTracing: false, // <-- debugging purposes only
        preloadingStrategy: SelectivePreloadingStrategyService,
      }
    )
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/