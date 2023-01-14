import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FacilitySaveComponent } from './facility-save.component';

describe('FacilitySaveComponent', () => {
  let component: FacilitySaveComponent;
  let fixture: ComponentFixture<FacilitySaveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FacilitySaveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FacilitySaveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
