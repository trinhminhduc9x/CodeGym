import { Component, OnInit } from '@angular/core';
import {Category} from '../model/category';
import {Product} from '../model/product';
import {TestService} from '../service/test.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  productNameSearch = '';
  endDaySearch = '';
  categoryListPaging: Category[] | undefined ;

  productList: Product[] | undefined ;
  numberRecord = 5;
  curPage = 1;
  totalPage = 0 ;
  temp: Category = {};
  tempProduct: Product = {};
  page = 0;
  size = 0;

  constructor(private service: TestService) {
  }

  ngOnInit(): void {
    // this.getAllPaging();
    // @ts-ignore
    this.getAllCategory();
  }


  // tslint:disable-next-line:typedef
  getAllCategory(page: number) {
    this.service.getAll(page).subscribe(data => {
        this.page = data.number;
        this.totalPage = data.totalPages;
        this.size = data.size;

      }
    );
  }

  // getAllPaging(): void {
  //   this.productService.findAllCategorySearch(this.productNameSearch, this.endDaySearch).subscribe(list => {
  //     this.totalPage = Math.ceil(list.length / this.numberRecord);
  //   }, error => {
  //     console.log(error);
  //   });
  //   this.productService.findCategorySearchPaging(this.numberRecord, this.curPage,
  //     this.productNameSearch, this.endDaySearch).subscribe(pagingList => {
  //     this.categoryListPaging = pagingList;
  //     console.log(pagingList);
  //   }, error => {
  //     console.log(error);
  //   }, () => {
  //     console.log('Hiển thị khách hàng ở trang ' + this.curPage);
  //   });
  // }
  //
  // getAllCategory(): void {
  //   this.productService.findAllProduct().subscribe(list => {
  //     this.productList = list;
  //   }, error => {
  //     console.log(error);
  //   });
  // }


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

  // // tslint:disable-next-line:typedef
  // reload() {
  //   this.getAllPaging();
  // }

  // // xóa đối tượng
  // // tslint:disable-next-line:typedef
  
  delete(id: number | undefined) {
    // tslint:disable-next-line:triple-equals
    if (id != undefined) {
      this.service.delete(id).subscribe(data => {
        alert('xóa thành công');
        this.ngOnInit();
      });
    }
  }
}
