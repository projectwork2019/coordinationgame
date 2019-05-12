import { Component, OnInit, ViewChild } from '@angular/core';
import { GameSessionSettings, Category } from '../game';
import { CoordinationRestService } from '../coordination-rest.service';
import { MatPaginator, MatTableDataSource } from '@angular/material';

@Component({
  selector: 'app-game-session-settings',
  templateUrl: './game-session-settings.component.html',
  styleUrls: ['./game-session-settings.component.css']
})
export class GameSessionSettingsComponent implements OnInit {

  constructor(private rest : CoordinationRestService) { }

  @ViewChild(MatPaginator) paginator: MatPaginator;

  dataSource = new MatTableDataSource<Category>();
  columnsToDisplay = ['categoryName','add'];

  categories : Array<Category> = [];
  categoriesDatasource = new MatTableDataSource<Category>(this.categories);
  selectedCategoriesColumns = ['categoryName', 'delete'];

  gameSessionSettings : GameSessionSettings;

  ngOnInit() {
    this.rest.getCategories().subscribe((result) => {
      this.dataSource = new MatTableDataSource(result);
      this.dataSource.paginator = this.paginator;
    });
    this.rest.getGameSessionDefaultSettings().subscribe((result) => {
      this.gameSessionSettings = result;
      console.log(this.gameSessionSettings);
    });
  }

  addCategory(category) {
    this.categories.push(category);
    this.categoriesDatasource._updateChangeSubscription();
    this.gameSessionSettings.categories = this.categories;
    this.rest.addOrUpdateGameSessionSettings(this.gameSessionSettings).subscribe(data => {
			console.log(data);
		});
  }

  deleteCategory(index) {
    console.log(event);
    this.categories.splice(index, 1);
    this.categoriesDatasource._updateChangeSubscription();
    this.gameSessionSettings.categories = this.categories;
    this.rest.addOrUpdateGameSessionSettings(this.gameSessionSettings).subscribe(data => {
			console.log(data);
		});
  }


}
