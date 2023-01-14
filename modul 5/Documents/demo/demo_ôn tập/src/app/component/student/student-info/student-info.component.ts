import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {Student} from "../../../model/student";
import {ActivatedRoute} from "@angular/router";
import {StudentService} from "../../../service/student.service";

@Component({
  selector: 'app-student-info',
  templateUrl: './student-info.component.html',
  styleUrls: ['./student-info.component.css']
})
export class StudentInfoComponent implements OnInit, OnChanges {
  student: Student | null = {point: 0}

  constructor(private activatedRoute: ActivatedRoute,
              private studentService: StudentService) {
    this.activatedRoute.paramMap.subscribe(data => {
      const id = data.get("id");
      if (id != null) {
        this.student = this.studentService.findById(parseInt(id));
      }
    }, error => {

    }, () => {

    })
  }

  ngOnChanges(changes: SimpleChanges): void {
    console.log(changes)
  }

  ngOnInit(): void {
  }
}
