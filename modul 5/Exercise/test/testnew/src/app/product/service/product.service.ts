import {Injectable, OnInit} from '@angular/core';
import {Product} from '../model/product';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService implements OnInit {
  private urlProduct = 'http://localhost:3000/product';
  urlCategory = 'http://localhost:3000/category';
  product?: Product;

  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.urlProduct);
  }
  // tslint:disable-next-line:typedef
  saveProduct(product: Product) {
    return this.httpClient.post<Product>(this.urlProduct, product);
  }


  // tslint:disable-next-line:variable-name
  findById(number: number): Observable<Product> {
    return this.httpClient.get(this.urlProduct + '/' +  number);
  }

  // tslint:disable-next-line:typedef
  updateProduct(product: Product) {
    return this.httpClient.patch(this.urlProduct + '/' + product.id, product);
  }

  deleteProduct(id: number): Observable<Product> {
    return this.httpClient.delete(this.urlProduct + '/' + id);
  }

  // tslint:disable-next-line:contextual-lifecycle
  ngOnInit(): void {
  }
}
