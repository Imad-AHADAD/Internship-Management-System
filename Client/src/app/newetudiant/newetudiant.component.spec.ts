import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewetudiantComponent } from './newetudiant.component';

describe('NewetudiantComponent', () => {
  let component: NewetudiantComponent;
  let fixture: ComponentFixture<NewetudiantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [NewetudiantComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(NewetudiantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
