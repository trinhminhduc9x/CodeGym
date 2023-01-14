import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Task} from './task';
import {TaskServiceService} from './service/task-service.service';
import {FormBuilder, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {

  tasks: Task[];
  rfTask: FormGroup;
  // tslint:disable-next-line:variable-name
  constructor(private _httpClient: HttpClient, private _taskService: TaskServiceService, private _formBuilder: FormBuilder) { }
  ngOnInit(): void {
    this.rfTask = this._formBuilder.group({
      taskName: [''],
      status: [true]
    });
    this._taskService.findAll().subscribe(data => {
      this.tasks = data;
    });
  }

  deleteTask(id: number) {
    this._taskService.remove(id).subscribe(() => {
      this._taskService.findAll().subscribe(data => {
        this.tasks = data;
      });
      console.log('remove ok!');
    });
  }

  createTask() {
    if (this.rfTask.value.taskName) {
      this._taskService.createTask({name: this.rfTask.value.taskName,
        status: this.rfTask.value.status}).subscribe( task => {
        this._taskService.findAll().subscribe(data => {
          this.tasks = data;
        });
        console.log('create task: ', task);
      });
    }
  }

  doTask(task: Task) {
    task.status = !task.status;
    console.log(task);
    this._taskService.update(task).subscribe(value => {
      this._taskService.findAll().subscribe(data => {
        this.tasks = data;
      });
      console.log('update ok');
    });
  }
}
