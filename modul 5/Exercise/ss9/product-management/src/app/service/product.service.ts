import { Injectable } from '@angular/core';
import {Product} from '../model/product';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ProductService {
  URL_PRODUCT = 'http://localhost:3000/product';
  constructor(private  httpClient: HttpClient) { }

  getAll(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.URL_PRODUCT );
  }

  saveProduct(product: Product): Observable<Product> {
    return this.httpClient.post<Product>(this.URL_PRODUCT, product);
  }

  findById(id: number ): Observable<Product> {
    return this.httpClient.get<Product>(`${(this.URL_PRODUCT)}/${id}`);
  }

  updateProduct(id: number , product: Product): Observable<Product> {
    return this.httpClient.patch<Product>(`${(this.URL_PRODUCT)}/${id}`, product);
  }

  deleteProduct(id: number ): Observable<Product> {
    return this.httpClient.delete<Product>(`${this.URL_PRODUCT}/${id}`);
  }
}
