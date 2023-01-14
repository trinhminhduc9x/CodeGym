import { Component, OnInit } from '@angular/core';
import {ProductService} from "../../service/product.service";
import {Product} from "../../model/product";
import {error} from "@angular/compiler/src/util";
import {Category} from "../../model/category";
import {CategoryService} from "../../service/category.service";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products:Product[]=[];
  product:Product={};
  categoryList:Category[] = [];

  constructor(private productService:ProductService,private categoryService:CategoryService){


  }

  ngOnInit(): void {
    // @ts-ignore
    this.products = this.productService.getAll().subscribe(
      data=> {
        console.log(data)
        this.products = data
      }, error => {

      }, () =>{

      }
    )
    // @ts-ignore
    this.categoryList = this.categoryService.getAllCategory().subscribe(data=>{
      this.categoryList= data;
    },error1 => {},()=>{})
  }

}
