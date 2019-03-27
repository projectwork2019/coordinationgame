import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CoordGamesAccessDeniedPageComponent } from './coord-games-access-denied-page.component';

describe('CoordGamesAccessDeniedPageComponent', () => {
  let component: CoordGamesAccessDeniedPageComponent;
  let fixture: ComponentFixture<CoordGamesAccessDeniedPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CoordGamesAccessDeniedPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CoordGamesAccessDeniedPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
