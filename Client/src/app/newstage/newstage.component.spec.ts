import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewstageComponent } from './newstage.component';

describe('NewstageComponent', () => {
  let component: NewstageComponent;
  let fixture: ComponentFixture<NewstageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [NewstageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(NewstageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
