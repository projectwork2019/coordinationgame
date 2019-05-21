/*
 * The page for adding a category to a game and displaying the categories currently in the database. 
 */
import { Component, OnInit, ViewChild, ChangeDetectorRef } from '@angular/core';
import { CoordinationRestService } from '../coordination-rest.service';
import {MatPaginator, MatTableDataSource} from '@angular/material';
import { Game, Category, CategoryDisplay } from '../game';

import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-coord-games-add-category-page',
  templateUrl: './coord-games-add-category-page.component.html',
  styleUrls: ['./coord-games-add-category-page.component.css']
})
export class CoordGamesAddCategoryPageComponent implements OnInit {
    
  newCategory:string;
  lastId:number;
  gameId:number;
  categoryId:number;
  
  game : Game;
  category : Category;

  dataSource = new MatTableDataSource<CategoryDisplay>();
  columnsToDisplay = ['categoryId', 'name'];
  
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private http: CoordinationRestService, private changeDetectorRefs: ChangeDetectorRef, private route: ActivatedRoute) { }

  ngOnInit() {
      this.route.queryParams
      .subscribe(params => {
        console.log(params); // {order: "popular"}
        

        //this.presentationId = params.presentationId;
        this.gameId = params.id;
        //console.log(this.presentationId); // popular
        console.log(this.gameId); // popular
        
        //this.loadPresentationReport(this.gameId, this.presentationId);
      });
    
     console.log(this.gameId); // popular
     
     this.http.getGame(this.gameId).subscribe(data => {
             //console.log(this.gameId);
             this.game = data;
             console.log(data);
             console.log(this.game);
      });
      
    console.log(this.gameId); // popular
      
    this.refresh();
  }
  
  //adds a new category to the list
  addCategory(name:string){
	  console.log(name);
          console.log(this.lastId);
          let category = new Category(name, this.lastId);
          console.log(category);
          this.http.addCategory(category).subscribe(data => {
              console.log("Category saved");
          });
          console.log(this.dataSource);
          this.refresh();
  }
  
  //refreshes the category page after a new category has been added
   refresh() {
    this.http.getCategories().subscribe((result) => {
    this.dataSource = new MatTableDataSource(result);
    this.dataSource.paginator = this.paginator;
    console.log(this.dataSource);
      //this.refresh();
    })
  }
  
  assignCategory() {
      //console.log(this.game);
      this.http.getCategory(this.categoryId).subscribe(data => {
             //console.log(this.gameId);
             this.category = data;
             console.log(data);
             console.log(this.category);
      });
      console.log(this.category);
      
      
      this.http.addOrEditGame({'gameDataObject' : this.game}).subscribe(data => {
            this.game.categories.push(this.category);
			console.log(data);
                        console.log("Saved");
//			this.snackBar.open("Game saved", null, {
//				duration: this.durationInSeconds * 1000,
//			  });
//			this.clearGraph();
		});
  }
  
  getSelectedId(id:number) {
      this.categoryId = id;
      console.log(this.categoryId);
  }
}
