import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceDetailCommandeComponent } from './service-detailcommande.component';

describe('ServiceDetailCommandeComponent', () => {
  let component: ServiceDetailCommandeComponent;
  let fixture: ComponentFixture<ServiceDetailCommandeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ServiceDetailCommandeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ServiceDetailCommandeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
