/*
 * Custom classes.
 */
export class Category {
	name : string;
	categoryID : number;
        
        constructor(name : string, id : number) {
            this.name = name;
            this.categoryID = id;
	}
}

export class GameSessionSettings {
	name : string;
	id : string;
	categories : Array<Category>;
}

export class GameDisplay {
	name : string;
	gameObjectData : string;
}

export class CategoryDisplay {
	name : string;
	categoryObjectData : string;
}

export class Game {
	name : string;
	gameDataObject : string;
	categories: Array<Category>;
	//components : Array<GameComponent>;
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
	constructor(source : string, target : string, label: string) {
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
 
 export class Selection {
	selectedNode : number;
	confidence : number;
	presentationId : number;
	constructor(selectedNode : number, confidence : number, presentationId : number) {
		this.selectedNode = selectedNode; 
		this.confidence = confidence;
		this.presentationId = presentationId;
	}
 }
        
 export class FeedbackPageAnswers {
	firsTime : boolean;
	readResearch : boolean;
	constructor(firsTime : boolean, readResearch : boolean) {
		this.firsTime = firsTime;
		this.readResearch = readResearch;
	}
 }
	
export class GameSession {
	id: number;
	firstTime: boolean;
	prevKnowledge: boolean;
	startTimestamp: any;
	endTimestamp: any;
	selections : Array<Selection>;
}