import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { Game, Edge, GameComponent, Node } from "../game";
import * as shape from 'd3-shape';
import { NgxGraphModule } from '@swimlane/ngx-graph';
import { Subject } from 'rxjs';
import { CoordinationRestService } from '../coordination-rest.service';


@Component({
  selector: 'graph-editor',
  templateUrl: './graph-editor.component.html',
  styleUrls: ['./graph-editor.component.css']
})
export class GraphEditorComponent implements OnInit {
	title = 'coordgames';
	currentNode = 0;
	currentComponent : GameComponent;
	curve = shape.curveBundle.beta(0);
	gamenodes = [];
	edges = [];
	hierarchialGraph = {nodes: this.gamenodes, links: this.edges}
	
	edgeFrom : Node;
	
	component : GameComponent = {
		edges : []
	}
	game : Game = {
		name : "Testi",
		components : []
	}
	
	update$: Subject<any> = new Subject();

	constructor(private http: CoordinationRestService) {}

	ngOnInit() { 
		this.currentComponent = this.component;
		this.game.name = "";
		this.game.components.push(this.component);
		console.log(this.game.components);	
	}
	
	save() {
		this.http.addOrEditGame({'gameDataObject' : JSON.stringify(this.hierarchialGraph)}).subscribe(data => {
			console.log(data);
		});
	}
	
	addLink(n : Node) {
		let e : Edge = new Edge(n.id, "", "");
		n.edges.push(e);
		this.edges.push(e);
	}
	
	addNode(){
		this.gamenodes.push(new Node(this.currentNode.toString(), this.currentNode.toString(), "x" + this.currentNode.toString()));
		this.edges.push([]);
		this.currentNode = this.currentNode + 1;
		this.hierarchialGraph.nodes = this.gamenodes;
		this.hierarchialGraph.links = this.edges;
		this.updateChart();
		console.log(JSON.stringify(this.gamenodes));
		console.log(JSON.stringify(this.edges));
		
	}
	submitGame() {
		console.log(JSON.stringify(this.game));
	}
	
	addEdge(node : Node) {
		if(this.edgeFrom != null && this.edgeFrom.id != node.id) {
			let e : Edge = new Edge(this.edgeFrom.id, node.id, "");
			node.edges.push(e);
			this.edges.push(e);
			this.updateChart();
			this.edgeFrom = null;
		}
		else {
			this.edgeFrom = node;
		}
	}
	// Update function
	updateChart(){
		this.update$.next(true);
	}
}
