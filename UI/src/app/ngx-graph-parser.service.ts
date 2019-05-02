import { Injectable } from '@angular/core';
import { Game, Edge, GameComponent, Node } from "./game";

@Injectable({
  providedIn: 'root'
})
export class NgxGraphParserService {
	
  constructor() { }
  
  parseGraphJSON(data) {
		let json = JSON.parse(data);
		let nodes = [];
		let edges = [];
		
		json.nodes.forEach(function (value) {
			nodes.push(new Node(value.nodeId, "", value.position));
		});

		json.edges.forEach(function (value) {
			edges.push(new Edge(value.leftNode, value.rightNode, ""));
		});
		
		return {nodes: nodes, links: edges};
	}
	
	serializeGraphJSON(json) {
		let nodes = [];
		let edges = [];
		console.log(json);
		
		json.nodes.forEach(function (value) {
			nodes.push({nodeId: value.id, alignment: "", position: value.position});
		});

		json.links.forEach(function (value) {
			edges.push({edgeId: "", leftNode: value.source, rightNode: value.target});
		});
		
		return {'gameDataObject' : JSON.stringify({nodes: nodes, edges: edges})};
	}
}
