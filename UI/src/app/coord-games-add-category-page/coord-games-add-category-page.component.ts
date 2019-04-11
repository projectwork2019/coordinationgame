import { Component, OnInit, ViewChild } from '@angular/core';
import { CoordinationRestService } from '../coordination-rest.service';
import {MatPaginator, MatTableDataSource} from '@angular/material';
import { CategoryDisplay } from '../game'

@Component({
  selector: 'app-coord-games-add-category-page',
  templateUrl: './coord-games-add-category-page.component.html',
  styleUrls: ['./coord-games-add-category-page.component.css']
})
export class CoordGamesAddCategoryPageComponent implements OnInit {

  dataSource = new MatTableDataSource<CategoryDisplay>();
  columnsToDisplay = ['categoryId', 'name'];
  
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private http: CoordinationRestService) { }

  ngOnInit() {
	  this.http.getCategories().subscribe((result) => {
		this.dataSource = new MatTableDataSource(result);
		this.dataSource.paginator = this.paginator;
		console.log(this.dataSource);
	  })
  }
  
  addCategory(name:string){
	  console.log(name);
  }

}
