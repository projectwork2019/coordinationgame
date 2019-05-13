/*
 * Component for displaying the graph
 */
import { Component, Input, OnInit, ViewEncapsulation, OnChanges } from '@angular/core';
import { Game, Edge, GameComponent, Node, NodeReport } from "../game";
import * as shape from 'd3-shape';
import { NgxGraphModule } from '@swimlane/ngx-graph';
import { Subject } from 'rxjs';
import { CoordinationRestService } from '../coordination-rest.service';
import { NgxGraphParserService } from '../ngx-graph-parser.service';

@Component({
  selector: 'app-show-graph',
  templateUrl: './show-graph.component.html',
  styleUrls: ['./show-graph.component.css'],
  providers: [ CoordinationRestService, NgxGraphParserService ]
})
export class ShowGraphComponent implements OnInit {
	
	@Input() childMessage: string;
	@Input() reportData: Array<NodeReport>;

	curve = shape.curveBundle.beta(0);
	hierarchialGraph;
	
	//String:
	//"LR" = Left to right (default)
	//"RL" = Right to left (mirrored)
	orientation = "LR";
	mirrored = false;
	first = true;
	graph;
	selectedNode;
	
	update$: Subject<any> = new Subject();

	constructor(private http: CoordinationRestService, private ngxParser: NgxGraphParserService) {}

	ngOnInit() {
		console.log(this.reportData);
		if(this.mirrored) {
			this.orientation = "RL";
		} else {
			this.orientation = "LR";
		}
		this.graph = this.childMessage;
		this.hierarchialGraph = JSON.parse(this.graph.gameDataObject);
		//this.hierarchialGraph = this.ngxParser.parseGraphJSON(this.graph.gameDataObject);
		
		this.updateChart(this.mirrored);
		
	}
	
	ngOnChanges() {
		if(this.mirrored) {
			this.orientation = "RL";
		} else {
			this.orientation = "LR";
		}
		this.graph = this.childMessage;
		this.hierarchialGraph = JSON.parse(this.graph.gameDataObject);
		//this.hierarchialGraph = this.ngxParser.parseGraphJSON(this.graph.gameDataObject);
		this.updateChart(this.mirrored);
	}	
	
	// Update function
	updateChart(mirrored: boolean){
		this.mirrored = mirrored;
		this.update$.next(true);
	}
	
	selectNode(node) {
		if(this.selectedNode != null){
			this.selectedNode.selected = false;
		}
		if(!this.mirrored && node.edges.length == 0){
		// TODO: Making node non-clickable should be handled better. This solution won't work if graph with more layers than 2 need to be playable
			this.selectedNode = node;
			node.selected = true;
		} else if(this.mirrored && node.edges.length != 0) {
			this.selectedNode = node;
			node.selected = true;
		}
	}

	getTooltip(node){
		if(this.reportData){
			let tooltip : string;
			this.reportData.forEach(element => {
				if(element.nodeId == node.id){
					tooltip = "Frequency: " + element.frequency + ", " + element.percentChosen + "%";
				}
				
			});
			return tooltip;
		}
		return "";
	}

	isReport(){
		if(this.reportData) {
			return true;
		}
		return false;
	}
	
	
	
}
