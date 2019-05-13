/*
 * The gameplay page. 
 */
import { Component, OnInit, ViewChild, Input } from '@angular/core';
import { CoordinationRestService } from '../coordination-rest.service';
import { ShowGraphComponent } from '../show-graph/show-graph.component';
import { CoordGamesFeedbackPageComponent } from '../coord-games-feedback-page/coord-games-feedback-page.component';
import { Routes, RouterModule, Router, NavigationExtras} from '@angular/router'
import { Selection, GameSession } from '../game';
//import { DateFormat } from '@angular/dateformat'

import { Options } from 'ng5-slider';

@Component({
  selector: 'app-coord-games-gameplay-page',
  templateUrl: './coord-games-gameplay-page.component.html',
  styleUrls: ['./coord-games-gameplay-page.component.css']
})
export class CoordGamesGameplayPageComponent implements OnInit {
	
	@ViewChild(ShowGraphComponent) graphComponent:ShowGraphComponent;
	graph : any = {};
	@Input() childMessage : any = this.graph;


	@ViewChild(CoordGamesFeedbackPageComponent) feedbackComponennt:CoordGamesFeedbackPageComponent;
	@Input() 
	gameSession : GameSession = new GameSession();
	
	
	games : any[];
	
	feedback:boolean = false;
	showGameplay = true;
	isDataAvailable:boolean = false;
	selections : any[] = [];
	gameNo : number = 1;
        value: number = 1; //for slider
        numberOfGames: number = 10;
	
	constructor(private rest: CoordinationRestService, private router:Router) {}

	ngOnInit() {
		this.loadGame();
		this.gameSession.selections = this.selections;
	}
	
	loadGame(){
		if(this.games == null){
			this.rest.getGamesForSession().subscribe(data => {
				this.games = data;
				console.log(this.games);
				//this.graph = data[Math.floor(Math.random()*data.length)];
					//		console.log(this.graph);
				//this.graph = data[gameNo-1].games.gameDataObject;
				//console.log(this.graph);
				//this.isDataAvailable = true;
				//this.graphComponent.updateChart();
				this.graph = this.games[this.gameNo-1].games;
				console.log(this.graph);
				this.isDataAvailable = true;
				this.numberOfGames = this.games.length;
				this.graphComponent.updateChart(this.games[this.gameNo-1].mirror);
			});
		} else {
			this.graph = this.games[this.gameNo-1].games;
			console.log(this.graph);
			this.isDataAvailable = true;
			this.graphComponent.updateChart(this.games[this.gameNo-1].mirror);
		}
		
	}
	
	confirmSelection() {
		let selectedNode = this.graphComponent.selectedNode;
		console.log(selectedNode);
		let selection = new Selection(Number(selectedNode.id), this.value, this.games[this.gameNo-1].presentationId);
		console.log(selection);
                
                if(this.gameNo == 1 ){ 
                    
                    //let dateFormat = require('dateformat');
                    let now = new Date().toISOString();
					console.log(now);
                    this.gameSession.startTimestamp = now;
                    /*this.rest.postAnswers(this.gameSession).subscribe(data => {
						console.log(data);
					});*/
                }
                
		//this.selections.push(this.graphComponent.selectedNode);
                this.selections.push(selection);
                
                
                
                
		if(this.gameNo == this.numberOfGames ){
			
			this.gameSession.endTimestamp = new Date().toISOString();
			/*this.rest.postSession(this.gameSession).subscribe(data => {
				console.log(data);
			});*/
			/*
            this.rest.postSession(this.selections);
			console.log(this.selections);*/
			//let navigationExtras : NavigationExtras = { queryParams : { "json" : JSON.stringify(this.gameSession) } };
			//this.router.navigate(['/coord-games-feedback-page'], navigationExtras);
			console.log("FEEDBACK TRUE");
			this.feedback = true;
			this.showGameplay = false;
		}
		else {
			this.gameNo = this.gameNo + 1;
			this.loadGame();
		}
	}
        
	//slider options
        options: Options = {
             floor: 1,
             ceil: 5,
             showTicks: true,
             showTicksValues: true
          };
}
