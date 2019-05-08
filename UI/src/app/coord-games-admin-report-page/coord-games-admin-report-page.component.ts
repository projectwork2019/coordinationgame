import { Component, OnInit, ViewChild } from '@angular/core';
import { CoordinationRestService } from '../coordination-rest.service';
import {MatPaginator, MatTableDataSource} from '@angular/material';
import { GameDisplay } from '../game'

import { ActivatedRoute } from '@angular/router';
import { filter } from 'rxjs/operators';



@Component({
  selector: 'app-coord-games-admin-report-page',
  templateUrl: './coord-games-admin-report-page.component.html',
  styleUrls: ['./coord-games-admin-report-page.component.css']
})
export class CoordGamesAdminReportPageComponent implements OnInit {

 id:number;

 dataSource = new MatTableDataSource<GameDisplay>();
  columnsToDisplay = ['nodeId', 'percentageChosen'];
  
  
  
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private http: CoordinationRestService, private route: ActivatedRoute) { }

  ngOnInit() {
     this.route.queryParams
      .subscribe(params => {
        console.log(params); // {order: "popular"}
        

        this.id = params.id;
        console.log(this.id); // popular
      });
      
//      this.route.events.pipe(
//   filter(params => params.id)
//     ).subscribe(this.id = params.id)
//     
//     console.log(this.id);
  }

  loadGameReport(gameId:number) {
//    this.http.getGames().subscribe((result) => {
      //this.id = gameId;
      console.log(this.id);
//      this.dataSource = new MatTableDataSource(result);
//      this.dataSource.paginator = this.paginator;
//      console.log(this.dataSource);
//      })
  }
  

}
