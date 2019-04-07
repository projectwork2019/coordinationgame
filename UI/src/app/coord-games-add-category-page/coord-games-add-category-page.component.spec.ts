import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CoordGamesAddCategoryPageComponent } from './coord-games-add-category-page.component';

describe('CoordGamesAddCategoryPageComponent', () => {
  let component: CoordGamesAddCategoryPageComponent;
  let fixture: ComponentFixture<CoordGamesAddCategoryPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CoordGamesAddCategoryPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CoordGamesAddCategoryPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
