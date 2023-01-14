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
    this.getAll()
  }

  getAll() {
    this.productService.getAll().subscribe(dataProduct => {
      this.productList = dataProduct;
    }, error => {
    }, () => {
    });
  }


  reload() {
    this.getAll();
  }
}
