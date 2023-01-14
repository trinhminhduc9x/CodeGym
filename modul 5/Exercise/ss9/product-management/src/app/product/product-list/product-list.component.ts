import {Component, Input, OnInit} from '@angular/core';
import {ProductService} from '../../service/product.service';
import {Product} from '../../model/product';
import {Router} from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];
  temp: Product = {};

  constructor(private productService: ProductService) {
  }

  ngOnInit(): void {
    this.getAll();
  }

  // tslint:disable-next-line:typedef
  private getAll() {
    this.productService.getAll().subscribe(products => {
      this.products = products;
      console.log(this.products);
    });
  }
}
