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
    this.route.queryParams.subscribe(params => {
      console.log(params["id"]);
      this.rest.getGame(parseInt(params["id"])).subscribe(data => {
          this.game = data;
          this.graph = this.game;
          console.log(this.game);
          this.isDataAvailable = true;
          this.rest.getCategories().subscribe((result) => {
            this.dataSource = new MatTableDataSource(result);
            this.dataSource.paginator = this.paginator;
            result.forEach(element => {
              console.log(this.game.categories);
              console.log(element);
              console.log(this.game.categories.some(item => item.categoryID == element.categoryID));
            });
          });
      });
    });
    
    
  
  }

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

  toggleEnabled(category, event){
    if(event.checked == true){
      this.selectedCategories.push(category);
    } else {
      console.log(this.selectedCategories.indexOf(category));
      this.selectedCategories.splice(this.selectedCategories.indexOf(category), 1);
    }
    this.game.categories = this.selectedCategories;
    this.rest.updateGameCategories(this.game).subscribe(data => {
			console.log(data);
		});
  }

}
