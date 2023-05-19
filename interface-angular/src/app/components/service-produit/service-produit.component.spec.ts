import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceProduitComponent } from './service-produit.component';

describe('ServiceProduitComponent', () => {
  let component: ServiceProduitComponent;
  let fixture: ComponentFixture<ServiceProduitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ServiceProduitComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ServiceProduitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
