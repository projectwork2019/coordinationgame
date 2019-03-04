import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { Game, Edge, GameComponent, Node } from "./game";
import * as shape from 'd3-shape';
import { NgxGraphModule } from '@swimlane/ngx-graph';
import { Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit{
	title = 'coordgames';
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

	ngOnInit() { 
		this.currentComponent = this.component;
		this.game.name = "";
		this.game.components.push(this.component);
		console.log(this.game.components);	
	}
	
	save() {
		this.http.post("http://httpbin.org/post", this.hierarchialGraph).subscribe(data => {
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
		if(this.currentNode > 0) {
			//this.edges.push(new Edge((this.currentNode - 1).toString() , this.currentNode.toString() , ""));
		}
		this.currentNode = this.currentNode + 1;
		this.hierarchialGraph.nodes = this.gamenodes;
		this.hierarchialGraph.links = this.edges;
		this.updateChart();
		console.log(JSON.stringify(this.gamenodes));
		console.log(JSON.stringify(this.edges));
		
	}
	
	addComponent(){
		this.currentComponent = new GameComponent();
		this.game.components.push(this.currentComponent);
		this.currentComponent.edges.push(new Edge());
	}
	
	submitGame() {
		console.log(JSON.stringify(this.game));
	}
	
	// Update function
	updateChart(){
		this.update$.next(true);
	}
}
