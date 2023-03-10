import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RoutingRoutingModule } from './routing-routing.module';
import {ProductListComponent} from '../product-list/product-list.component';
import {ProductCreateComponent} from '../product-create/product-create.component';
import {ProductEditComponent} from '../product-edit/product-edit.component';
import {ProductDeleteComponent} from '../product-delete/product-delete.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';


@NgModule({
  declarations: [
    ProductListComponent,
    ProductCreateComponent,
    ProductEditComponent,
    ProductDeleteComponent
  ],
  exports: [
    ProductDeleteComponent
  ],
  imports: [
    CommonModule,
    RoutingRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class RoutingModule { }
