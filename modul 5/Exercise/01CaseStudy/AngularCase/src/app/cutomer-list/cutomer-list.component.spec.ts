import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CutomerListComponent } from './cutomer-list.component';

describe('CutomerListComponent', () => {
  let component: CutomerListComponent;
  let fixture: ComponentFixture<CutomerListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CutomerListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CutomerListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
