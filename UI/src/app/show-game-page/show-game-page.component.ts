import { Component, OnInit, ViewChild, Input } from '@angular/core';
import { ShowGraphComponent } from '../show-graph/show-graph.component';
import { Router, NavigationExtras, ActivatedRoute } from '@angular/router';
import { CoordinationRestService } from '../coordination-rest.service';
import { Game, Category } from '../game';
import { MatTableDataSource, MatPaginator } from '@angular/material';

@Component({
  selector: 'app-show-game-page',
  templateUrl: './show-game-page.component.html',
  styleUrls: ['./show-game-page.component.css']
})
export class ShowGamePageComponent implements OnInit {

  constructor(private rest : CoordinationRestService, private route: ActivatedRoute) { }

  @ViewChild(ShowGraphComponent) graphComponent:ShowGraphComponent;
  graph : any = {};
  @Input() childMessage : any = this.graph;
  
  @ViewChild(MatPaginator) paginator: MatPaginator;

  game : Game;

  dataSource = new MatTableDataSource<Category>();
  columnsToDisplay = ['categoryName','enabled'];

  initializedCategories : Array<Category> = [];
  selectedCategories : Array<Category> = [];
  isDataAvailable : boolean = false;

  ngOnInit() {
    // Get game by id url paramater
    this.route.queryParams.subscribe(params => {
      this.rest.getGame(parseInt(params["id"])).subscribe(data => {
          this.game = data;
          this.graph = this.game;
          this.isDataAvailable = true;
          // Get categories and bind the category list to datasource to generate category table
          this.rest.getCategories().subscribe((result) => {
            this.dataSource = new MatTableDataSource(result);
            this.dataSource.paginator = this.paginator;
            result.forEach(element => {
            });
          });
      });
    });
    
    
  
  }

  // Check if the game contains said category. Set checkbox state depending on this function
  isInGame(category){
   let found =  this.game.categories.some(item => item.categoryID == category.categoryID);
   if(!this.initializedCategories.includes(category)){
    this.initializedCategories.push(category);
   if(found){
    this.selectedCategories.push(category);
   } 
  }
   return found;
  }

  // Toggle event for binding categories to the game
  toggleEnabled(category, event){
    // Add category to the selected list if checked, otherwise remove from the list
    if(event.checked == true){
      this.selectedCategories.push(category);
    } else {
      this.selectedCategories.splice(this.selectedCategories.indexOf(category), 1);
    }
    this.game.categories = this.selectedCategories;

    // Rest call for updating the categories game has
    this.rest.updateGameCategories(this.game).subscribe(data => {
		});
  }

}
