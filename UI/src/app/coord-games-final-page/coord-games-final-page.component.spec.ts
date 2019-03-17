import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CoordGamesFinalPageComponent } from './coord-games-final-page.component';

describe('CoordGamesFinalPageComponent', () => {
  let component: CoordGamesFinalPageComponent;
  let fixture: ComponentFixture<CoordGamesFinalPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CoordGamesFinalPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CoordGamesFinalPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
