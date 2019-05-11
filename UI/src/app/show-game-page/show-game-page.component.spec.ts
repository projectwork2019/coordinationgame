import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowGamePageComponent } from './show-game-page.component';

describe('ShowGamePageComponent', () => {
  let component: ShowGamePageComponent;
  let fixture: ComponentFixture<ShowGamePageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowGamePageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowGamePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
