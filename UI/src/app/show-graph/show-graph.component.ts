import { Component, Input, OnInit, ViewEncapsulation, OnChanges } from '@angular/core';
import { Game, Edge, GameComponent, Node } from "../game";
import * as shape from 'd3-shape';
import { NgxGraphModule } from '@swimlane/ngx-graph';
import { Subject } from 'rxjs';
import { CoordinationRestService } from '../coordination-rest.service';

@Component({
  selector: 'app-show-graph',
  templateUrl: './show-graph.component.html',
  styleUrls: ['./show-graph.component.css']
})
export class ShowGraphComponent implements OnInit {
	
	@Input() childMessage: string;

	curve = shape.curveBundle.beta(0);
	hierarchialGraph;
	
	graph;
	selectedNode;
	
	update$: Subject<any> = new Subject();

	constructor(private http: CoordinationRestService) {}

	ngOnInit() {
		this.graph = this.childMessage;
		this.hierarchialGraph = JSON.parse(this.graph.gameDataObject);
		this.updateChart();
	}
	
	ngOnChanges() {
		this.graph = this.childMessage;
		this.hierarchialGraph = JSON.parse(this.graph.gameDataObject);
		this.updateChart();
	}	
	
	// Update function
	updateChart(){
		this.update$.next(true);
	}
	
	selectNode(node) {
		if(this.selectedNode != null){
			this.selectedNode.selected = false;
		}
		this.selectedNode = node;
		node.selected = true;
		console.log(node.selected);
	}
	
}
