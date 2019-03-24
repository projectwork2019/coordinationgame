import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CoordGamesFeedbackReceivedPageComponent } from './coord-games-feedback-received-page.component';

describe('CoordGamesFeedbackReceivedPageComponent', () => {
  let component: CoordGamesFeedbackReceivedPageComponent;
  let fixture: ComponentFixture<CoordGamesFeedbackReceivedPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CoordGamesFeedbackReceivedPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CoordGamesFeedbackReceivedPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
