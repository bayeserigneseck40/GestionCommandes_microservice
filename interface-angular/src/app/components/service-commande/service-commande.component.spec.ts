import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceCommandeComponent } from './service-commande.component';

describe('ServiceCommandeComponent', () => {
  let component: ServiceCommandeComponent;
  let fixture: ComponentFixture<ServiceCommandeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ServiceCommandeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ServiceCommandeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
