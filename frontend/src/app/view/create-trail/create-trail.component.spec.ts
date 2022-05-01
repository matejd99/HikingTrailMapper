import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateTrailComponent } from './create-trail.component';

describe('CreateTrailComponent', () => {
  let component: CreateTrailComponent;
  let fixture: ComponentFixture<CreateTrailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateTrailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateTrailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
