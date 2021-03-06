/*
 * The page displayed after the admin has logged in. 
 */

import { Component, OnInit, ViewChild } from '@angular/core';
import { CoordinationRestService } from '../coordination-rest.service';
import {MatPaginator, MatTableDataSource} from '@angular/material';
import { GameDisplay } from '../game'
import { Router,
         NavigationExtras } from '@angular/router';

@Component({
  selector: 'app-coord-games-admin-games-page',
  templateUrl: './coord-games-admin-games-page.component.html',
  styleUrls: ['./coord-games-admin-games-page.component.css']
})
export class CoordGamesAdminGamesPageComponent implements OnInit { 
  
  dataSource = new MatTableDataSource<GameDisplay>();
  columnsToDisplay = ['gameId','showReport','addCategoryToAGame','removeGame'];
  
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private http: CoordinationRestService, public router: Router) { }

  ngOnInit() {
	  this.loadGamesList();
  }

  //loads the current list of games
  loadGamesList() {
    this.http.getGames().subscribe((result) => {
      console.log(result);
      this.dataSource = new MatTableDataSource(result);
      this.dataSource.paginator = this.paginator;
      console.log(this.dataSource);
      })
  }
  
  //toggle for enabling/disabling a game
  toggleEnabled(id:number){
	  console.log(id);
	  this.http.toggleEnabled(id).subscribe((result) => {
		console.log(result);
	  });
  }
  
  //removes the game with the specified id
  removeGame(id:number){
    console.log(id);
    this.http.deleteGame(id).subscribe((result) => {
      console.log(result);
      this.loadGamesList();
      });
  }
  
  //redirects the user to the report page for the game of the specified id
  showReport(gameId:number){
    //this.router.navigate(['/coord-games-admin-report-page/' + id]);
    let redirect = '/coord-games-admin-report-page';

    let navigationExtras: NavigationExtras = {
          queryParamsHandling: 'merge',
//          preserveFragment: true
            queryParams: { id: gameId }
            
    };


    this.router.navigate([redirect], navigationExtras);
  }

//}

  addCategoryToAGame(gameId:number) {
    let redirect = '/coord-games-add-category-page';

    let navigationExtras: NavigationExtras = {
          queryParamsHandling: 'merge',
//          preserveFragment: true
            queryParams: { id: gameId }
            
    };


    this.router.navigate([redirect], navigationExtras);
  }
}
