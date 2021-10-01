import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfHomepageComponent } from './prof-homepage.component';

describe('ProfHomepageComponent', () => {
  let component: ProfHomepageComponent;
  let fixture: ComponentFixture<ProfHomepageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfHomepageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfHomepageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
