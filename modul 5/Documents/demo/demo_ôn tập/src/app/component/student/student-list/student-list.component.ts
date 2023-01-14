import {Component, OnInit} from '@angular/core';
import {Student} from "../../../model/student";
import {StudentService} from "../../../service/student.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  temp: Student = {point: 0};
  students: Student[] = []

  constructor(private studentService: StudentService, private router: Router) {
    this.students = this.studentService.getAll();
  }

  ngOnInit(): void {
  }

  saveStudent(event: any) {
    this.studentService.saveStudent(event);
  }

  showPageCreate() {
    this.router.navigateByUrl("/student/create")
  }

  showInfo(id: number) {
    this.router.navigate(["/student/detail", id]);
  }
}
