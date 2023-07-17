import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewBusinessDialogComponent } from './view-business-dialog.component';

describe('ViewBusinessDialogComponent', () => {
  let component: ViewBusinessDialogComponent;
  let fixture: ComponentFixture<ViewBusinessDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewBusinessDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewBusinessDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
