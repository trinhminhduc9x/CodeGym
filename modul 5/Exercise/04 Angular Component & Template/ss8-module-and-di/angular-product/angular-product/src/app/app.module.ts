import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductListComponent } from './product/product-list/product-list.component';
import { ProductCreateComponent } from './product/product-create/product-create.component';
import {ReactiveFormsModule} from "@angular/forms";
import { ProductDeleteComponent } from './product/product-delete/product-delete.component';
import { ProductUpdateComponent } from './product/product-update/product-update.component';
import {HttpClientModule} from "@angular/common/http";
import { NavbarComponent } from './shared/navbar/navbar.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    ProductCreateComponent,
    ProductDeleteComponent,
    ProductUpdateComponent,
    NavbarComponent
  ],
    imports: [
        BrowserModule,
      HttpClientModule,
        AppRoutingModule,
        ReactiveFormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
