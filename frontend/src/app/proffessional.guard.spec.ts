import { TestBed } from '@angular/core/testing';

import { ProffessionalGuard } from './proffessional.guard';

describe('ProffessionalGuard', () => {
  let guard: ProffessionalGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(ProffessionalGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
