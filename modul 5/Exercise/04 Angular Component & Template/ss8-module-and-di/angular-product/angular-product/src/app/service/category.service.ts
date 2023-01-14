import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Category} from "../model/category";

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private API_URL = "http://localhost:3000/category";
  constructor(private httpClient:HttpClient) { }

  getAllCategory():Observable<Category[]> {
    return this.httpClient.get<Category[]>(this.API_URL);
  }
}
