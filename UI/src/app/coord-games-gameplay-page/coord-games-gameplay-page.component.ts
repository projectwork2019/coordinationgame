import { Component, OnInit, ViewChild, Input } from '@angular/core';
import { CoordinationRestService } from '../coordination-rest.service';
import { ShowGraphComponent } from '../show-graph/show-graph.component';
import { Routes, RouterModule, Router} from '@angular/router'
import { Selection } from '../game';

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
		console.log(this.graphComponent);
		let selection = new Selection(selectedNode.id, selectedNode.id, this.graphComponent.graph.id);
		console.log(selection);
		this.selections.push(this.graphComponent.selectedNode);
		if(this.gameNo == 10 ){
			this.router.navigate(['/coord-games-feedback-page']);
		}
		else {
			this.gameNo = this.gameNo + 1;
			this.loadGame();
		}
	}
	
}
