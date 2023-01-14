import { Injectable } from '@angular/core';
import {Customer} from "../customer";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CustomerType} from "../customer-type";

@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService {
  private API_URL = 'http://localhost:3000/';
  private URLCustomer = 'http://localhost:3000/customers';
  private URLCustomerType = 'http://localhost:3000/customerTypes';

  constructor(private httpClient: HttpClient) {
  }

  // findAllCustomer(): Observable<Customer[]> {
  //   return this.httpClient.get<Customer[]>(this.API_URL + 'customers');
  // }

  findAllCustomerSearch(nameSearch: string, addressSearch: string, phoneSearch: string): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(this.API_URL +
      'customers?customerName_like=' + nameSearch + '&customerAddress_like=' + addressSearch + '&customerPhone_like=' + phoneSearch);
  }

  findCustomerSearchPaging(numberRecord: number, curPage: number,
                           nameSearch: string, addressSearch: string, phoneSearch: string): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(this.API_URL + 'customers?_page=' + curPage + '&_limit=' + numberRecord +
      '&customerName_like=' + nameSearch + '&customerAddress_like=' + addressSearch + '&customerPhone_like=' + phoneSearch);
  }

  deleteCustomer(id: number): Observable<Customer> {
    return this.httpClient.delete<Customer>(this.API_URL + 'customers/' + id);
  }

  detailCustomer(id: number): Observable<Customer> {
    return this.httpClient.get<Customer>(this.API_URL + 'customers/' + id);
  }

  findAllCustomerType(): Observable<CustomerType[]> {
    return this.httpClient.get<CustomerType[]>(this.API_URL + 'customerTypes');
  }
  //
  addCustomer(customer: Customer): Observable<Customer> {
    return this.httpClient.post<Customer>(this.API_URL + 'customers', customer);
  }

  getById(id: number): Observable<Customer> {
    return this.httpClient.get<Customer>(this.API_URL + 'customers/' + id);
  }

  updateCustomer(id: number, customer: Customer): Observable<Customer> {
    return this.httpClient.put<Customer>(this.API_URL + 'customers/' + id, customer);
  }



}
