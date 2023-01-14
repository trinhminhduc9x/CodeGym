import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CategoryCreateComponent } from './category/category-create/category-create.component';
import { CategoryListComponent } from './category/category-list/category-list.component';
import { CategoryDeleteComponent } from './category/category-delete/category-delete.component';
import { CategoryEditComponent } from './category/category-edit/category-edit.component';
import { ProductCreateComponent } from './product/product-create/product-create.component';
import { ProductDeleteComponent } from './product/product-delete/product-delete.component';
import { ProductListComponent } from './product/product-list/product-list.component';
import { ProductEditComponent } from './product/product-edit/product-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    CategoryCreateComponent,
    CategoryListComponent,
    CategoryDeleteComponent,
    CategoryEditComponent,
    ProductCreateComponent,
    ProductDeleteComponent,
    ProductListComponent,
    ProductEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
