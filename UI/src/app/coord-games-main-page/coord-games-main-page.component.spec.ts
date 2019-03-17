import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CoordGamesMainPageComponent } from './coord-games-main-page.component';

describe('CoordGamesMainPageComponent', () => {
  let component: CoordGamesMainPageComponent;
  let fixture: ComponentFixture<CoordGamesMainPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CoordGamesMainPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CoordGamesMainPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
