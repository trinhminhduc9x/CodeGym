import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RangtingComponent } from './rangting.component';

describe('RangtingComponent', () => {
  let component: RangtingComponent;
  let fixture: ComponentFixture<RangtingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RangtingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RangtingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
