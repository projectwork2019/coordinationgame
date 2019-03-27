import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CoordGamesLoginFailedPageComponent } from './coord-games-login-failed-page.component';

describe('CoordGamesLoginFailedPageComponent', () => {
  let component: CoordGamesLoginFailedPageComponent;
  let fixture: ComponentFixture<CoordGamesLoginFailedPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CoordGamesLoginFailedPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CoordGamesLoginFailedPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
