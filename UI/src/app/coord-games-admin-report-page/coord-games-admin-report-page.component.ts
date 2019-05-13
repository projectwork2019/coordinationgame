/*
 * The page for displaying a report of the game with the specified id. 
 */
import { Component, OnInit, ViewChild } from '@angular/core';
import { CoordinationRestService } from '../coordination-rest.service';
import {MatPaginator, MatTableDataSource, MatSelectModule} from '@angular/material';

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
  columnsToDisplay = ['nodeId', 'percentageChosen', 'avgConfidence'];
  columnsToDisplayPresentations = ['presentationId', 'showReport'];
  
  
  
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
      console.log(result);
      this.dataSource = new MatTableDataSource(result);
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

}
