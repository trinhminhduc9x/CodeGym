import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Task} from '../task';
import {Observable} from 'rxjs';
import {environment} from '../../../environments/environment';
@Injectable({
  providedIn: 'root'
})
export class TaskServiceService {

  constructor(private _httpClient: HttpClient) { }
  save(task: Task): Observable<Task> {
    return this._httpClient.post<Task>(environment.URL_API_ToDo, task);
  }
  findAll(): Observable<Task[]> {
    return this._httpClient.get<Task[]>(environment.URL_API_ToDo);
  }

  remove(id: number): Observable<void> {
    return this._httpClient.delete<void>(environment.URL_API_ToDo + '/' + id);
  }

  createTask(task: {name: string[]; status: any}): Observable<Task> {
    return this._httpClient.post<Task>(environment.URL_API_ToDo, task);
  }

  update(task: Task): Observable<Task> {
    return this._httpClient.put<Task>(environment.URL_API_ToDo + '/' + task.id, task);
  }
}
