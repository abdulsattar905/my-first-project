import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserFormComponent } from './components/user-form/user-form.component';
import { ListuserComponent } from './components/listuser/listuser.component';

const appRoutes:Routes =[
  {path:'',component:ListuserComponent},
  {path:'/author',component:UserFormComponent},
]

@NgModule({
  declarations: [
    AppComponent,
    UserFormComponent,
    ListuserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
