import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { NgxGraphModule } from '@swimlane/ngx-graph';
import { NgxChartsModule } from '@swimlane/ngx-charts';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { GraphEditorComponent } from './graph-editor/graph-editor.component';
import { ShowGraphComponent } from './show-graph/show-graph.component';
import { TestComponentComponent } from './test-component/test-component.component';

@NgModule({
  declarations: [
    AppComponent,
    GraphEditorComponent,
    ShowGraphComponent,
    TestComponentComponent
  ],
  imports: [
	BrowserModule,
	FormsModule,
	NgxGraphModule,
	HttpClientModule,
	NgxChartsModule,
	BrowserAnimationsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
