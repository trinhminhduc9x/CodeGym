import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Todo} from "../model/todo";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  constructor(private http: HttpClient) {
  }

  getAll(): Observable<Todo[]> {
    return this.http.get<Todo[]>(environment.api_url_todo);
  }

  saveTodo(todo: any ): Observable<Todo> {
    return this.http.post<Todo>(environment.api_url_todo, todo);
  }

  updateTodo(todo: { id: string; }): Observable<Todo> {
    return this.http.patch<Todo>(environment.api_url_todo + "/" + todo.id, todo);
  }
  deleteTodo(todo: { id: string; }): Observable<Todo>{
    return this.http.delete<Todo>(environment.api_url_todo+"/"+todo.id);
  }
}
