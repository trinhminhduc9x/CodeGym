import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ProductService} from '../../service/product.service';
import {CategoryService} from '../../service/category.service';
import {Category} from '../../model/category';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  categories: Category[] = [];
  productForm: FormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    price: new FormControl(),
    description: new FormControl(),
    category: new FormControl()
  });

  constructor(private productService: ProductService, private categoryService: CategoryService) { }
  // tslint:disable-next-line:typedef
  getAllListCategory() {
    this.categoryService.getAll().subscribe(categories => {
      this.categories = categories;
      console.log(categories);
    });
  }

  ngOnInit(): void {
    this.getAllListCategory();
  }

  // tslint:disable-next-line:typedef
  submit() {
    const product = this.productForm.value;
    this.productService.saveProduct(product).subscribe(() => {
      this.productForm.reset();
      alert('Thêm mới thành công');
    }, error => {

    });
  }

}
