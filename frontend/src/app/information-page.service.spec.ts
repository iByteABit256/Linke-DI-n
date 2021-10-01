import { TestBed } from '@angular/core/testing';

import { InformationPageService } from './information-page.service';

describe('InformationPageService', () => {
  let service: InformationPageService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InformationPageService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
