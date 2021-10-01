import { TestBed } from '@angular/core/testing';

import { JobOfferApplicationService } from './job-offer-application.service';

describe('JobOfferApplicationService', () => {
  let service: JobOfferApplicationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(JobOfferApplicationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
