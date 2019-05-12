/*
 * The page for displaying a report of the game with the specified id. 
 */
import { Component, OnInit, ViewChild } from '@angular/core';
import { CoordinationRestService } from '../coordination-rest.service';
import {MatPaginator, MatTableDataSource} from '@angular/material';
import { GameDisplay } from '../game'

import { ActivatedRoute } from '@angular/router';
import { filter } from 'rxjs/operators';

@Component({
  selector: 'app-coord-games-admin-presentation-report-page',
  templateUrl: './coord-games-admin-presentation-report-page.component.html',
  styleUrls: ['./coord-games-admin-presentation-report-page.component.css']
})
export class CoordGamesAdminPresentationReportPageComponent implements OnInit {

 gameId:number;
 presentationId:number;

 dataSource = new MatTableDataSource<GameDisplay>();
  columnsToDisplay = ['nodeId', 'percentageChosen'];
  
  
  
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private http: CoordinationRestService, private route: ActivatedRoute) { }

  //gets the game id
  ngOnInit() {
     this.route.queryParams
      .subscribe(params => {
        console.log(params); // {order: "popular"}
        

        this.presentationId = params.presentationId;
        this.gameId = params.id;
        console.log(this.presentationId); // popular
        console.log(this.gameId); // popular
        
        this.loadPresentationReport(this.gameId, this.presentationId);
      }
      
      );
      
//      this.route.events.pipe(
//   filter(params => params.id)
//     ).subscribe(this.id = params.id)
//     
//     console.log(this.id);
  }

  //loads the report
  loadPresentationReport(gameId:number, presentationId:number) {
    this.http.getGameReport(gameId).subscribe((result) => {
      console.log(result);
      this.dataSource = new MatTableDataSource(result);
      this.dataSource.paginator = this.paginator;
      console.log(this.dataSource);
      })
  }
  }
  
    

}
