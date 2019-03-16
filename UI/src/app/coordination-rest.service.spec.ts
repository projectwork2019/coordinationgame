import { TestBed } from '@angular/core/testing';

import { CoordinationRestService } from './coordination-rest.service';

describe('CoordinationRestService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CoordinationRestService = TestBed.get(CoordinationRestService);
    expect(service).toBeTruthy();
  });
});
