import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {CustomerType} from "../customer-type";
import {Customer} from "../customer";
import {CustomerServiceService} from "../service/customer-service.service";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customerNameSearch = '';
  customerAddressSearch = '';
  customerPhoneSearch = '';

  customerListPaging: Customer[] | undefined;
  numberRecord = 5;
  curPage = 1;
  totalPage: number | undefined;
  temp: Customer = {};

  @Output() eventDelete = new EventEmitter();

  constructor(private customerService: CustomerServiceService) {
  }


  ngOnInit(): void {
    this.getAllCustomerPaging();
  }

  getAllCustomerPaging(): void {
    this.customerService.findAllCustomerSearch(this.customerNameSearch, this.customerAddressSearch, this.customerPhoneSearch).subscribe(list => {
      this.totalPage = Math.ceil(list.length / this.numberRecord);
    }, error => {
      console.log(error);
    });

    this.customerService.findCustomerSearchPaging(this.numberRecord, this.curPage,
      this.customerNameSearch, this.customerAddressSearch, this.customerPhoneSearch).subscribe(pagingList => {
      this.customerListPaging = pagingList;
    }, error => {
      console.log(error);
    }, () => {
      console.log('Hiển thị khách hàng ở trang ' + this.curPage);
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

  reload() {
    this.getAllCustomerPaging();
  }

  deleteCustomer(id: number | undefined) {
    if (id != undefined) {
      this.customerService.deleteCustomer(id).subscribe(data => {
        alert("xóa thành công");
        this.ngOnInit();
      });
    }
  }
}
