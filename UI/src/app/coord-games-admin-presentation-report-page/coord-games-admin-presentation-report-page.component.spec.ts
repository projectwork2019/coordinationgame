import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CoordGamesAdminPresentationReportPageComponent } from './coord-games-admin-presentation-report-page.component';

describe('CoordGamesAdminPresentationReportPageComponent', () => {
  let component: CoordGamesAdminPresentationReportPageComponent;
  let fixture: ComponentFixture<CoordGamesAdminPresentationReportPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CoordGamesAdminPresentationReportPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CoordGamesAdminPresentationReportPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
