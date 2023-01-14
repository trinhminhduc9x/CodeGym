import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './component/common/header/header.component';
import { StudentInfoComponent } from './component/student/student-info/student-info.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { StudentListComponent } from './component/student/student-list/student-list.component';
import { StudentCreateComponent } from './component/student/student-create/student-create.component';
import { StudentDeleteComponent } from './component/student/student-delete/student-delete.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    StudentInfoComponent,
    StudentListComponent,
    StudentCreateComponent,
    StudentDeleteComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        ReactiveFormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
