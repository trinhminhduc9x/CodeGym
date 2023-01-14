import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ProductService} from "../../productServer/product.service";
import {Product} from "../../productServer/product";

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {

  products: Product[] = [];

  constructor(private productService: ProductService) {
  }

  ngOnInit() {
    this.getAll();
  }

  getAll() {
    this.products = this.productService.getAll();
  }

}
