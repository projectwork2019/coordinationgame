import { Component, OnInit, ViewChild, Input } from '@angular/core';
import { CoordinationRestService } from '../coordination-rest.service';
import { ShowGraphComponent } from '../show-graph/show-graph.component';
import { Routes, RouterModule, Router} from '@angular/router'
import { Selection } from '../game';
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
	
	isDataAvailable:boolean = false;
	selections : any[] = [];
	gameNo : number = 1;
        value: number = 1; //for slider
        numberOfGames: number = 10;
	
	constructor(private rest: CoordinationRestService, private router:Router) {}

	ngOnInit() {
		this.loadGame();
	}
	
	loadGame(){
		this.rest.getGames().subscribe(data => {
			this.graph = data[Math.floor(Math.random()*data.length)];
                        console.log(this.graph);
			this.isDataAvailable = true;
			this.graphComponent.updateChart();
		});
	}
	
	confirmSelection() {
		let selectedNode = this.graphComponent.selectedNode;
		console.log(selectedNode);
		let selection = new Selection(Number(selectedNode.id), this.value, this.graphComponent.graph.id);
		console.log(selection);
                
                if(this.gameNo == 1 ){ 
                    
                    //let dateFormat = require('dateformat');
                    let now = new Date();
                    
                    this.rest.postAnswers(now).subscribe(data => {
						console.log(data);
					});
                }
                
		//this.selections.push(this.graphComponent.selectedNode);
                this.selections.push(selection);
                
                
                
                
		if(this.gameNo == this.numberOfGames ){
			
			this.rest.postSession(this.selections).subscribe(data => {
				console.log(data);
			});
			/*
            this.rest.postSession(this.selections);
            console.log(this.selections);*/
			this.router.navigate(['/coord-games-feedback-page']);
		}
		else {
			this.gameNo = this.gameNo + 1;
			this.loadGame();
		}
	}
        
	
        options: Options = {
             floor: 1,
             ceil: 5,
             showTicks: true,
             showTicksValues: true
          };
}
