import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Category} from "../model/category";
import {ProductServiceService} from "../service/product-service.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  productFormGroup: FormGroup = new FormGroup({
    name: new FormControl('', Validators.required),
    price: new FormControl('', Validators.required),
    description: new FormControl('', Validators.required),
    category: new FormControl('', Validators.required)
  });

  categoryList: Category[] | undefined;
  categoryId: number | undefined;

  constructor(private productServiceService: ProductServiceService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
  }


  ngOnInit(): void {
    this.getAllCategory();
    this.categoryId = Number(this.activatedRoute.snapshot.params.id);
  }

  getAllCategory(): void {
    this.productServiceService.findAllCategory().subscribe(list => {
      this.categoryList = list;
    }, error => {
      console.log(error);
    });
  }

  update(id: number) {
    const product = this.productFormGroup.value;
    this.productServiceService.update(id, product).subscribe(() => {

      this.router.navigateByUrl('');
    }, error => {
      console.log(error);
    }, () => {
      console.log('Cập nhật khách hàng thành công!');
    });
  }

  compareWithId(item1: { id: any; }, item2: { id: any; }): boolean {
    return item1 && item2 && item1.id === item2.id;
  }

}
