import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CoordGamesAdminAddGamePageComponent } from './coord-games-admin-add-game-page.component';

describe('CoordGamesAdminAddGamePageComponent', () => {
  let component: CoordGamesAdminAddGamePageComponent;
  let fixture: ComponentFixture<CoordGamesAdminAddGamePageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CoordGamesAdminAddGamePageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CoordGamesAdminAddGamePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
