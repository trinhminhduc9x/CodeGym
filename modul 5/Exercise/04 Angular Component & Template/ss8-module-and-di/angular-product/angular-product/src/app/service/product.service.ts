import { Injectable } from '@angular/core';
import {Product} from "../model/product";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private API_URL = "http://localhost:3000/product";
  constructor(private  _httpClient:HttpClient) { }


  getAll():Observable<Product[]> {
    return this._httpClient.get<Product[]>(this.API_URL);
  }

  saveProduct(product: any) {
return  this._httpClient.post(this.API_URL,product);
  }

  findById(number: number | undefined): Observable<Product> | null {
    return   this._httpClient.get<Product>(this.API_URL+"/"+number);

    // let temp = this._httpClient.get<Product>(this._httpClient+"/"+number);
    // if (temp === 0) {
    //   return null;
    // }
    // return temp[0];
  }

  deleteById(id: number | undefined ) :Observable<Product> {
    return this._httpClient.delete<Product>(this.API_URL+"/"+id);
//     if (id!=undefined){
//       let s = this.findById(id)
//       if (s!=null){
//         let length=this.products.length
//         for (let i = 0; i <length; i++) {
// if (s.id==this.products[i].id){
//   this.products.splice(i,1);
//   break;
// }
//         }
//       }
//     }
//     return undefined;
  }

  updateProduct(id: number, product: Product) {
 return this._httpClient.put(this.API_URL+"/"+id,product);

    // for (let i = 0; i < this.products.length; i++) {
    //   if (this.products[i].id === id) {
    //     this.products[i] = product;
    //   }
    // }
  }
}
