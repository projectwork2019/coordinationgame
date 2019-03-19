import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { slideInAnimation } from './animations';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.css'],
  animations: [ slideInAnimation ]
})
export class AppComponent {
  getAnimationData(outlet: RouterOutlet) {
    return outlet && outlet.activatedRouteData && outlet.activatedRouteData['animation'];
  }
}

/*
export class AppComponent implements OnInit{
	
	graph = {};
	isDataAvailable:boolean = false;
	
	constructor(private rest: CoordinationRestService) {}

	ngOnInit() {
		this.rest.getGame(204).subscribe((data: {}) => {
			this.graph = data.gameDataObject;
			this.isDataAvailable = true;
			console.log(this.graph);
		});
	}
	
	getTest() {
		this.rest.getGames().subscribe((data: {}) => {
			console.log(data);
		});
	}
	
	postTest() {
		let testData = { gameDataObject : "" };
		testData.gameDataObject = "asd";
		this.rest.addOrEditGame(testData).subscribe( data => {
			console.log(data);
		})
	}
	/*title = 'coordgames';
	currentNode = 0;
	currentComponent : GameComponent;
	curve = shape.curveBundle.beta(0);
	gamenodes = [];
	edges = [];
	hierarchialGraph = {nodes: this.gamenodes, links: this.edges}
	
	component : GameComponent = {
		edges : []
	}
	game : Game = {
		name : "Testi",
		components : []
	}
	
	update$: Subject<any> = new Subject();

	constructor(private http: HttpClient) {}
>>>>>>> Stashed changes

/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/