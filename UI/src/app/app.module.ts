import { NgModule }       from '@angular/core';
import { BrowserModule }  from '@angular/platform-browser';
import { FormsModule }    from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { HttpClientModule } from '@angular/common/http';
import { NgxGraphModule } from '@swimlane/ngx-graph';
import { NgxChartsModule } from '@swimlane/ngx-charts';

import { Router } from '@angular/router';

import { AppComponent }            from './app.component';
import { PageNotFoundComponent }   from './page-not-found/page-not-found.component';
import { ComposeMessageComponent } from './compose-message/compose-message.component';

import { AppRoutingModule }        from './app-routing.module';
import { HeroesModule }            from './heroes/heroes.module';
import { AuthModule }              from './auth/auth.module';
import { CoordGamesMainPageComponent } from './coord-games-main-page/coord-games-main-page.component';
import { CoordGamesFinalPageComponent } from './coord-games-final-page/coord-games-final-page.component';
import { CoordGamesFeedbackPageComponent } from './coord-games-feedback-page/coord-games-feedback-page.component';
import { CoordGamesGameplayPageComponent } from './coord-games-gameplay-page/coord-games-gameplay-page.component';
import { CoordGamesAdminGamesPageComponent } from './coord-games-admin-games-page/coord-games-admin-games-page.component';
import { CoordGamesAdminAddGamePageComponent } from './coord-games-admin-add-game-page/coord-games-admin-add-game-page.component';
import { GraphEditorComponent } from './graph-editor/graph-editor.component';
import { ShowGraphComponent } from './show-graph/show-graph.component';
import { TestComponentComponent } from './test-component/test-component.component';
import { CoordGamesFeedbackReceivedPageComponent } from './coord-games-feedback-received-page/coord-games-feedback-received-page.component';

@NgModule({
 imports: [
   BrowserModule,
   BrowserAnimationsModule,
   FormsModule,
   HeroesModule,
   AuthModule,
   AppRoutingModule,
   NgxGraphModule,
   NgxChartsModule,
   HttpClientModule
 ],
  declarations: [
    AppComponent,
    ShowGraphComponent,
    ComposeMessageComponent,
    PageNotFoundComponent,
    CoordGamesMainPageComponent,
    CoordGamesFinalPageComponent,
    CoordGamesFeedbackPageComponent,
    CoordGamesGameplayPageComponent,
    CoordGamesAdminGamesPageComponent,
    CoordGamesAdminAddGamePageComponent,
    GraphEditorComponent,
    TestComponentComponent,
    CoordGamesFeedbackReceivedPageComponent
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule {
  // Diagnostic only: inspect router configuration
  constructor(router: Router) {
    // Use a custom replacer to display function names in the route configs
    // const replacer = (key, value) => (typeof value === 'function') ? value.name : value;

    // console.log('Routes: ', JSON.stringify(router.config, replacer, 2));
  }
}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/