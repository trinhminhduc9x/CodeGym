import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {Student} from "../../../model/student";
import {StudentService} from "../../../service/student.service";
import {Route, Router} from "@angular/router";

@Component({
  selector: 'app-student-delete',
  templateUrl: './student-delete.component.html',
  styleUrls: ['./student-delete.component.css']
})
export class StudentDeleteComponent implements OnInit, OnChanges {
  @Input()
  student: Student = {point: 0};

  constructor(private studentService: StudentService, private router: Router) { }

  ngOnInit(): void {
  }

  ngOnChanges(changes: SimpleChanges): void {
    // this.student = this.studentService.findById(this.student.id);
  }


  deleteStudent() {
    this.studentService.deleteById(this.student.id);
    document.getElementById('exampleModal')?.click();
  }
}
