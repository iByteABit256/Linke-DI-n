import { TestBed } from '@angular/core/testing';

import { RecommendedPostsService } from './recommended-posts.service';

describe('RecommendedPostsService', () => {
  let service: RecommendedPostsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RecommendedPostsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
