import {Injectable} from '@angular/core';
import {Student} from "../model/student";

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  students: Student[] = [
    {id: 1, name: "haiTT", dateOfBirth: "1998-01-01", point: 11},
    {id: 2, name: "TrungDC", dateOfBirth: "1993-01-01", point: 8},
    {id: 3, name: "TrungDP", dateOfBirth: "1985-01-01", point: 9.5},
  ]

  constructor() {
  }

  getAll() {
    return this.students;
  }

  saveStudent(event: any) {
    this.students.push(event)
  }

  findById(number: number): Student | null {
    let temp = this.students.filter(element => element.id === number);
    if (temp.length == 0) {
      return null;
    }
    return temp[0];
  }

  deleteById(id: number | undefined) {
    if (id != undefined) {
      let student = this.findById(id);
      if (student != null) {
        let length = this.students.length
        for (let i = 0; i < length; i++) {
          if (student.id == this.students[i].id) {
            this.students.splice(i, 1);
            break;
          }

        }
      }
    }
  }
}
