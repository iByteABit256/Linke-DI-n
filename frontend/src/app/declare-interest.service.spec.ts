import { TestBed } from '@angular/core/testing';

import { DeclareInterestService } from './declare-interest.service';

describe('DeclareInterestService', () => {
  let service: DeclareInterestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DeclareInterestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
