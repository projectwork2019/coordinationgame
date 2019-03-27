import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CoordGamesLogoutPageComponent } from './coord-games-logout-page.component';

describe('CoordGamesLogoutPageComponent', () => {
  let component: CoordGamesLogoutPageComponent;
  let fixture: ComponentFixture<CoordGamesLogoutPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CoordGamesLogoutPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CoordGamesLogoutPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
