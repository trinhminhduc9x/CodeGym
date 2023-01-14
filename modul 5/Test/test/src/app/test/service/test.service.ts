import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Product} from '../model/product';
import {Observable} from 'rxjs';
import {Category} from '../model/category';

@Injectable({
  providedIn: 'root'
})
export class TestService {

  private URL = 'http://localhost:3000/';

  constructor(private httpClient: HttpClient) {}

  getAll(page: number): Observable<any> {
    return this.httpClient.get<any>(this.URL + 'category?page=' + page);
  }


// chú ý cẩn thận sai xintac , phải nhập đúng cú pháp cần tìm.ví dụ :product.name
  findAllCategorySearch(nameProductSearch: string, endDaySearch: string): Observable<Category[]>{
    return this.httpClient.get<Category[]>(this.URL + 'category?product.name_like=' + nameProductSearch + '&endDay_like=' + endDaySearch );
  }
// chú ý cẩn thận sai xintac , phải nhập đúng cú pháp cần tìm
  findCategorySearchPaging(numberRecord: number, curPage: number, nameProductSearch: string, endDaySearch: string): Observable<Category[]> {
    // tslint:disable-next-line:max-line-length
    return this.httpClient.get<Category[]>(this.URL + 'category?_page=' + curPage + '&_limit=' + numberRecord + '&product.name_like=' + nameProductSearch + '&endDay_like=' + endDaySearch );
  }

  findAllProduct(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.URL + 'product');
  }

  // xóa đối tượng
  delete(id: number): Observable<Product> {
    return this.httpClient.delete<Product>(this.URL + 'category/' + id);
  }



// thêm mới đối tượng
  add(category: Category): Observable<Category> {
    return this.httpClient.post<Category>(this.URL + 'category', category);
  }
// sửa đối tượng
  getById(id: number): Observable<Product>{
    return this.httpClient.get<Product>(this.URL + 'product/' + id);
  }

  update(id: number, student: Product): Observable<Product>{
    return this.httpClient.put<Product>(this.URL + 'product/' + id, student);
  }
}
