import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RequestSampleComponent } from './request-sample.component';

describe('RequestSampleComponent', () => {
  let component: RequestSampleComponent;
  let fixture: ComponentFixture<RequestSampleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RequestSampleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RequestSampleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
