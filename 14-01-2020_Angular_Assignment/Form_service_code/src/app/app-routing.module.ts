import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponentComponent } from './register-component/register-component.component';
import { ViewComponentComponent } from './view-component/view-component.component';



const routes: Routes = [
  {path:"register",component:RegisterComponentComponent},
  {path:"view",component:ViewComponentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
