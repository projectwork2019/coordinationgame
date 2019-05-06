/*
 * The page displayed after the admin has logged in. 
 */

import { Component, OnInit, ViewChild } from '@angular/core';
import { CoordinationRestService } from '../coordination-rest.service';
import {MatPaginator, MatTableDataSource} from '@angular/material';
import { GameDisplay } from '../game'

@Component({
  selector: 'app-coord-games-admin-games-page',
  templateUrl: './coord-games-admin-games-page.component.html',
  styleUrls: ['./coord-games-admin-games-page.component.css']
})
export class CoordGamesAdminGamesPageComponent implements OnInit { 
  
  dataSource = new MatTableDataSource<GameDisplay>();
  columnsToDisplay = ['gameId', 'removeGame'];
  
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private http: CoordinationRestService) { }

  ngOnInit() {
	  this.loadGamesList();
  }

  loadGamesList() {
    this.http.getGames().subscribe((result) => {
      console.log(result);
      this.dataSource = new MatTableDataSource(result);
      this.dataSource.paginator = this.paginator;
      console.log(this.dataSource);
      })
  }
  
  toggleEnabled(id:number){
	  console.log(id);
	  this.http.toggleEnabled(id).subscribe((result) => {
		console.log(result);
	  });
  }
  
  removeGame(id:number){
    console.log(id);
    this.http.deleteGame(id).subscribe((result) => {
      console.log(result);
      this.loadGamesList();
      });
  }

}
