import { TestBed } from '@angular/core/testing';

import { GetConnectedService } from './get-connected.service';

describe('GetConnectedService', () => {
  let service: GetConnectedService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GetConnectedService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
