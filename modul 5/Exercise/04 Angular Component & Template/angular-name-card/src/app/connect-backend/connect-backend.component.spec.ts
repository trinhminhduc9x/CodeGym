import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConnectBackendComponent } from './connect-backend.component';

describe('ConnectBackendComponent', () => {
  let component: ConnectBackendComponent;
  let fixture: ComponentFixture<ConnectBackendComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConnectBackendComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ConnectBackendComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
