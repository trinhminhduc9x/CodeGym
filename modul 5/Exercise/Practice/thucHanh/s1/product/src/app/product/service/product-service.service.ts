import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../model/product";
import {Category} from "../model/category";

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {

  private URL ="http://localhost:3000/";

  constructor(private httpClient: HttpClient) {}
// chú ý cẩn thận sai xintac , phải nhập đúng cú pháp cần tìm.ví dụ :product.name
  findAllSearch(nameSearch: string, categorySearch: string): Observable<Product[]>{
    return this.httpClient.get<Product[]>(this.URL + 'product?name_like=' + nameSearch + '&category.name_like=' + categorySearch );
  }
// chú ý cẩn thận sai xintac , phải nhập đúng cú pháp cần tìm
  findSearchPaging(numberRecord: number, curPage: number, nameSearch: string, categorySearch: string): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.URL + 'product?_page=' + curPage + '&_limit=' + numberRecord + '&name_like=' + nameSearch + '&category.name_like=' + categorySearch);
  }

  findAllCategory(): Observable<Category[]> {
    return this.httpClient.get<Category[]>(this.URL + 'category');
  }


  // xóa đối tượng
  delete(id: number): Observable<Product> {
    return this.httpClient.delete<Product>(this.URL + 'product/' + id);
  }



// thêm mới đối tượng
  add(product: Product): Observable<Product> {
    return this.httpClient.post<Product>(this.URL + 'product', product);
  }
// sửa đối tượng
  getById(id:number):Observable<Product>{
    return this.httpClient.get<Product>(this.URL + 'product/' + id);
  }

  update(id:number, student:Product):Observable<Product>{
    return this.httpClient.put<Product>(this.URL + 'product/' + id,student);
  }
}
