import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-foo-bar-quix-form',
  templateUrl: './foo-bar-quix-form.component.html'
})
export class FooBarQuixFormComponent implements OnInit {
  @Output() submitNumberOutput = new EventEmitter<number>();
  fooBarQuixForm: FormGroup;

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.fooBarQuixForm = this.formBuilder.group({
      inputNumber: ['', Validators.required]
    });
  }

  submitNumber(): void {
    if (this.fooBarQuixForm.valid) {
      const inputNumber = this.fooBarQuixForm.controls.inputNumber.value;
      this.submitNumberOutput.emit(inputNumber);
      this.fooBarQuixForm.reset();
    }
  }

}
