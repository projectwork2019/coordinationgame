import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CoordGamesGameplayPageComponent } from './coord-games-gameplay-page.component';

describe('CoordGamesGameplayPageComponent', () => {
  let component: CoordGamesGameplayPageComponent;
  let fixture: ComponentFixture<CoordGamesGameplayPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CoordGamesGameplayPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CoordGamesGameplayPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
