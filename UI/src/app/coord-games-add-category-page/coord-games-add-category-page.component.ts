import { Component, OnInit, ViewChild } from '@angular/core';
import { CoordinationRestService } from '../coordination-rest.service';
import {MatPaginator, MatTableDataSource} from '@angular/material';
import { CategoryDisplay } from '../game'
import { Category } from '../game'

@Component({
  selector: 'app-coord-games-add-category-page',
  templateUrl: './coord-games-add-category-page.component.html',
  styleUrls: ['./coord-games-add-category-page.component.css']
})
export class CoordGamesAddCategoryPageComponent implements OnInit {
    
  newCategory:string;
  lastId:number;

  dataSource = new MatTableDataSource<CategoryDisplay>();
  columnsToDisplay = ['categoryId', 'name'];
  
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private http: CoordinationRestService) { }

  ngOnInit() {
	  this.http.getCategories().subscribe((result) => {
		this.dataSource = new MatTableDataSource(result);
		this.dataSource.paginator = this.paginator;
                //let num = this.dataSource.data.length - 1;
                //this.lastId = this.dataSource.data.num.category_id
		console.log(this.dataSource);
	  })
  }
  
  addCategory(name:string){
	  console.log(name);
          //console.log(id);
          this.lastId = this.dataSource.data.length + 4000 + 1;
          console.log(this.lastId);
          
          let category = new Category(name, this.lastId);
          console.log(category);
          this.http.addCategory(category);
  }

}
