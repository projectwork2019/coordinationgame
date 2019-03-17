import { Component, Input, OnInit, ViewEncapsulation } from '@angular/core';
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
	hierarchialGraph = {};
	
	update$: Subject<any> = new Subject();

	constructor(private http: CoordinationRestService) {}

	ngOnInit() {
		console.log(this.childMessage);
		console.log(JSON.parse(this.childMessage));
		this.hierarchialGraph = JSON.parse(this.childMessage);
		this.updateChart();
	}
	// Update function
	updateChart(){
		this.update$.next(true);
	}
}
