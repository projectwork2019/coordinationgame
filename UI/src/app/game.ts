export class Game {
	name : string;
	components : Array<GameComponent>;
}

export class GameComponent {
	edges : Array<Edge>;
	constructor() {
		this.edges = [];
	}
}

export class Edge {
	source: string;
    target: string;
	label : string;
	constructor(source : string, target : string, label: label) {
		this.source = source;
		this.target = target;
		this.label = "";
	}/*
	constructor(){
		this.e = [];
	}*/
}

export class Node {
    id : string;
    position: string;
	label : string;
	edges : Array<Edge>;
	constructor(id : string, label : string, position : string) {
		this.id = id;
		this.label = label;
		this.position = position;
		this.edges = [];
	}
 }