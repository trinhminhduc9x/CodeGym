import { Component, OnInit } from '@angular/core';
import {Category} from '../../model/category';
import {CategoryService} from '../../service/category.service';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit {

  categories: Category[] = [];

  constructor(private categoryService: CategoryService) {
  }

  // tslint:disable-next-line:typedef
  ngOnInit() {
    this.getAll();
  }

  // tslint:disable-next-line:typedef
  getAll() {
    this.categoryService.getAll().subscribe(categories => {
      this.categories = categories;
      console.log(categories);
    });
  }
}
