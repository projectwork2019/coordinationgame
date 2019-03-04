import { Component, OnInit } from '@angular/core';
import { Game, Edge, GameComponent } from "../game"
@Component({
  selector: 'app-games',
  templateUrl: './games.component.html',
  styleUrls: ['./games.component.css']
})
export class GamesComponent implements OnInit {
	edge : Edge = {
		e : [1,1]
	}
	component : GameComponent = {
		edges : []
	}
	game : Game = {
		name : "Testi",
		components : []
	}
	
	constructor() { }

	ngOnInit() { 
	this.game.name = "Vammasta paskaa";
	this.component.edges.push(this.edge);
	this.game.components.push(this.component);
	console.log(this.game.components);
	}
	
	
	
	



}
