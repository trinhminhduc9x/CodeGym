import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Student} from "../../../model/student";
import {AbstractControl, FormControl, FormGroup, NgForm, Validators} from "@angular/forms";

@Component({
  selector: 'app-student-create',
  templateUrl: './student-create.component.html',
  styleUrls: ['./student-create.component.css']
})
export class StudentCreateComponent implements OnInit {
  student: Student = {point: 0};
  fromReactive: FormGroup;

  @Output()
  eventCreate = new EventEmitter();

  constructor() {
    //Lệnh gọi server
    this.fromReactive = new FormGroup({
      id: new FormControl("5", [Validators.required, Validators.min(0)]),
      name: new FormControl("", [Validators.required, Validators.minLength(3), Validators.maxLength(100)]),
      dateOfBirth: new FormControl(),
      point: new FormControl("")
    }, [this.validatePoint]);
  }

  ngOnInit(): void {

  }

  validatePoint(point: any) {
    if(point.controls.point.value <0) {
      return {"invalidPoint": true}
    }
    return null;
  }

  createStudent() {
    this.eventCreate.emit(this.student);
    this.student = {point: 0};
  }

  saveStudentWithTemplate(templateForm: NgForm) {
    console.log(templateForm)
    this.eventCreate.emit(templateForm.value)
  }

  saveStudentWithReactive() {
    if(this.fromReactive.valid) {
      this.eventCreate.emit(this.fromReactive.value);
    }
    console.log(this.fromReactive)
  }
}
