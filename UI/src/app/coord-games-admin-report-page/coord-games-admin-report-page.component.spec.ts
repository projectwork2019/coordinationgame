import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CoordGamesAdminReportPageComponent } from './coord-games-admin-report-page.component';

describe('CoordGamesAdminReportPageComponent', () => {
  let component: CoordGamesAdminReportPageComponent;
  let fixture: ComponentFixture<CoordGamesAdminReportPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CoordGamesAdminReportPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CoordGamesAdminReportPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
