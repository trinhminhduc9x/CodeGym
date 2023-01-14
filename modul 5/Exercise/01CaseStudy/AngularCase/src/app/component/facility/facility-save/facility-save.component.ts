import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Customer} from '../../model/customer/customer';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Facility} from '../../model/facility/Facility';

@Component({
  selector: 'app-facility-save',
  templateUrl: './facility-save.component.html',
  styleUrls: ['./facility-save.component.css']
})
export class FacilitySaveComponent implements OnInit {
  facilityForm: FormGroup = new FormGroup({});
  regexNumber: RegExp = /[0-9]*/;
  constructor(private formBuilder: FormBuilder) {
    this.facilityForm = formBuilder.group({
      id: ['', [Validators.required]],
      name: ['', [Validators.required]],
      area: ['', [Validators.required, Validators.min(0), Validators.pattern(this.regexNumber)]],
      cost: ['', [Validators.required, Validators.min(0), Validators.pattern(this.regexNumber)]],
      maxPeople: ['', [Validators.required, Validators.min(0), Validators.pattern(this.regexNumber)]],
      facilityType: ['', [Validators.required]],
      rentType: ['', [Validators.required]]
    })
  }

  ngOnInit(): void {
  }

  submitFacility() {

  }
}
