import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CoordGamesAdminChooseFromListPageComponent } from './coord-games-admin-choose-from-list-page.component';

describe('CoordGamesAdminChooseFromListPageComponent', () => {
  let component: CoordGamesAdminChooseFromListPageComponent;
  let fixture: ComponentFixture<CoordGamesAdminChooseFromListPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CoordGamesAdminChooseFromListPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CoordGamesAdminChooseFromListPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
