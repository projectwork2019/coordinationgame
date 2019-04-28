import { TestBed } from '@angular/core/testing';

import { NgxGraphParserService } from './ngx-graph-parser.service';

describe('NgxGraphParserService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: NgxGraphParserService = TestBed.get(NgxGraphParserService);
    expect(service).toBeTruthy();
  });
});
