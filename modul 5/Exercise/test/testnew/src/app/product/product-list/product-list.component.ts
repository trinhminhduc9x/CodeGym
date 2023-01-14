import {Component, OnInit} from '@angular/core';
import {Product} from '../model/product';
import {ProductService} from '../service/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  productList: Product[] = [];
  temp: Product = {};

  constructor(private productService: ProductService) {
  }

  ngOnInit(): void {
    this.getAll();
  }

  // tslint:disable-next-line:typedef
  getAll() {
    this.productService.getAll().subscribe(dataProduct => {
      this.productList = dataProduct;
    }, error => {
    }, () => {
    });
  }


  // tslint:disable-next-line:typedef
  reload() {
    this.getAll();
  }
}
