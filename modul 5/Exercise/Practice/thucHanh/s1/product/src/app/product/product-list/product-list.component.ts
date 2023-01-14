import {Component, OnInit} from '@angular/core';
import {Category} from "../model/category";
import {ProductServiceService} from "../service/product-service.service";
import {Product} from "../model/product";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  productNameSearch = '';
  categorySearch = '';
  categoryList: Category[] | undefined ;

  productListPaging: Product[] | undefined ;
  numberRecord = 5;
  curPage = 1;
  totalPage: number | undefined ;
  temp: Category = {};
  tempProduct:Product = {};
  constructor(private productService: ProductServiceService) {
  }

  ngOnInit(): void {
    this.getAllPaging();
    this.getAllCategory()
  }

  getAllPaging(): void {
    this.productService.findAllSearch(this.productNameSearch, this.categorySearch).subscribe(list => {
      this.totalPage = Math.ceil(list.length / this.numberRecord);
    }, error => {
      console.log(error);
    });
    this.productService.findSearchPaging(this.numberRecord, this.curPage,
      this.productNameSearch, this.categorySearch).subscribe(pagingList => {
      this.productListPaging = pagingList;
      console.log(pagingList);
    }, error => {
      console.log(error);
    }, () => {
      console.log('Hiển thị khách hàng ở trang ' + this.curPage);
    });
  }

  getAllCategory(): void {
    this.productService.findAllCategory().subscribe(list => {
      this.categoryList = list;
    }, error => {
      console.log(error);
    });
  }


  next(): void {
    this.curPage++;
    this.ngOnInit();
  }

  previos(): void {
    this.curPage--;
    this.ngOnInit();
  }

  searchByMore(): void {
    this.curPage = 1;
    this.ngOnInit();
  }

  compareWithId(item1: { id: any; }, item2: { id: any; }): boolean {
    return item1 && item2 && item1.id === item2.id;
  }

  reload() {
    this.getAllPaging();
  }

  // xóa đối tượng
  delete(id: number | undefined) {
    if (id != undefined) {
      this.productService.delete(id).subscribe(data => {
        alert("xóa thành công");
        this.ngOnInit();
      });
    }
  }
}
