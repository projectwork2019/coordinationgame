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

import { AuthGuard }                          from './auth/auth.guard';
import { SelectivePreloadingStrategyService } from './selective-preloading-strategy.service';

const appRoutes: Routes = [
//  {
//    path: 'compose',
//    component: ComposeMessageComponent,
//    outlet: 'popup'
//  },
  {
   path: 'graph-editor',
   component: GraphEditorComponent
  },
  {
    path: 'coord-games-admin-add-game-page',
    component: CoordGamesAdminAddGamePageComponent
  },
  {
    path: 'coord-games-admin-games-page',
    component: CoordGamesAdminGamesPageComponent
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
    path: 'admin',
    loadChildren: './admin/admin.module#AdminModule',
    canLoad: [AuthGuard]
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