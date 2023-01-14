import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Category} from '../model/category';
@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  URL_CATEGORY = 'http://localhost:3000/category';
  constructor(private  httpClient: HttpClient) { }

  getAll(): Observable<Category[]> {
    return this.httpClient.get<Category[]>(this.URL_CATEGORY );
  }

  saveCategory(category: Category): Observable<Category> {
    return this.httpClient.post<Category>(this.URL_CATEGORY , category);
  }

  findById(id: number ): Observable<Category> {
    return this.httpClient.get<Category>(`${(this.URL_CATEGORY)}/${id}`);
  }

  updateCategory(id: number , category: Category): Observable<Category> {
    return this.httpClient.patch<Category>(`${(this.URL_CATEGORY)}/${id}`, category);
  }

  deleteCategory(id: number ): Observable<Category> {
    return this.httpClient.delete<Category>(`${this.URL_CATEGORY}/${id}`);
  }
}
