import { Injectable } from '@angular/core';
import {Category} from "./product/category";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(
    private httpClient: HttpClient
  ) { }

  getAll(): Observable<Category[]> {
    return this.httpClient.get<Category[]>(environment.apiUrlCategory)
  }

  findCategoryById(categoryId: number): Observable<Category> {
    return this.httpClient.get<Category>(environment.apiUrlCategory + '/' + categoryId)
  }
}
