import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Category} from "../model/category";
import {ProductServiceService} from "../service/product-service.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {

  productFormGroup: FormGroup = new FormGroup(
    {
    name: new FormControl('', Validators.required),
    price: new FormControl('', Validators.required),
    description: new FormControl('', Validators.required),
    category: new FormControl('', Validators.required)
  });

  categoryList: Category[] | undefined;

  constructor(private productServiceService: ProductServiceService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
  }


  ngOnInit(): void {
    this.getAllCategory()
  }

  getAllCategory(): void {
    this.productServiceService.findAllCategory().subscribe(list => {
      this.categoryList = list;
    }, error => {
      console.log(error);
    });
  }

  submit(): void {
    const product = this.productFormGroup.value;
    this.productServiceService.add(product).subscribe(() => {
      this.productFormGroup.reset();
    }, error => {
      console.log(error);
    }, () => {
      this.router.navigateByUrl('');
      console.log('Thêm mới khách hàng thành công!');
    });
  }

  compareWithId(item1: { id: any; }, item2: { id: any; }): boolean {
    return item1 && item2 && item1.id === item2.id;
  }

}
