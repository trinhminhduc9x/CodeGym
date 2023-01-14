import {Component, OnInit} from '@angular/core';
import {Product} from '../model/product';
import {ProductService} from '../service/product.service';



@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  nameSearch = '';
  classSearch = '';
  numberRecord = 5;
  curPage = 1;
  totalPage: number | undefined;
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

  getAllStudentPaging(): void {
    this.productService.findAllStudentSearch(this.nameSearch, this.classSearch).subscribe(list => {
      this.totalPage = Math.ceil(list.length / this.numberRecord);
    }, error => {
      console.log(error);
    });


  }

  previos() {

  }

  reload() {
    this.getAll();
  }
}
