import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CoordGamesAdminGamesPageComponent } from './coord-games-admin-games-page.component';

describe('CoordGamesAdminGamesPageComponent', () => {
  let component: CoordGamesAdminGamesPageComponent;
  let fixture: ComponentFixture<CoordGamesAdminGamesPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CoordGamesAdminGamesPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CoordGamesAdminGamesPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
