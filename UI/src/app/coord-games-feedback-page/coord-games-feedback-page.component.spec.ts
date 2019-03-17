import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CoordGamesFeedbackPageComponent } from './coord-games-feedback-page.component';

describe('CoordGamesFeedbackPageComponent', () => {
  let component: CoordGamesFeedbackPageComponent;
  let fixture: ComponentFixture<CoordGamesFeedbackPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CoordGamesFeedbackPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CoordGamesFeedbackPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
