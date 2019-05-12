import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GameSessionSettingsComponent } from './game-session-settings.component';

describe('GameSessionSettingsComponent', () => {
  let component: GameSessionSettingsComponent;
  let fixture: ComponentFixture<GameSessionSettingsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GameSessionSettingsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GameSessionSettingsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
