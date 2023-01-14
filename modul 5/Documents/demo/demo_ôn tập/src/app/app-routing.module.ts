import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {StudentListComponent} from "./component/student/student-list/student-list.component";
import {StudentCreateComponent} from "./component/student/student-create/student-create.component";
import {StudentInfoComponent} from "./component/student/student-info/student-info.component";

const routes: Routes = [
  {path: "student", component: StudentListComponent},
  {path: "student/create", component: StudentCreateComponent},
  {path: "student/detail/:id/:name", component: StudentInfoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
