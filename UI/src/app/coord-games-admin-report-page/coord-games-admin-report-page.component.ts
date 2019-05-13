/*
 * The page for displaying a report of the game with the specified id. 
 */
import { Component, OnInit, ViewChild, Input } from '@angular/core';
import { CoordinationRestService } from '../coordination-rest.service';
import {MatPaginator, MatTableDataSource, MatSelectModule} from '@angular/material';
import { ShowGraphComponent } from '../show-graph/show-graph.component';
import { NodeReport, PresentationDisplay } from '../game'

import { ActivatedRoute } from '@angular/router';
import { filter } from 'rxjs/operators';

import { Router,
         NavigationExtras } from '@angular/router';



@Component({
  selector: 'app-coord-games-admin-report-page',
  templateUrl: './coord-games-admin-report-page.component.html',
  styleUrls: ['./coord-games-admin-report-page.component.css']
})
export class CoordGamesAdminReportPageComponent implements OnInit {

 id:number;

  dataSource = new MatTableDataSource<NodeReport>();
  dataSourcePresentations = new MatTableDataSource<PresentationDisplay>();
  columnsToDisplay = ['nodeId', 'frequency' ,'percentageChosen', 'avgConfidence'];
  columnsToDisplayPresentations = ['presentationId', 'showReport'];
  isDataAvailable : boolean = false;
  
  @ViewChild(ShowGraphComponent) graphComponent:ShowGraphComponent;
  graph : any = {};
  @Input() childMessage : any = this.graph;

  reportList : Array<NodeReport> = [];
  @Input() nodeReport : Array<NodeReport> = this.reportList;
  
  @ViewChild(MatPaginator) paginator: MatPaginator;
  //@ViewChild(MatPaginator) paginatorPresentations: MatPaginator;

  constructor(private http: CoordinationRestService, private route: ActivatedRoute, public router: Router) { }

  //gets the game id
  ngOnInit() {
     this.route.queryParams
      .subscribe(params => {
        console.log(params); // {order: "popular"}
        

        this.id = params.id;
        console.log(this.id); // popular
        
        this.loadGameReport(this.id);
        this.loadPresentationList(this.id);
      }
      
      );
      

      
//      this.route.events.pipe(
//   filter(params => params.id)
//     ).subscribe(this.id = params.id)
//     
//     console.log(this.id);
  }

  //loads the report
  loadGameReport(gameId:number) {

    this.http.getGameReport(gameId).subscribe((result) => {
      this.graph = result[0].presentation.games;
      this.dataSource = new MatTableDataSource(this.parseReportList(result));
      this.dataSource.paginator = this.paginator;
      console.log(this.dataSource);
      })
  }
  //}
  
  loadPresentationList(gameId:number) {
      this.http.getPresentationsByGameId(gameId).subscribe((result) => {
      console.log(result);
      this.dataSourcePresentations = new MatTableDataSource(result);
      //this.dataSourcePresentations.paginatorPresentations = this.paginatorPresentations;
      console.log(this.dataSourcePresentations);
      })
  }
  showPresentationReport(presentationId:number){
    //this.router.navigate(['/coord-games-admin-report-page/' + id]);
    let redirect = '/coord-games-admin-presentation-report-page';

    let navigationExtras: NavigationExtras = {
          queryParamsHandling: 'merge',
//          preserveFragment: true
            queryParams: { presentationId : presentationId }
            
    };


    this.router.navigate([redirect], navigationExtras);
  }

  parseReportList(result){
    
      let totalFrequency : number = 0;
      let firstLoop : boolean = true;

      while(result.length > 0){
        let nodeReport : NodeReport = new NodeReport();
        let length = result.length;
        for(let i : number = length - 1; i >= 0 ; i--){
          if(firstLoop){
            totalFrequency = totalFrequency + result[i].frequency;
          }
          if(i== length - 1){
            nodeReport.nodeId = result[i].selection_id.selectedNode;
            nodeReport.frequency = nodeReport.frequency + result[i].frequency;
            nodeReport.avgConfidence = nodeReport.avgConfidence + result[i].selection_id.confidence * result[i].frequency;
            result.splice(i, 1);
          } 
          else if(result[i].selection_id.selectedNode == nodeReport.nodeId) {
            nodeReport.frequency = nodeReport.frequency + result[i].frequency;
            nodeReport.avgConfidence = nodeReport.avgConfidence + result[i].selection_id.confidence * result[i].frequency;
            result.splice(i, 1);
          }
        }
        firstLoop = false;
        nodeReport.avgConfidence = nodeReport.avgConfidence / nodeReport.frequency;
        nodeReport.percentChosen = (nodeReport.frequency / totalFrequency) * 100;
        console.log(nodeReport);
        this.reportList.push(nodeReport);
      }
      this.nodeReport = this.reportList;
      this.isDataAvailable = true;
      return this.reportList;
  }

}
