// import { Component, OnInit } from '@angular/core';
//
// @Component({
//   selector: 'app-product-update',
//   templateUrl: './product-update.component.html',
//   styleUrls: ['./product-update.component.css']
// })
// export class ProductUpdateComponent implements OnInit {
//
//   import { Component, OnInit } from '@angular/core';
// import {FormBuilder, FormGroup} from "@angular/forms";
// import {ProductServiceService} from "../../service/product-service.service";
// import {Router} from "@angular/router";
// import {Category} from "../../model/category";
// import {CategoryService} from "../../service/category.service";
//
// @Component({
//   selector: 'app-product-create',
//   templateUrl: './product-create.component.html',
//   styleUrls: ['./product-create.component.css']
// })
// export class ProductCreateComponent implements OnInit {
//
//   rfProduct: FormGroup;
//   categoryList: Category[];
//
//   constructor(
//     private _formBuilder: FormBuilder,
//     private _productService: ProductServiceService,
//     private _router: Router,
//     private categoryService: CategoryService
//   ) { }
//
//   ngOnInit(): void {
//     this.rfProduct = this._formBuilder.group({
//       id: [],
//       name: ['2'],
//       price: ['3'],
//       description: ['4'],
//       category: [],
//     })
//
//     this.getCategoryList();
//   }
//
//   onSubmit() {
//     const newProduct = this.rfProduct.value;
//
//     this._productService.addNewProduct(newProduct).subscribe(product => {
//       this._router.navigateByUrl('/productList');
//     })
//   }
//
//   getCategoryList() {
//     this.categoryService.getAll().subscribe(categoryList => {
//       console.log(categoryList)
//       this.categoryList = categoryList;
//     })
//   }
//
// }
