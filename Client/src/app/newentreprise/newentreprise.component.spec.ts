import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewentrepriseComponent } from './newentreprise.component';

describe('NewentrepriseComponent', () => {
  let component: NewentrepriseComponent;
  let fixture: ComponentFixture<NewentrepriseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [NewentrepriseComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(NewentrepriseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
