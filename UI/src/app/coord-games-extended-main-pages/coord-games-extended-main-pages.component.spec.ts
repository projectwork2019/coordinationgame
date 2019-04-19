import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CoordGamesExtendedMainPagesComponent } from './coord-games-extended-main-pages.component';

describe('CoordGamesExtendedMainPagesComponent', () => {
  let component: CoordGamesExtendedMainPagesComponent;
  let fixture: ComponentFixture<CoordGamesExtendedMainPagesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CoordGamesExtendedMainPagesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CoordGamesExtendedMainPagesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
