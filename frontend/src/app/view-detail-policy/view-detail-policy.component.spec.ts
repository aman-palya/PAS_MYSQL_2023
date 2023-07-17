import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewDetailPolicyComponent } from './view-detail-policy.component';

describe('ViewDetailPolicyComponent', () => {
  let component: ViewDetailPolicyComponent;
  let fixture: ComponentFixture<ViewDetailPolicyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewDetailPolicyComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewDetailPolicyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
