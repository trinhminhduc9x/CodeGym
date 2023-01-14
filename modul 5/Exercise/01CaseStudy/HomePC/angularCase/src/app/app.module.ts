import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CutomerListComponent } from './cutomer-list/cutomer-list.component';
import { ProductListComponent } from './product/product/product-list/product-list.component';
import { ProductCreateComponent } from './product/product/product-create/product-create.component';

@NgModule({
  declarations: [
    AppComponent,
    CutomerListComponent,
    ProductListComponent,
    ProductCreateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
