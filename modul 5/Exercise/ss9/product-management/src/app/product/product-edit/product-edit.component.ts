import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ProductListComponent} from '../product-list/product-list.component';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {Product} from '../../model/product';
import {Category} from '../../model/category';
import {CategoryService} from '../../service/category.service';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  productUpdateForm: FormGroup = new FormGroup({});
  product: Product = {};
  id: number;
  categories: Category[] = [];

  constructor(private productService: ProductService,
              private activatedRoute: ActivatedRoute,
              private categoryService: CategoryService) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      // @ts-ignore
      this.id = +paramMap.get('id');
      if (this.id != null) {
        this.getProduct(this.id);
      }
    });
  }
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

  compareCate(item1: Category, item2: Category): boolean {
    return item1 && item2 ? item1.id === item2.id : item1 === item2;
  }

  // tslint:disable-next-line:typedef
  getProduct(id: number ) {
    return this.productService.findById(id).subscribe(category => {
      this.productUpdateForm = new FormGroup({
        id: new FormControl(category.id),
        name: new FormControl(category.name),
        price: new FormControl(category.price),
        description: new FormControl(category.description),
        category: new FormControl(category.category)
      });
      console.log(this.productUpdateForm);
    });
  }

  // tslint:disable-next-line:typedef
  updateProduct(id: number) {
    const product = this.productUpdateForm.value;
    this.productService.updateProduct(id, product).subscribe(() => {
      alert('Cập nhật thành công');
    }, e => {
      console.log(e);
    });
  }
}
