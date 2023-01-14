import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Customer} from '../../model/customer/customer';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {

  customer: Customer | undefined;
  fomReactive: FormGroup;

  @Output()
  eventCreate = new EventEmitter();

  constructor() {
    this.fomReactive = new FormGroup({
      id: new FormControl('', [Validators.required, Validators.min(0)]),
      name: new FormControl('', [Validators.required, Validators.minLength(5), Validators.maxLength(50)]),
      idCard: new FormControl('', [Validators.required, Validators.pattern('[0-9]{9}|[0-9]{12}')]),
      dayOfBirth: new FormControl('', [Validators.required]),
      phoneNumber: new FormControl('', [Validators.required, Validators.pattern('[0][0-9]{9}')]),
      address: new FormControl('', [Validators.required, Validators.minLength(5), Validators.maxLength(100)]),
      email: new FormControl('',[Validators.required])
    });
  }

  ngOnInit(): void {
  }

  save() {
  }

}
