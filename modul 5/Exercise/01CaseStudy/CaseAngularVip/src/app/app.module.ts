import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {RouterModule, Routes} from "@angular/router";
import {CustomerListComponent} from "./customer/customer-list/customer-list.component";
import {CommonModule} from "@angular/common";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CustomerCreateComponent} from "./customer/customer-create/customer-create.component";
import { CustomerEditComponent } from './customer/customer-edit/customer-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomerListComponent,
    CustomerCreateComponent,
    CustomerEditComponent,

  ],
    imports: [
      BrowserModule,
      RouterModule,
      HttpClientModule,
      AppRoutingModule,
      CommonModule,
      FormsModule,
      ReactiveFormsModule,
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
